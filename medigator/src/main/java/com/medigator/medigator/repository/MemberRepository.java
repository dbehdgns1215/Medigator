package com.medigator.medigator.repository;

import com.medigator.medigator.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

                                                    // 어떤 엔티티 ,    PK키 자료형
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 아이디로 회원 정보 조회
    Optional<MemberEntity> findByMemberId(String memberId);
    // SELECT * FROM member_table WHERE member_Id=?


}