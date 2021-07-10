package com.lgj.ex2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_memo")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

    @Transient
    private int t;
}
