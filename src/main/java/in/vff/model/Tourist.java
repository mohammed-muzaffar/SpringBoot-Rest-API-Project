package in.vff.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
//It generates the getter methods for all the fields. It generates the setter methods for all the non-final fields. It generates the toString() method implementation.
@Entity
//entity is Data JPA annotation, this class treated as a table in the database. 
public class Tourist {
	
	@Id
	// id used for primary key 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//This annotation is generally used in conjunction with @Id annotation to automatically generate unique values for primary key columns within our database tables.
	private Integer tid;
	private String name;
	private String  packageType;
	private Double budget;
	private String city;
}
