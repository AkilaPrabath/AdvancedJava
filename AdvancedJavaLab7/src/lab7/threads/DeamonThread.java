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
class DeamonThread extends Thread {
   @Override
   public void run() {
       int count = 0;
      
       // Infinite loop
       while (true) {
           System.out.println("+ Hello from Deamon Thread " + count++);
           try {
               // Sleep 2 second
               sleep(2000);
           } catch (InterruptedException e) {
           }
       }
   }
}
