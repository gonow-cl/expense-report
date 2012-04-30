package expenseReport;

class TextReportView {
  public ReportPrinter printer;

  public TextReportView(ReportPrinter printer) {
    this.printer = printer;
  }

  public void printReport(ReportLogic reportLogic) {
    printHeader(reportLogic.getDate());

    for (ReportExpense reportExpense : reportLogic.getReportExpenses()) {
      printExpense(reportExpense);
    }

    printSummary(reportLogic);
  }

  private void printHeader(String date) {
    printer.print("Expenses " + date + "\n");
  }

  private void printExpense(ReportExpense expense) {
    printer.print(String.format("%s\t%s\t$%.02f\n",
        (expense.isTooExpensive()) ? "X" : " ",
        expense.getName(), expense.getAmount()));
  }

  private void printSummary(ReportLogic reportLogic) {
    printer.print(String.format("\nMeal expenses $%.02f", reportLogic.getMealExpenses()));
    printer.print(String.format("\nTotal $%.02f", reportLogic.getTotal()));
  }
}
