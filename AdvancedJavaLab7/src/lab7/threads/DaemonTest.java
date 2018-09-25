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
public class DaemonTest {
 
   public static void main(String[] args) {
       System.out.println("==> Main Thread running..\n");
 
       // Create thread
       Thread deamonThread = new DeamonThread();
 
       // Set deamon true
       deamonThread.setDaemon(true);
       deamonThread.start();
 
       // Create other thread
       new NoneDeamonThread().start();
 
       try {
           // Sleep 5 second
           Thread.sleep(5000);
       } catch (InterruptedException e) {
       }
      
       // Main Thread ending
       System.out.println("\n==> Main Thread ending\n");
   }
 
}
