

package cn.edu.sjtu.se.dclab.cloud.sample.warrantydemo.mysql;

@javax.persistence.Entity
@javax.persistence.Table(name = "Product")
public class Product {
	private Long id;
	private String Name;
	private String Manufacturer;
		
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
		
	@javax.persistence.Column(name = "Name")
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}	
	@javax.persistence.Column(name = "Manufacturer")
	public String getManufacturer() {
		return Manufacturer;
	}
	
	public void setManufacturer(String Manufacturer) {
		this.Manufacturer = Manufacturer;
	}	
		
	
	
	}