package vn.tayjava.configuration;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
public class LocalResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // Mặc định là trả về tiếng anh nên ta phải lấy giá trị từ request header
        String languageHeader = request.getHeader("Accept-Language");
        // Mình cần trả về local cho nó
        // Tìm kiếm languageHeader có nằm trong List ["en", "fr"] hay không
        return StringUtils.hasLength(languageHeader) ? Locale.lookup(
                Locale.LanguageRange.parse(languageHeader),
                List.of(
                        new Locale("en"),
                        new Locale("fr"),
                        new Locale("vi")
                ))
                : Locale.getDefault();
    }
}
