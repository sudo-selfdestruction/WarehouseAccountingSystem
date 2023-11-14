package by.bsu.rfict.WarehouseAccountingSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Разрешаем запросы из любого источника и разрешаем передавать заголовки "Authorization"
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");

        // Разрешаем методы GET, POST, PUT, DELETE, OPTIONS
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");

        // Устанавливаем максимальное время (в секундах) для кэширования предзапроса CORS
        config.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}