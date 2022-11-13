package tn.esprit.rh.achat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableScheduling
@SpringBootApplication
public class AchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchatApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer (){
    	return new WebMvcConfigurer(){
    		public void addCorsMappings(CorsRegistry registry){
    			registry.addMapping("/greeting-javaconfig")
    			        .allowedOrigins("http://192.168.1.149:4200");
    		}
    	};
    }

}
