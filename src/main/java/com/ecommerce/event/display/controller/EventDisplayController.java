package com.ecommerce.event.display.controller;


import com.ecommerce.event.display.model.EventContent;
import com.ecommerce.event.display.model.request.EventComponentReqDto;
import com.ecommerce.event.display.model.request.EventContentsReqDto;
import com.ecommerce.event.display.model.request.EventExhibitionReqDto;
import com.ecommerce.event.display.model.response.EventExhibitionResDto;
import com.ecommerce.event.display.service.EventDisplayService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventDisplayController {
    private final EventDisplayService eventDisplayService;


    @Autowired
    public EventDisplayController(EventDisplayService eventDisplayService){
        this.eventDisplayService = eventDisplayService;
    }

    /*
    전시구좌 생성
     */
    @PostMapping("/display/exhibition")
    public ResponseEntity<Long> createEventExhibition(@Valid @RequestBody EventExhibitionReqDto eventExhibitionReqDto){

        return ResponseEntity.ok(eventDisplayService.createEventExhibition(eventExhibitionReqDto));
    }

    /*
    컴포넌트 생성
    */
    @PostMapping("/display/component")
    public ResponseEntity<Long> createEventComponent(@Valid @RequestBody EventComponentReqDto eventComponentReqDto){


        return ResponseEntity.ok(eventDisplayService.createEventComponent(eventComponentReqDto));
    }

    /*
    컨텐츠 생성
     */
    @PostMapping("/display/content")
    public ResponseEntity<Long> createEventContent(@Valid @RequestBody EventContentsReqDto eventContentsReqDto){


        return ResponseEntity.ok(eventDisplayService.createEventContent(eventContentsReqDto));
    }

    /*
    전시 컨텐츠 개별 조회
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
      전시 컨텐츠 구좌별 조회
    */
    @GetMapping("/display/exhibition/content")
    public ResponseEntity<List<List<EventContent>>> getEventExhibitionContents(@RequestParam(value = "exhibitionNo")Long exhibitionNo
                                                                       ) throws Exception {

        return ResponseEntity.ok(eventDisplayService.getEventExhibitionContents(exhibitionNo));

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
