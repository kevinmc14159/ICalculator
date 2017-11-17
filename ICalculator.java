import java.io.*;
import java.text.DecimalFormat;

public class ICalculator {

  private static final int NUM_MONTHS = 12;
  private static final double HUNDRED = 100.0;

  private double current;
  private int years;
  private double interest;
  private int monthly;

  public ICalculator(double current, int years, double interest, int monthly) {
    this.current = current;
    this.years = years;
    this.interest = interest;
    this.monthly = monthly;
  }

  public void calculate() {
    while(this.years > 0) {
      // Calculate yearly contribution.
      this.current += (this.monthly * NUM_MONTHS);

      // Apply exponential growth.
      this.current *= ((HUNDRED + this.interest) / HUNDRED);

      this.years--;
    }    
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    System.out.println("Welcome to the Investment Calculator!");

    System.out.println("Enter a starting amount (float) for your investments:");
    input = br.readLine();
    double current = Double.parseDouble(input);

    System.out.println("How many years (int) will you contribute?");
    input = br.readLine();
    int years = Integer.parseInt(input);

    System.out.println("What is the interest rate (float) at which your investments will grow?");
    input = br.readLine();
    double interest = Double.parseDouble(input);

    System.out.println("What is your monthly contribution (int)?");
    input = br.readLine();
    int monthly = Integer.parseInt(input);

    ICalculator myCalc = new ICalculator(current, years, interest, monthly);
    myCalc.calculate();

    // Make final amount more readable.
    DecimalFormat formatter = new DecimalFormat("#,###");
    double result = Math.round(myCalc.current);

    System.out.println("Your final net worth is $" + formatter.format(result));

  }

}