package input;
import java.time.LocalDate;
import java.time.Month;

public class Date {
  //Keep track of start and end month/year of a trait
  int initMonth;
  int initYear;
  int finMonth;
  int finYear;

  /**
   * Constructor for past events
   * @param initMonth start month
   * @param initYear start year
   * @param finMonth end month
   * @param finYear end year
   */
  public Date(int initMonth, int initYear, int finMonth, int finYear) {
    this.initMonth = initMonth;
    this.initYear = initYear;
    this.finMonth = finMonth;
    this.finYear = finYear;
  }

  /**
   * Constructor for on-going events
   * @param initMonth start month
   * @param initYear start year
   */
  public Date(int initMonth, int initYear) {
    //Getting the current date value
    LocalDate currentdate = LocalDate.now();
    this.initMonth = initMonth;
    this.initYear = initYear;
    this.finMonth = currentdate.getMonthValue();
    this.finYear = currentdate.getYear();
  }

//  public ArrayList<Person> getPeople() {
//    return people;
//  }
//
//  public void addPerson(Person p) {
//    people.add(p);
//  }
//
//  public int numberOfPeople() {
//    return people.size();
//  }

  /**
   * Checks to see if given date is within this.
   * @param date date you want to check
   * @return true if the date is within this, false otherwise
   */
  public boolean includes(Date date) {
    if (date.initYear < this.initYear || ((date.initYear == this.initYear) && (date.initMonth < this.initMonth))) {
      return false;
    } 
    else if (date.finYear > this.finYear || ((date.finYear == this.finYear) && (date.finMonth > this.finMonth))) {
      return false;
    }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Date date = (Date) o;
    return date.initMonth == initMonth &&
            date.initYear == initYear &&
            date.finMonth == finMonth &&
            date.finYear == finYear;
  }

  @Override
  public String toString() {
    return "Date{" +
            "starting from " + initYear + "/" + initMonth +
            " to " + finYear + "/" + finMonth + "}";
  }
}
