package com.myrealtrip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long totalStartTime = System.currentTimeMillis();

        // 시작 시간 기록
        long startTime = System.currentTimeMillis();
        // 8000ms
        CompletableFuture<SsgCategory> ssgCategoryFuture = CompletableFuture.supplyAsync(getSsgCategorySupplier());

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("startTime = " + startTime);
        });

        // 3000ms
        CompletableFuture<SsgBanner> ssgBannerFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("배너 스레드: " + Thread.currentThread().getName());
            return new SsgBanner("banner!!!!!");
        });

        List<SsgItem> ssgItem = new ArrayList<>();
        ssgItem.add(SsgItem.mock());
        System.out.println(ssgCategoryFuture.isDone());
        ssgItem.add(SsgItem.mock());
        System.out.println(ssgCategoryFuture.isDone());
        ssgItem.add(SsgItem.mock());
        System.out.println(ssgCategoryFuture.isDone());
        ssgItem.add(SsgItem.mock());
        ssgItem.add(SsgItem.mock());
        voidCompletableFuture.join();
        System.out.println(ssgCategoryFuture.isDone());

        // 종료 시간 기록
        long endTime = System.currentTimeMillis();

        // 실행 시간 계산
        long elapsedTime = endTime - startTime;

        System.out.println("실행 시간: " + elapsedTime + " 밀리초");

        SsgVo ssgVo = new SsgVo(ssgBannerFuture.get(), ssgCategoryFuture.get(), ssgItem);

        System.out.println("ssgVo = " + ssgVo);
        long totalEndTime = System.currentTimeMillis();
        System.out.println("총 실행 시간: " + (totalEndTime - totalStartTime) + " 밀리초");
    }

    private static Supplier<SsgCategory> getSsgCategorySupplier() {
        return () -> {
            System.out.println("카테고리 스레드: " + Thread.currentThread().getName());
            return new SsgCategory("category!!!!!");
        };
    }
}