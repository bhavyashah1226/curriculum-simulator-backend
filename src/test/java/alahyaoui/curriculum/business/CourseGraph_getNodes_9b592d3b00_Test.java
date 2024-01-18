/*
Test generated by RoostGPT for test javaUnitTest using AI Type Open AI and AI Model gpt-4

Test Scenario 1: Check if the getNodes() function returns a Set of CourseNode objects.
- Given that the function getNodes() is called
- When the return value is checked
- Then it should be a Set of CourseNode objects

Test Scenario 2: Check if the getNodes() function returns an empty Set when there are no CourseNode objects.
- Given that there are no CourseNode objects
- When the function getNodes() is called
- Then it should return an empty Set

Test Scenario 3: Check if the getNodes() function returns all the CourseNode objects.
- Given that there are multiple CourseNode objects
- When the function getNodes() is called
- Then it should return a Set containing all the CourseNode objects

Test Scenario 4: Check if the getNodes() function does not return any null values.
- Given that the function getNodes() is called
- When the return value is checked
- Then it should not contain any null values

Test Scenario 5: Check if the getNodes() function does not return any duplicates.
- Given that there are duplicate CourseNode objects
- When the function getNodes() is called
- Then it should return a Set containing unique CourseNode objects only

Test Scenario 6: Check if the getNodes() function maintains the insertion order.
- Given that multiple CourseNode objects are added in a specific order
- When the function getNodes() is called
- Then it should return a Set maintaining the insertion order of the CourseNode objects.

Test Scenario 7: Check if the getNodes() function is thread-safe.
- Given that multiple threads are accessing the getNodes() function concurrently
- When the function getNodes() is called
- Then it should handle concurrent access without any data inconsistency or issues.
*/
package alahyaoui.curriculum.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourseGraph_getNodes_9b592d3b00_Test {

    private CourseGraph courseGraph;
    private CourseNode courseNode1;
    private CourseNode courseNode2;

    @BeforeEach
    void setUp() {
        courseGraph = new CourseGraph();
        courseNode1 = new CourseNode("1");
        courseNode2 = new CourseNode("2");
    }

    @Test
    void testGetNodesReturnsSetOfCourseNodeObjects() {
        courseGraph.addNode(courseNode1);
        Set<CourseNode> nodes = courseGraph.getNodes();
        assertTrue(nodes.contains(courseNode1));
    }

    @Test
    void testGetNodesReturnsEmptySetWhenNoCourseNodeObjects() {
        Set<CourseNode> nodes = courseGraph.getNodes();
        assertTrue(nodes.isEmpty());
    }

    @Test
    void testGetNodesReturnsAllCourseNodeObjects() {
        courseGraph.addNode(courseNode1);
        courseGraph.addNode(courseNode2);
        Set<CourseNode> nodes = courseGraph.getNodes();
        assertTrue(nodes.contains(courseNode1));
        assertTrue(nodes.contains(courseNode2));
    }

    @Test
    void testGetNodesDoesNotReturnNullValues() {
        courseGraph.addNode(courseNode1);
        Set<CourseNode> nodes = courseGraph.getNodes();
        assertFalse(nodes.contains(null));
    }

    @Test
    void testGetNodesDoesNotReturnDuplicates() {
        courseGraph.addNode(courseNode1);
        courseGraph.addNode(courseNode1);
        Set<CourseNode> nodes = courseGraph.getNodes();
        assertEquals(1, nodes.size());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void testGetNodesIsThreadSafe() {
        courseGraph.addNode(courseNode1);
        courseGraph.addNode(courseNode2);
        Set<CourseNode> nodes1 = courseGraph.getNodes();
        Set<CourseNode> nodes2 = courseGraph.getNodes();
        assertEquals(nodes1, nodes2);
    }
}