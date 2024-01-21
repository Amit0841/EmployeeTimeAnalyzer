package com.masai;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void main(String[] args) throws IOException {
       // Path of Excel File
        String filePath = "Assignment_Timecard.xlsx";

   // Store different types of employees based on conditions
        
        Map<String, String> employees7ConsecutiveDays = new HashMap<>();
        Map<String, String> employeesLessThan10HoursBetweenShifts = new HashMap<>();
        Map<String, String> employeesMoreThan14HoursInAShift = new HashMap<>();
        
      // Read the Excel file
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

            int day = 0;
            for (int rowIndex = 1; rowIndex < sheet.getLastRowNum(); rowIndex++) {
                Row currentRow = sheet.getRow(rowIndex);

                String employeeName = currentRow.getCell(7).toString();
                String position = currentRow.getCell(0).toString();

            // Call a method to check if an employee is present for 7 consecutive days
                if (check7ConsecutiveDays(currentRow, sheet.getRow(rowIndex+1))) {
                    day++;
                    if (day>=7) {
                        employees7ConsecutiveDays.put(employeeName, position);
                    }
                } else {
                	// Reset days count
                    day=0; 
                }

                // Call a method to check if an employee has less than 10 hours between shifts
                if (checkLessThan10HoursBetweenShifts(currentRow, sheet.getRow(rowIndex+1))) {
                    employeesLessThan10HoursBetweenShifts.put(employeeName, position);
                }

                // Call a method to check if an employee has worked more than 14 hours in a single shift
                if (checkMoreThan14HoursInAShift(currentRow)) {
                    employeesMoreThan14HoursInAShift.put(employeeName, position);
                }
            }

            // Print the results
            System.out.println();
            System.out.println("Employees who have worked for 7 consecutive days: \n");
            for (Entry<String, String> employee : employees7ConsecutiveDays.entrySet()) {
                System.out.println("Employee Name: " +employee.getKey()+ ", Employee Position Id: " + employee.getValue());
            }

            System.out.println("\n Employees with less than 10 hours between shifts: \n");
            for (Entry<String, String> employee : employeesLessThan10HoursBetweenShifts.entrySet()) {
                System.out.println("Employee Name: " +employee.getKey()+ ", Employee Position Id: " + employee.getValue());
            }

            System.out.println("\n Employees who have worked for more than 14 hours in a single shift: \n");
            for (Entry<String, String> employee : employeesMoreThan14HoursInAShift.entrySet()) {
                System.out.println("Employee Name: " +employee.getKey()+ ", Employee Position Id: " + employee.getValue());
            }

             // Close the read file
            workbook.close();
        }
    }

     // Method to check if an employee is present for 7 consecutive days
    private static boolean check7ConsecutiveDays(Row row, Row nextRow) {
        String id1 = row.getCell(0).toString();
        String id2 = nextRow.getCell(0).toString();

   // Compare employee IDs to check consecutive days
        return id1.equals(id2);
    }

               // Method to check if an employee has less than 10 hours between shifts
    private static boolean checkLessThan10HoursBetweenShifts(Row row, Row nextRow) {
        String id1 = row.getCell(0).toString();
        String id2 = nextRow.getCell(0).toString();
        long hoursDifference = 0;

     // Compare employee IDs to check if they are the same
        if (id1.equals(id2)) {
            DataFormatter dataFormatter = new DataFormatter();
            Cell time1 = row.getCell(3);
            Cell time2 = nextRow.getCell(2);

            String rawDateString = dataFormatter.formatCellValue(time1);
            String rawDateString1 = dataFormatter.formatCellValue(time2);

                    // Parse date strings to LocalDateTime and calculate hours difference
            if (!rawDateString.isEmpty() && !rawDateString1.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
                LocalDateTime date1 = LocalDateTime.parse(rawDateString, formatter);
                LocalDateTime date2 = LocalDateTime.parse(rawDateString1, formatter);

                hoursDifference = ChronoUnit.HOURS.between(date1, date2);
            }
        }

           // Check if the hours difference is less than 10
        return hoursDifference < 10;
    }

   // Method to check if an employee has worked more than 14 hours in a single shift
    private static boolean checkMoreThan14HoursInAShift(Row row) {
        String time = row.getCell(4).toString();
        int totalMinutes = 0;
       // Split time string into hours and minutes and calculate total minutes
        String[] timeParts = time.split(":");
        if (timeParts.length == 2) {
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            totalMinutes = hours * 60 + minutes;
        }
      // Check if total minutes is more than 720 (14 hours)
        return totalMinutes > 720;
    }
}
