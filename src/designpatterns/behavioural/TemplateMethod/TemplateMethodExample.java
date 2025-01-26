package src.designpatterns.behavioural.TemplateMethod;

// Abstract Class (Template)
abstract class ReportGenerator {
    void generateReport() {
        fetchData();
        formatReport();
        printReport();
    }

    abstract void fetchData();
    abstract void formatReport();

    void printReport() { System.out.println("Printing report..."); }
}

// Concrete Classes
class PDFReport extends ReportGenerator {
    void fetchData() { System.out.println("Fetching data for PDF report."); }
    void formatReport() { System.out.println("Formatting PDF report."); }
}

class CSVReport extends ReportGenerator {
    void fetchData() { System.out.println("Fetching data for CSV report."); }
    void formatReport() { System.out.println("Formatting CSV report."); }
}

// Client
public class TemplateMethodExample {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new PDFReport();
        pdfReport.generateReport();

        ReportGenerator csvReport = new CSVReport();
        csvReport.generateReport();
    }
}

