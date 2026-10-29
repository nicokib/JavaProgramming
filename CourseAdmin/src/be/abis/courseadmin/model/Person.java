package be.abis.courseadmin.model;

public class Person {
    private static int counter = 0;
    private String firstName;
    private String lastName;
    private Company company;
    private int personNumber;
    private String[] hobbies = new String[10];
    private int nbrHobbies = 0;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        counter++;
        personNumber = counter;
    }

    public Person(String firstName, String lastName, Company company) {
        this(firstName, lastName);
        this.company = company;
    }

    public static int getCounter() {
        return counter;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public int getNbrHobbies() {
        return nbrHobbies;
    }

    public String getHobby(int numHobby) {
        if (numHobby >= 0 && numHobby < hobbies.length) {
            return hobbies[numHobby];
        }
        else return "";
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void addHobby(String hobby) {
        if(nbrHobbies < hobbies.length) {
            hobbies[nbrHobbies++] = hobby;
        }
        else {
            System.out.println("Hobbies is full (max " + hobbies.length + " hobbies) : Impossible to add "+ hobby +".");
        }
    }

    public void addHobbies(String... hobbies) {
        for(String hobby : hobbies) {
            addHobby(hobby);
        }
    }

    public void printInfo() {
        String message = "Person number " + getPersonNumber() + " : " + getFirstName() + " " + getLastName();
        if(getCompany() != null) {
            message += " works for " + getCompany().getName() + ".";
        }
        else {
            message +=" is not linked to a company for the moment.";
        }
        System.out.println(message);
    }

    @Override
    public String toString() {
        String message = "Person - Firstname :" + getFirstName() + ", Lastname : " + getLastName() + ", "+ (getCompany() != null ? getCompany().toString() : "not link to a company");
        return message;
    }

    public void attendCourse(Course c) {
        System.out.println(getFirstName() + " is attending " + c.getTitle() + " course ");
        System.out.println("The price of the course will be " + c.calculateTotalPrice());
    }
}
