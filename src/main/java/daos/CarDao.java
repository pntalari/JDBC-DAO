package daos;
import models.Car;
import java.sql.*;
import java.util.List;

public class CarDao extends Dao<Car> {

    private static final String CREATE = "Insert into car" +
            "(id, make, model, year, color, vin)" +
            "values(?,?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM car WHERE id = ?";
    private static final String UPDATE = "UPDATE car SET id = ?, make = ?, model = ?, year = ?, color = ?, vin = ?";
    private static final String DELETE = "DELETE FROM car WHERE id = ?";

    public CarDao(Connection conn) {
        super(conn);
    }

    // Create car
    public Car create(Car dto) {
        Car car = null;

        try(PreparedStatement pStmt = this.connection.prepareStatement(CREATE);){
            pStmt.setInt(1,dto.getId());
            pStmt.setString(2,dto.getMake());
            pStmt.setString(3,dto.getModel());
            pStmt.setInt(4, dto.getYear());
            pStmt.setString(5, dto.getColor());
            pStmt.setInt(6,dto.getVinNum());

            pStmt.executeUpdate();

            car = findById(dto.getId());

        } catch (SQLException e) {
            printError(e);
            e.printStackTrace();
        }

        return car;
    }


    @Override
    public Car findById(Integer id) {
        Car car = null;

        try(PreparedStatement pStmt = this.connection.prepareStatement(GET_ONE);){
            pStmt.setInt(1,id);
            ResultSet resultSet = pStmt.executeQuery();

            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMake(resultSet.getString("make"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                car.setYear(resultSet.getInt("year"));
                car.setVinNum(resultSet.getInt("vin"));
            }

        } catch (SQLException e) {
            printError(e);
            e.printStackTrace();
        }
        return car;
    }

    public List findAll() {
        return null;
    }

    @Override
    public Car update(Car dto) {
        return null;
    }


    public void delete(Integer id) {

    }

    public void printError(SQLException e){
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error Code: " + e.getErrorCode());
    }
}
