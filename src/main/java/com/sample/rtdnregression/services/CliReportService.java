package com.sample.rtdnregression.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CliReportService {
	@Autowired
	private ValidationService validationService;

	public void action(String... args) {
		int envNo;
		
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		if(args.length == 1 && args[0] == "default") {
			envNo = 2;
			try {
				startDate = dateFormat.parse("01/11/2024");
				endDate = dateFormat.parse("01/12/2024");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("Select Environment:\n" + "\t1.Dev\n" + "\t2.Test");
				envNo = scanner.nextInt();
				if (envNo == 1 || envNo == 2) {
					break;
				} else {
					System.out.println("Invalid input. Please enter 1 or 2.");
				}
			}

			System.out.println("Provide Date Range:");
			while (startDate == null || endDate == null) {
				
				System.out.println("Start Date (DD/MM/YYYY)");
				String startDateStr = scanner.nextLine();
				System.out.println("End Date (DD/MM/YYYY)");
				String endDateStr = scanner.nextLine();
				try { 
					startDate = dateFormat.parse(startDateStr); 
					endDate = dateFormat.parse(endDateStr); 
				} catch (ParseException e) { 
					System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
				}
			}
			
			
			scanner.close();
		}
		
		validationService.validation();
		
		
		

	}
}
