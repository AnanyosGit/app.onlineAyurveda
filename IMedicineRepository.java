package com.app.onlineAyurveda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.onlineAyurveda.entity.Medicine;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine,String> {

}
