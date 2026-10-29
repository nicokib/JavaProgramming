package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceException;
import be.abis.courseadmin.exception.PriceTooHighException;

public class Company {

    private String name;
    private int companyNumber;
    private double minPrice = 5000;
    private double maxPrice = 50000;

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, int companyNumber)
    {
    this(name);
    this.companyNumber = companyNumber;
    }

    public Company(String name, int companyNumber, double maxPrice)
    {
        this(name);
        this.companyNumber = companyNumber;
        this.maxPrice = maxPrice;
    }

    public Company(String name, int companyNumber, double minPrice,  double maxPrice)
    {
        this(name);
        this.companyNumber = companyNumber;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void prinInfo() {
        System.out.println(toString());
    }

    public double requestPriceOfferForCompanySession(Course c, int numberOfParticipants) throws PriceException {
        CompanySession session = new CompanySession(c,"",this, null, this, numberOfParticipants);

        double priceOffer = session.calculatePrice();
        if(priceOffer > maxPrice) {
            throw new PriceTooHighException("Price offer exceeds maximum alloxed price of " + maxPrice);
        }
        return priceOffer;
    }

    @Override
    public String toString(){
        return "The company's name is " + name +" and the company number is "+ companyNumber +".";
    }
}
