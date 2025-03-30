package com.solidPrinciples;
/*
class ReportGeneratorBad {
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void saveToFile() {
        System.out.println("Saving report to file...");
    }
}
*/
class ReportGeneratorGood {
    public String generateReport() {
        return "Report Data";
    }
}

class ReportSaver {
    public void saveToFile(String reportData) {
        System.out.println("Saving report: " + reportData);
    }
}
public class S {
}
