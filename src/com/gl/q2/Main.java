package com.gl.q2;
 
// Class of the node
class Node
{
    int nodeData;
    Node left, right;
    
    // Function to allocate a new node with the given data and NULL left and right branch
    Node(int nodeValue)
    {
        nodeData = nodeValue;
        left = right = null;
    }
}
class Main
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
   
    // Function to to convert BST into a skewed tree in increasing order, having only right nodes
    static void BSToSkewed(Node root)
    {
       
        // Base Case
        if(root == null)       	
            return;           
        
        BSToSkewed(root.left);
        
        Node rightNode = root.right;
       
        if(headNode == null) {        	
            headNode = root;
            root.left = null;
            prevNode = root;            
        }
        else {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        // Similarly recurse for subtree
        BSToSkewed(rightNode);
    }
   
    // Function to traverse the right of skewed tree using recursion
    static void traverseSkewedTree(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.nodeData + " ");
        traverseSkewedTree(root.right);       
    }
   
    // Driver Code
    public static void main (String[] args)
    {
    	
    	Main tree = new Main();
    	tree.node = new Node(50);
    	tree.node.left = new Node(30);
    	tree.node.right = new Node(60);
    	tree.node.left.left = new Node(10);
    	tree.node.right.left= new Node(55);
    	
        BSToSkewed(node);
        traverseSkewedTree(headNode);
    }
}