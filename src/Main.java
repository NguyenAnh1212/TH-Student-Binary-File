import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Tạo danh sách students
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        // gọi phương thức writeToFile()
        writeToFile("student.txt", students);
        //
        List<Student> studentDataFromFile = readDataFromFile("student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
    // Phương thức ghi file truyền vào 2 tham số là đường dẫn mang tên file và đối tượng object là mảng student.
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path); // Tạo 1 luồng đầu ra với mục đích ghi thông tin vào file
            ObjectOutputStream oos = new ObjectOutputStream(fos); //tạo luồng Ghi dữ liệu là các đối tượng student vào file.
            oos.writeObject(students);  // Ghi đối tượng students đến luồng ghi obj được tạo bên trên.
            oos.close(); // đóng luồng.
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path); // Tạo luồng thông tin đầu vào mục đích liên kết với tệp có đường dẫn path
            ObjectInputStream ois = new ObjectInputStream(fis);//  tạo luồng nhập đối tượng có tên ois liên kết với luồng nhập file path có tên fis
            students = (List<Student>) ois.readObject();// Đọc đối tượng students, kiểu dữ liệu Student, ois là đối tượng luồng nhập
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }

}
