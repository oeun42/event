package com.ecommerce.event.display.dao;

import com.ecommerce.event.display.model.EventContent;
import com.ecommerce.event.display.model.request.EventContentsReqDto;
import com.ecommerce.event.display.model.request.EventExhibitionReqDto;
import com.ecommerce.event.display.model.response.EventExhibitionResDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventDisplayMapper {
    public List<EventExhibitionResDto> selectEventComponentList(EventExhibitionReqDto eventExhibitionReqDto);

    public List<EventContent> selectEventBannerList(EventContentsReqDto eventContentsReqDto);

    public List<EventContent> selectEventProductList(EventContentsReqDto eventContentsReqDto);

    public List<EventContent> selectEventCouponList(EventContentsReqDto eventContentsReqDto);
}
