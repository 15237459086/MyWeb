package com.lyh.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PDFJasperReport extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public PDFJasperReport() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		/*JasperReport jasperReport = null;  
        JasperPrint jasperPrint = null;  
        try {
        	jasperReport = JasperCompileManager  
                    .compileReport("E:\\ireport\\TestJasperReport.jasper"); 
        	FileInputStream fis = new FileInputStream(new File(pathname),"UTF-8");
        	new fileinpu
        	InputStreamReader isf = new InputStreamReader( new FileInputStream("E:\\ireport\\TestJasperReport1.jrxml"), "UTF-8");
        	InputStream a = 
            jasperReport = JasperCompileManager.compileReport("E:\\ireport\\report1.jrxml");  
            jasperPrint = JasperFillManager.fillReport(jasperReport,  
                    new HashMap(), new JREmptyDataSource());
           
            ServletOutputStream ouputStream = response.getOutputStream(); 
            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            response.setContentLength(bytes.length);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline;filename=temp.pdf");
            ouputStream.write(bytes, 0, bytes.length);  
            ouputStream.flush();
            response.setContentType("application/pdf");
    		response.addHeader("Content-Disposition", "inline;FileName=out.pdf");
    		
            ObjectOutputStream oos = new ObjectOutputStream(ouputStream);     
            oos.writeObject(jasperPrint);
            
            oos.flush();        
            oos.close();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.writeTo(oos);
            ouputStream.write(baos.toByteArray(), 0, baos.size());  
            ouputStream.flush();
            ouputStream.close();
        } catch (JRException e) {  
            e.printStackTrace();  
        }  
        */
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
	}

	private String readJson(String Path){
		BufferedReader reader = null;
		FileInputStream fileInputStream;
		String laststr = "";
		try {
			fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr += tempString;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return laststr;
	}
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
