package dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public interface IImages {

	public void putImage(int r_id, InputStream is);
	public InputStream getImage(int r_id);
}
