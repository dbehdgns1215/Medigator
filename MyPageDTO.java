package com.medigator.medigator.dto;

import com.medigator.medigator.entity.MyPageEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 회원 정보에 필요한 정보를 필드로 정의
public class MyPageDTO {
    private Long MyPageDTOid;
    private String name;
    private String sex;
    private int age;
    private int highbp;
    private int lowbp;

    public static MyPageDTO toMyPageDTO(MyPageEntity mypageEntity) {
        MyPageDTO mypageDTO = new MyPageDTO();
        mypageDTO.setMyPageDTOid(mypageEntity.getMyPageid());
        mypageDTO.setName(mypageEntity.getName());
        mypageDTO.setSex(mypageEntity.getSex());
        mypageDTO.setAge(mypageEntity.getAge());
        mypageDTO.setHighbp(mypageEntity.getHighbp());
        mypageDTO.setLowbp(mypageEntity.getLowbp());
        return mypageDTO;
    }
}
