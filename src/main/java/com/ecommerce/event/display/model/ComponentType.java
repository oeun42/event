package com.ecommerce.event.display.model;

import lombok.Getter;

public enum ComponentType {

    BANNER(1, "배너"),
    PRODUCT(2, "상품"),
    COUPON(3, "쿠폰");

    @Getter
    private Integer componentType;
    private String description;


    ComponentType(Integer componentType, String description) {
        this.componentType = componentType;
        this.description = description;
    }
}
