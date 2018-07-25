// INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Lowest_Common_Ancestor
{
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
            
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            GfG g = new GfG();
            Node k = g.LCA(root,a,b);
            System.out.println(k.data);
            //System.out.println();
            t--;
            
        }
    }
}



/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class GfG
{
    
    boolean findNode(Node n, int d, Stack<Node> path){
        if(n == null){
            return false;
        }
        path.push(n);
        if(n.data == d){
            return true;
        }
        if(n.left != null && findNode(n.left, d,path)){
            return true;
        }
        if(n.right != null && findNode(n.right, d,path)){
            return true;
        }
        path.pop();
        return false;
    }
    Node LCA(Node root, int n1,int n2)
    {
        Stack<Node> path1 = new Stack<Node>();
        Stack<Node> path2 = new Stack<Node>();
        boolean findResult1 = findNode(root, n1, path1);
        boolean findResult2 = findNode(root, n2, path2);
        if(!findResult1 && !findResult2){
            return root;
        }
        while(!path1.isEmpty() && !path2.isEmpty()){

            if(path1.size() > path2.size()){
                path1.pop();
            }else if(path2.size() > path1.size()){
                path2.pop();
            } else {
                Node p1 = path1.pop();
                Node p2 = path2.pop();
                if(p1.data == p2.data){
                    return p1;
                }
            }
        }
        return root;
        
    }
}