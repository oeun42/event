package com.ecommerce.event.display.model.response;

import lombok.Data;

@Data
public class EventComponentResDto {
    private Long dpComponentNo;
    private Long evtId;
    private Long exhibitionNo;

    private Integer componentType;
    private String componentCd;
    private Integer dispYn;
    private Integer dispSeq;
}
