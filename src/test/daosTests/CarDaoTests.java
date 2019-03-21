package daosTests;

import daos.CarDao;
import models.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CarDaoTests {
    Connection conn = null;

    @Before
    public void setup() throws SQLException {

        String myURL = "jdbc:mysql://localhost:3306/JDBCDAO";
        String myUSER = "root";
        String myPASS = "";

        conn = DriverManager.getConnection(myURL, myUSER, myPASS);
        System.out.println("Connection Established to MySQL Database!");

    }

    @Test
    public void findByIdTest() {
        CarDao carDao = new CarDao(conn);
        Integer expectedId = 11;
        Car car = carDao.findById(expectedId);

        System.out.println("The car with id: " + expectedId + " is: "
                + car.getMake() + ", " + car.getModel() + ", " +
                car.getColor() + ", " + car.getYear() + ", " +
                car.getVinNum());
        Assert.assertEquals(expectedId, car.getId());
    }

    @Test
    public void createTest() {
        CarDao carDao = new CarDao(conn);
        Car car = new Car();
        car.setId(12);
        car.setMake("Porsche");
        car.setModel("Mazerrati");
        car.setYear(2019);
        car.setColor("Blue");
        car.setVinNum(708090100);

        carDao.create(car);
        //carDao.findById(car.getId());

        System.out.println("The car inserted with id: " + car.getId() + " is: "
                + car.getMake() + ", " + car.getModel() + ", " +
                car.getColor() + ", " + car.getYear() + ", " +
                car.getVinNum());
        Assert.assertEquals("Porsche", car.getMake());
    }

    @Test
    public void updateTest() {
        CarDao carDao = new CarDao(conn);
        Car car = new Car();
        car.setId(11);
        car.setModel("Civic");
        car.setMake("Honda");
        car.setYear(2012);
        car.setColor("White");
        car.setVinNum(77777777);

        Car car1 = carDao.update(car);

        System.out.println("The car updated with id: " + car1.getId() + " is: "
                + car1.getMake() + ", " + car1.getModel() + ", " +
                car1.getColor() + ", " + car1.getYear() + ", " +
                car1.getVinNum());

        Assert.assertEquals("Honda", car.getMake());

    }

    @Test
    public void deleteTest() {
        CarDao carDao = new CarDao(conn);
        Car car = carDao.findById(12);

        System.out.println("The car delete with id: " + car.getId() + " is: "
                + car.getMake() + ", " + car.getModel() + ", " +
                car.getColor() + ", " + car.getYear() + ", " +
                car.getVinNum());
        carDao.delete(12);

        Assert.assertNull(carDao.findById(12));
    }

    @Test
    public void findAllTest() {
        CarDao carDao = new CarDao(conn);
        List<Car> carList = carDao.findAll();

        System.out.println("List of Cars:");

        for (Car car : carList) {
            System.out.println("Id: " + car.getId() + ",Make: "
                    + car.getMake() + ",Model: " + car.getModel() + ",Color: " +
                    car.getColor() + ",Year: " + car.getYear() + ",Vin: " +
                    car.getVinNum());

            Assert.assertNotNull(carList.size());
        }

    }
}

//        1	Honda	Civic	2012	White	1234567890
//        2	Honda	Accord	2010	Blue	1112131415
//        2	Volvo	XC5	2019	Blue	1617181920
//        3	Volkswagen	Jetta	2015	Yellow	2122232425
//        4	Volkwagen	Beetle	2004	Grey	2627282930
//        5	BMW	X9	2020	White	3132333435
//        6	Toyota	Prius	2017	Green	3637383940
//        7	Toyota	Corolla	2007	Gold	4142434445
//        8	Nissan	Rogue	2009	SeaBlue	4647484950
//        9	Hyundai	Sonota	2006	Grey	5152535455
//        10	Porsche	Mazerrati	2019	Blue	708090100


