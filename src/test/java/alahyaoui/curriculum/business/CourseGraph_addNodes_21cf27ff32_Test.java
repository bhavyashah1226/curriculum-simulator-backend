/*
Test generated by RoostGPT for test javaUnitTest using AI Type Open AI and AI Model gpt-4

Test Scenario 1: Adding a Single Node
- Create a single CourseNode object and add it to a List of CourseNodes.
- Call the addNodes method with the aforementioned List.
- Assert that the nodes Set contains the CourseNode object added earlier.

Test Scenario 2: Adding Multiple Nodes
- Create multiple CourseNode objects and add them to a List of CourseNodes.
- Call the addNodes method with the aforementioned List.
- Assert that the nodes Set contains all the CourseNode objects added earlier.

Test Scenario 3: Adding Duplicate Nodes
- Create a CourseNode object and add it to a List of CourseNodes twice.
- Call the addNodes method with the aforementioned List.
- Assert that the nodes Set contains only one instance of the CourseNode object.

Test Scenario 4: Adding Null Nodes
- Create a List of CourseNodes with null values.
- Call the addNodes method with the aforementioned List.
- Assert that the nodes Set does not contain any null values.

Test Scenario 5: Adding Nodes to an Already Populated Set
- Create and add a CourseNode object to the nodes Set.
- Create a different CourseNode object and add it to a List of CourseNodes.
- Call the addNodes method with the aforementioned List.
- Assert that the nodes Set contains both the CourseNode objects.

Test Scenario 6: Adding an Empty List
- Create an empty List of CourseNodes.
- Call the addNodes method with the aforementioned List.
- Assert that the nodes Set is unchanged.

Test Scenario 7: Adding a List with a Mix of Null and Non-Null Nodes
- Create a List of CourseNodes with both null and non-null values.
- Call the addNodes method with the aforementioned List.
- Assert that the nodes Set contains the non-null values and does not contain any null values.
*/
package alahyaoui.curriculum.business;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourseGraph_addNodes_21cf27ff32_Test {
    private CourseGraph courseGraph;
    private CourseNode node1;
    private CourseNode node2;
    private CourseNode node3;

    @Before
    public void setUp() {
        courseGraph = new CourseGraph();
        node1 = new CourseNode("1");
        node2 = new CourseNode("2");
        node3 = new CourseNode("3");
    }

    @Test
    public void testAddNodes_SingleNode() {
        List<CourseNode> nodes = new ArrayList<>();
        nodes.add(node1);
        courseGraph.addNodes(nodes);
        Assert.assertTrue(courseGraph.getNodes().contains(node1));
    }

    @Test
    public void testAddNodes_MultipleNodes() {
        List<CourseNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        courseGraph.addNodes(nodes);
        Assert.assertTrue(courseGraph.getNodes().contains(node1));
        Assert.assertTrue(courseGraph.getNodes().contains(node2));
        Assert.assertTrue(courseGraph.getNodes().contains(node3));
    }

    @Test
    public void testAddNodes_DuplicateNodes() {
        List<CourseNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node1);
        courseGraph.addNodes(nodes);
        Assert.assertEquals(1, courseGraph.getNodes().size());
    }

    @Test
    public void testAddNodes_NullNodes() {
        List<CourseNode> nodes = new ArrayList<>();
        nodes.add(null);
        courseGraph.addNodes(nodes);
        Assert.assertFalse(courseGraph.getNodes().contains(null));
    }

    @Test
    public void testAddNodes_AlreadyPopulatedSet() {
        courseGraph.addNodes(List.of(node1));
        courseGraph.addNodes(List.of(node2));
        Assert.assertEquals(2, courseGraph.getNodes().size());
        Assert.assertTrue(courseGraph.getNodes().contains(node1));
        Assert.assertTrue(courseGraph.getNodes().contains(node2));
    }

    @Test
    public void testAddNodes_EmptyList() {
        courseGraph.addNodes(new ArrayList<>());
        Assert.assertTrue(courseGraph.getNodes().isEmpty());
    }

    @Test
    public void testAddNodes_MixOfNullAndNonNullNodes() {
        List<CourseNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(null);
        courseGraph.addNodes(nodes);
        Assert.assertFalse(courseGraph.getNodes().contains(null));
        Assert.assertTrue(courseGraph.getNodes().contains(node1));
    }
}
