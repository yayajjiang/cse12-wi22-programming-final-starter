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
        //ArrayList<Integer> actual = fivetree.sortTree();

        assertEquals(expected, fivetree.sortTree());

    }

    /**
     * This tests if elements are null for the add and contains methods, will throw exceptions
     */
    @Test
    public void testCustom(){
        boolean catchexception = false;
        try{
            fivetree.add(null);
        }catch (NullPointerException e){
            catchexception = true;
        }
        assertTrue("Exception thrown for null key.", catchexception);


        boolean catchexception2 = false;
        try{
            fivetree.contains(null);
        }catch (NullPointerException e){
            catchexception2 = true;
        }
        assertTrue("Exception thrown for null key.", catchexception2);
    }

    /**
     * This tests when that if the tree is empty, then the value of the root will
     * be the element added
     *
     */
    @Test
    public void testaddnull(){
        CSE12NaryTree<Integer> nulltree = new CSE12NaryTree<>(5);
        nulltree.add(1);
        assertEquals("The size should increase",nulltree.size, 1);
        assertEquals(nulltree.root.getData(), Integer.valueOf(1));
    }


    /**
     * This tests when we add many elements to the tree
     *
     */
    @Test
    public void testaddrecurrsive(){
        CSE12NaryTree<Integer> threetree = new CSE12NaryTree<>(3);
        threetree.root = threetree.new Node(0);
        threetree.root.addChild(threetree.new Node(1));
        threetree.root.addChild(threetree.new Node(2));
        threetree.size=3;
        threetree.add(3);
        threetree.add(4);
        threetree.add(5);
        threetree.add(6);
        threetree.add(7);

        assertEquals("The size should increase",threetree.size, 8);
        assertEquals(threetree.root.getChildren().get(2).getData(), Integer.valueOf(3));
        assertEquals(threetree.root.getChildren().get(0).getChildren().get(0).getData(), Integer.valueOf(4));
        assertEquals(threetree.root.getChildren().get(0).getChildren().get(1).getData(), Integer.valueOf(5));
        assertEquals(threetree.root.getChildren().get(0).getChildren().get(2).getData(), Integer.valueOf(6));
        assertEquals(threetree.root.getChildren().get(1).getChildren().get(0).getData(), Integer.valueOf(7));

    }

    /**
     * This tests when that if the tree is empty or it only contains one root node
     *
     */
    @Test
    public void testcontainsnullorroot(){
        CSE12NaryTree<Integer> nulltree = new CSE12NaryTree<>(5);
        assertEquals(nulltree.contains(3),false);

        nulltree.add(3);
        assertEquals(nulltree.contains(3),true);

        CSE12NaryTree<Integer> fivetree = new CSE12NaryTree<>(5);
        fivetree.root = fivetree.new Node(0);
        fivetree.root.addChild(fivetree.new Node(1));
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(4));
        fivetree.root.addChild(fivetree.new Node(5));
        assertTrue(fivetree.contains(3));
    }


    /**
     * test when the 5-ary tree which has many nodes
     */
    @Test
    public void testSortTreeregular(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);expected.add(1);expected.add(2);
        expected.add(3);expected.add(4);expected.add(5);
        //ArrayList<Integer> actual = fivetree.sortTree();
        fivetree.root = fivetree.new Node(0);
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(4));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(5));
        fivetree.root.addChild(fivetree.new Node(1));
        assertEquals(expected, fivetree.sortTree());

    }

    /**
     * test when the 5-ary tree which has duplicates nodes
     */
    @Test
    public void testSortTreeduplicates(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);expected.add(1);expected.add(1);
        expected.add(2);expected.add(3);expected.add(5);
        //ArrayList<Integer> actual = fivetree.sortTree();
        fivetree.root = fivetree.new Node(0);
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(1));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(5));
        fivetree.root.addChild(fivetree.new Node(1));
        assertEquals(expected, fivetree.sortTree());

    }




}
