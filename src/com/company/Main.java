package com.company;
class Priority implements Runnable {
    static int count;
    static Thread thread;
    static Boolean stop = false;
    static String currentName;

    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
        return;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(thread.getName() + " is starting to operate.");
        do {
            count++;
            if (currentName.compareTo(thread.getName()) != 0) {
                currentName = thread.getName();
                System.out.println(thread.getName() + " is executed.");
            }
        } while (stop == false && count < 10_000_000);
        stop = true;
        System.out.println("\n" + thread.getName() + " finished running.");

    }
}
       class Main {
            public static void main(String[] args) {
                Priority p1 = new Priority("1st priority");
                Priority p2 = new Priority("2nd priority");
                Priority p3 = new Priority("3rd priority");
                Priority p4 = new Priority("4th priority");
                Priority p5 = new Priority("5th priority");

                p1.thread.setPriority(Thread.MAX_PRIORITY + 5);
                p2.thread.setPriority(Thread.MIN_PRIORITY - 5);

                p1.thread.start();
                p2.thread.start();
                p3.thread.start();
                p4.thread.start();
                p5.thread.start();

                try {
                    p1.thread.join();
                    p2.thread.join();
                    p3.thread.join();
                    p4.thread.join();
                    p5.thread.join();
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
}
