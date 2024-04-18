package com.medigator.medigator.entity;

import com.medigator.medigator.dto.MyPageDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate; // java.time.LocalDate import 추가

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "mypage_table")
public class MyPageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long MyPageid;

    @Column(unique = true)
    private String name;

    @Column
    private String sex;

    @Column
    private int age;

    @Column
    private int highbp;

    @Column
    private int lowbp;
    public static MyPageEntity toMyPageEntity(MyPageDTO mypageDTO) {
        MyPageEntity mypageEntity = new MyPageEntity();
        mypageEntity.setName(mypageDTO.getName());
        mypageEntity.setSex(mypageDTO.getSex());
        mypageEntity.setAge(mypageDTO.getAge());
        mypageEntity.setHighbp(mypageDTO.getHighbp());
        mypageEntity.setLowbp(mypageDTO.getLowbp());
        return  mypageEntity;
    }
}
