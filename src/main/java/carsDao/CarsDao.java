package carsDao;

/**
 * @author HARITA LOLLA
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cars.domain.Car;
import carsDao.AbstractDao;

/**
 * Creating a database for insert, delete and update operations
 * @author HARITA LOLLA
 *
 */


public class CarsDao extends AbstractDao<Car> {
	
	
	private static final String SQL_FIND_BY_ID = "SELECT * FROM car c WHERE id = ?"; //$NON-NLS-1$

	private static final String SQL_FIND_BY_NAME = "SELECT * FROM car c WHERE name = ?"; //$NON-NLS-1$

	private static final String SQL_LIST_ORDER_BY_ID = "SELECT * FROM car c ORDER BY id"; //$NON-NLS-1$
	
	private static final String SQL_INSERT = "INSERT INTO car (" //$NON-NLS-1$
			+ Car.COL_NAME + ", " //$NON-NLS-1$
			+ Car.COL_PRICE + "," //$NON-NLS-1$
			+ Car.COL_DOORS + "," //$NON-NLS-1$
			+ Car.COL_MAX_SPEED + "," //$NON-NLS-1$
			+ Car.COL_Fuel_USAGE + "," //$NON-NLS-1$
			+ Car.COL_MILEAGE + "," //$NON-NLS-1$
			+ Car.COL_RELEASE_YEAR + ") VALUES (?, ?, ?, ?, ?, ?, ?)"; //$NON-NLS-1$
	
	private static final String SQL_UPDATE = "UPDATE car SET " //$NON-NLS-1$
			+ Car.COL_NAME + "=?," //$NON-NLS-1$
			+ Car.COL_PRICE + "=?,"//$NON-NLS-1$
			+ Car.COL_DOORS + "=?," //$NON-NLS-1$
			+ Car.COL_MAX_SPEED + " = ?, " //$NON-NLS-1$
			+ Car.COL_Fuel_USAGE + " = ?, " //$NON-NLS-1$
			+ Car.COL_MILEAGE + " = ?, " //$NON-NLS-1$
			+ Car.COL_RELEASE_YEAR + " = ? WHERE id = ?"; //$NON-NLS-1$
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE if not exists car ( id integer identity primary key, "+  //$NON-NLS-1$
            Car.COL_NAME + " varchar(40), " +  //$NON-NLS-1$
            Car.COL_PRICE + " int, " +  //$NON-NLS-1$
            Car.COL_DOORS + " int, "+  //$NON-NLS-1$
            Car.COL_MAX_SPEED + " int, "+ //$NON-NLS-1$
            Car.COL_Fuel_USAGE + " int, "+ //$NON-NLS-1$
            Car.COL_MILEAGE + " int, "+ //$NON-NLS-1$	
            Car.COL_RELEASE_YEAR + " int);"; //$NON-NLS-1$
	

	private static final String SQL_DELETE = "DELETE FROM Car WHERE id = ?"; //$NON-NLS-1$

	private static final String SQL_DELETE_ALL = "DELETE FROM Car"; //$NON-NLS-1$



	public CarsDao(String url, String user, String password) {
		super(url, user, password);
		checkCarTable();
	}


	@Override
	protected Car createDomain(ResultSet rs) throws SQLException {
		return new Car(rs);
	}
	

	public Car findById(Integer id) {
		return find(SQL_FIND_BY_ID, id);
	}

	public Car findByName(String name) {
		return find(SQL_FIND_BY_NAME, name);
	}

	public List<Car> listOrderById() {
		return list(SQL_LIST_ORDER_BY_ID);
	}
	@Override
	protected Object[] getDomainValues(Car domain) {
		return new Object[] { domain.getName(),
				Integer.valueOf(domain.getPrice()),
				Integer.valueOf(domain.getDoors()),
				Integer.valueOf(domain.getMaxSpped()),
				Float.valueOf(domain.getFuelUsage()),
				Float.valueOf(domain.getMileage()),
				Integer.valueOf(domain.getReleaseYear()) };
		
	}

	@Override
	protected Object[] getDomainValuesForUpdate(Car domain) {
		return new Object[] {domain.getName(),
				Integer.valueOf(domain.getPrice()),
				Integer.valueOf(domain.getDoors()),
				Integer.valueOf(domain.getMaxSpped()),
				Float.valueOf(domain.getFuelUsage()),
				Float.valueOf(domain.getMileage()),
				Integer.valueOf(domain.getReleaseYear()),
				domain.getClass()
				
		};
	}

	@Override
	protected String getInsertSql() {
		return SQL_INSERT;
	}

	@Override
	protected String getDeleteSql() {
		return SQL_DELETE;
	}

	@Override
	protected String getDeleteAllSql() {
		return SQL_DELETE_ALL;
	}

	@Override
	protected String getUpdateSql() {
		return SQL_UPDATE;
	}
	public static CarsDao createCarsDao() {
		CarsDao result = new CarsDao (DB_URL, DB_User, DB_PASSWORD);
		return result;
	}

	private void checkCarTable() {
		try(Statement stmt = this.connection.createStatement()){
			stmt.execute(SQL_CREATE_TABLE);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
