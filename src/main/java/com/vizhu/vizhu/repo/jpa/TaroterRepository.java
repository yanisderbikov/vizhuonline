package com.vizhu.vizhu.repo.jpa;

import com.vizhu.vizhu.repo.Taroter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaroterRepository extends JpaRepository<Taroter, UUID> {
    Optional<Taroter> findByLogin(String login);
}