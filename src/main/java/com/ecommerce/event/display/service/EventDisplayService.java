package com.ecommerce.event.display.service;


import com.ecommerce.event.display.dao.EventDisplayMapper;
import com.ecommerce.event.display.model.ComponentType;
import com.ecommerce.event.display.model.EventContent;
import com.ecommerce.event.display.model.request.EventContentsReqDto;
import com.ecommerce.event.display.model.request.EventExhibitionReqDto;
import com.ecommerce.event.display.model.response.EventExhibitionResDto;
import com.ecommerce.event.exception.exceptions.NoConentsTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    public List<EventExhibitionResDto> getEventExhibitionList(EventExhibitionReqDto eventExhibitionReqDto){
        return eventDisplayMapper.selectEventComponentList(eventExhibitionReqDto);
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
}
