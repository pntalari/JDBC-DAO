import daos.CarDao;
import models.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppRunner {

    static String myURL = "jdbc:mysql://localhost:3306/JDBCDAO";
    static String myUSER = "root";
    static String myPASS = "";

    public static void main(String... args) throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(myURL, myUSER, myPASS);
            System.out.println("Connection Established to MySQL Database!");

            CarDao carDao = new CarDao(conn);

            //find the car
//            Integer id = 3;
//            Car car = carDao.findById(id);
//            System.out.println("The car with id: " + id + " is: "
//                    + car.getMake() + ", " + car.getModel() + ", " +
//                    car.getColor() + ", " + car.getYear() + ", " +
//                    car.getVinNum());

            //create car
//            Car car = new Car();
//            car.setId(12);
//            car.setMake("Porsche");
//            car.setModel("Mazerrati");
//            car.setYear(2019);
//            car.setColor("Blue");
//            car.setVinNum(708090100);
//
//            carDao.create(car);
//            carDao.findById(car.getId());
//
//            System.out.println("The car inserted with id: " + car.getId() + " is: "
//                    + car.getMake() + ", " + car.getModel() + ", " +
//                    car.getColor() + ", " + car.getYear() + ", " +
//                    car.getVinNum());

            // update car
//            Car car = new Car();
//            car.setId(5);
//            car.setModel("Toyota");
//            car.setMake("Prius");
//            car.setYear(2000);
//            car.setColor("White");
//            car.setVinNum(102030405);
//
//            carDao.update(car);
//            System.out.println("The car updated with id: " + car.getId() + " is: "
//                    + car.getMake() + ", " + car.getModel() + ", " +
//                    car.getColor() + ", " + car.getYear() + ", " +
//                    car.getVinNum());

            //delete car
            Car car = carDao.findById(11);

            System.out.println("The car delete with id: " + car.getId() + " is: "
                    + car.getMake() + ", " + car.getModel() + ", " +
                    car.getColor() + ", " + car.getYear() + ", " +
                    car.getVinNum());
            carDao.delete(4);

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        } finally {
            conn.close();
        }


    }
}
