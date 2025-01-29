package sample;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    
    private String groupName;
    private Student[] students = new Student[10];

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException("Cannot add student. The group is full.");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Student with last name " + lastName + " not found.");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public void sortStudentsByLastName() {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1 == null && s2 == null) {
                    return 0;
                }
                if (s1 == null) {
                    return 1;
                }
                if (s2 == null) {
                    return -1;
                }
                return s1.getLastName().compareTo(s2.getLastName());
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Group: " + groupName + "\n");

        if (students != null && students.length > 0) {
            for (Student student : students) {
                if (student != null) {
                    sb.append(student.toString()).append("\n"); // Перевод строки для нового студента
                }
            }
        } else {
            sb.append("No students in the group.\n");
        }

        return sb.toString();
    }
}
