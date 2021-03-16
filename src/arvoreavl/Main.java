package arvoreavl;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaDePesquisa a = new ArvoreBinariaDePesquisa();
        BinaryTreePrinter<No> p = new BinaryTreePrinter<>(a);

        a.inserir(10);
        a.inserir(5);
        a.inserir(15);
        a.inserir(17);
        a.inserir(16);
//        a.inserir(6);
//        a.inserir(7);
//        a.inserir(15);
//        a.inserir(14);
//        a.inserir(13);
//        a.inserir(12);
//        a.inserir(11);
        

        p.imprimir(System.out);

        System.out.println("\n\n================== DELETANDO ==================\n");

//        a.deletar(1);
//        a.deletar(13);
//        a.deletar(15);
//        a.deletar(7);
//        a.deletar(14);
//        a.deletar(12);
//        a.deletar(6);
//       a.deletar(4);
//       a.deletar(5);
//       a.deletar(3);
//       a.deletar(11);
//       a.deletar(2);
////       a.deletar(2);
//        p.imprimir(System.out);
    }
}
