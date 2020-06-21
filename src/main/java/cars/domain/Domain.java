package cars.domain;

/**
 * Minimal interface for a database domain 
 * 
 * It has only one field named id, which is the primary key of the database table
 * 
 * @author HARITA LOLLA
 *
 */

public interface Domain {
	
	Integer getId();
	
	void setId(Integer id);

}
