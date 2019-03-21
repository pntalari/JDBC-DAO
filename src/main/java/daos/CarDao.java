package daos;

import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao extends Dao<Car> {

    private static final String CREATE = "Insert into car" +
            "(id, make, model, year, color, vin)" +
            "values(?,?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM car WHERE id = ?";
    private static final String UPDATE = "UPDATE car SET year = ?, make = ?, model = ?, color = ?, vin = ? " +
            "WHERE id = ?";
    private static final String DELETE = "DELETE FROM car WHERE id = ?";
    private static final String ALL = "SELECT * FROM car";

    public CarDao(Connection conn) {
        super(conn);
    }

    // Create car
    public Car create(Car dto) {
        Car car = null;

        try (PreparedStatement pStmt = this.connection.prepareStatement(CREATE);) {
            pStmt.setInt(1, dto.getId());
            pStmt.setString(2, dto.getMake());
            pStmt.setString(3, dto.getModel());
            pStmt.setInt(4, dto.getYear());
            pStmt.setString(5, dto.getColor());
            pStmt.setInt(6, dto.getVinNum());

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

        try (PreparedStatement pStmt = this.connection.prepareStatement(GET_ONE);) {
            pStmt.setInt(1, id);
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

    public List<Car> findAll() {

        Car car = null;
        List<Car> carList = new ArrayList<>();

        try(PreparedStatement pStmt = this.connection.prepareStatement(ALL);){
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()){
                car = new Car();
                car.setId(rs.getInt("id"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setColor(rs.getString("color"));
                car.setVinNum(rs.getInt("vin"));

                carList.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carList;
    }

    @Override
    public Car update(Car dto) {
        Car car = null;

        try (PreparedStatement pStmt = this.connection.prepareStatement(UPDATE)){;
            pStmt.setInt(1, dto.getYear());
            pStmt.setString(2, dto.getMake());
            pStmt.setString(3, dto.getModel());
            pStmt.setString(4, dto.getColor());
            pStmt.setInt(5, dto.getVinNum());
            pStmt.setInt(6, dto.getId());

            pStmt.executeUpdate();

            car = this.findById(dto.getId());

        } catch (SQLException e) {
            printError(e);
            e.printStackTrace();
        }

        return car;
    }


    public void delete(Integer id) {
        try (PreparedStatement pStmt = this.connection.prepareStatement(DELETE);){
            pStmt.setInt(1, id);
            pStmt.executeUpdate();

        } catch (SQLException e) {
            printError(e);
            e.printStackTrace();
        }

    }

    public void printError(SQLException e) {
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error Code: " + e.getErrorCode());
    }
}
