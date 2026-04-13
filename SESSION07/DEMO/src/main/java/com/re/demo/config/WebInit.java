package com.re.demo.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //Phím tắt ctrl + o -> để upload file ví dụ chỉ gửi file tối đa 25mb
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        /*
        location: Địa chỉ lưu tạm thời
        maxFileSize: File có dung lượng đối đa 25MB
        maxRequestSize: Giới hạn file gửi lên ở đây là -> 25MB
        fileSizeThreshold: Muốn lưu file tạm kích cỡ bao nhiêu 0
        */
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        "/",
                        25 * 1024 * 1024L,
                        25 * 1024 * 1024L,
                        0
                )
        );
    }

}
