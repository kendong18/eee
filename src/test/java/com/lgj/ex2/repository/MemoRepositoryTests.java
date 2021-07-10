package com.lgj.ex2.repository;

import com.lgj.ex2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
        // 출력 결과 값 : com.sun.proxy.$Proxy92
        // 스프링이 MemoRepository 객체를 자동으로 생성
        // 자동으로 생성할 때 프록시 방법으로 생성하기 때문에 위아 같은 이름이 출력

    }

    //등록 테스트 메소드
//    @Test
//    public void testInsertDummies(){
//        IntStream.range(1, 100).forEach(i -> {
//            Memo memo = Memo.builder().memoText("Sample " + i).build();
//            memoRepository.save(memo);
//        });
//    }


    // 조회 작업 테스트 메서드 : findById
//    @Test
//    public void testSelect(){
//        // 데이터베이스에 존재하는 mno
//        Long mno = 100L;
//        Optional<Memo> result = memoRepository.findById(mno);
//        System.out.println("========================");
//
//        if(result.isPresent()){
//            Memo memo = result.get();
//            System.out.println(memo);
//        }
//
//        System.out.println("========================");
//
//    }
    // 조회 작업 테스트 2 : getOne()를 이용
    // getOne()는 엔티티 객체로 변환

//    @Test
//    public void testSelect2(){
//        Long mno = 100L;
//        Memo memo = memoRepository.getOne(mno);
//        System.out.println("=================================");
//
//        System.out.println(memo);
//
//        System.out.println("=================================");
//    }

    // 수정 작업 테스트 메소드 : save() 메서드 사용
//    @Test
//    public void testUpdate(){
//        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
//        System.out.println(memoRepository.save(memo));
//    }

//    // 삭제 테스트 메서드 : deleteById()를 이용
//    @Test
//    public void testDelete(){
//        Long mno = 100L;
//        memoRepository.deleteById(mno);
//    }


    // 페이지 처리 메서드 : findAll()
    // findAll() : Spring Data JPA에서 페이징 처리와 정렬 작업에서 사용되는 메서드
    // PagingAndSortRepository에서 정의된 메서드
    // 이 메서드에 전달할 수 있는 데이터는 Pageable 객체
    // 따라서 이 메서드를 사용하려면 먼저 Pageable 객체를 생성해야 하고
    // 이 객체는 PageRequest.of(시작, 갯수)같이 지정하여 얻어낼 수 있다.
    // 주의사항 : 스프링부트 2.0 버전부터 지원.

//    @Test
//    public void testPageDefault(){
//        // 만약 한 페이지에 10개씩 출력하고 싶을 경우
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<Memo> result = memoRepository.findAll(pageable);
//
//        System.out.println(result);
//        System.out.println("--------------------------------------");
//        System.out.println("Total Pages : " + result.getTotalPages());
//        System.out.println("Total Count : " + result.getTotalElements());
//        System.out.println("Current Page Number" + result.getNumber());
//        System.out.println("has next page? : " + result.hasNext());
//        System.out.println("first page? : " + result.isFirst());
//
//    }

    // 정렬 조건 추가 및 조회된 데이터 출력 : finAll() 메서드 이용
//    @Test
//    public void testSort(){
//        Sort sort = Sort.by("mno").descending();
//
//        Pageable pageable = PageRequest.of(3, 10, sort);
//        Page<Memo> result = memoRepository.findAll(pageable);
//
//        result.get().forEach(memo ->{
//            System.out.println(memo);
//        });
//    }
//    @Test
//    public void testQueryMethods(){
//        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
//        for(Memo memo : list){
//            System.out.println(memo);
//        }
//    }

    // 쿼리 메소드와 Pageable 결합
    // Memo의 mno 값이 10~50 사이의 객체를 조회하고
    // 그 중에 첫 페이지에 해당하는 10개의 객체를 mno를 기준으로 역순 정렬

//    @Test
//    public void testQueryMethodWithPageable(){
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
//        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
//
//        result.get().forEach(memo -> System.out.println(memo));
//    }

//    @Commit
//    @Transactional
//    @Test
//    public void testDeleteQueryMethods(){
//        memoRepository.deleteMemoByMnoLessThan(10L);
//    }
//

    // JPQL : Entity Class 기준
    // SQL : Table 기준
    // JPA 에서는
    // SQL "select * from tbl_memo m order by m.mno desc"
    // JPQL "select m from Memo m order by m.mno desc"
//    @Test
//    public void testSelectAll(){
//        List<Memo> list = memoRepository.getListDesc();
//
//        for (Memo memo : list){
//            System.out.println(memo);
//        }
//    }

//    @Test
//    public void testUpdate(){
//        memoRepository.updateMemoText(30L, "asdf");
//    }

   @Test
   public void testUpdateMemoText(){
        Memo memo = Memo.builder().mno(22L).memoText("TTT").build();
        int n = memoRepository.updateMemoText(memo);
   }
}
