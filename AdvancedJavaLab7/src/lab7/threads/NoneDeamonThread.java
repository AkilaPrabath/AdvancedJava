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
public class NoneDeamonThread extends Thread {
   @Override
   public void run() {
       int i = 0;
 
       // Loop 10 times. This thread will end.
       while (i < 10) {
           System.out.println("  - Hello from None Deamon Thread " + i++);
           try {
               // Sleep 1 second
               Thread.sleep(1000);
           } catch (InterruptedException e) {
           }
       }
       // None deamon thread ending.
       System.out.println("\n==> None Deamon Thread ending\n");
   }
}
