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

    public LoginResponse login(MemberDTO memberDTO) {
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDTO.getMemberId());
        if (byMemberId.isPresent()) {
            MemberEntity memberEntity = byMemberId.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return new LoginResponse(true, "로그인 성공", dto);
            } else {
                return new LoginResponse(false, "비밀번호가 틀렸습니다.", null);
            }
        } else {
            return new LoginResponse(false, "존재하지 않는 아이디입니다.", null);
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
