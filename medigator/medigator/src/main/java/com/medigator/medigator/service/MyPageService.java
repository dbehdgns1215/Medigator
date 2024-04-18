package com.medigator.medigator.service;

import com.medigator.medigator.dto.MemberDTO;
import com.medigator.medigator.dto.MyPageDTO;
import com.medigator.medigator.entity.MemberEntity;
import com.medigator.medigator.entity.MyPageEntity;
import com.medigator.medigator.repository.MemberRepository;
import com.medigator.medigator.repository.MyPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

// spring bean으로 등록
@Service
@RequiredArgsConstructor
public class MyPageService {
    private final MyPageRepository mypageRepository;

    public void MyPage(MyPageDTO mypageDTO) {
        // repository의 join 메서드 호출 (조건 : entity 객체를 넘겨야 함.)
        // 1. DTO -> Entity 변환
        // 2. repository의 joun 메서드 호출.
        MyPageEntity mypageEntity = MyPageEntity.toMyPageEntity(mypageDTO);
        mypageRepository.save(mypageEntity);
    }
}
