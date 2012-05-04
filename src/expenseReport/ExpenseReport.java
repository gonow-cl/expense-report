package expenseReport;

import java.util.ArrayList;
import java.util.List;


public class ExpenseReport {

  private List<Expense> expenses = new ArrayList<Expense>();
  private int mealExpenses = 0;
  private int totalExpenses = 0;
  private String reportOutPut = "";

  public void printReport(ReportPrinter printer) {

    reportOutPut += "Expenses " + getDate() + "\n";

    for (Expense expense : expenses) {

        switch (expense.getType()) {
            case DINNER:
            appendExpenseToReport("Dinner", expense.getAmount());
            break;
            case BREAKFAST:
            appendExpenseToReport("Breakfast", expense.getAmount());
            break;
            case CAR_RENTAL:
            appendExpenseToReport("Car Rental", expense.getAmount());
            break;
            default:
            appendExpenseToReport("TILT",0);
            break;
        }

    }

    reportOutPut += "\nMeal expenses $" + mealExpenses/100.0;
    reportOutPut += "\nTotal $" + totalExpenses/100.0;

    printer.print(reportOutPut);

  }

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }

  private String getDate() {
    return "9/12/2002";
  }

  private void appendExpenseToReport(String expenseType, int expenseAmount) {

    if ("Breakfast".equals(expenseType) || "Dinner".equals(expenseType)) mealExpenses += expenseAmount;

      reportOutPut += (
              expenseType == "Dinner" && expenseAmount > 5000 ||    // too expensive dinner
              expenseType == "Breakfast" && expenseAmount > 1000    // too expensive breakfast
        ) ? "X" : " ";
    reportOutPut += "\t"+expenseType+"\t$"+expenseAmount/100.0+"\n";

    totalExpenses += expenseAmount;

  }

}
