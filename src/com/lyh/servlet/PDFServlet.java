package com.lyh.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyh.util.PDFUtil;

public class PDFServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5212472178976091795L;

	
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

		/*String srcPDFPath = "F:/MyWeb测试数据/PDF加水印/image.pdf";
		String watermarkName ="复印无效";
		ByteArrayOutputStream baos = null;
		try {
			baos = PDFUtil.getOutputStreamOfWterMarkByText(srcPDFPath, watermarkName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String srcImgPath = "F:/MyWeb测试数据/PDF加水印/image.png";
		ByteArrayOutputStream baos = null;
		try {
			baos = PDFUtil.getOutputStreamImageToPdf(srcImgPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentLength(baos.size());
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline;FileName=out.pdf");
		
		OutputStream outStream = response.getOutputStream();  
        outStream.write(baos.toByteArray(), 0, baos.size());  
        outStream.flush();  
        outStream.close(); 
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

	

}
