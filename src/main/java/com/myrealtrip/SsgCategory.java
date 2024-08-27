package com.myrealtrip;

public class SsgCategory {
    private final String title;

    @Override
    public String toString() {
        return "SsgCategory{" +
                "title='" + title + '\'' +
                '}';
    }

    public SsgCategory(String title) {
        this.title = title;

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
