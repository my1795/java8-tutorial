package com.winterbe.java8.samples.orion;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassengerReader {
    public static void main(String[] args) {
        try (InputStream inputStream = PassengerReader.class.getResourceAsStream("dataset.csv");
             InputStreamReader reader = new InputStreamReader(inputStream)) {

            CSVReader csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();

            Stream<Passenger> passengerStream = records.stream()
                    .skip(1)
                    .map(PassengerReader::parseToPassenger);

            System.out.println("CASE 1 ");
            case1(passengerStream);

            System.out.println("CASE 2 ");
            case2(records.stream()
                    .skip(1)
                    .map(PassengerReader::parseToPassenger));

            System.out.println("CASE 3 ");
            case3(records.stream()
                    .skip(1)
                    .map(PassengerReader::parseToPassenger));

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private static Passenger parseToPassenger(String[] record) {
        return new Passenger(
                Integer.parseInt(record[0]),
                record[1],
                record[2],
                record[3],
                Integer.parseInt(record[4]),
                record[5],
                record[6],
                record[7],
                record[8],
                record[9],
                record[11],
                record[12],
                record[13],
                record[14]
        );
    }

    // case 1  japon yolcularin bulundugu havalanlarini ve burda bulunan yolcularin sayisini yazdir
    private static void case1(Stream<Passenger> passengerStream) {
        Predicate<Passenger> passengerPredicate= passenger -> "Japan".equals(passenger.getNationality());
        passengerStream
                .filter(passengerPredicate)
                .collect(Collectors.groupingBy(Passenger::getAirportName, Collectors.counting()))
                .forEach((k, v) -> {
                        System.out.println("Airport: " + k + " Count: " + v);
                });

    }

    // case 2  yolculugu en cok iptal olan milliyetteki yolculari yazdir
    private static void case2(Stream<Passenger> passengerStream) {
        passengerStream
                .filter(passenger -> "Cancelled".equals(passenger.getFlightStatus())) // Assuming "Canceled" indicates a canceled flight
                .collect(Collectors.groupingBy(Passenger::getNationality, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(1)
                .forEach(entry -> {
                    System.out.println("Nationality: " + entry.getKey() + " Count: " + entry.getValue());
                });
    }

    // case 3 yolculugu en cok On time olan en yakin yarihteki ilk 50 yolcuyu yazdir
    private static void case3(Stream<Passenger> passengerStream){

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("[MM/dd/yyyy][M/d/yyyy]")
                .toFormatter();

        passengerStream
                .filter(passenger -> "On Time".equals(passenger.getFlightStatus()))
                .sorted(Comparator.comparing((Passenger passenger) -> LocalDate.parse(passenger.getDepartureDate(), formatter)).reversed())
                .limit(100)
                .map(passenger -> passenger.getFirstName()+" "+ passenger.getDepartureDate())
                .forEach(System.out::println);
    }

    // case 4
    private static void case4(Stream<Passenger> passengerStream) {

    }


}

