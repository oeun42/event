package com.ecommerce.event.display.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

@Data
public class EventComponentReqDto {

    @NotNull(message = "이벤트 아이디를 입력해야 합니다.")
    private Long evtId;

    @NotNull(message = "전시구좌번호를 입력해야 합니다.")
    private Long exhibitionNo;

    @NotNull(message = "컴포넌트 타입을 입력해야 합니다.")
    private Integer componentType;

    @Pattern(regexp = "^[A-Z0-9]$", message = "컴포넌트코드는 대문자와 숫자로만 입력해야 합니다.")
    private String componentCd;

    @NotNull(message = "전시 유무를 입력해야 합니다.")
    private Integer dispYn;

    @NotNull(message = "전시 순서를 입력해야 합니다.")
    private Integer dispSeq;

    @Pattern(regexp = "[a-zA-Z0-9]", message = "생성자 아이디는 영어와 숫자로만 입력해야 합니다.")
    private String createId;

    private Long dpComponentNo;
}
