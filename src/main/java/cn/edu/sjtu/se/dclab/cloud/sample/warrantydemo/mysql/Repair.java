

package cn.edu.sjtu.se.dclab.cloud.sample.warrantydemo.mysql;

@javax.persistence.Entity
@javax.persistence.Table(name = "Repair")
public class Repair {
	private Long id;
	private java.sql.Timestamp RequestTime;
	private int Status;
	private String Repairer;
		
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
		
	@javax.persistence.Column(name = "RequestTime")
	public java.sql.Timestamp getRequestTime() {
		return RequestTime;
	}
	
	public void setRequestTime(java.sql.Timestamp RequestTime) {
		this.RequestTime = RequestTime;
	}	
	@javax.persistence.Column(name = "Status")
	public int getStatus() {
		return Status;
	}
	
	public void setStatus(int Status) {
		this.Status = Status;
	}	
	@javax.persistence.Column(name = "Repairer")
	public String getRepairer() {
		return Repairer;
	}
	
	public void setRepairer(String Repairer) {
		this.Repairer = Repairer;
	}	
		
	
	
	private Warranty Warranty;

	@javax.persistence.JoinColumn(name = "Warranty")
	public Warranty getWarranty(){
		return Warranty;
	}
	
	public void setWarranty(Warranty Warranty){
		this.Warranty = Warranty;
	}  
	private User User;

	@javax.persistence.JoinColumn(name = "User")
	public User getUser(){
		return User;
	}
	
	public void setUser(User User){
		this.User = User;
	}  
	}