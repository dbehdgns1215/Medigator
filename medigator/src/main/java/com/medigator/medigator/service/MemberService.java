package com.medigator.medigator.service;

import com.medigator.medigator.dto.MemberDTO;
import com.medigator.medigator.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// spring bean으로 등록
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(MemberDTO memberDTO) {

    }
}
