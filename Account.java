//Aditya Malik
//This class will be making the Account for the Customer at a given Date
public class Account extends Object
{
  //These are the initial variables for the class
  //sets monthly fee for service
  private double lineFee=0;
  //rate for the account
  private double rate=0;
  //tax percentage applied to sales
  private double taxRate=0;
  //interest percentage applied to past due amounts
  private double interestRate=0;
  //service used by the account this month
  private int monthUsage=0;
  //expected monthly usages
  private int expectedMonthlyUsage=0;
  //past year usage 
  private int pastYearUsage =0;
  //the balane on the account
  private double balance=0;
  //amount billed to the customer this month
  private double monthBill=0;
  //amount paid by the customer so far this month
  private double amountPaidThisMonth=0;
  //amount in the account
  private double amount=0;
  //amount used by the customer in this current year
  private double currentYearUsage=0;
  //creates the customer
  private Customer customer;
  //creates the current date
  private Date date;
  //checks to see if the account is open
  private boolean isOpen;
  //checks to see if the account is on the monthly plan
  private boolean monthlyPlan;
  //sets the anniversary dae
  private Date anniversaryDate;
  //This constructor has input lineFee, rate, taxRate, interestRate, expectedMonthlyUsage
  public Account(double lineFee, double rate, double taxRate, double interestRate, int expectedMonthlyUsage)
  {
    this.lineFee = lineFee;
    this.rate = rate;
    this.taxRate = taxRate;
    this.interestRate = interestRate;
    this.expectedMonthlyUsage = expectedMonthlyUsage;
  }
  //This constructor takes the values from the other constructor but also adds customer and date to it 
  public Account(double lineFee, double rate, double taxRate, double interestRate, int expectedMonthlyUsage, Customer customer, Date date)
  {
   this(lineFee,rate,taxRate,interestRate,expectedMonthlyUsage);
   this.customer = customer;
   this.date = date;
  }
  //The following are a bunch of getter/setter methods for the various variables:
  //sets the value for lineFee, fee for having the service
  public void setLineFee(double lineFee)
  {
    this.lineFee = lineFee;
  }
  //Retrieves the value for lineFee
  public double getLineFee()
  {
    return lineFee;
  }
  //sets the value for rate for the account
  public void setRate(double rate)
  {
    this.rate = rate;
  }
  //retrieves the value for rate
  public double getRate()
  {
    return rate;
  }
  //sets the value for taxRate which is the tax percentage applied to sales
  public void setSalesTaxRate(double taxRate)
  {
    this.taxRate = taxRate;
  }
  //retrieves the value for taxRate
  public double getSalesTaxRate()
  {
    return taxRate;
  }
  //sets the value for interestRate which is the interest % applied to past-due amounts
  public void setInterestRate(double interestRate)
  {
    this.interestRate = interestRate;
  }
  //gets the value for interestRate
  public double getInterestRate()
  {
    return interestRate;
  }
  //sets the value for monthUsage which is the amount of service used this month
  public void setMonthUsage(int monthUsage)
  {
    this.monthUsage = monthUsage;
  }
  //retrieves the monthUsage
  public int getMonthUsage()
  {
    return monthUsage;
  }
  //retrieves the amount of service used by the account in the past year
  public int getPastYearUsage()
  {
    pastYearUsage = expectedMonthlyUsage*12;
    return pastYearUsage;
  }
  //retrieves the current money balance on the account
  public double getBalance()
  {
    return balance;
  }
  //retrieves the amount billed to the customer this month
  public double getMonthBill()
  {
    return monthBill;
  }
  //retrieves the amount the customer has paid off so far this month
  public double getAmountPaidThisMonth()
  {
    return amountPaidThisMonth;
  }
  //this allows the customers money to go through which decreases balance by amount and increases the amount paid this month by amount
  public void receivePayment(double amount)
  {
    this.amount = amount;
    balance = balance-amount;
    amountPaidThisMonth = amountPaidThisMonth+amount;
  }
  //sets the accounts customer to customer and sets anniversary date to date of when the account was created
  public void openAccount(Date date, Customer customer)
  {
    this.date = anniversaryDate;
    this.customer = customer;
    isOpen = true;
  }
  //checks to see if the account is open
  public boolean isOpen()
  {
    return isOpen;
  }
  //retrieves the anniversary date for the account
  public Date getAnniversaryDate()
  {
    return date;
  }
  //retrieves the current date
  public Date getDate()
  {
    return date;
  }
  //retrieves the customer for the account
  public Customer getCustomer()
  {
    return customer;
  }
  //this will test the processing at the end of a one year cycle
  public void endOfYearProcessing()
  {
    //if account is not open do not do anything here
    if(isOpen == false)
    {
    }
    else
    {
      //if its not on a plan, it'll do the following to get expectedMonthlyUsage
      if(monthlyPlan==false)
      {
        expectedMonthlyUsage = (int)currentYearUsage/12; 
      } 
      //if it is on a plan, it'll find the expectedMonthlyUsage, set that to pastYearUsage, and reset currentYearUsage
      if(monthlyPlan == true)
      {
        expectedMonthlyUsage = (int)(currentYearUsage+(currentYearUsage - pastYearUsage))/12;
        pastYearUsage = (int)currentYearUsage;
        currentYearUsage = 0; 
      }
    }
  }
  //this method does the processing for a single month cycle
  public void endOfMonthProcessing()
  {
    //if the account is not open then dont do anything
    if(isOpen == false)
    {
    }
    else
    { 
      //first it sets the currentYearUsage to increase, and the balance has the taxrate applied
      currentYearUsage = currentYearUsage + monthUsage;
      balance = balance + (lineFee+(monthUsage*rate))*(1+taxRate);
      //if the bill is more than the amountPaidThisMonth, add the interestRate
      if(amountPaidThisMonth < monthBill)
      {
        balance = balance + ((1+interestRate)*(monthBill-amountPaidThisMonth)); 
        monthBill = balance;
      }
      //if the account is not on a monthlyPlan, do the following statements
      if(monthlyPlan == false)
      {
        //if no balance or negative, set bill to 0
       if(balance <= 0)
       {
         monthBill = 0;
       }
       else
       {
         //if balance, then monthBill is equal to balance
         monthBill = balance;
       }
      }
      //If the account is on a monthlyPlan, do the following statements
      if(monthlyPlan == true)
      {
        //If the account owes more money that it has paid, then interestRate is applied to monthBill
        if(balance > amountPaidThisMonth)
        {
          monthBill = ((balance-amountPaidThisMonth)*(1+interestRate)+lineFee+(expectedMonthlyUsage*rate)+(lineFee*taxRate)+(expectedMonthlyUsage*rate*taxRate));
        }
        //If the account owes equal or less money than it has paid, then no interestRate is applied to monthBill
        if(balance <= amountPaidThisMonth)
        {
          monthBill = ((balance-amountPaidThisMonth)+lineFee+(expectedMonthlyUsage*rate)+(lineFee*taxRate)+(expectedMonthlyUsage*rate*taxRate)); 
        }
      }
    }
  }
  //This method checks to see if the account is on a monthlyPlab
  public boolean isOnMonthlyPlan()
  { 
    return monthlyPlan;
  }
  //This method will turn the account off from a monthlyPlan, and if it is open, it'll change the expectedMonthlyUsage
  public void turnOffMonthlyPlan()
  {
    monthlyPlan = false;
    if(isOpen == true)
    {
      expectedMonthlyUsage = pastYearUsage/12;
    }    
  }
  //This ses the account to be on a monthlyPlan. It also does the following statements:
  public void turnOnMonthlyPlan()
  {
    monthlyPlan = true;
    //If the account is open, the expectedMonthlyUsage is changed
     if(isOpen == true)
     {
       expectedMonthlyUsage = (int)(pastYearUsage-currentYearUsage)/(date.monthsUntil(this.getAnniversaryDate()));
       //If the monthlyUsage is negative or 0, just set it to 0
       if(expectedMonthlyUsage <= 0)
       {
         expectedMonthlyUsage = 0;
       }
     }
  }
  //This method will process the date for the accounts
  public void processDate(Date date)
  {
    this.date = date;
    //if the account is open, do nothing
    if(isOpen == false)
    {
    }
    else
    {
      //if the dates day and month are equal to anniversairys date an dmonth, it calls endOfYearProcessing
      if((this.date == anniversaryDate))
      {
       this.endOfYearProcessing(); 
      }
      //also if the dates day is equal to anniversaryds date day, the endOfMonthProcessing is called
      if(this.date.getDay() == anniversaryDate.getDay())
      {
        this.endOfMonthProcessing();
      }
    }
  }
}
  
  
  
  
  
  