package com.ecommerce.event.display.service;


import com.ecommerce.event.display.dao.EventDisplayMapper;
import com.ecommerce.event.display.model.EventContent;
import com.ecommerce.event.display.model.request.EventComponentReqDto;
import com.ecommerce.event.display.model.request.EventContentsReqDto;
import com.ecommerce.event.display.model.request.EventExhibitionReqDto;
import com.ecommerce.event.display.model.response.EventComponentResDto;
import com.ecommerce.event.display.model.response.EventExhibitionResDto;
import com.ecommerce.event.exception.exceptions.NoConentsTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.event.display.model.ComponentType.*;

@Service
public class EventDisplayService {

    private final EventDisplayMapper eventDisplayMapper;

    @Autowired
    public EventDisplayService(EventDisplayMapper eventDisplayMapper){
        this.eventDisplayMapper = eventDisplayMapper;
    }


    public Long createEventExhibition(EventExhibitionReqDto eventExhibitionReqDto){
        eventDisplayMapper.insertEventExhibition(eventExhibitionReqDto);

        return eventExhibitionReqDto.getExhibitionNo();
    }

    public Long createEventComponent(EventComponentReqDto eventComponentReqDto){
        eventDisplayMapper.insertEventComponent(eventComponentReqDto);

        return eventComponentReqDto.getDpComponentNo();
    }

    public Long createEventContent(EventContentsReqDto eventContentsReqDto){
        Integer componentType = eventContentsReqDto.getComponentType();
        Long contentKey = null;

        if(BANNER.getComponentType().equals(eventContentsReqDto.getComponentType())){
            eventDisplayMapper.insertEventBanner(eventContentsReqDto);
            contentKey = eventContentsReqDto.getDpBannerNo();
        }
        else if(PRODUCT.getComponentType().equals(componentType)){
            eventDisplayMapper.insertEventProduct(eventContentsReqDto);
            contentKey = eventContentsReqDto.getDpProductNo();
        }
        else if(COUPON.getComponentType().equals(componentType)){
            eventDisplayMapper.insertEventCoupon(eventContentsReqDto);
            contentKey = eventContentsReqDto.getDpCouponNo();
        }
        else {
            throw new NoConentsTypeException("Wrong Component Type");
        }
        return contentKey;
    }

    public List<EventExhibitionResDto> getEventExhibitionList(EventExhibitionReqDto eventExhibitionReqDto){
        return eventDisplayMapper.selectEventExhibitionList(eventExhibitionReqDto);
    }


    public List<EventContent> getEventComponentContents(EventContentsReqDto eventContentsReqDto) throws Exception {
        List<EventContent> eventContents = null;
        Integer componentType = eventContentsReqDto.getComponentType();

        if(BANNER.getComponentType().equals(componentType)){
            eventContents = eventDisplayMapper.selectEventBannerList(eventContentsReqDto);
        }
        else if(PRODUCT.getComponentType().equals(componentType)){
            eventContents = eventDisplayMapper.selectEventProductList(eventContentsReqDto);
        }
        else if(COUPON.getComponentType().equals(componentType)){
            eventContents = eventDisplayMapper.selectEventCouponList(eventContentsReqDto);
        }
        else {
            throw new NoConentsTypeException("Wrong Component Type");
        }

        return eventContents;
    }

    public List<List<EventContent>> getEventExhibitionContents(Long exhibitionNo){
        List<EventComponentResDto> components = eventDisplayMapper.selectEventComponentList(exhibitionNo);

        List<List<EventContent>> exhbitionContentsList = new ArrayList<>();
        Integer componentType = null;

        for(EventComponentResDto component : components){
            componentType = component.getComponentType();
            EventContentsReqDto eventContentsReqDto = EventContentsReqDto.builder()
                    .dpComponentNo(component.getDpComponentNo())
                    .build();

            if(BANNER.getComponentType().equals(componentType)){
                exhbitionContentsList.add(eventDisplayMapper.selectEventBannerList(eventContentsReqDto));
            }
            else if(PRODUCT.getComponentType().equals(componentType)){
                exhbitionContentsList.add(eventDisplayMapper.selectEventBannerList(eventContentsReqDto));
            }
            else if(COUPON.getComponentType().equals(componentType)){
                exhbitionContentsList.add(eventDisplayMapper.selectEventBannerList(eventContentsReqDto));
            }
            else {
                throw new NoConentsTypeException("Wrong Component Type");
            }
        }

        return exhbitionContentsList;
    }
}
