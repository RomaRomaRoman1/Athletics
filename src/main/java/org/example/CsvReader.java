package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvReader {
    List<Sportsmans> sportsmansList = new ArrayList<>();
    private String path = "C:\\Users\\Roman\\Desktop\\Книга1.csv";
    public void read() {
        char separator = ';';
        CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(path))
                .withCSVParser(parser)
                .build()) {
            String[] header = reader.readNext();//обычный массив для чтения заголовка, куда мы читаем данные из таблицы csv
            String [] row;
            while ((row = reader.readNext()) != null) {
                String name = row[1];
                String lastName= row[0];
                String gender= row[2];
                String distance= row[3];
                Integer result= Integer.valueOf(row[4]);
                Sportsmans sportmans = new Sportsmans();
                sportmans.setName(name);
                sportmans.setDistance(distance);
                sportmans.setGender(gender);
                sportmans.setResult(result);
                sportmans.setLastName(lastName);
                sportsmansList.add(sportmans);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
    public void out () {
        for (var s: sportsmansList) {
            System.out.println(s);
        }
    }

    public List<Sportsmans> getSportsmansList() {
        return sportsmansList;
    }

    public void setSportsmansList(List<Sportsmans> sportsmansList) {
        this.sportsmansList = sportsmansList;
    }
}
