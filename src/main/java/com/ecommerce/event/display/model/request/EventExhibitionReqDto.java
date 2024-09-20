package com.ecommerce.event.display.model.request;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class EventExhibitionReqDto {
    private Long evtId;
}
