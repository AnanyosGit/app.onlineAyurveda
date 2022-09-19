package com.app.onlineAyurveda.service;

import java.util.List;

import com.app.onlineAyurveda.entity.Medicine;
import com.app.onlineAyurveda.exception.IMedicineIdNullException;


public interface IMedicineService {
	public Medicine addMedicine(Medicine medicine) throws Exception;
	public Medicine viewMedicine(Medicine medicine) throws Exception;
	public Medicine updateMedicine(Medicine medicine) throws Exception;
	public Medicine deleteMedicine(String id) throws IMedicineIdNullException;
	public List<Medicine> showAllMedicine();

}