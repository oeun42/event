package com.ecommerce.event.display.model;


import lombok.Data;

@Data
public abstract class EventContent {
    private Long dpComponentNo;
    private Long evtId;

    private Integer dispSeq;
    private Integer dispYn;
}
