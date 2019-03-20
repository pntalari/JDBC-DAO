package daos;
import models.Car;
import java.sql.*;
import java.util.List;

public class CarDao extends Dao<Car> {

    private static final String CREATE = "Insert into car" +
            "(id, make, model, year, color, vinNum)" +
            "values(?,?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM car WHERE id = ?";
    private static final String UPDATE = "UPDATE car SET id = ?, make = ?, model = ?, year = ?, color = ?, vinNum = ?";
    private static final String DELETE = "DELETE FROM car WHERE id = ?";

    public CarDao(Connection conn) {
        super(conn);
    }

    @Override
    public Object findById(Integer id) {
        Car car = null;

        try(PreparedStatement pStmt = connection.prepareStatement(GET_ONE);){
            pStmt.setInt(1,id);
            ResultSet resultSet = pStmt.executeQuery();

            while (resultSet.next()) {
                car.setId(resultSet.getInt("id"));
                car.setMake(resultSet.getString("make"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                car.setYear(resultSet.getInt("year"));
                car.setVinNum(resultSet.getInt("vin"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public List findAll() {
        return null;
    }

    public Object update(Object dto) {
        return null;
    }

    public Object create(Object dto) {
        return null;
    }

    public void delete(Integer id) {

    }
}
