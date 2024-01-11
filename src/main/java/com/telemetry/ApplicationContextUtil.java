package com.telemetry;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author LiuCheng
 * @date 2021/6/8 10:02
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static <T> T getBean(String name, Class<T> clz) throws BeansException {
        return applicationContext.getBean(name, clz);
    }

    public static <T> T getBean(Class<T> clz) throws BeansException {
        return applicationContext.getBean(clz);
    }

    public static String getMessage(String code, @Nullable Object[] args, String defaultMessage, String language,
                                    String country) {
        return applicationContext.getMessage(code, args, defaultMessage, new Locale(language, country));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }
}
