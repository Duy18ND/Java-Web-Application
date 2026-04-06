package org.example.btth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountManagement {
    private Map<String,Double> persons = new HashMap<>();

    // DI - Field Injection
    @Autowired
    private NormalNotify normalNotify;
    @Autowired
    private VIPNotify vipNotify;

    public AccountManagement(Map<String, Double> persons) {
        this.persons = persons;
    }

    public void checkYourComputer(String username, String area) {
        // kiểm tra username trống hoặc null
        if(username == null || username.isEmpty()) {
            System.err.println("[ERROR] Loi roi khong duoc de trong");
            return;
        }

        // kiểm tra username có tồn tại hay không
        if(!persons.containsKey(username)) {
            System.err.println("[ERROR] Khong ton tai nguoi dung");
            return;
        }

        // Kiểm tra tiền
        // Thực hiện lấy tiền
        Double balance = persons.get(username);
        if(balance < 0 ) {
            System.err.println("[ERROR] Khong du tien de choi game");
            return;
        }

        // kiểm tra < 5000 thì thông báo

        if(balance < 5000) {
            if(area.equals("VIP")) {
                // khu vực víp thì cần yên lặng
                vipNotify.sendNotify(username,"Anh có cần e giúp nạp tiền không ạ!!!");
            } else {
                // khu vực bình thường thì cần âm thanh
                normalNotify.sendNotify(username,"Sắp hết tiền rồi bạn eiiiiiiii !!!");
            }
        }


    }
}
