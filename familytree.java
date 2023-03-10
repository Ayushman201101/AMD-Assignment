import java.util.*;
class familytree{
    class person{
        String Name;
        LinkedList<person> Child = new LinkedList<person>();
        person Father;
        person Mother;
        person Spouce;
    }
    person ansistor;
    static Scanner sc =new Scanner(System.in);
    public void addansistor(String ansistor){
        person p = new person();
        p.Name=ansistor;
        this.ansistor=p;
    }
    public void addchild(person parent,String child,String relation){
        person p = new person();
        p.Name=child;
        if(relation.equals("father")){
            p.Father = parent;
            p.Mother = p.Father.Spouce;
            parent.Child.add(p);
            parent.Spouce.Child.add(p);
        }else if(relation.equals("mother")){
            p.Mother = parent;
            p.Father = p.Mother.Spouce; 
            parent.Child.add(p);
            parent.Spouce.Child.add(p);  
        }
    }
    public void addspouce(person husband, String name){
        person p = new person();
        p.Name = name;
        husband.Spouce = p;
        p.Spouce = husband;
        for (person n : husband.Child) {
            p.Child.add(n);
        }
    }
    public void addgrandchild(person grandperson,String name){
        person p = new person();
        p.Name = name;
        System.out.println("Enter the child name of"+grandperson.Name+"to which"+p.Name+"is child");
        String childname = sc.nextLine();
        for (person n : grandperson.Child) {
            if(n.Name.equals(childname)){
                n.Child.add(p);
            }
        }
    }
    public static void main(String [] args){
        System.out.println("Menu:\n1.Ansistor\n2.child\n3.grandchild\n4.spouce");
        String choice = sc.nextLine(); 
        familytree ft = new familytree();
        switch(choice){
            case "Ansistor": 
                ft.addansistor(sc.nextLine());
                break;
            case "child":
                ft.addchild(ft.ansistor,sc.nextLine(),sc.nextLine());
                break;
            case "grandchild":
                ft.addgrandchild(ft.ansistor,sc.nextLine());
                break;
            case "spouce":
                ft.addspouce(ft.ansistor, sc.nextLine());
                break;
            default:
                System.out.println("Enter the right choice");
        }

    }
}