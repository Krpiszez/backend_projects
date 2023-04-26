package com.libbioproject.repository;

import com.libbioproject.domain.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select count(*) from Book b join b.image img where img.id = :id")
    Integer findBookCountByImageId(@Param("id") String imageId);

    @EntityGraph(attributePaths = {"imageFile"})
    List<Book> findAll();

}
