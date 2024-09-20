package com.ecommerce.event.display.model.response;

import com.ecommerce.event.display.model.EventContent;
import lombok.Data;

@Data
public class EventDisplayCouponDto extends EventContent {
    private Long dpCouponNo;
    private String clickAction;
    private Long couponId;
}
