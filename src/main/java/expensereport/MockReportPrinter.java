package expensereport;

public class MockReportPrinter implements ReportPrinter {

    private StringBuilder printedText = new StringBuilder();

    public void print(String text) {
        printedText.append(text);
    }

    public String getText() {
        return printedText.toString();
    }

}
