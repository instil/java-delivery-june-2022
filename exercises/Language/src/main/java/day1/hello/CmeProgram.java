package day1.hello;

class Wibble {
    void wobble() {}
}

//Program - Simple Name
//day1.hello.Program - Fully Qualified Name
public class CmeProgram {
    public static void main(String[] args) {
        //class Class {}
        System.out.println(CmeProgram.class.getName());
        System.out.println(CmeProgram.class.getSimpleName());
        System.out.println(CmeProgram.class.getSuperclass().getName());
        System.out.println("Hello CME");

        Wibble w = new Wibble();
        System.out.println(w.toString());
        System.out.println(w);

        Object obj = w;
        System.out.println(obj);
    }
}
