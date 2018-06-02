package hello.model;

import hello.declaration.TimeClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleTimeClient  implements TimeClient {
    private LocalDateTime dateAndTime;

    public SimpleTimeClient() {
        dateAndTime = LocalDateTime.now();
    }

    @Override
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }

    @Override
    public void setDate(int day, int month, int year) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime currentTime = LocalTime.from(dateAndTime);
        dateAndTime = LocalDateTime.of(dateToSet, currentTime);
    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }

    @Override
    public String toString() {
        return dateAndTime.toString();
    }

}
