package com.treecare.treecarebackend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity      // 이 클래스가 데이터베이스 테이블임을 나타냅니다.
@Getter      // 각 필드의 getter 메소드를 자동으로 만듭니다. (Lombok)
@Setter      // 각 필드의 setter 메소드를 자동으로 만듭니다. (Lombok)
public class Tree {

    @Id // 이 필드가 테이블의 고유 식별자(PK)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 값을 자동으로 생성합니다.
    private Long id;

    private String title;
    private double lat;
    private double lng;
    private int moisture;
    private boolean isAdopted = false; // 입양 여부 필드 추가
}