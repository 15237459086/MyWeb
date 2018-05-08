package com.lyh.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 水印工具Util
 * @author lyh
 *
 */
public class ImageRemarkUtil {

	// 水印透明度
    private static float alpha = 0.5f;
    // 水印横向位置
    private static int positionWidth = 150;
    // 水印纵向位置
    private static int positionHeight = 300;
    // 水印文字字体
    private static Font font = new Font("宋体", Font.BOLD, 72);
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
            ImageRemarkUtil.alpha = alpha;
        if (positionWidth != 0)
            ImageRemarkUtil.positionWidth = positionWidth;
        if (positionHeight != 0)
            ImageRemarkUtil.positionHeight = positionHeight;
        if (font != null)
            ImageRemarkUtil.font = font;
        if (color != null)
            ImageRemarkUtil.color = color;
    }

    /**
     * 获取缓存图片水印的图片对象
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param degree 目标图片路径
     * @return BufferedImage
     * @throws IOException
     */
    public static BufferedImage getBufferedMarkImageByIcon(String iconPath, String srcImgPath,
            Integer degree) throws IOException {
    	Image srcImg = ImageIO.read(new File(srcImgPath));

        BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // 1、得到画笔对象
        Graphics2D g = buffImg.createGraphics();

        // 2、设置对线段的锯齿状边缘处理
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g.drawImage(
                srcImg.getScaledInstance(srcImg.getWidth(null),
                        srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                null);
        // 3、设置水印旋转
        if (null != degree) {
            g.rotate(Math.toRadians(degree),
                    (double) buffImg.getWidth() / 2,
                    (double) buffImg.getHeight() / 2);
        }

        // 4、水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
        ImageIcon imgIcon = new ImageIcon(iconPath);

        // 5、得到Image对象。
        Image img = imgIcon.getImage();

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                alpha));

        // 6、水印图片的位置
        g.drawImage(img, positionWidth, positionHeight, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        // 7、释放资源
        g.dispose();
        return buffImg;
    }
    
    /**
     * 生成带图片水印的图像
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath){
    	OutputStream os = null;
    	try {
			BufferedImage buffImg = ImageRemarkUtil.getBufferedMarkImageByIcon(iconPath, srcImgPath,null);
			os = new FileOutputStream(targerPath);
	        ImageIO.write(buffImg, "JPG", os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	           try {
	               if (null != os)
	                   os.close();
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	       }
    }
    
    /**
     * 生成带图片水印的图像
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath,Integer degree) {
    	OutputStream os = null;
    	try {
			BufferedImage buffImg = ImageRemarkUtil.getBufferedMarkImageByIcon(iconPath, srcImgPath,degree);
			os = new FileOutputStream(targerPath);
	        ImageIO.write(buffImg, "JPG", os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	           try {
	               if (null != os)
	                   os.close();
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	       }
    }
    
    /**
     * 获取缓存图片水印的图片对象
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @return BufferedImage
     * @throws IOException
     */
    public static BufferedImage getBufferedMarkImageByIcon(String iconPath, String srcImgPath) throws IOException{
    	return ImageRemarkUtil.getBufferedMarkImageByIcon(iconPath, srcImgPath,null);
    }
    
    /**
     * 获取缓存文字水印的图片对象
     * @param logoText 水印文字
     * @param srcImgPath 源图片路径
     * @param degree 水印图片旋转角度
     * @return BufferedImage
     * @throws IOException
     */
    public static BufferedImage getBufferedMarkImageByText(String logoText, String srcImgPath,Integer degree) throws IOException {

    	// 1、源图片
        Image srcImg = ImageIO.read(new File(srcImgPath));
        BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // 2、得到画笔对象
        Graphics2D g = buffImg.createGraphics();
        // 3、设置对线段的锯齿状边缘处理
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(
                srcImg.getScaledInstance(srcImg.getWidth(null),
                        srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                null);
        // 4、设置水印旋转
        if (null != degree) {
            g.rotate(Math.toRadians(degree),
                    (double) buffImg.getWidth() / 2,
                    (double) buffImg.getHeight() / 2);
        }
        // 5、设置水印文字颜色
        g.setColor(color);
        // 6、设置水印文字Font
        g.setFont(font);
        // 7、设置水印文字透明度
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                alpha));
        // 8、第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
        g.drawString(logoText, positionWidth, positionHeight);
        // 9、释放资源
        g.dispose();
        return buffImg;
    }

    /**
     * 获取缓存文字水印的图片对象
     * @param logoText 水印文字
     * @param srcImgPath 源图片路径
     * @return BufferedImage
     * @throws IOException
     */
    public static BufferedImage getBufferedMarkImageByText(String logoText, String srcImgPath) throws IOException{
    	return getBufferedMarkImageByText(logoText, srcImgPath,null);
    }
    
    /**
     * 生成带文字水印的图像
     * @param logoText 水印文字
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     */
    public static void markImageByText(String logoText, String srcImgPath,
            String targerPath) {
    	OutputStream os = null;
    	try {
			BufferedImage buffImg  = getBufferedMarkImageByText(logoText, srcImgPath,null);
			os = new FileOutputStream(targerPath);
           ImageIO.write(buffImg, "JPG", os);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
           try {
               if (null != os)
                   os.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
    
    /**
     * 生成带文字水印的图像
     * @param logoText 水印文字
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     */
    public static void markImageByText(String logoText, String srcImgPath,
            String targerPath, Integer degree) {
    	OutputStream os = null;
    	try {
			BufferedImage buffImg  = getBufferedMarkImageByText(logoText, srcImgPath,degree);
			os = new FileOutputStream(targerPath);
           ImageIO.write(buffImg, "JPG", os);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
           try {
               if (null != os)
                   os.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
}
