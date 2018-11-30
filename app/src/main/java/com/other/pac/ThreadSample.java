package com.other.pac;

public class ThreadSample extends Thread{
    @Override
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return super.getUncaughtExceptionHandler();
    }
}
