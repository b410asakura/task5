package com20.task5.repository;

import com20.task5.dto.userDto.UserResponse;
import com20.task5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            select new com20.task5.dto.userDto.UserResponse
                        (   u.id,
                            u.firstName,
                            u.lastName,
                            u.email,
                            u.password,
                            u.phoneNumber,
                            u.role)
                        from User u
            """)
    List<UserResponse> getAll();

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);
}
