/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.threads;
import java.util.Date;
 
public class YieldThreadExample {
 
    private static Date importantEndTime;
    private static Date unImportantEndTime;
 
    public static void main(String[] args) {
        importantEndTime = new Date();
        unImportantEndTime = new Date();
 
        System.out.println("Create thread 1");
 
        Thread importantThread = new ImportantThread();
 
        // Set the highest priority for this thread.
        importantThread.setPriority(Thread.MAX_PRIORITY);
 
        System.out.println("Create thread 2");
 
        Thread unImportantThread = new UnImportantThread();
 
        // Set the lowest priority for this thread.
        unImportantThread.setPriority(Thread.MIN_PRIORITY);
 
        // Start threads.
        unImportantThread.start();
        importantThread.start();
 
    }
 
    // A important job which requires high priority.
    static class ImportantThread extends Thread {
 
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                System.out.println("\n Important work " + i);
 
                // Notifying the operating system,
                // this thread gives priority to other threads.
                Thread.yield();
            }
 
            // The end time of this thread.
            importantEndTime = new Date();
            printTime();
        }
 
    }
 
    static class UnImportantThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                System.out.println("\n  -- UnImportant work " + i);
            }
            // The end time of this thread.
            unImportantEndTime = new Date();
            printTime();
        }
    }
 
    private static void printTime() {
        // Interval (Milliseconds)
        long interval = unImportantEndTime.getTime() - importantEndTime.getTime();
 
        System.out.println("UnImportant Thread - Important Thread = " //
                + interval + " milliseconds");
    }
 
}