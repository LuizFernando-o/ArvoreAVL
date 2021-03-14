package arvoreavl;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaDePesquisa a = new ArvoreBinariaDePesquisa();
        a.inserir(5);
        a.inserir(3);
        a.inserir(4);
        a.inserir(2);
        a.inserir(1);
        a.inserir(8);
        a.inserir(7);
        a.inserir(6);
        a.inserir(10);
        a.inserir(9);
        a.inserir(11);
        
        
        BinaryTreePrinter<No> p = new BinaryTreePrinter<No>(a);
        p.imprimir(System.out);
    }
}
