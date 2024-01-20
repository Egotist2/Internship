package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeWorkAnalysis {

    public EmployeeWorkAnalysis() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = inputScanner.nextLine();

        // Validate file path
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Error: Invalid file path");
            return;
        }

    
        List<Employee> employees = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                Employee employee = parseEmployeeRecord(fileScanner.nextLine());
                employees.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + filePath);
            return;
        }
        analyzeEmployeeRecords(employees);
    }
    private static void analyzeEmployeeRecords(List<Employee> employees) {
   
        for (Employee employee : employees) {
            LocalDate payCycleStartDate = employee.getPayCycleStartDate().toLocalDate();
            LocalDate payCycleEndDate = employee.getPayCycleEndDate().toLocalDate();

            int consecutiveDays = 1;
            for (LocalDate currentDate = payCycleStartDate.plusDays(1); currentDate.isBefore(payCycleEndDate); currentDate = currentDate.plusDays(1)) {
                boolean hasRecordForNextDay = false;

                for (Employee nextDayRecord : employees) {
                    if (nextDayRecord.getEmployeeName().equals(employee.getEmployeeName()) &&
                            nextDayRecord.getPayCycleStartDate().toLocalDate().equals(currentDate)) {
                        hasRecordForNextDay = true;
                        break;
                    }
                }

                if (hasRecordForNextDay) {
                    consecutiveDays++;
                } else {
                    consecutiveDays = 1;  
                }

                if (consecutiveDays >= 7) {
                    System.out.println("Employee worked 7 consecutive days: " + employee.getEmployeeName() +
                            ", Position: " + employee.getPositionStatus());
                    break;  
                }
            }
        }
    

    

    

        for (int i = 0; i < employees.size() - 1; i++) {
            Employee record1 = employees.get(i);
            Employee record2 = employees.get(i + 1);
            if (record1.getEmployeeName().equals(record2.getEmployeeName()) &&
                    record2.getPayCycleStartDate().toLocalDate().equals(record1.getPayCycleStartDate().plusDays(1))) {
                long hoursBetweenShifts = Duration.between(record1.getTimeOut(), record2.getTime())
                        .toHours();
                if (hoursBetweenShifts > 1 && hoursBetweenShifts < 10) {
                    System.out.println("Employee has less than 10 hours between shifts: " +
                            record1.getEmployeeName() + ", Position: " + record1.getPositionStatus());
                }
            }
        }


        for (Employee employee : employees) {
            long shiftDurationHours = Duration.between(employee.getTime(), employee.getTimeOut())
                    .toHours();
            if (shiftDurationHours > 14) {
                System.out.println("Employee worked more than 14 hours in a single shift: " +
                        employee.getEmployeeName() + ", Position: " + employee.getPositionStatus());
            }
        }


    
        if (employees.isEmpty()) {
            System.out.println("No employee records found for analysis.");
        }
    }

    private static Employee parseEmployeeRecord(String line) {
        String[] parts = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        return new Employee(
                parts[0], parts[1], LocalDateTime.parse(parts[2], formatter),
                LocalDateTime.parse(parts[3], formatter), Double.parseDouble(parts[4]),
               LocalDateTime.parse(parts[5], formatter), LocalDateTime.parse(parts[6], formatter),
                parts[7], parts[8]
        );
    }

    public static void main(String[] args) {
        new EmployeeWorkAnalysis();
    }
}
