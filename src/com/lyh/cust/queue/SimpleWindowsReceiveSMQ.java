package com.lyh.cust.queue;

import ionic.Msmq.Message;
import ionic.Msmq.MessageQueueException;
import ionic.Msmq.Queue;

public class SimpleWindowsReceiveSMQ {

	static{  
        System.loadLibrary("MsmqJava64");  
    }  
    public static void main(String[] args) {  
        try {  
            //192.32.12.76为本机的IP地址（经测试不能使用127.0.0.1,不然会报错）  
            //private$\\myqueue是队列名字  
        	 /*String fullname="direct=tcp:192.168.21.25\\private$\\javaqueue"; */
        	String fullname="direct=tcp:192.168.1.104\\private$\\javaqueue";
             Queue queue= new Queue(fullname);  
             Message message=queue.receive();
             System.out.println(message.getBodyAsString());  
         }  
         catch (MessageQueueException ex1) {  
             System.out.println("Put failure: " + ex1.toString());  
             ex1.printStackTrace();  
         } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
