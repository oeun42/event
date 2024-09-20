package com.ecommerce.event.display.model.response;

import com.ecommerce.event.display.model.EventContent;
import lombok.Data;

@Data
public class EventDisplayBannerDto extends EventContent {
    private Long dpBannerNo;
    private String bannerImgPath;
    private String linkUrl;
}
