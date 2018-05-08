package com.lyh.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XMLUtil {

	public static Element getRootElement(String xmlPath){
		
		try{
			//1.获取SAM接口： 
			SAXReader saxReader = new SAXReader();  
	        //2.获取XML文件：  
	        Document doc = saxReader.read(new File(xmlPath));
			
	        //3.获取根节点：
            Element root = doc.getRootElement();
            return root;
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			return null;
		}
	}
	
	private static void createXMLDocumentSimple(){
		// 创建文档并设置文档的根元素节点   
        Element root = DocumentHelper.createElement("books");  
        Document document = DocumentHelper.createDocument(root);
        //根节点  
        root.addAttribute("name","bookvalue");  
        //子节点  
        Element element1 = root.addElement("author1 ");  
        element1.addAttribute( "name", "James1" );  
        element1.addAttribute( "location1", "UK1" );  
        element1.addText( "James Strachan1" );  
          
        Element element = root.addElement("author2 ");  
        element.addAttribute( "name", "chen" );  
        element.addAttribute( "kenken", "ZK" );  
        element.addText( "chen kenken" );  
        
        try {
        	OutputFormat outputFormat = new OutputFormat();
        	outputFormat.setEncoding("UTF-8");
        	XMLWriter writer = new XMLWriter(new FileWriter(new File("F:\\test_data\\xml\\books.xml")),outputFormat);
        	writer.write(document);
        	writer.close();
        	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
