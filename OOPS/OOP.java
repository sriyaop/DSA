public class OOP{
    public static void main(String[] args) {
        // Animal a=new Animal();
        // Horse h=new Horse();
        // h.walk();
        // h.eat();
        // h.changeColor();
        // System.out.println(h.color);

        // System.out.println();

        // Chicken c=new Chicken();
        // c.walk();
        // c.eat();
        // System.out.println(c.color);

        // Queen q=new Queen();
        // q.moves();
        Student s1=new Student();
        s1.schoolName="MVM";

        Student s2=new Student();
        System.out.println(s2.schoolName);//even though we dod not assign since it is static used for every thing without being changed


    }
}

class Student{
   String name;
   int roll;
   
   static String schoolName;

   void setName(String name){
    this.name=name;
   }

   String getName(){
    return this.name;
   }
}

abstract class Animal{
    String color;

    Animal(){
        color="brown";
    }

    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();
}

class Horse extends Animal{
    void changeColor(){
        color="dark brown";
    }

    void walk(){
        System.out.println("walks on 4 legs");
    }
}

class Chicken extends Animal{
    void changeColor(){
        color="yellow";
    }

    void walk(){
        System.out.println("walks on 2 legs");
    }
}

interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("All directions");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("straight");
    }
}
class Pawn implements ChessPlayer{
    public void moves(){
        System.out.println("1/ 2 steps ahead");
    }
} 