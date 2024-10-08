package com.ecommerce.event.display.model.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class EventContentsReqDto {
    @NotNull(message = "이벤트 아이디를 입력해야 합니다.")
    private Long evtId;

    @NotNull(message = "컴포넌트 번호를 입력해야 합니다.")
    private Long dpComponentNo;

    @NotNull(message = "컴포넌트 타입을 입력해야 합니다.")
    private Integer componentType;

    @NotNull(message = "전시 유무를 입력해야 합니다.")
    private Integer dispYn;

    @NotNull(message = "전시 순서를 입력해야 합니다.")
    private Integer dispSeq;

    @Pattern(regexp = "[a-zA-Z0-9]", message = "생성자 아이디는 영어와 숫자로만 입력해야 합니다.")
    private String createId;

    /*배너*/
    private Long dpBannerNo;
    private String bannerImgPath;
    private String linkUrl;

    /*상품*/
    private Long dpProductNo;
    private Long productId;

    /*쿠폰*/
    private Long dpCouponNo;
    private String clickAction;
    private Long couponId;
}
