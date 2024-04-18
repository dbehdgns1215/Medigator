package com.medigator.medigator.service;

import com.medigator.medigator.dto.MemberDTO;
import com.medigator.medigator.entity.MemberEntity;
import com.medigator.medigator.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

// spring bean으로 등록
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public void join(MemberDTO memberDTO) {
        // repository의 join 메서드 호출 (조건 : entity 객체를 넘겨야 함.)
        // 1. DTO -> Entity 변환
        // 2. repository의 joun 메서드 호출.
        MemberEntity memeberEntity = MemberEntity.toMemeberEntity(memberDTO);
        memberRepository.save(memeberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        // 아이디로 DB 조회 -> DB에서 비밀번호 가져와서 입력한 비밀번호와 일치하는지 판별.
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDTO.getMemberId());
        if (byMemberId.isPresent()) {
            // 조회 성공
            MemberEntity memberEntity = byMemberId.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // Entity 객체 -> DTO 객체 (변환)
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 조회 실패
            return null;
        }
    }

    public String idCheck(String memberId) {
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberId);
        if (byMemberId.isPresent()) {
            // 조회 결과 -> 있다 -> 사용할 수 없다.
            return null;
        } else {
            return "ok";
        }
    }
}
