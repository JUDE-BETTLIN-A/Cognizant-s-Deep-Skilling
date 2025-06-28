//Model Class
class Student {
    private String id;
    private String name;
    private String grade;

    //Constructor
    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

//View Class
class StudentView {
    public void displayStudentDetails(String id, String name, String grade) {
        System.out.println("=== Student Details ===");
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Grade : " + grade);
        System.out.println("========================");
    }
}

//Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    //Controller methods
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
    }
}

//Test Class
public class MVCPattern {
    public static void main(String[] args) {
        Student student = new Student("S001", "Alice", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        controller.updateView();
    }
}
