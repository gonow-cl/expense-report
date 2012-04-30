package expenseReport;

import expense.Expense;

public class ExpenseReport {
  private ReportLogic reportLogic = new ReportLogic();
  
  public void addExpense(Expense expense) {
    reportLogic.addExpense(expense);
  }
  
  public void print(ReportPrinter printer) {
    TextReportView view = new TextReportView(printer);
    view.printReport(reportLogic);
  }
}
