package service;

import java.io.FileInputStream;
import java.io.InputStream;

import dao.ImageDAO;

public class ImageService {

	public static void putImage(int r_int, InputStream fis) {
		new ImageDAO().putImage(r_int,fis);
	}
	
	public static InputStream getImage(int r_int) {
		return new ImageDAO().getImage(r_int);
	}
}
