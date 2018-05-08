package com.lyh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyh.util.SecuritySha1;
/**
 * 微信请求校验
 * @author lyh
 *
 */
public class WeChatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

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

		String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
        
        PrintWriter out = response.getWriter();  
        if(signature == null){
        	out.print("web request");
        }else{
        	//微信的token
        	String token = "weCharMyWeb";
        	String[] arr = new String[] { token, timestamp, nonce };  
            // 将token、timestamp、nonce三个参数进行字典序排序  
            Arrays.sort(arr);
            
            StringBuilder content = new StringBuilder();  
            for (int i = 0; i < arr.length; i++) {  
                content.append(arr[i]);  
            }  
        	String sha1 = SecuritySha1.getSha1(content.toString());
        	if(sha1 != null && sha1.equals(signature.toUpperCase())){
        		out.print(echostr);
        	}
        	// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
            /*if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
                out.print(echostr);  
            } */
        }
         
        
        out.close();  
        out = null;
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
