/**
 * TODO: Add file header
 * Name:
 * ID:
 * Email:
 * File description: 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO: Add class header
 */
public class CSE12NaryTree<E extends Comparable<E>> {
    
    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;
    
        /**
         * Initializes the node with the data passed in
         * 
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    
        /**
         * Getter for data
         * 
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         * 
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         * 
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         * 
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         * 
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }
    
    }
    //root node of the N-ary tree
    Node root;
    //number of nodes in the N-ary tree
    int size;
    //maximum of children in each node for this N-ary tree
    int N;

    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     * 
     * @param N The N the N-tree should be initialized with
     */
    public CSE12NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        //initialization
        this.root = null;
        this.size = 0;
        this.N = N;
    }

    //duplicates are allowed, null values are not allowed.
    /**
     * adds a new node containing element in the level order, and update the size.
     * implement queue to do level order, and then find the parent through index calculation
     *
     */

    public void add(E element) {
        //throw exception if element is null
        if(element == null){
            throw new NullPointerException();
        }
        //the node to be added
        Node node = new Node(element);
        //if tree is empty, change the value from null to element, size increments
        if(this.root == null){
            this.root = new Node(element);
            size++;
            return;
        }
        //if the tree is not empty, then we use queue to keep iterating the nodes
        Queue<Node> q = new LinkedList<>();
        //use a list to store the nodes in the tree, so that we can get the parent node through
        //the index calculation easily
        List<Node> levelnodes = new ArrayList<>();

        q.add(root);
        while(!q.isEmpty()){
            //remove the node from the queue and add it to the list to store the nodes
            Node n = q.remove();
            levelnodes.add(n);
            //iteration through all the children if such nodes exist
            if(n.getChildren()!=null){
                for(int i = 0; i < n.getNumChildren(); i++){
                    //adding the children (if there are any) to the queue
                    q.add(n.getChildren().get(i));
                }
            }
        }
//        while(levelorderhelper(q, curr, height)){
//            height++;
//        }
        //we will get the level order of travesel, and store the nodes in the queue q
        //now we will find the index of the node's parent and then find the parent
        int parentindex = (q.size()-1)/N;
        //now addChild to the parent node
        Node parent = levelnodes.get(parentindex);

        parent.addChild(node);
        size++;
    }

    /**
     * TODO: Add method header
     */
    public boolean contains(E element) {
        //null exception
        if(element == null){
            throw new NullPointerException();
        }
        //empty tree
        if(this.root == null){
            return false;
        }
        //base case, root value is equal to the element
        if(this.root.getData().compareTo(element) == 0){
            return true;
        }
        //if the tree is not empty, then we use queue to keep iterating the nodes
        Queue<Node> q = new LinkedList<>();
        //use a list to store the nodes in the tree
        List<Node> levelnodes = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            //remove the node from the queue and add it to the list to store the nodes
            Node n = q.remove();
            levelnodes.add(n);
            //iteration through all the children if such nodes exist
            if(n.getChildren()!=null){
                for(int i = 0; i < n.getNumChildren(); i++){
                    //iterate through all the children nodes, and compare with the element
                    //return true if find such node
                    if(n.getChildren().get(i) == element){
                        return true;
                    }else{
                        //else keeping adding the nodes into the q
                        q.add(n.getChildren().get(i));
                    }
                }
            }
        }
        return false;
    }

    /**
     * Use a priority queue and heap sort to return the tree in an ascending order
     * if the tree is empty, the list should be null
     */
    public ArrayList<E> sortTree(){
        //initialize to an empty list
        ArrayList<E> list = new ArrayList<>();
        //initialize a priority queue
        PriorityQueue<E> pq = new PriorityQueue<>();
        Queue<Node> q = new LinkedList<>();

        //empty tre, return an empty arraylist
        if(root == null){
            return list;
        }else {
            q.add(root);
            while (!q.isEmpty()) {
                //remove the node from the queue and add it to the list to store the nodes
                Node n = q.remove();
                pq.add(n.getData());
                if(n.getChildren() != null){
                    for(int i =0; i < n.getNumChildren(); i++){
                        q.add(n.getChildren().get(i));
                    }
                }
            }
        }
        while(!pq.isEmpty()){
            list.add((E)pq.remove());
        }
        return list;

    }
}
