package ru.warpreaktor.util.profiler.profiler;

import com.gaskar.core.isr.api.v2.security.annotations.NullIfHasNoReadPermission;
import org.springdoc.core.SecurityService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CanViewISRWorkValue implements BeanPostProcessor {
    private SecurityService securityService;
    private Map<String, Set<Method>> mapBeanNameVsAnnotatedMethods = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        Set<Method> annotatedMethods = Arrays.stream(beanClass.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(NullIfHasNoReadPermission.class))
                .collect(Collectors.toSet());

        if (!annotatedMethods.isEmpty()) {
            mapBeanNameVsAnnotatedMethods.put(beanName, annotatedMethods);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        Set<Method> annotatedMethods = mapBeanNameVsAnnotatedMethods.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return null;
                }
            });
        }
        return bean;
    }
}
