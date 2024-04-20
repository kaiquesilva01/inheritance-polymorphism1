package entities;

public class Company extends TaxPayer{

    private Integer empNumber;

    public Company(String name, Double annualIncome, Integer empNumber) {
        super(name, annualIncome);
        this.empNumber = empNumber;
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }
    public Double Tax() {
        if(empNumber > 10) {
            return getAnnualIncome() * 0.14;
        }
        else {
            return getAnnualIncome() * 0.16;
        }
    }
}
