package input;

public class Trait {
    private Group group;
    private Date date;

    public Trait(Group group, Date date) {
        if (group != null) {
            this.group = new Group(group);
        }
        if (date != null) {
            this.date = date;
        }
    }

    public Group getGroup() {
        return group;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Trait{" +
                "group=" + group +
                ", date=" + date +
                '}';
    }
}
