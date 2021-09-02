package com.example.restAPI;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PersonScheduler {
	
	@Autowired
	private PersonService personService;
	
	private static long fileCount = 1;
	
	@Scheduled(cron = "0 * * * * *")
	public void createExcelSheet()  throws Exception  {
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Person Information");
		XSSFRow row;
		for(int i=0;i<personService.getAllPersons().size();i++) { 
			row = spreadsheet.createRow(i);
			Person person = personService.getAllPersons().get(i);
			row.createCell(0).setCellValue(person.getName());
			row.createCell(1).setCellValue(person.getAge());
			row.createCell(2).setCellValue(person.getCompany());
			row.createCell(3).setCellValue(person.getCompanyId());
		}
		
		FileOutputStream out = new FileOutputStream(new File("F://ExcelFiles/File"+fileCount+".xlsx"));
	    fileCount++;
        workbook.write(out);
        out.close();
		
	}
}
