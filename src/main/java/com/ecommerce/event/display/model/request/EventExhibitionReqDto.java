package com.ecommerce.event.display.model.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class EventExhibitionReqDto {

    @NotNull(message = "이벤트 아이디를 입력해야 합니다.")
    private Long evtId;

    @NotNull(message = "전시 유무를 입력해야 합니다.")
    private Integer dispYn;

    @NotNull(message = "전시 순서를 입력해야 합니다.")
    private Integer dispSeq;

    @Pattern(regexp = "[a-zA-Z0-9]", message = "생성자 아이디는 영어와 숫자로만 입력해야 합니다.")
    private String createId;

    private Long exhibitionNo;
}
