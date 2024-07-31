package com.winterbe.java8.samples.orion;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
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
                record[10],
                record[11],
                record[12],
                record[13]
        );
    }
    // case 1  japon yolcularin bulundugu havalanlarini ve burda bulunan yolcularin sayisini yazdir
    private static void case1(Stream<Passenger> passengerStream){
                passengerStream
                .filter(passenger -> "Japan".equals(passenger.getNationality()))
                        .collect(Collectors.groupingBy(Passenger::getAirportName, Collectors.counting()))
                        .forEach((k,v) -> {
                            System.out.println("Airport: "+k + " Count: "+v);
                        });

    }
    // case 2  yolculugu en cok iptal olan milliyetteki yolculari yazdir
    private static void case2(Stream<Passenger> passengerStream){
    }
}

