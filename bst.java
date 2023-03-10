import java.util.*;
class Node{
    int data;
    Node left, right;
    public Node(){
        data=0;
        left= null;
        right= null;
    }
    public Node(int d){
        data=d;
        left= null;
        right= null;
    }
}
public class bst{
    Node r;
    bst(){
        r = null;
    }
    // to insert data
    public Node create(Node root,int n){
        if(root == null){ 
            root = new Node(n);
            return root;
        }else if(n < root.data){
            root.left = create(root.left,n);
        }else if(n > root.data){
            root.right = create(root.right,n);
        }else{
            System.out.println("\nCan not insert duplicate value");
        }
        return root;
    }
    // to search node
    public Node search(Node root,int key){
        if (root == null){
            return root;
        }
        if(root.data == key){
            System.out.println("\nThe key you want to search is present at root node ");
        }else if(root.data < key){
            System.out.println("\nThe key you want to search is present in right subtree ");
        }else if(root.data > key){
            System.out.println("\nThe key you want to search is present in left subtree");
        }
        else if(root.data < key){
            root.left = search(root.left, key);
        }else{
            root.right = search(root.right,key);
        }
        return root;
    }
    // to find minimum in right side
    public Node rmin(Node root){
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    // to find maximum
    public Node lmax(Node root){
        root = root.left;
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
    // to delete node
    public Node delete(Node root,int key){
        Node temp = new Node();
        if(root == null){
            System.out.println("\nplease create tree first");
            return root;
        }
        if(key > root.data){
            root.right = delete(root.right, key);
        }
        else if(key < root.data){
            root.left = delete(root.left, key);
        }
        else{
            if(root.left == null && root.right==null){
                root= null;
            }
            else if(root.left == null){
                temp = rmin(root);
                root.data = temp.data;
                root.right = delete(root.right, root.data);
            }else{
                temp = lmax(root);
                root.data = temp.data;
                root.left=delete(root.left, root.data);
            }
        }
        return root;
    }
    // to display inorder
    void inOrder(Node node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    public int height(Node root){
        if(root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh > rh ){
            return lh+1;
        } else
        return rh + 1;
    }
    public void plevel(Node root,int level){
        if(root==null){
            return ;
        }
        if(level==1){
            System.out.print(root.data+" ");
        }else if(level > 1){
            plevel(root.left, level-1);
            plevel(root.right,level-1);
        }
    }
    // BFS (level-wise print)
    void BFS(Node root){
        int height = height(root);
        for(int i = 0;i<=height;i++){
            plevel(root,i);
        }

    }
    public static void main(String[] args) {
        
        bst obj = new bst();
        Scanner s=new Scanner(System.in);
        int key;
        int ch;
        do{
            System.out.println("\n1.insert 2. delete 3. search 4. BFS 5. display : ");
            System.out.println("Enter yor choice: ");
            ch = s.nextInt();
        switch(ch){
            case 1:
            int data;
            Scanner sc= new Scanner(System.in);
            System.out.println("\nEnter data to store: ");
            data= sc.nextInt();
            obj.r = obj.create(obj.r,data);
            break;
            case 2:
            System .out.println("\nEnter the element to be deleted: ");
            key = s.nextInt();
             obj.delete(obj.r, key);
            break;
            case 3:
            key = s.nextInt();
             obj.search(obj.r, key);
            break;
            case 4:
            obj.BFS(obj.r);
            break;
            case 5:
                System.out.println("\ninorder traversal using recrsion of binary tree is: ");
                obj.inOrder(obj.r);
                break;

        }
    }while(ch>0&&ch<6);
        
        
        
        
        
        
    }
}