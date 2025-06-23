package model.enities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller  implements Serializable{
       
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String emaiil;
	private Date birthDate;
	private Double baseSalary;
	
    private Department departament;
    
    public Seller() {
    	
    }

	public Seller(Integer id, String nome, String emaiil, Date birthDate, Double baseSalary, Department departament) {
		this.id = id;
		this.nome = nome;
		this.emaiil = emaiil;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmaiil() {
		return emaiil;
	}

	public void setEmaiil(String emaiil) {
		this.emaiil = emaiil;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartament() {
		return departament;
	}

	public void setDepartament(Department departament) {
		this.departament = departament;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", nome=" + nome + ", emaiil=" + emaiil + ", birthDate=" + birthDate
				+ ", baseSalary=" + baseSalary + ", departament=" + departament + "]";
	}

	
    
    
}
