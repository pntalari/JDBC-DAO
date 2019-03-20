package models;

import daos.DTO;

import java.util.Date;

public class Car implements DTO {

    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private Integer vinNum;

    public Car() {
    }

    public Car(Integer id, String make, String model, Integer year, String color, Integer vinNum) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vinNum = vinNum;
    }

    public Car(Integer id, String make, String model) {
        this.id = id;
        this.make = make;
        this.model = model;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVinNum() {
        return vinNum;
    }

    public void setVinNum(Integer vinNum) {
        this.vinNum = vinNum;
    }

    @Override
    public String toString(){
        return this.id + " " + this.make + " " + this.model + " "
                + this.year + " " + this.color + " " + this.vinNum;
    }
}
