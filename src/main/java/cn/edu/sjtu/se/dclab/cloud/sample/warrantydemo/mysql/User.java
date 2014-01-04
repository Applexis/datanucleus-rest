

package cn.edu.sjtu.se.dclab.cloud.sample.warrantydemo.mysql;

@javax.persistence.Entity
@javax.persistence.Table(name = "User")
public class User {
	private Long id;
	private String Company;
	private String Tel;
	private String Address;
		
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
		
	@javax.persistence.Column(name = "Company")
	public String getCompany() {
		return Company;
	}
	
	public void setCompany(String Company) {
		this.Company = Company;
	}	
	@javax.persistence.Column(name = "Tel")
	public String getTel() {
		return Tel;
	}
	
	public void setTel(String Tel) {
		this.Tel = Tel;
	}	
	@javax.persistence.Column(name = "Address")
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}	
		
	
	
	}