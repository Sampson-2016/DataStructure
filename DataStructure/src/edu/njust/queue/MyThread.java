package  edu.njust.queue;

import java.util.Random;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread implements Runnable{
	static MyNewQueue< Integer> myNewQueue=new MyNewQueue<Integer>();
	static Random rand=new Random(10);
	private int count=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.currentThread().isInterrupted()) {
			int i=rand.nextInt(10)+1;
			myNewQueue.put(i);
			System.out.println(myNewQueue.size());
			count++;
			if(count==5){
				Thread.currentThread().interrupt();
			}
		}

	}
	
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool();
		for(int i=0;i<3;i++){
			executorService.execute(new MyThread());
		}
		executorService.shutdown();
	}
}
  