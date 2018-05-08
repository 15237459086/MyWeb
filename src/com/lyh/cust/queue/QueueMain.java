package com.lyh.cust.queue;

public class QueueMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		PushBlockQueue.getInstance().start();
        for(;;){
            Thread.sleep(1000);
            PushBlockQueue.getInstance().put("0123456");
        }
	}

}
