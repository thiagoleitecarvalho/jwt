package com.github.thiagoleitecarvalho.jwt.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.thiagoleitecarvalho.jwt.filter.AutenticacaoFilter;

/**
 * Classe de configuração do filtro de avaliação do token JWT.
 * @author Thiago Leite e Carvalho
 */
@Configuration
public class FiltroConfig {

    /**
     * Cria e registra o filtro de avaliação do token JWT no ApplicationContext do SptingBoot.
     * @return
     */
    @Bean
    protected FilterRegistrationBean<AutenticacaoFilter> registrarAuthenticationFilter() {

        FilterRegistrationBean<AutenticacaoFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AutenticacaoFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }
}
