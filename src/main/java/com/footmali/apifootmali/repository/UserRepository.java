package com.footmali.apifootmali.repository;

import com.footmali.apifootmali.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findByNom(String nom);
}

interface  UserLight {
    String getNom();
    Integer getId();
}
