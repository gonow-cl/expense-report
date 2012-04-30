package expenseReport;

class ReportExpense {
  private double amount;
  private String name;
  private boolean tooExpensive;

  public ReportExpense(double amount, String name, boolean tooExpensive) {
    this.amount = amount;
    this.name = name;
    this.tooExpensive = tooExpensive;
  }

  public boolean isTooExpensive() {
    return tooExpensive;
  }

  public double getAmount() {
    return amount;
  }

  public Object getName() {
    return name;
  }
}
