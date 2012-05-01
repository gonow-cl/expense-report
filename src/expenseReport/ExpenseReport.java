package expenseReport;

import java.util.ArrayList;
import java.util.List;

import static expenseReport.Expense.Type.*;


public class ExpenseReport {
  private List<Expense> expenses = new ArrayList<Expense>();
  public int total;
  public int mealExpenses;
  public final int MAX_ALLOWED_DINNER = 5000;
  public final int MAX_ALLOWED_BREAKFAST = 1000;

  public void printReport(ReportPrinter printer) {
    resetTotals();
    printHeader(printer);

    for (Expense expense : expenses) {
      printer.print(expenseDescription(expense));
      updateTotals(expense);
    }

    printTotals(printer);
  }

  private void resetTotals() {
    total = 0;
    mealExpenses = 0;
  }

  private void printHeader(ReportPrinter printer) {
    printer.print("Expenses " + getDate() + "\n");
  }

  private String expenseDescription(Expense expense) {
    String name = nameOfExpenseType(expense.type);

    return String.format("%s\t%s\t$%.02f\n",
        isTooExpensiveWarning(expense),
        name, intToReal(expense.amount));
  }

  private String isTooExpensiveWarning(Expense expense) {
    boolean tooExpensiveDinner = expense.type == DINNER && expense.amount > MAX_ALLOWED_DINNER;
    boolean tooExpensiveBreakfast = expense.type == BREAKFAST && expense.amount > MAX_ALLOWED_BREAKFAST;
    return tooExpensiveDinner || tooExpensiveBreakfast ? "X" : " ";
  }

  private String nameOfExpenseType(Expense.Type expenseType) {
    String name = "TILT";
    switch (expenseType) {
      case DINNER: name = "Dinner"; break;
      case BREAKFAST: name = "Breakfast"; break;
      case CAR_RENTAL: name = "Car Rental"; break;
    }
    return name;
  }

  private void updateTotals(Expense expense) {
    if (expense.type == BREAKFAST || expense.type == DINNER)
      mealExpenses += expense.amount;
    total += expense.amount;
  }

  private void printTotals(ReportPrinter printer) {
    printer.print(String.format("\nMeal expenses $%.02f", intToReal(mealExpenses)));
    printer.print(String.format("\nTotal $%.02f", intToReal(total)));
  }

  /**
   * Because the amount (from Expense model) is an integer, we need to convert it to an currency value.
   * @param amount An integer amount (*100), like 1250
   * @return the real value, like 12.50
   */
  private double intToReal(int amount) {
    return amount / 100.0;
  }

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }

  private String getDate() {
    return "9/12/2002";
  }

}
