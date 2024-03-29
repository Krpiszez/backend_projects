package com.libbioproject.repository;

import com.libbioproject.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "roles")
    Optional<User> findByEmail(String email);
    @EntityGraph(attributePaths = "roles")
    Optional<User> findById(Long id);
    @EntityGraph(attributePaths = "roles")
    List<User> findAll();

    boolean existsByEmail(String email);
    @Query("update User u set u.firstName = :firstName, u.lastName = :lastName, u.phoneNumber = :phoneNumber, u.email = :email, " +
            "u.address = :address, u.zipCode = :zipCode where u.id = :id")
    @Modifying
    void update(@Param("id") Long id,
                @Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("phoneNumber") String phoneNumber,
                @Param("email") String email,
                @Param("address") String address,
                @Param("zipCode") String zipCode);
}
