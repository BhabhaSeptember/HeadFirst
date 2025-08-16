/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17;

/**
 *
 * @author User
 */
//AN OLD APPROACH TO LAUNCHING A NEW THREAD
public class ThreadTester {

    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
//Pass the new Runnable instance into the new Thread constructor and it will
//tell the thread which job to run i.e. the Runnable's run() method will be 
//the first method that the new thread will run
        Thread myThread = new Thread(threadJob);

//In order to get a new thread of execution we must call the start() method
//on the Thread instance otherwise the Thread instance remains an object
//Now we will have two independent call stacks
        myThread.start();

        System.out.println(Thread.currentThread().getName()
                + ": back in main");
        Thread.dumpStack();
    }
}

