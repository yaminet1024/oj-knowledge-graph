package cn.yaminets.ojknowledgegraph.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class BeanUtil implements ApplicationContextAware {
    protected static ApplicationContext context;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) context.getBean(name);//name表示其他要注入的注解name名
    }

    public static <T> T getBean(Class<T> t) {
        return context.getBean(t);
    }

}
