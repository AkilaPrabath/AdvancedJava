/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.threads;

/**
 *
 * @author Akila
 */
public class RunnableTest {
 
   public static void main(String[] args) throws InterruptedException {
 
       System.out.println("Main thread running..");
 
       // Create a thread from Runnable.
       Thread thread = new Thread(new RunnableDemo());
 
       thread.start();
 
       // Sleep 5 seconds.
       Thread.sleep(5000);
       System.out.println("Main thread stopped");
   }
}