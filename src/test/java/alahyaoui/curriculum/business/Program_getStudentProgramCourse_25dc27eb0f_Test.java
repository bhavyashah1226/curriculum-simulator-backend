/*
Test generated by RoostGPT for test javaUnitTest using AI Type Open AI and AI Model gpt-4

1. Positive Scenario: Test if the method returns the correct CourseStateDto when a valid courseId is passed. This can be done by adding a known CourseStateDto to the coursesToStates HashMap and then calling the method with the courseId of the added CourseStateDto.

2. Negative Scenario: Test if the method returns null when an invalid courseId is passed. This can be done by calling the method with a courseId that does not exist in the coursesToStates HashMap.

3. Negative Scenario: Test if the method returns null when a null courseId is passed. This is to check how the method handles null inputs.

4. Positive Scenario: Test if the method can handle and return correct CourseStateDto when multiple entries are present in the coursesToStates HashMap. This can be done by adding multiple CourseStateDto to the HashMap and then calling the method with the courseIds of the added CourseStateDto.

5. Negative Scenario: Test if the method behaves as expected when the coursesToStates HashMap is empty. This can be done by calling the method without adding any CourseStateDto to the HashMap.

6. Edge Scenario: Test if the method can handle and return correct CourseStateDto for edge cases like the longest possible courseId or shortest possible courseId (like a single character courseId).

7. Negative Scenario: Test if the method behaves as expected when the courseId is an empty string. This is to check how the method handles empty string inputs. 

8. Positive Scenario: Test if the method is case sensitive. Add a CourseStateDto with a courseId in a certain case and then call the method with the courseId in a different case. The expected behavior should be clarified in the method's requirements. 

9. Negative Scenario: Test if the method behaves as expected when courseId is made of special characters or spaces. 

10. Positive Scenario: Test if the method returns the correct CourseStateDto for courseIds with leading or trailing spaces. The method should ideally trim the courseId before processing. 

11. Negative Scenario: Test how the method behaves when it is called concurrently. This is to test the method's thread-safety.
*/
package alahyaoui.curriculum.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import alahyaoui.curriculum.dto.CourseStateDto;

public class Program_getStudentProgramCourse_25dc27eb0f_Test {

    private Program program;

    @BeforeEach
    public void setup() {
        program = new Program();
    }

    @Test
    public void testGetStudentProgramCourse_validCourseId() {
        CourseStateDto expectedDto = new CourseStateDto();
        program.coursesToStates.put("validCourse", expectedDto);

        CourseStateDto actualDto = program.getStudentProgramCourse("validCourse");

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testGetStudentProgramCourse_invalidCourseId() {
        assertNull(program.getStudentProgramCourse("invalidCourse"));
    }

    @Test
    public void testGetStudentProgramCourse_nullCourseId() {
        assertNull(program.getStudentProgramCourse(null));
    }

    @Test
    public void testGetStudentProgramCourse_multipleEntries() {
        CourseStateDto expectedDto1 = new CourseStateDto();
        CourseStateDto expectedDto2 = new CourseStateDto();
        program.coursesToStates.put("course1", expectedDto1);
        program.coursesToStates.put("course2", expectedDto2);

        assertEquals(expectedDto1, program.getStudentProgramCourse("course1"));
        assertEquals(expectedDto2, program.getStudentProgramCourse("course2"));
    }

    @Test
    public void testGetStudentProgramCourse_emptyMap() {
        assertNull(program.getStudentProgramCourse("course1"));
    }

    @Test
    public void testGetStudentProgramCourse_edgeCases() {
        CourseStateDto expectedDto = new CourseStateDto();
        program.coursesToStates.put("a", expectedDto);

        assertEquals(expectedDto, program.getStudentProgramCourse("a"));
    }

    @Test
    public void testGetStudentProgramCourse_emptyString() {
        assertNull(program.getStudentProgramCourse(""));
    }

    @Test
    public void testGetStudentProgramCourse_caseSensitive() {
        CourseStateDto expectedDto = new CourseStateDto();
        program.coursesToStates.put("course", expectedDto);

        assertNull(program.getStudentProgramCourse("COURSE"));
    }

    @Test
    public void testGetStudentProgramCourse_specialCharacters() {
        assertNull(program.getStudentProgramCourse("@#$%"));
    }

    @Test
    public void testGetStudentProgramCourse_leadingTrailingSpaces() {
        CourseStateDto expectedDto = new CourseStateDto();
        program.coursesToStates.put("course", expectedDto);

        assertEquals(expectedDto, program.getStudentProgramCourse(" course "));
    }

    @Test
    public void testGetStudentProgramCourse_concurrentAccess() throws InterruptedException {
        CourseStateDto expectedDto = new CourseStateDto();
        program.coursesToStates.put("course", expectedDto);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                CourseStateDto actualDto = program.getStudentProgramCourse("course");
                assertEquals(expectedDto, actualDto);
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }
}
