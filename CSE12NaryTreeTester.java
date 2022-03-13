/**
 * TODO: Add file header
 * Name:
 * ID:
 * Email:
 * File description: 
 */
 
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * TODO: Add class header
 */
public class CSE12NaryTreeTester {
    //setup
    CSE12NaryTree<Integer> fivetree = new CSE12NaryTree<>(5);

    @Before
    public void setUp(){
        fivetree.root = fivetree.new Node(0);

        //CSE12NaryTree<Integer>.Node parent = fivetree.root.getChildren().get(0);

    }

    /**
     * TODO: Add test case description.
     */
    @Test
    public void testAdd(){
        fivetree.root.addChild(fivetree.new Node(1));
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(4));
        fivetree.root.addChild(fivetree.new Node(5));
        fivetree.size=6;


        fivetree.add(6);
        //after adding a node, the size should increment, and the position should be right
        assertEquals("The size should increase", fivetree.size, 7);
        assertEquals(fivetree.root.getChildren().get(0).getChildren().get(0).getData(), Integer.valueOf(6));
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testContains(){
        fivetree.root.addChild(fivetree.new Node(1));
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(4));
        fivetree.root.addChild(fivetree.new Node(5));
        assertFalse(fivetree.contains(7));
    }

    /**
     * test when the 5-ary tree only contains the root node
     */
    @Test
    public void testSortTree(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(fivetree.root.data);
        ArrayList<Integer> actual = fivetree.sortTree();
        assertSame(expected.get(0), actual.get(0));

    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testCustom(){
        
    }
}
