package com.ecommerce.event.display.model.response;


import com.ecommerce.event.display.model.EventContent;
import lombok.Data;

@Data
public class EventDisplayProductDto extends EventContent {
    private Long dpProductNo;
    private Long productId;
}
