import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.example.ClassRoom;
import org.example.ClassRoomService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.objenesis.instantiator.annotations.Instantiator;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassRoomTest {

    @Test
    public void checkMarks() {
        ClassRoom cr = new ClassRoom();

        List<Integer> marks = Arrays.asList(1, 3, 4, 2, 1, 3, 2, 1);

        assertTrue(cr.findClassAverageMarks(marks) < 3);

    }

    //TODO: Write a function that checks if the average makrs equal a certain one

    @Test
    public void ClassRoomMock() {
        ClassRoomService crs = mock(ClassRoomService.class);

        List<String> students = Arrays.asList("Susi", "Maxi", "Babsi", "Timmy");
        when(crs.getStudentsForClassRoom("1A")).thenReturn(students);

        assertNotNull(crs.getStudentsForClassRoom("1A"));

        ClassRoom cr = new ClassRoom(crs);

        assertTrue(cr.studentsStartWith("S").contains("Susi"));
    }
}
