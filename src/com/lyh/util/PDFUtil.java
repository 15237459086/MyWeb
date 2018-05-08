package com.lyh.util;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

/**
 * PDFUtil
 * @author lyh
 *
 */
public class PDFUtil {
	
	
	// 水印透明度
    private static float alpha = 0.5f;
    // 水印横向位置
    private static int positionWidth = 150;
    // 水印纵向位置
    private static int positionHeight = 300;
    // 水印文字颜色
    private static Color color = Color.red;
    
    /**
     * 设置水印的透明度，水平横纵向位置，水印文字字体，印文字颜色
     * @param alpha
     *            水印透明度
     * @param positionWidth
     *            水印横向位置
     * @param positionHeight
     *            水印纵向位置
     * @param font
     *            水印文字字体
     * @param color
     *            水印文字颜色
     */
    public static void setImageMarkOptions(float alpha, int positionWidth,
            int positionHeight, Font font, Color color) {
        if (alpha != 0.0f)
        	PDFUtil.alpha = alpha;
        if (positionWidth != 0)
        	PDFUtil.positionWidth = positionWidth;
        if (positionHeight != 0)
        	PDFUtil.positionHeight = positionHeight;
        if (color != null)
        	PDFUtil.color = color;
    }
	
    /**
     * 获取PDF输出流
     * @param imgFilePath 
     * @return ByteArrayOutputStream
     * @throws DocumentException
     * @throws IOException
     */
    public static ByteArrayOutputStream getOutputStreamImageToPdf(String imgFilePath) throws DocumentException, IOException{
    	Document document = new Document();
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, bos);
	
			/*// 添加PDF文档的某些信息，比如作者，主题等等
			document.addAuthor("arui");
			document.addSubject("test pdf.");*/
			// 设置文档的大小
			document.setPageSize(PageSize.A4);
			// 打开文档
			document.open();
			// 写入一段文字
			//document.add(new Paragraph("JUST TEST ..."));
			// 读取一个图片
			Image image = Image.getInstance(imgFilePath);
			float imageHeight=image.getScaledHeight();
			float imageWidth=image.getScaledWidth();
			int i=0;
			while(imageHeight>500||imageWidth>500){
				image.scalePercent(100-i);
				i++;
				imageHeight=image.getScaledHeight();
				imageWidth=image.getScaledWidth();
			}

