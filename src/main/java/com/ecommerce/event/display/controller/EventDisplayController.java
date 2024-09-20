package com.ecommerce.event.display.controller;


import com.ecommerce.event.display.model.EventContent;
import com.ecommerce.event.display.model.request.EventContentsReqDto;
import com.ecommerce.event.display.model.request.EventExhibitionReqDto;
import com.ecommerce.event.display.model.response.EventExhibitionResDto;
import com.ecommerce.event.display.service.EventDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventDisplayController {
    private final EventDisplayService eventDisplayService;


    @Autowired
    public EventDisplayController(EventDisplayService eventDisplayService){
        this.eventDisplayService = eventDisplayService;
    }

    /*
    전시 컨텐츠 조회
     */
    @GetMapping("/display/content")
    public ResponseEntity<List<EventContent>> getEventComponentContents(@RequestParam(value = "dpComponentNo")Long dpComponentNo,
                                                                        @RequestParam(value = "componentType")Integer componentType) throws Exception {
        EventContentsReqDto contentsReqDto = EventContentsReqDto.builder()
                .dpComponentNo(dpComponentNo)
                .componentType(componentType)
                .build();

        return ResponseEntity.ok(eventDisplayService.getEventComponentContents(contentsReqDto));

    }

    /*
    전시구좌 및 컴포넌트 조회
     */
    @GetMapping("/display/exhibition")
    public ResponseEntity<List<EventExhibitionResDto>> getEventExhibitionList(@RequestParam(value = "evtId")Long evtId){
        EventExhibitionReqDto eventExhibitionReqDto = EventExhibitionReqDto.builder()
                .evtId(evtId)
                .build();

        return ResponseEntity.ok(eventDisplayService.getEventExhibitionList(eventExhibitionReqDto));
    }
}
