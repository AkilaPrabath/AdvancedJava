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
public class HelloThread extends Thread {
   @Override
   public void run() {
       int index = 1;
 
       for (int i = 0; i < 10; i++) {
           System.out.println("  - HelloThread running " + index++);
 
           try {
               // Sleep 1030 miliseconds.
               Thread.sleep(1030);
           } catch (InterruptedException e) {
           }
 
       }
       System.out.println("  - ==> HelloThread stopped");
   }
}
