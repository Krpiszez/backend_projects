package com.libbioproject.repository;

import com.libbioproject.domain.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    Optional<ContactMessage> findByEmail(String email);

    Optional<ContactMessage> findByName(String name);
}
