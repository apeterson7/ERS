package Servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.ImageService;

public class ImageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uri = request.getRequestURI();
		String tmp = uri.split("/")[2].split("\\.")[0];
		
		
//			String[] uriList = uri.split("?");
//			System.out.println(uriList);
//			Integer r_id = Integer.parseInt(uriList[1]);
		Integer r_id = Integer.parseInt(tmp);
		//FileOutputStream outputStream = new FileOutputStream(new File("src/main/resources/result.jpg"));
		System.out.println("r_id: "+r_id);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		int read = 0;
		byte[] buffer = new byte[1024];
		
		InputStream fis = ImageService.getImage(r_id);
		while ((read = fis.read(buffer)) != -1) {
			os.write(buffer, 0, read);
		}
		byte[] imageBytes = os.toByteArray();

	    response.setContentType("image/jpeg");
	    response.setContentLength(imageBytes.length);
	    response.getOutputStream().write(imageBytes);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		
	}

}
