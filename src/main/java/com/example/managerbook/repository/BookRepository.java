package com.example.managerbook.repository;

import com.example.managerbook.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    List<BookEntity> findAllByCategoryId(Integer cateId, Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE book SET title = ?1 WHERE id = ?2")
    int updateBookByNativeModify(String title, Integer id);

    @Query(nativeQuery = true, value = "SELECT id, title FROM book")
    List<Object[]> getIdAndTitle();

}
