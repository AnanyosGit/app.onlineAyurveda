package com.app.onlineAyurveda.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.onlineAyurveda.entity.Medicine;
import com.app.onlineAyurveda.exception.IMedicineIdNullException;
import com.app.onlineAyurveda.exception.IMedicineIllegalCostException;
import com.app.onlineAyurveda.exception.IMedicineIllegalMfdDateException;
import com.app.onlineAyurveda.exception.NullCategoryIdException;
import com.app.onlineAyurveda.repository.CategoryRepository;
import com.app.onlineAyurveda.repository.IMedicineRepository;



@Service
public class IMedicineServiceImpl implements IMedicineService{

	@Autowired
	private IMedicineRepository medrepo;
	private CategoryRepository catrepo;
	
	@Override
	public Medicine addMedicine(Medicine medicine) throws Exception {
		// TODO Auto-generated method stub
		LocalDate currentdate = LocalDate.now();
		if(medicine.getMedicineId()==null) {
			throw new IMedicineIdNullException();
		}
		else if(medicine.getMedicineCost()<0.0f) {
			throw new IMedicineIllegalCostException();
		}		
		else if(currentdate.compareTo(medicine.getMfd())<0) {
			throw new IMedicineIllegalMfdDateException();			
		}/*
		else if(medicine.getCategory().getCategoryId()==null) {
			throw new NullCategoryIdException();
		}*/else {
			
		Medicine savedmedicine = medrepo.save(medicine);
		return savedmedicine;
		}
	}

	
	@Override
	public Medicine updateMedicine(Medicine medicine) throws Exception {
		// TODO Auto-generated method stub
		LocalDate currentdate = LocalDate.now();
		if(medicine.getMedicineId()==null) {
			throw new IMedicineIdNullException();
		}
		else if(medicine.getMedicineCost()<0.0f) {
			throw new IMedicineIllegalCostException();
		}		
		else if(currentdate.compareTo(medicine.getMfd())<0) {
			throw new IMedicineIllegalMfdDateException();			
		}/*
		else if(medicine.getCategory().getCategoryId()==null) {
			throw new NullCategoryIdException();
		}*/
		
		Medicine updatedMed=new Medicine();
		if(medrepo.existsById(medicine.getMedicineId())){
			updatedMed = medrepo.save(medicine);
			return updatedMed;
		}
		return updatedMed;
	}

	
	@Override
	public List<Medicine> showAllMedicine() {
		// TODO Auto-generated method stub
		List<Medicine> medlist = medrepo.findAll();
		return medlist;
	}


	@Override
	public Medicine viewMedicine(Medicine medicine) throws Exception {
		// TODO Auto-generated method stub
		LocalDate currentdate = LocalDate.now();
		if(medicine.getMedicineId()==null) {
			throw new IMedicineIdNullException();
		}
		else if(medicine.getMedicineCost()<0.0f) {
			throw new IMedicineIllegalCostException();
		}		
		else if(currentdate.compareTo(medicine.getMfd())<0) {
			throw new IMedicineIllegalMfdDateException();			
		}
		else if(medicine.getCategory().getCategoryId()==null) {
			throw new NullCategoryIdException();
		}
		else {
		String medId = medicine.getMedicineId();
		Medicine viewingMed = medrepo.getById(medId);
		return viewingMed;
		}
	}


	@Override
	public Medicine deleteMedicine(String id) throws IMedicineIdNullException {
		// TODO Auto-generated method stub
		if(id==null) {
			throw new IMedicineIdNullException();
		}else {
		Medicine medToDelete = medrepo.getById(id);
		medrepo.delete(medToDelete);
		return medToDelete;
		}
	}

}