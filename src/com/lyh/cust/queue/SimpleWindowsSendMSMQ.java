package com.lyh.cust.queue;

import ionic.Msmq.Message;
import ionic.Msmq.MessageQueueException;
import ionic.Msmq.Queue;

public class SimpleWindowsSendMSMQ {

	static{
        System.loadLibrary("MsmqJava64");  
    }  
    public static void main(String[] args) {  
        try {  
            //192.32.12.76为本机的IP地址（经测试不能使用127.0.0.1,不然会报错）  
            //private$\\myqueue是队列名字  
        	
        	
            /*String fullname="direct=tcp:192.168.21.25\\private$\\javaqueue";  */
        	String fullname="direct=tcp:192.168.28.136\\private$\\javaqueue";  
             Queue queue= new Queue(fullname);  
             //标题  
             String label="testmessage";
             //内容  
             String body= "Hello, World2!";  
             //这个属性我还没搞清楚是什么，有大神知道的请告知  
             String correlationId = "123";   
             //创建消息  
             Message msg= new Message(body, label, correlationId);  
             //发送  
             queue.send(msg);  
         }  
         catch (MessageQueueException ex1) {  
             System.out.println("Put failure: " + ex1.toString());  
             ex1.printStackTrace();  
         } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}
