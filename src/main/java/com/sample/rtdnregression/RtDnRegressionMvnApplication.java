package com.sample.rtdnregression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sample.rtdnregression.services.CliReportService;

@SpringBootApplication
public class RtDnRegressionMvnApplication implements CommandLineRunner {
	
	@Autowired
	private CliReportService cliReportService;

	public static void main(String[] args) {
		SpringApplication.run(RtDnRegressionMvnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(String arg: args) {
			System.out.println(arg); 
		}
		
		cliReportService.action(args);
	}
}
