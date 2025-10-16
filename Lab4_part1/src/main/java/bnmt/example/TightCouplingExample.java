package bnmt.example;

interface Printer {
    void print(String message);
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}

class Report {
    private final Printer printer;

    // Dependency Injection qua constructor
    Report(Printer printer) {
        this.printer = printer;
    }

    void generate() {
        printer.print("Generating report...");
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        Report report = new Report(printer);
        report.generate();
    }
}
