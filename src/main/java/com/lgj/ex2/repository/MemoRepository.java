package com.lgj.ex2.repository;

import com.lgj.ex2.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // Memo의 mno 값이 70~80 사이의 객체들을 조회하고, mno의 역순으로 정렬할 수 있는 쿼리 메소드
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    // 쿼리 메소드와 Pageable을 결합한 쿼리 메소드
    Page<Memo>findByMnoBetween(Long from, Long to, Pageable pageable);

    // 특정 조건에 맞는 엔티티 객체를 삭제하는 쿼리 메소드
    // Memo의 mno가 10 보다 작은 엔티티 객체를 삭제하는 메소드
    void deleteMemoByMnoLessThan(Long num);

    @Query("select  m from  Memo m order by m.mno desc")
    List<Memo> getListDesc();

    @Transactional
    @Modifying
    @Query("update Memo m set m.memoText = :memoText where m.mno = :mno")
    int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText);


    @Transactional
    @Modifying
    @Query("update Memo m set m.memoText = :#{#param.memoText} where m.mno = :#{#param.mno}")
    int updateMemoText(@Param("param") Memo memo);
}
