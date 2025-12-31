public class OOPS{

    public static void main(String[] args) {
        //Pen p1=new Pen(); //created a pen object called p1
        // Pen p2=new Pen("Reynolds");
        // Pen p3=new Pen(2);
        // p1.setColor("Blue");
        // System.out.println(p1.color);
        // p1.tip=7;
        // System.out.println(p1.tip);
        
        // BankAccount myAcct=new BankAccount(); //new account object created as myAcct

        // myAcct.username="Sriya";
        // myAcct.setPassword("abcd");

        // System.out.println(myAcct.username);
        // // System.out.println(myAcct.password);//not accessible outside the BankAccount class as password is private
        // System.out.println(myAcct.getPwd());//it is accessible through getters
    
        // Student s1=new Student("Geethika");
        // System.out.println(s1.name);

        // Pen p2= new Pen(p1);
        // p2.tip=8;
        
        Fish shark=new Fish();//since this is child class uses cild class funtcton eats
        shark.eat();
    }
    
}

//Base Class
class Animal{
    String color;

    void eat(){
        System.out.println("eats food");
    }

    void breathe(){
        System.out.println("breathes");
    }
}

//Derived class

class Fish extends Animal{
    int fins;

    void eat(){
       System.out.println("eats plantae"); 
    }
}




































class Student{
    String name;
    int roll;

    Student(String name){
        this.name=name;
    }
}

class Pen{
    //properties
    String color;
    int tip;

    Pen(Pen p1){
        this.color=p1.color;
        this.tip=p1.tip;
    }

    // Non Parameterized Constructor
    Pen(){
        System.out.println("Constructor is called! ");
    }

    //parameterixe constructor
    Pen(String color){
        this.color=color;
    }

    Pen(int tip){
        this.tip=tip;
    }

    //functions 

    //getters
    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }

    //setters
    void setColor(String newColor){
        color=newColor;
    }

    void setTip(int newTip){
        tip=newTip;
    }
}

class BankAccount{
    public String username;
    private String password;

    void setPassword(String pwd){
        this.password=pwd; //possible within the class as password is private to class
    }

    String getPwd(){
        return this.password;
    }
}