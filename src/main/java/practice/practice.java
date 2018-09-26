package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import model.Employee;
import service.EmployeeService;
import service.ImageService;
import service.ReimbursementService;
import java.sql.Blob;

public class practice {
	
	public static void main(String[] args) throws IOException {
//		for(Employee e: EmployeeService.getAllEmployees()) {
//			System.out.println(e);
//		}
		
//		Employee e = EmployeeService.getEmployeeByID(1);
//		ReimbursementService.addReimbursement(e, 250, "airfare");
//		ReimbursementService.addReimbursement(EmployeeService.getEmployeeByID(3),1000,"chateau marmont bottle service");
		//System.out.println(ReimbursementService.getResolvedReimbursements(e));
		//System.out.println(ReimbursementService.getAllPending());
		//ReimbursementService.updateReimbursement(1, EmployeeService.getEmployee(2), 0, 1);
		//System.out.println();
		//System.out.println(ReimbursementService.getResolvedReimbursements(e));
		//System.out.println(ReimbursementService.getAllPending());
		//ImageService.putImage(1,"src/main/resources/test.jpg");
		
		//ImageService.getImage(1);
		
		
//		FileOutputStream outputStream = new FileOutputStream(new File("src/main/resources/result.jpg"));
//
//		int read = 0;
//		byte[] bytes = new byte[1024];
//		
//		InputStream fis = ImageService.getImage(1);
//		while ((read = fis.read(bytes)) != -1) {
//			outputStream.write(bytes, 0, read);
//		}
		
		
		//File f = new File("test.jpg");
		//FileInputStream fis = new FileInputStream("src/main/resources/test.jpg");
//		String uri = "/ERS/1.image";
//		String tmp = uri.split("/")[2].split("\\.")[0];
//		
//		String lol = tmp[2];
//		System.out.println(lol);
//		String[] hello = lol.split("\\.");
//		System.out.println(hello[0]);
	}
	

}
