import java.io.*;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> list = new ArrayList<>();
    private final String FILE = "students.dat";

    public StudentManager() {
        load();
    }

    public boolean rollExists(int roll) {
        for (Student s : list) {
            if (s.getRollNo() == roll)
                return true;
        }
        return false;
    }

    public void addStudent(Student s) {
        list.add(s);
        save();
    }

    public void viewAll() {
        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public void findStudent(int roll) throws StudentNotFoundException {
        for (Student s : list) {
            if (s.getRollNo() == roll) {
                System.out.println(s);
                return;
            }
        }
        throw new StudentNotFoundException("Student not found!");
    }

    public void deleteStudent(int roll) throws StudentNotFoundException {
        for (Student s : list) {
            if (s.getRollNo() == roll) {
                list.remove(s);
                save();
                System.out.println("Record deleted.");
                return;
            }
        }
        throw new StudentNotFoundException("Student not found!");
    }

    private void save() {
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    @SuppressWarnings("unchecked")
    private void load() {
        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(FILE))) {
            list = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            list = new ArrayList<>();
        }
    }
}
