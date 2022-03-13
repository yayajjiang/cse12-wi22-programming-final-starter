/**
 * Name:Jinya Jiang
 * ID:A17196093
 * Email:j9jiang@ucsd.edu
 * File description: This file is a TreeTester file. It tests the custom cases
 * and makes sure the methods inside the tree jave file functions well. The
 * tests are only for the add, contains, and sorttree method in the tree file.
 */
 
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * This class is a tester class. It has set up method and different
 * test methods to test the tree and the node. The first four tests
 * come from the description from the final programming. The rest are
 * edge cases or other cases which do not cover in the public tests.
 */
public class CSE12NaryTreeTester {
    //setup
    CSE12NaryTree<Integer> fivetree = new CSE12NaryTree<>(5);


    /**
     * This tests the add method on a 5-ary tree that already contains only
     * a root node and its 5 children nodes.
     */
    @Test
    public void testAdd(){
        fivetree.root = fivetree.new Node(0);
        fivetree.root.addChild(fivetree.new Node(1));
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(4));
        fivetree.root.addChild(fivetree.new Node(5));
        fivetree.size=6;

        //add the seventh node, which has a value of 6
        //    0
        //1 2 3 4 5
        //6
        fivetree.add(6);
        //after adding a node, the size should increment, and the position
        // should be right
        assertEquals("The size should increase", fivetree.size, 7);
        assertEquals(fivetree.root.getChildren().get(0).getChildren().
                get(0).getData(), Integer.valueOf(6));
    }

    /**
     * Tests the contains method on a 5-ary tree when the element is
     * not present in it.
     */
    @Test
    public void testContains(){
        fivetree.root = fivetree.new Node(0);
        fivetree.root.addChild(fivetree.new Node(1));
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(4));
        fivetree.root.addChild(fivetree.new Node(5));

        //7 is not in the tree
        assertFalse(fivetree.contains(7));
    }

    /**
     * test when the 5-ary tree only contains the root node
     */
    @Test
    public void testSortTree(){
        fivetree.root = fivetree.new Node(0);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(fivetree.root.data);

        //the list contains the data only will be created
        assertEquals(expected, fivetree.sortTree());

    }

    /**
     * This tests if elements are null for add and contains methods,
     * the outcome is throwing exceptions. This is different from others
     * because it tests if the element is null, then exceptions will be thrown
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
     * This tests when that if the tree is empty, then the value of the root
     * will be the element added
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
     * //                        0
     * //           1            2           *3* (added)
     * //   *4*  *5*  *6*   *7*
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
        assertEquals(threetree.root.getChildren().get(2).getData(),
                Integer.valueOf(3));
        assertEquals(threetree.root.getChildren().get(0).getChildren().
                get(0).getData(), Integer.valueOf(4));
        assertEquals(threetree.root.getChildren().get(0).getChildren().
                get(1).getData(), Integer.valueOf(5));
        assertEquals(threetree.root.getChildren().get(0).getChildren().
                get(2).getData(), Integer.valueOf(6));
        assertEquals(threetree.root.getChildren().get(1).getChildren().
                get(0).getData(), Integer.valueOf(7));

    }

    /**
     * This tests if the tree is empty and when it contains the root node or
     * leaf node
     *
     */
    @Test
    public void testcontainsnullorroot(){
        CSE12NaryTree<Integer> nulltree = new CSE12NaryTree<>(5);
        assertEquals(nulltree.contains(3),false);

        nulltree.add(3);
        assertEquals(nulltree.contains(3),true);

        //CSE12NaryTree<Integer> fivetree = new CSE12NaryTree<>(5);
        fivetree.root = fivetree.new Node(0);
        fivetree.root.addChild(fivetree.new Node(1));
        fivetree.root.addChild(fivetree.new Node(2));
        fivetree.root.addChild(fivetree.new Node(3));
        fivetree.root.addChild(fivetree.new Node(4));
        fivetree.root.addChild(fivetree.new Node(5));
        assertEquals(fivetree.contains(Integer.valueOf(3)), true);
    }



    /**
     * test when the 5-ary tree is empty , the expected outcome is an
     * empty arraylist
     */
    @Test
    public void testSortempty(){
        ArrayList<Integer> expected = new ArrayList<>();
        assertEquals(expected, fivetree.sortTree());

    }
    /**
     * test when the 5-ary tree which has many nodes, the values of them are
     * out of order
     */
    @Test
    public void testSortTreeregular(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);expected.add(1);expected.add(2);
        expected.add(3);expected.add(4);expected.add(5);
        //0 1 2 3 4 5
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
        //0 1 1 2 3 5
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
