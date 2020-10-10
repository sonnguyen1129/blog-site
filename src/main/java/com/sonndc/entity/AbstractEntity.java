package com.sonndc.entity;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;
}

//Will need to enable JPA Auditing
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
class JpaConfig {
// Creating a bean of AuditorAwareImpl which will provide currently logged in user
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
}

//Creating implementation of AuditorAware and override its methods to provide currently logged in user
class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable("Naresh");
		// Can use Spring Security to return currently logged in user
		// return ((User)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
	}
}