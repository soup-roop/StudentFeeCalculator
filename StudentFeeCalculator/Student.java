import java.io.Serializable;

public final class Student implements Serializable {

    private final String name;
    private final int rollNo;
    private final double marks;
    private final String category;    
    private final String scholarship;  
    private final String backlog;       
    private final double baseFee = 50000;

    public Student(String name, int rollNo, double marks,
                   String category, String scholarship, String backlog) {

        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.category = category;
        this.scholarship = scholarship;
        this.backlog = backlog;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double calculateDiscount() {

        double discount = 0;

        if (marks >= 90)
            discount += 20;
        else if (marks >= 80)
            discount += 10;
        else if (marks >= 70)
            discount += 5;

        switch (category.toUpperCase()) {
            case "SC":
            case "ST":
                discount += 10;
                break;
            case "OBC":
                discount += 5;
                break;
            case "GENERAL":
                discount += 2;
                break;
        }

        if (scholarship.equalsIgnoreCase("yes")
                && backlog.equalsIgnoreCase("no")) {
            discount += 10;
        }

        return discount;
    }

    public double finalFee() {
        return baseFee - (baseFee * calculateDiscount() / 100);
    }

    @Override
    public String toString() {
        return "\nName: " + name +
               "\nRoll No: " + rollNo +
               "\nMarks: " + marks +
               "\nCategory: " + category +
               "\nScholarship: " + scholarship +
               "\nBacklog: " + backlog +
               "\nDiscount: " + calculateDiscount() + "%" +
               "\nFinal Fee: rs" + finalFee() +
               "\n---------------------------";
    }
}


