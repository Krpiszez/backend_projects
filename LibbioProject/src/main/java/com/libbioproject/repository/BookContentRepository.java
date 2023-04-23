package com.libbioproject.repository;

import com.libbioproject.domain.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookContentRepository extends JpaRepository<BookContent, Long> {
}
