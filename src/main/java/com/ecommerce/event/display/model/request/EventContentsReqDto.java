package com.ecommerce.event.display.model.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventContentsReqDto {
    private Long dpComponentNo;
    private Integer componentType;
}