			image.setAlignment(Image.ALIGN_CENTER); 
			//设置图片的绝对位置
			// image.setAbsolutePosition(0, 0);
			// image.scaleAbsolute(500, 400);
			// 插入一个图片
			document.add(image);
			
		} catch (DocumentException de) {
			de.printStackTrace();
			throw de;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw ioe;
		}finally{

			try{
				if(document != null){
					document.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return bos;
    }
    
    /**
	 * 图片转PDF
	 * @param imgFilePath 图片文件路径
	 * @param pdfFilePath PDF文件路径
     * @return true/false
     * @throws Exception
     */
    public static boolean convertImgToPdf(String imgFilePath, String pdfFilePath) throws Exception{
		Document document = new Document();
		FileOutputStream fos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = PDFUtil.getOutputStreamImageToPdf(imgFilePath);
			fos = new FileOutputStream(pdfFilePath);
			fos.write(baos.toByteArray());
			PdfWriter.getInstance(document, fos);			
		} catch (DocumentException de) {
			de.printStackTrace();
			throw de;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw ioe;
		}finally{

			try{
				if(document != null){
					document.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try{
				if(baos != null){
					baos.flush();
					baos.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
				if(fos != null){
					fos.flush();
					fos.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return true;
	}
    
    /**
	 * 图片转PDF
	 * @param imgFilePath 图片文件路径
	 * @param pdfFilePath PDF文件路径
	 * @return true/false
	 * @throws Exception
	 *//*
	public static boolean convertImgToPdf(String imgFilePath, String pdfFilePath) throws Exception{
		Document document = new Document();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(pdfFilePath);
			PdfWriter.getInstance(document, fos);
	
			// 添加PDF文档的某些信息，比如作者，主题等等
			document.addAuthor("arui");
			document.addSubject("test pdf.");
			// 设置文档的大小
			document.setPageSize(PageSize.A4);
			// 打开文档
			document.open();
			// 写入一段文字
			//document.add(new Paragraph("JUST TEST ..."));
			// 读取一个图片
			Image image = Image.getInstance(imgFilePath);
			float imageHeight=image.getScaledHeight();
			float imageWidth=image.getScaledWidth();
			int i=0;
			while(imageHeight>500||imageWidth>500){
				image.scalePercent(100-i);
				i++;
				imageHeight=image.getScaledHeight();
				imageWidth=image.getScaledWidth();
			}

			image.setAlignment(Image.ALIGN_CENTER); 
			//设置图片的绝对位置
			// image.setAbsolutePosition(0, 0);
			// image.scaleAbsolute(500, 400);
			// 插入一个图片
			document.add(image);
			
		} catch (DocumentException de) {
			de.printStackTrace();
			throw de;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw ioe;
		}finally{

			try{
				if(document != null){
					document.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
				if(fos != null){
					fos.flush();
					fos.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return true;
	}
	*/
	/**
	 * 获取水印PDF输出流
	 * @param inputPDFFile 输入PDF文件路径
	 * @param waterMarkFile 水印图片路径
	 * @return ByteArrayOutputStream
	 * @throws Exception
	 */
	public static ByteArrayOutputStream getOutputStreamOfWterMarkByIcon(String inputPDFFile,String waterMarkFile) throws Exception {
		PdfStamper stamper = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
            PdfReader reader = new PdfReader(inputPDFFile);
            stamper = new PdfStamper(reader, bos);
            int total = reader.getNumberOfPages() + 1;
            PdfContentByte under = null;
            for (int i = 1; i < total; i++) {
                // 获得PDF最顶层
                under = stamper.getOverContent(i);
                under.saveState();
                // set Transparency
                PdfGState gs = new PdfGState();
                // 设置透明度为0.2
                gs.setFillOpacity(PDFUtil.alpha);
                under.setGState(gs);
                // 注意这里必须调用一次restoreState 否则设置无效
                under.restoreState();
                under.beginText();
                
                under.setColorFill(PDFUtil.color);
                Image image = Image.getInstance(waterMarkFile);
                image.setAbsolutePosition(PDFUtil.positionWidth, PDFUtil.positionHeight); // set the first background image of the absolute   
                image.scaleToFit(200,200);  
                under.addImage(image);  
                // 添加水印文字
                under.endText();
                under.setLineWidth(1f);
                under.stroke();
            }
            
            return bos;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
        	
        	if(stamper!= null){
        		try{
        			stamper.close();
        		}catch (Exception e) {
                    e.printStackTrace();
                }
        		
        	}
        }
    }
	
	/**
	 * 获取水印PDF输出流
	 * @param inputPDFFile 输入PDF文件路径
	 * @param waterMarkText 水印文字
	 * @return ByteArrayOutputStream
	 * @throws Exception
	 */
	public static ByteArrayOutputStream getOutputStreamOfWterMarkByText(String inputPDFFile,String waterMarkText) throws Exception {
		PdfStamper stamper = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
            PdfReader reader = new PdfReader(inputPDFFile);
            stamper = new PdfStamper(reader, bos);
            //这里的字体设置比较关键，这个设置是支持中文的写法
            BaseFont base = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 使用系统字体
            int total = reader.getNumberOfPages() + 1;
            PdfContentByte under = null;
            for (int i = 1; i < total; i++) {
                // 计算水印X,Y坐标
                float x = PDFUtil.positionWidth;
                float y = PDFUtil.positionHeight;
                // 获得PDF最顶层
                under = stamper.getOverContent(i);
                under.saveState();
                // set Transparency
                PdfGState gs = new PdfGState();
                // 设置透明度为0.2
                gs.setFillOpacity(PDFUtil.alpha);
                under.setGState(gs);
                // 注意这里必须调用一次restoreState 否则设置无效
                under.restoreState();
                under.beginText();
                under.setFontAndSize(base, 30);
                
                under.setColorFill(PDFUtil.color);
               
                // 水印文字成45度角倾斜
                under.showTextAligned(Element.ALIGN_CENTER
                        , waterMarkText, x,
                        y, 55);
                // 添加水印文字
                under.endText();
                under.setLineWidth(1f);
                under.stroke();
            }
            
            return bos;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
        	
        	if(stamper!= null){
        		try{
        			stamper.close();
        		}catch (Exception e) {
                    e.printStackTrace();
                }
        		
        	}
        }
		
		
    }
	
	/**
	 * PDF添加图片水印
	 * @param inputPDFFile 输入PDF文件路径
	 * @param waterMarkFile 水印图片路径
	 * @param outputPDFFile 输出PDF文件路径
	 * @return true/false
	 * @throws Exception
	 */
	public static boolean waterMarkByIcon(String inputPDFFile,String waterMarkFile,String outputPDFFile) throws Exception{
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputPDFFile);
			ByteArrayOutputStream bos = getOutputStreamOfWterMarkByIcon(inputPDFFile,waterMarkFile);
			
			fos.write(bos.toByteArray());
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	
	/**
	 * PDF添加文字水印
	 * @param inputPDFFile 输入PDF文件路径
	 * @param waterMarkText 水印文字
	 * @param outputPDFFile 输出PDF文件路径
	 * @return true/false
	 * @throws Exception
	 */
	public static boolean waterMarkByText(String inputPDFFile, String waterMarkText,String outputPDFFile) throws Exception{
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputPDFFile);
			ByteArrayOutputStream bos = getOutputStreamOfWterMarkByText(inputPDFFile,waterMarkText);
			
			fos.write(bos.toByteArray());
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
