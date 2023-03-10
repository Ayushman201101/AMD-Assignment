import java.util.*;

class Node{
    char data;
    Node left,right;
    public Node ( char d){
        data=d;
        left=null;
        right=null;
    }
}
public class exptree{
    Node root;
    exptree(){
        root =null;
    }
    Stack <Node> st = new Stack<Node>();
   
    boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch =='*' || ch=='/' || ch=='^'){
            return true;
        }
        return false;
    }
    Node create(String data){
        Stack <Node> cs = new Stack<Node>();
        Node operand,operator,oprand1,oprand2;
        for ( int  i = 0;i<data.length();i++){
            if(!isOperator(data.charAt(i))){
                operand =new Node(data.charAt(i));
                cs.push(operand);
            }
            else{
                operator = new Node(data.charAt(i));
                oprand1 = cs.pop();
                oprand2 = cs.pop();

                operator.right = oprand1;
                operator.left = oprand2;

                cs.push(operator);
            }
        }
        operator = cs.pop();
        return operator;
    }
    void preorder_iterative(Node n){
        while(n != null){
            System.out.print(n.data+" ");
            st.push(n);
            n =n.left;
        }
        while(!st.empty()){
            n = st.pop();
            n= n.right;
            while(n!=null){
                System.out.print(n.data+" ");
                st.push(n);
                n =n.left;
            }
        }
    }
    void inorder_iterative(Node n){
        while(n != null){
            st.push(n);
            n =n.left;
        }
        while(!st.empty()){
            n= st.pop();
            System.out.print(n.data+" ");
            n= n.right;
            while(n != null){
                st.push(n);
                n =n.left;
            }
        }
    }
    Stack <Integer> s = new Stack<Integer>();
    void postorder_iterative(Node n){
        int flag;
        while(n != null){
            s.push(0);
            st.push(n);
            n = n.left;
        }
        while(!st.empty()){
            n = st.pop();
            flag = s.pop();
            if(flag == 1){
                System.out.print(n.data+ " ");
                continue;
            }
            else{
                st.push(n);
                s.push(1);
                n = n.right;
            }
            while(n!=null){
                s.push(flag);
                st.push(n);
                n=n.left;
            }
        }
    }
    void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    void inOrder(Node node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    void postOrder(Node node)
    {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the postfix expression");
        String data = sc.nextLine();
        exptree ep = new exptree();
        Node m = ep.create(data);
        System.out.println("preorder traversal using iterative function ");
        ep.preorder_iterative(m);
        System.out.println("\ninorder traversal using iterative function");
        ep.inorder_iterative(m);
        System.out.println("\npostorder traversal using iterative function");
        ep.postorder_iterative(m);

        System.out.println("\n\npreorder traversal using recrsion function");
        ep.preOrder(m);
        System.out.println("\ninorder traversal using recrsion function ");
        ep.inOrder(m);
        System.out.println("\npostorder traversal using recrsion function");
        ep.postOrder(m);        
    }
}

