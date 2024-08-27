package com.myrealtrip;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SsgItem{
    private final String title;
    private final String imageUrl;
    private final String description;
    private final BigDecimal price;

    public SsgItem(String title, String imageUrl, String description, BigDecimal price) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }

    public static SsgItem mock() {
        Random random = new Random();

        // 제목 리스트에서 랜덤 선택
        List<String> titles = Arrays.asList("Amazing Product", "Best Item", "Fantastic Gadget", "Awesome Thing");
        String randomTitle = titles.get(random.nextInt(titles.size()));

        // 이미지 URL 리스트에서 랜덤 선택
        List<String> imageUrls = Arrays.asList(
                "https://example.com/image1.jpg",
                "https://example.com/image2.jpg",
                "https://example.com/image3.jpg",
                "https://example.com/image4.jpg"
        );
        String randomImageUrl = imageUrls.get(random.nextInt(imageUrls.size()));

        // 설명 리스트에서 랜덤 선택
        List<String> descriptions = Arrays.asList(
                "This product is amazing!",
                "You'll love this item!",
                "Top quality and great value.",
                "A must-have for everyone."
        );
        String randomDescription = descriptions.get(random.nextInt(descriptions.size()));

        // 가격을 10.00 ~ 100.00 사이에서 랜덤 생성
        BigDecimal randomPrice = BigDecimal.valueOf(10 + (90 * random.nextDouble()))
                .setScale(2, RoundingMode.HALF_UP);

        // SsgItem 객체 생성 및 반환
        return new SsgItem(randomTitle, randomImageUrl, randomDescription, randomPrice);
    }

    @Override
    public String toString() {
        return "SsgItem{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
