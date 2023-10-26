package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultProcessor {
    private CsvReader csvReader;

    public void setCsvReader(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    public CsvReader getCsvReader() {
        return csvReader;
    }

    Comparator<Sportsmans> sportsmansComparator = (s1, s2) -> Integer.compare(s1.getResult(), s2.getResult());//компаратор для сортировки по возрастанию
    @Autowired
    public ResultProcessor(CsvReader csvReader) {
        this.csvReader = csvReader;
    }
    public void sortResult() {
        csvReader.sportsmansList.sort(sportsmansComparator);//сортировка по возрастанию
    }

    public void filterResult (int numberOfSportsmans, String gender, String distance)  {
        int num =1;
        for (int i=0; i<csvReader.sportsmansList.size(); i++){//цикл для перебора значений
            Sportsmans sportsmans = csvReader.sportsmansList.get(i);//создание объекта, чтобы значения передать объектов с List sportsmansList
            if (sportsmans.getGender().equalsIgnoreCase(gender) && sportsmans.getDistance().equalsIgnoreCase(distance) && numberOfSportsmans>0) {//Вывод только значений, которые подходят по парметрам
                System.out.println("number : " + num + " " + sportsmans);
                numberOfSportsmans--;//уменьшаем значение счетчика - кол-ва спортсменов, чтобы не выводить лишнее
            }
            num++;
        }
    }
    void showResult (int numberOfSportsmans, String gender, String distance){//На вход: количество самых быстрых спортсменов, пол, дистанция
        csvReader.read();
        sortResult();
        filterResult(numberOfSportsmans, gender, distance);
    }
}
