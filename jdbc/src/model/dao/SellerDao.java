package model.dao;

import java.util.List;

import model.enities.Department;
import model.enities.Seller;

public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller>findByDepartment(Department department);

}
