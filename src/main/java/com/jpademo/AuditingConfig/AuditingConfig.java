package com.jpademo.AuditingConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Ritesh on 24-10-2016.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AuditingConfig {
    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
    public class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public String getCurrentAuditor() {

            String createdby = "Ritesh";
            return createdby;
        }
    }
}
