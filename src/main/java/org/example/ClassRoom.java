package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class ClassRoom {
    private ClassRoomService crs;

    public ClassRoom() {

    }
    public ClassRoom(ClassRoomService crs) {
        this.crs = crs;
    }

    public double findClassAverageMarks(List<Integer> marks) {

        return marks.stream().mapToDouble(mark->mark).average().getAsDouble();
    }

    public boolean findStudent(String studentName) {
        return false;
    }

    public List<String> studentsStartWith(String startingLetter) {
        List<String> students = new ArrayList<String>();
        for(String student : crs.getStudentsForClassRoom("1A")) {
            if(student.startsWith(startingLetter)) {
                students.add(student);
            }
        }
        return students;
    }
}
