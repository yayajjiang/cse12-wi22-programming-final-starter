/**
 *
 * Name:Jinya Jiang
 * ID:A17196093
 * Email:j9jiang@ucsd.edu
 * File description: This file is a tree class, it also has a Node class
 * inside it. The tree and node builds an N tree. It have basic add, contains,
 * and sort functions. It also implements an arraylist to represent the
 * children nodes.
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This class has a constructor for the tree and several mathods such as add,
 * contains and sort methods. It also has an inner Node class which creates
 * Node objects.
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
     * adds a new node containing element in the level order, and update
     * the size, it implements queue to do level order, and then find the
     * parent through index calculation
     *
     */

    public void add(E element) {
        //throw exception if element is null
        if(element == null){
            throw new NullPointerException();
        }
        //the node to be added
        Node node = new Node(element);
        //if tree is empty, creat a new node, it has the value element,
        //also size increments
        if(this.root == null){
            this.root = new Node(element);
            size++;
            return;
        }
        //if the tree is not empty, then we use queue to keep iterating
        // the nodes.
        //Queue has two implementation - linked list or priority queue,
        //In this case, we use linked list to store all the nodes
        //we can also get the parent node through the index calculation easily
        Queue<Node> q = new LinkedList<>();
        //we use another list to get all the nodes pulled from the queue
        List<Node> levelnodes = new LinkedList<>();

        q.add(root);
        while(true){
            Node n = q.remove();
            //remove the node from the queue and add it to the list to store the nodes
            levelnodes.add(n);
            //iteration through all the children nodes if such nodes exist
            if(n.getChildren()!=null){
                for(int i = 0; i < n.getNumChildren(); i++){
                    //adding the children (if there are any) to the queue
                    q.add(n.getChildren().get(i));
                }
            }
            if(q.isEmpty()){
                //if all the nodes are removed
                break;
            }
        }

        //we will get the level order traversal of the tree, and we store the
        // all nodes inside the linked list as well.
        // now we will find the index of the node's parent and the parent node
        // we give a connection to the parent node and the node that will be
        // inserted, be careful about the index here.
        int parentindex = ((levelnodes.size()-1)/N) ;
        //now addChild to the parent node
        Node parent = levelnodes.get(parentindex);
        parent.addChild(node);
        size++;
    }

    /**
     * This contains method 
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
