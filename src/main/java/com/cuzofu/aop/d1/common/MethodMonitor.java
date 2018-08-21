package com.cuzofu.aop.d1.common;

class MethodMonitor {
    private long start;
    private String method;

    MethodMonitor(String method) {
        this.method = method;
        System.out.println("begin monitor...");
        this.start = System.currentTimeMillis();
    }

    void log() {
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("end monitor...");
        System.out.println("Method: " + method + ", execution time: " + elapsedTime + " milliseconds.");
    }

}
