package com.medigator.medigator.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate; // java.time.LocalDate import 추가

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column
    private String memberId;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    @Column(unique = true)
    private String memberEmail;

    @Column
    private LocalDate memberBirth;
}
