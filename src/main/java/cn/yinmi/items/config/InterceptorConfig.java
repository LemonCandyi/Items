//package cn.yinmi.items.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurationSupport {
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        //registry.addInterceptor(new UserRoleAuthorizationInterceptor()).addPathPatterns("/demo/pics/**");
//        super.addInterceptors(registry);
//    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/html/**").addResourceLocations("classpath:/html/");
//        registry.addResourceHandler("/pics/**").addResourceLocations("classpath:/pics/");
//        super.addResourceHandlers(registry);
//    }
//}
//
