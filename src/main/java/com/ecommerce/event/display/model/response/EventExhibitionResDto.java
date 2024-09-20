package com.ecommerce.event.display.model.response;

import lombok.Data;

import java.util.List;

@Data
public class EventExhibitionResDto {
    private Long evtId;              //이벤트 번호
    private Long exhibitionNo;       //전시구좌 번호

    private Integer dispSeq;         //전시순서
    private Integer dispYn;          //전시유무(0,1)
    private String title;            //전시구좌 제목
    private String bgColor;          //배경색
    private String bgImgPath;        //배경 이미지 URL

    private List<EventComponentResDto> componentList;
}
