package com.libbioproject.repository;

import com.libbioproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

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
