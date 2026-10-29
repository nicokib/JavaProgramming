package be.abis.courseadmin.model;

public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String message = "Company - Name :" + getName();
        return message;
    }
}
