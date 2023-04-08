package com.libbioproject.repository;

import com.libbioproject.domain.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDataRepository extends JpaRepository<BookData, Long> {
}
