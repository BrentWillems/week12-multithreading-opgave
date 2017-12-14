package be.pxl.multithreading.voorbeeld1a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ListUsage {
	public static void main(String... args) throws InterruptedException {
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());
        IntStream.rangeClosed(1, 10000).forEach(i -> integers.add(i));
        List<Thread> allThreads = new ArrayList<>();
        
        int size = integers.size();
        for (int i = 0; i < size / 100 ; i++) {
        	Thread aThread = new ReaderThread(integers);
        	allThreads.add(aThread);
        	aThread.start();        	
        }
        
        for(Thread aThread:allThreads) {
        	aThread.join();
        }
        
       
        System.out.println(integers.size());//should be zero
    }
}
