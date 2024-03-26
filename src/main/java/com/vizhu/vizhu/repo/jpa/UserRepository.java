package com.vizhu.vizhu.repo.jpa;

import com.vizhu.vizhu.repo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {}
