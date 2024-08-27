package com.myrealtrip;

public class SsgBanner {
    private final String title;

    public SsgBanner(String title) {
        this.title = title;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "SsgBanner{" +
                "title='" + title + '\'' +
                '}';
    }
}
