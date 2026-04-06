package org.example.demo_mvc.configuration;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        // Tầng này dành cho Service/Repository. Hiện tại chưa có nên trả về null
        return null;
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        // MỌI CẤU HÌNH LIÊN QUAN ĐẾN WEB (MVC, View, Controller) PHẢI NẰM Ở ĐÂY
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Định nghĩa các request từ phía client vào from controller
    }
}
