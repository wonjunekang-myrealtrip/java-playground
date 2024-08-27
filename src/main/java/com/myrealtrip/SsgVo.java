package com.myrealtrip;

import java.util.List;

public class SsgVo {
    private final SsgBanner ssgBanner;
    private final SsgCategory ssgCategory;
    private final List<SsgItem> ssgItem;

    public SsgVo(SsgBanner ssgBanner, SsgCategory ssgCategory, List<SsgItem> ssgItem) {
        this.ssgBanner = ssgBanner;
        this.ssgCategory = ssgCategory;
        this.ssgItem = ssgItem;
    }

    @Override
    public String toString() {
        return "SsgVo{" +
                "ssgBanner=" + ssgBanner +
                ", ssgCategory=" + ssgCategory +
                ", ssgItem=" + ssgItem +
                '}';
    }
}
