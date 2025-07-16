package com.treecare.treecarebackend;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받는 것만으로 기본적인 DB 작업을 모두 처리할 수 있습니다.
public interface TreeRepository extends JpaRepository<Tree, Long> {
}