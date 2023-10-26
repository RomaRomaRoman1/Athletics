package org.example;

public class Sportsmans {
    private String name;
    private String gender;
    private String lastName;
    private String distance;
    private int result;

    public Sportsmans() {
    }

    @Override
    public String toString() {
        return "Sportsman: " +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", distance='" + distance + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public Sportsmans(String name, String gender, String lastName, String distance, int result) {
        this.name = name;
        this.gender = gender;
        this.lastName = lastName;
        this.distance = distance;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
