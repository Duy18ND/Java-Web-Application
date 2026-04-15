package com.re.demo.controller;

import com.re.demo.dto.PersonDTO;
import com.re.demo.model.Gender;
import com.re.demo.model.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PersonController {
    public static List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person(1L, "Đoàn Mạnh Duy", Gender.MALE, LocalDate.of(2006, 7, 28), 20, "duy18nd@gmail.com"),
                    new Person(2L, "Nguyễn Thị Mai", Gender.FEMALE, LocalDate.of(1998, 5, 12), 26, "mai.nguyen98@gmail.com"),
                    new Person(3L, "Trần Văn Hùng", Gender.MALE, LocalDate.of(1995, 11, 30), 29, "hungtv.dev@example.com"),
                    new Person(4L, "Lê Hà Phương", Gender.FEMALE, LocalDate.of(2002, 3, 8), 22, "phuongle.02@example.com"),
                    new Person(5L, "Phạm Hoàng Sơn", Gender.MALE, LocalDate.of(2000, 9, 15), 24, "sonpham2000@gmail.com")
            )
    );

    @GetMapping({"/person-list", "/"})
    public String home(Model model) {
        model.addAttribute("person", personList);
        return "person-list";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        //Gửi sang view 1 dữ liệu rỗng
        model.addAttribute("personDTO", new PersonDTO());
        return "view-add";
    }

    @PostMapping("/view-add")
    public String savePerson(
            // Thêm @Valid để kích hoạt validate từ DTO
            @Valid
            @ModelAttribute(name = "personDTO") PersonDTO personDTO,
            // BindingResult BẮT BUỘC phải đứng ngay sau tham số @Valid
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        // 1. KIỂM TRA LỖI
        if (result.hasErrors()) {
            // Nếu có lỗi, lập tức trả về lại trang form để người dùng sửa.
            // Tuyệt đối không dùng redirect ở đây để tránh mất dữ liệu họ vừa nhập và mất thông báo lỗi.
            return "view-add";
        }

        // 2. NẾU DỮ LIỆU HỢP LỆ -> LƯU VÀO DANH SÁCH
        // Tự động tăng ID
        Long nextId = personList.stream().mapToLong(Person::getId).max().orElse(0L) + 1;

        // Chuyển từ DTO sang Model thực tế
        Person newPerson = new Person(
                nextId,
                personDTO.getName(),
                personDTO.getGender(),
                personDTO.getDateOfBirth(),
                personDTO.getAge(),
                personDTO.getEmail()
        );
        personList.add(newPerson);

        // Truyền thông báo thành công sang trang danh sách
        redirectAttributes.addFlashAttribute("msgSuccess", "Đã thêm thành công người dùng: " + newPerson.getName());

        // 3. CHUYỂN HƯỚNG VỀ TRANG DANH SÁCH
        return "redirect:/person-list";
    }
}
