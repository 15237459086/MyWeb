package com.lyh.cust.queue;

public class PushBlockQueueHandler implements Runnable {

	private Object obj;
    public PushBlockQueueHandler(Object obj){
        this.obj = obj;
    }
    
    @Override
    public void run() {
        doBusiness();
    }
    
    /**
     * 业务处理时限
     */
    public void doBusiness(){
        System.out.println(" 处理请求 "+obj );
    }

}
