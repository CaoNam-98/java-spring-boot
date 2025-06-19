package vn.tayjava.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class AppConfig extends OncePerRequestFilter {
    // Lọc request đến ứng dụng của mình trước tiên cả. Phải qua cái này rồi mới đến API

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        // cho phép domain http://localhost:5137 được phép truy xuất
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5137");
        filterChain.doFilter(request, response);
    }
}
