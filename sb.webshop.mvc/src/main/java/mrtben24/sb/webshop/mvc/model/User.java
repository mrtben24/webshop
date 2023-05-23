package mrtben24.sb.webshop.mvc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	
	@Transient
	List<Integer> userProdIdList;

	public User() {
		
		this.userProdIdList = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getUserProdIdList() {
		return userProdIdList;
	}

	public void setUserProdIdList(List<Integer> userProdIdList) {
		this.userProdIdList = userProdIdList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userProdIdList=" + userProdIdList + "]";
	}
	
	
	public void addToUserProdIdList(int pId) {
		
		this.userProdIdList.add(pId);
	}
	
}















