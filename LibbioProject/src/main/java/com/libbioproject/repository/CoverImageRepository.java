package com.libbioproject.repository;

import com.libbioproject.domain.CoverImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverImageRepository extends JpaRepository<CoverImage, Long> {
}
