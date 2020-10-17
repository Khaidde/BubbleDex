package input;
import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDate;
import java.time.Month;

public class Date {
  //Keep track of start and end month/year of a trait
  int initMonth;
  int initYear;
  int finMonth;
  int finYear;
  //private ArrayList<Person> people;

  public Date(int initMonth, int initYear, int finMonth, int finYear) {
    this.initMonth = initMonth;
    this.initYear = initYear;
    this.finMonth = finMonth;
    this.finYear = finYear;
  }

  //for ongoing events
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
            "to " + finYear + "/" + finMonth + "}";
  }
}
