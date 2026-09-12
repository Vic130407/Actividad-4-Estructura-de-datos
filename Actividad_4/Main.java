
public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.insertar(58);
        arbol.insertar(54);
        arbol.insertar(20);
        arbol.insertar(86);
        arbol.insertar(45);
        arbol.insertar(37);
        arbol.insertar(67);
        arbol.insertar(33);
        arbol.insertar(47);
        arbol.insertar(55);
        arbol.insertar(100);
        arbol.insertar(44);
        arbol.insertar(29);
        arbol.insertar(2);
        arbol.insertar(11);
        arbol.insertar(89);
        arbol.insertar(39);
        arbol.insertar(69);
        arbol.insertar(15);
        arbol.insertar(48);
        arbol.insertar(97);
        arbol.insertar(75);
        System.out.println("Inorden:\n" + arbol.inorden());
        System.out.println("Preorden:\n" + arbol.preorden());
        System.out.println("Postorden:\n" + arbol.postorden());
        System.out.println("Buscar 100: " + arbol.buscar(100));
        System.out.println("Buscar 101: " + arbol.buscar(101));
        System.out.println("Clase del nodo 100: " + arbol.claseNodo(100));
        System.out.println("Clase del nodo 101: " + arbol.claseNodo(101));
        System.out.println("Eliminar 15: " + arbol.eliminar(15));
        System.out.println("Eliminar 2: " + arbol.eliminar(2));
        System.out.println("Eliminar 54: " + arbol.eliminar(54));
        System.out.println("Eliminar 58: " + arbol.eliminar(58));
        System.out.println("Inorden:\n" + arbol.preorden());
    }
}