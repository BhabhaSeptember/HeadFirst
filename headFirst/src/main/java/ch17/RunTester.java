/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17;

/**
 *
 * @author User
 */
//HOW NOT TO RUN THE RUNNABLE
//This code below will not work as we expect it to because the run() method is
//sitting in the main method, so it becomes part of the main method call stack
//instead of its own new call stack
public class RunTester {

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        runnable.run();

        System.out.println(Thread.currentThread().getName()
                + ": back in main");
        Thread.dumpStack();
    }
}
