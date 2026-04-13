package com.re.btvn.config;

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

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // Cấu hình dung lượng 2MB theo yêu cầu
        long maxFileSize = 2 * 1024 * 1024;      // 2MB cho mỗi file
        long maxRequestSize = 2 * 1024 * 1024;   // 2MB cho toàn request
        int fileSizeThreshold = 0;

        String tempDir = "";

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
                tempDir, maxFileSize, maxRequestSize, fileSizeThreshold
        );

        registration.setMultipartConfig(multipartConfigElement);
    }
}
