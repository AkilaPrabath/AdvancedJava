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
public class JoinTest {
 
   public static void main(String[] args) throws InterruptedException {
 
       System.out.println("\n==> Main thread starting..\n");
 
       Thread joinThreadA = new JoinThread("A*", 2);
       Thread joinThreadB = new JoinThread("B*", 3);
       // None join Thread.
       Thread noJoinThreadC = new JoinThread("C", 5);
       joinThreadA.start();
       joinThreadB.start();
       noJoinThreadC.start();
       // Using join()
       joinThreadA.join();
       joinThreadB.join();
       // The following code will have to wait until 2
       // JoinThread A, B completed.
       System.out.println("Hello from main thread...");
 
       System.out.println("Thread A isLive? " + joinThreadA.isAlive());
       System.out.println("Thread B isLive? " + joinThreadB.isAlive());
       System.out.println("Thread C isLive? " + noJoinThreadC.isAlive());
 
       System.out.println("\n==> Main Thread end!\n");
   }
}
