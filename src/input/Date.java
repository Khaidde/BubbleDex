package input;

public class Date {
    //TODO: If making Date, change the ArrayList in Person too
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
    //this is for if the trait/event is still ongoing??
    public Date(int initMonth, int initYear) {
        this(initMonth, initYear, ??, ??, new ArrayList<>());
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
                "starting from" + initYear + "/" + iniMonth + 
                "to" + finYear + "/" + finMonth
                '}';
    }
}
