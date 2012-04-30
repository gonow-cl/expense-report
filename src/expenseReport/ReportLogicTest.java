package expenseReport;

import expense.Expense;
import org.junit.Before;
import org.junit.Test;

import static expense.Expense.Type.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReportLogicTest {
  private ReportLogic reportLogic;

  @Before
  public void setUp() {
    reportLogic = new ReportLogic();
  }

  @Test
  public void printEmpty() {
    assertEquals("9/12/2002", reportLogic.getDate());
    assertEquals(0, reportLogic.getReportExpenses().size());
    assertTotalsEquals(0, 0);
  }

  @Test
  public void printOneDinner() {
    reportLogic.addExpense(new Expense(DINNER, 1678));

    assertTotalsEquals(16.78, 16.78);
  }

  @Test
  public void twoMeals() throws Exception {
    reportLogic.addExpense(new Expense(DINNER, 1000));
    reportLogic.addExpense(new Expense(BREAKFAST, 500));

    assertTotalsEquals(15.0, 15.0);
  }

  @Test
  public void twoMealsAndCarRental() throws Exception {
    reportLogic.addExpense(new Expense(DINNER, 1000));
    reportLogic.addExpense(new Expense(BREAKFAST, 500));
    reportLogic.addExpense(new Expense(CAR_RENTAL, 50000));
    
    assertTotalsEquals(15.0, 515.0);
  }

  @Test
  public void overages() throws Exception {
    reportLogic.addExpense(new Expense(BREAKFAST, 1000));
    reportLogic.addExpense(new Expense(BREAKFAST, 1001));
    reportLogic.addExpense(new Expense(DINNER, 5000));
    reportLogic.addExpense(new Expense(DINNER, 5001));

    assertNormalAt(0);
    assertTooExpensiveAt(1);
    assertNormalAt(2);
    assertTooExpensiveAt(3);
  }

  private void assertNormalAt(int i) {
    assertFalse(reportLogic.getReportExpenses().get(i).isTooExpensive());
  }

  private void assertTooExpensiveAt(int i) {
    assertTrue(reportLogic.getReportExpenses().get(i).isTooExpensive());
  }

  private void assertTotalsEquals(double expectedMealExpenses, double expectedTotal) {
    assertEquals(expectedMealExpenses, reportLogic.getMealExpenses(), 0.001);
    assertEquals(expectedTotal, reportLogic.getTotal(), 0.001);
  }

}
