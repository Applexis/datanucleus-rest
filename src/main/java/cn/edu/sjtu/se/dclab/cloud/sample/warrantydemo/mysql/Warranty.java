

package cn.edu.sjtu.se.dclab.cloud.sample.warrantydemo.mysql;

@javax.persistence.Entity
@javax.persistence.Table(name = "Warranty")
public class Warranty {
	private Long id;
	private java.sql.Timestamp DueTime;
	private java.sql.Timestamp StartTime;
	private String ProductSerial;
	private int Status;
		
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
		
	@javax.persistence.Column(name = "DueTime")
	public java.sql.Timestamp getDueTime() {
		return DueTime;
	}
	
	public void setDueTime(java.sql.Timestamp DueTime) {
		this.DueTime = DueTime;
	}	
	@javax.persistence.Column(name = "StartTime")
	public java.sql.Timestamp getStartTime() {
		return StartTime;
	}
	
	public void setStartTime(java.sql.Timestamp StartTime) {
		this.StartTime = StartTime;
	}	
	@javax.persistence.Column(name = "ProductSerial")
	public String getProductSerial() {
		return ProductSerial;
	}
	
	public void setProductSerial(String ProductSerial) {
		this.ProductSerial = ProductSerial;
	}	
	@javax.persistence.Column(name = "Status")
	public int getStatus() {
		return Status;
	}
	
	public void setStatus(int Status) {
		this.Status = Status;
	}	
		
	
	
	private User User;

	@javax.persistence.JoinColumn(name = "User")
	public User getUser(){
		return User;
	}
	
	public void setUser(User User){
		this.User = User;
	}  
	private Product Product;

	@javax.persistence.JoinColumn(name = "Product")
	public Product getProduct(){
		return Product;
	}
	
	public void setProduct(Product Product){
		this.Product = Product;
	}  
	}