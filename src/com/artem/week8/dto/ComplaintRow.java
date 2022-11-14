package com.artem.week8.dto;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class ComplaintRow {

    private final int id;
    private final LocalDateTime dateTimeComplaint;
    private final String fullName;
    private final String phoneNumber;
    private final String textOfComplaint;
    private final AtomicBoolean isAdded = new AtomicBoolean(false);

    public ComplaintRow(int id, LocalDateTime dateTimeComplaint, String fullName, String phoneNumber, String textOfComplaint) {
        this.id = id;
        this.dateTimeComplaint = dateTimeComplaint;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.textOfComplaint = textOfComplaint;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTimeComplaint() {
        return dateTimeComplaint;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTextOfComplaint() {
        return textOfComplaint;
    }

    @Override
    public String toString() {
        return "ComplaintRow{" +
                "id=" + id +
                ", dateTimeComplaint=" + dateTimeComplaint +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", textOfComplaint='" + textOfComplaint + '\'' +
                '}';
    }
}
