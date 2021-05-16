package ru.netcracker.tasks.basics.webinar;

public class Name {
    private String first, last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Name)) {
            return false;
        }
        Name n = (Name) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        java.util.Set s = new java.util.HashSet();
        s.add(new Name("Brad", "Pitt")); System.out.println(s.contains(new Name("Brad", "Pitt")));
    }
}
