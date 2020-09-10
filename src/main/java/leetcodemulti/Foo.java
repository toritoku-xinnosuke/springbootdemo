package leetcodemulti;

import java.util.concurrent.locks.LockSupport;

class Foo {

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        LockSupport.parkNanos(10);
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        LockSupport.parkNanos(20);
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        LockSupport.parkNanos(30);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
