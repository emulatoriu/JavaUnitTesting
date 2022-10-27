import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.example.ClassRoom;
import org.example.ClassRoomService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.objenesis.instantiator.annotations.Instantiator;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClassRoomTest {

    ClassRoomService crs;
    @Test
    @DisplayName("Mega cooler Test")
    public void checkMarks() {
        ClassRoom cr = new ClassRoom();

        List<Integer> marks = Arrays.asList(1, 3, 4, 2, 1, 3, 2, 0);

        assertTrue(cr.findClassAverageMarks(marks) < 3);

        assertEquals(cr.findClassAverageMarks(marks), 2, 0);

    }

    @BeforeAll
    public void init() {
        crs = mock(ClassRoomService.class);
    }

    @Test
    public void ClassRoomMock() {


        List<String> students = Arrays.asList("Susi", "Maxi", "Babsi", "Timmy");
        when(crs.getStudentsForClassRoom("1A")).thenReturn(students);

        assertNotNull(crs.getStudentsForClassRoom("1A"));

        ClassRoom cr = new ClassRoom(crs);

        assertTrue(cr.studentsStartWith("S").contains("Susi"));
    }
}
