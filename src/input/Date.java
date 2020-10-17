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
  private ArrayList<Person> people;

  public Date(int initMonth, int initYear, int finMonth, int finYear, ArrayList<Person> people) {
    this.initMonth = initMonth;
    this.initYear = initYear;
    this.finMonth = finMonth;
    this.finYear = finYear
    for (int i = 0; i < people.size(); i++)
      this.people.add(people.get(i));
  }
  //Getting the current date value
  LocalDate currentdate = LocalDate.now();

  //for ongoing events
  public Date(int initMonth, int initYear, ArrayList<Person> people) {
    this(initMonth, initYear, currentdate.getMonthValue(), currentdate.getYear(), people);
  }

  public ArrayList<Person> getPeople() {
    return people;
  }

  public void addPerson(Person p) {
    people.add(p);
  }

  public int numberOfPeople() {
    return people.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Date date = (Date) o;
    return date.initMonth = initMonth, date.initYear = initYear, date.finMonth = finMonth, date.finYear = finYear;
  }

  @Override
  public String toString() {
    return "Date{" +
            "starting from " + initYear + "/" + iniMonth +
            "to " + finYear + "/" + finMonth
    '}';
  }
}
