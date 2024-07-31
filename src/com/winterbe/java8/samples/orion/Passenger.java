package com.winterbe.java8.samples.orion;

public class Passenger {
    private int passengerId;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String nationality;
    private String airportName;
    private String airportCountryCode;
    private String countryName;
    private String airportContinent;
    private String departureDate;
    private String arrivalAirport;
    private String pilotName;
    private String flightStatus;

    // No-argument constructor
    public Passenger() {
    }

    // Constructor with all fields
    public Passenger(int passengerId, String firstName, String lastName, String gender, int age, String nationality,
                     String airportName, String airportCountryCode, String countryName, String airportContinent,
                     String departureDate, String arrivalAirport, String pilotName, String flightStatus) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
        this.airportName = airportName;
        this.airportCountryCode = airportCountryCode;
        this.countryName = countryName;
        this.airportContinent = airportContinent;
        this.departureDate = departureDate;
        this.arrivalAirport = arrivalAirport;
        this.pilotName = pilotName;
        this.flightStatus = flightStatus;
    }

    // Getter and setter methods
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCountryCode() {
        return airportCountryCode;
    }

    public void setAirportCountryCode(String airportCountryCode) {
        this.airportCountryCode = airportCountryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAirportContinent() {
        return airportContinent;
    }

    public void setAirportContinent(String airportContinent) {
        this.airportContinent = airportContinent;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", airportName='" + airportName + '\'' +
                ", airportCountryCode='" + airportCountryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", airportContinent='" + airportContinent + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", pilotName='" + pilotName + '\'' +
                ", flightStatus='" + flightStatus + '\'' +
                '}';
    }
}

