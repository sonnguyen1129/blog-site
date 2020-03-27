package com.sonndc.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Demo {
	int temp = 0;
	
	@Scheduled(cron = "0/10 * * * * ?")
	public void scheduleTask() {
		temp++;
		System.out.println(temp);
	}

}
