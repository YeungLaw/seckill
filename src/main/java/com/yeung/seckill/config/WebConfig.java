package com.yeung.seckill.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yeung Law~
 *
 * 通过该配置类，将自定义的解析器加入到 HandlerMethodArgumentResolver列表中
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


    @Resource
    private UserArgumentResolver userArgumentResolver;

    @Resource
    private AccessLimitInterceptor accessLimitInterceptor;
    // @Resource
    // private AccessLimitInterceptor accessLimitInterceptor;
    //
    //
    // //注册自定义拦截器，这样就可以生效
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(accessLimitInterceptor);
    // }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessLimitInterceptor);
    }

    //静态资源加载
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    //这里加入我们自定义的解析器到 HandlerMethodArgumentResolver列表中
    //这样自定义的解析器工作
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver);
    }
}
