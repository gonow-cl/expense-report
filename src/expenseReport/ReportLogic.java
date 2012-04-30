package expenseReport;

import expense.Expense;

import java.util.ArrayList;
import java.util.List;

import static expense.Expense.Type.BREAKFAST;
import static expense.Expense.Type.DINNER;


class ReportLogic {
  private List<ReportExpense> reportExpenses = new ArrayList<ReportExpense>();
  private float total = 0;
  private float mealExpenses = 0;

  public void addExpense(Expense expense) {
    addReportItem(expense);
    updateTotals(expense);
  }

  private void addReportItem(Expense expense) {
    reportExpenses.add(new ReportExpense(expense.amount / 100.0,
        expenseName(expense),
        isTooExpensive(expense)));
  }

  private void updateTotals(Expense expense) {
    if (isMeal(expense)) {
      mealExpenses += expense.amount / 100.0;
    }

    total += expense.amount / 100.0;
  }

  private boolean isTooExpensive(Expense expense) {
    return (expense.type == DINNER && expense.amount > 5000)
        || (expense.type == BREAKFAST && expense.amount > 1000);
  }

  private String expenseName(Expense expense) {
    String name = "TILT";
    switch (expense.type) {
      case DINNER: name = "Dinner"; break;
      case BREAKFAST: name = "Breakfast"; break;
      case CAR_RENTAL: name = "Car Rental"; break;
    }
    return name;
  }

  private boolean isMeal(Expense expense) {
    return expense.type == DINNER || expense.type == BREAKFAST;
  }

  public String getDate() {
    return "9/12/2002";
  }

  public List<ReportExpense> getReportExpenses() {
    return reportExpenses;
  }

  public float getMealExpenses() {
    return mealExpenses;
  }

  public float getTotal() {
    return total;
  }
}
