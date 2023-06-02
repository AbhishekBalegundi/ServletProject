package dto;

public class AdminDTO 
{
	private String name;
	private String password;
	private String dept;
	
	
	public AdminDTO() 
	{}


	@Override
	public String toString() {
		return "Visitor [name=" + name + ", password=" + password + ", dept=" + dept + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public AdminDTO(String name, String password, String dept) {
		this.name = name;
		this.password = password;
		this.dept = dept;
	}
	

	

}
