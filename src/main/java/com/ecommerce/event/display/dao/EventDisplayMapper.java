package com.ecommerce.event.display.dao;

import com.ecommerce.event.display.model.EventContent;
import com.ecommerce.event.display.model.request.EventComponentReqDto;
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

    public void insertEventExhibition(EventExhibitionReqDto eventExhibitionReqDto);
    public void insertEventComponent(EventComponentReqDto eventComponentReqDto);
    public void insertEventBanner(EventContentsReqDto eventContentsReqDto);
    public void insertEventProduct(EventContentsReqDto eventContentsReqDto);

    public void insertEventCoupon(EventContentsReqDto eventContentsReqDto);
}
