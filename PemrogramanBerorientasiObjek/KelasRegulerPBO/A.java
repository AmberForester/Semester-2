package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class A {
    private int y = 20;
    int x = 12;
    class B{
        // static int x = 10;
        int x = 10;
        void methodPadaB(){
            System.out.println("Saya adalah method kelas B");
            System.out.println("Kelas B berada dalam kelas A");
            System.out.println("y = " + y);
            System.out.println("x = " + this.x);
            System.out.println("x = " + A.this.x);
        }
    }
    void methodPadaA(){
        B b = new B();
        System.out.println("Saya adalah method A");
        System.out.println("Saya membuat objek dari inner class B");
        b.methodPadaB();
    }   
}
