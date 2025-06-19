package vn.tayjava.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Component
public class Translator {
    private static ResourceBundleMessageSource messageSource;

    @Autowired
    private Translator(ResourceBundleMessageSource messageSource) {
        Translator.messageSource = messageSource;
    }

    public static String toLocale(String msgCode) {
        // Lệnh này để lấy ra local hiện tại
        Locale locale = LocaleContextHolder.getLocale();
        // msgCode là message Code, default message và locale của nó
        return messageSource.getMessage(msgCode, null, locale);
    }
}
