package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class A2 {
    void methodDiA2(){
        class B2{
            int i = 0;
            void methodDiB2(){
                System.out.println("i = " + i);
            }
        }
        B2 b2 = new B2();
        b2.methodDiB2();
    }
}
