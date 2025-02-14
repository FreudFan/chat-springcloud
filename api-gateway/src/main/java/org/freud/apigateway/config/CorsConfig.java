package org.freud.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/***
 * 跨域配置
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        //是否支持cookie跨域
        config.setAllowCredentials(true);
        //支持的原始域 //http:www.a.com
        config.setAllowedOrigins(Collections.singletonList("*"));
        //允许的请求头
        config.setAllowedHeaders(Collections.singletonList("*"));
        //允许的请求方法
        config.setAllowedMethods(Collections.singletonList("*"));
        //缓存时间，多少时间内相同跨域请求不再检查跨域请求
        config.setMaxAge(300L);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
