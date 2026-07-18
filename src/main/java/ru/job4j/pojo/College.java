package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("АФИ-1");
        student.setAdmissionDate(2026, 7, 18);

        System.out.println(
                student.getFullName()
                        + ", группа: "
                        + student.getGroup()
                        + ", дата поступления: "
                        + student.getAdmissionDate()
        );
    }
}
