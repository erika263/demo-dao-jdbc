package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.enities.Department;
import model.enities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	
    public SellerDaoJDBC(Connection conn) {
    	this.conn = conn;
    }

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,depart"
					+ ""
					+ "ment.Name as DepName " 
						   + "FROM seller INNER JOIN department  " 
						   + "ON seller.DepartmentId = department.id " 
						   + "WHERE seller.Id = ?");
			   
			st.setInt(1, id);
			rs = st.executeQuery();		
			
			if(rs.next()) {
				Department dep = instatiateDepartment(rs);
				Seller obj = instantiateSeller(rs, dep);
				return obj;
			}		
			return null;		
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj =  new Seller();
			obj.setId(rs.getInt("Id"));
			obj.setName(rs.getString("Name"));
			obj.setEmaiil(rs.getString("Email"));
			obj.setBaseSalary(rs.getDouble("BaseSalary"));
			obj.setBirthDate(rs.getDate("BirthDate"));
			obj.setDepartament(dep);
			return obj;
	}

	private Department instatiateDepartment(ResultSet rs) throws SQLException {
	  Department dep = 	new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getNString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "  
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? " 
					+"ORDER BY Name");
			   
			st.setInt(1, department.getId());
			
			rs = st.executeQuery();	
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			// percorrer enquanto tiver um proximo
			while(rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				if (dep == null){
					dep = instatiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller obj = instantiateSeller(rs, dep);
				list.add(obj);
			}		
			return list;		
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}
