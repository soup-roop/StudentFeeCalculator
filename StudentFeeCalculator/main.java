import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n--- STUDENT FEE MANAGEMENT ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All");
            System.out.println("3. Find Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();

                    if (manager.rollExists(roll)) {
                        System.out.println("Duplicate roll number! Please enter another roll number.");
                        break;
                    }

                    sc.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    System.out.print("Enter Category (SC/ST/OBC/GENERAL): ");
                    String category = sc.next();

                    System.out.print("Scholarship (yes/no): ");
                    String scholarship = sc.next();

                    System.out.print("Backlog (yes/no): ");
                    String backlog = sc.next();

                    Student s = new Student(name, roll, marks, category, scholarship, backlog);
                    manager.addStudent(s);

                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Roll No: ");
                    try {
                        manager.findStudent(sc.nextInt());
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 4:
                    System.out.print("Enter Roll No: ");
                    try {
                        manager.deleteStudent(sc.nextInt());
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}



