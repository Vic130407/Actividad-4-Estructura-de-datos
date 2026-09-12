public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // ===== FASE 1: INSERCIÓN =====
    public void insertar(int d) {
        raiz = insertarRec(raiz, d);
    }

    private Nodo insertarRec(Nodo n, int d) {
        if(n == null){
            return new Nodo(d);
        }
        if(d < n.getDato()){
            n.setIzq(insertarRec(n.getIzq(), d));
        }
        else if(d > n.getDato()){
            n.setDer(insertarRec(n.getDer(), d));
        }
        return n;
    }

      // ===== FASE 2: RECORRIDOS =====
    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void inordenRec(Nodo n, StringBuilder sb) {
        if (n == null) {
        return;
        }
        inordenRec(n.getIzq(), sb);
        sb.append(n.getDato()).append(",");
        inordenRec(n.getDer(), sb);
    }


    public String preorden() {
        StringBuilder sb = new StringBuilder();
        preordenRec(raiz, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void preordenRec(Nodo n, StringBuilder sb) {
        if(n == null){
            return;
        }
        sb.append(n.getDato()).append(",");
        preordenRec(n.getIzq(), sb);
        preordenRec(n.getDer(), sb);
    }

    public String postorden() {
        StringBuilder sb = new StringBuilder();
        postordenRec(raiz, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void postordenRec(Nodo n, StringBuilder sb) {
        if(n == null){
            return;
        }
        postordenRec(n.getIzq(), sb);
        postordenRec(n.getDer(), sb);
        sb.append(n.getDato()).append(",");
    }
    // ===== FASE 3: BÚSQUEDA =====
    public boolean buscar(int d) {
        return buscarRec(raiz, d);
    }

    private boolean buscarRec(Nodo n, int d) {
        if(n == null){
            return false;
        }
        if(d < n.getDato()){
            return buscarRec(n.getIzq(), d);
        }
        else if(d > n.getDato()){
            return buscarRec(n.getDer(), d);
        }
        return true;
    }

    public String claseNodo(int d) {
        if (buscarNodo(raiz, d) == null) {
            return "NO_EXISTE";
        }
        if (raiz == buscarNodo(raiz, d)) {
            return "RAIZ";
        }
        if (buscarNodo(raiz, d).getIzq() == null && buscarNodo(raiz, d).getDer() == null) {
            return "HOJA";
        }
        if (buscarNodo(raiz, d).getIzq() != null && buscarNodo(raiz, d).getDer() != null) {
            return "DOS_HIJOS";
        }
        return "UN_HIJO";
    }

    private Nodo buscarNodo(Nodo n, int d) {
        if(n.getDato() == d){
            return n;
        }
        if(d < n.getDato() && n.getIzq() != null){
            return buscarNodo(n.getIzq(), d);
        }
        if(d > n.getDato() && n.getDer() != null){
            return buscarNodo(n.getDer(), d);
        }
        return null;
    }

    // ===== FASE 4: ELIMINACIÓN =====
    public boolean eliminar(int d) {
        // TODO: elimina el valor d del árbol si existe.
        // Devuelve true si lo encontró y eliminó, false si no existía.
        // Uso: raiz = eliminarRec(raiz, d); return encontrado(o false).
        if(buscar(d)){
            raiz = eliminarRec(raiz, d);
            return true;
        }
        return false;
    }

    private Nodo eliminarRec(Nodo n, int d) {
        // TODO: los 3 casos:
        //   - HOJA: devuelve null.
        //   - UN hijo: devuelve ese hijo.
        //   - DOS hijos: reemplaza por el mínimo del subárbol derecho
        //     (sucesor inorden) y elimina ese sucesor.
        if(n == null){
            return null;
        }

        if(d < n.getDato()){
            n.setIzq(eliminarRec(n.getIzq(), d));
        } else if(d > n.getDato()){
            n.setDer(eliminarRec(n.getDer(), d));
        } else {
            if(n.getIzq() == null && n.getDer() == null){
            return null;
            }
            if(n.getIzq() == null){
            return n.getDer(); 
            }
            if(n.getDer() == null){
            return n.getIzq(); 
            }

            Nodo heir = minimo(n.getDer());
            n.setDato(heir.getDato());
            n.setDer(eliminarRec(n.getDer(), heir.getDato()));
        }
        return n;
    }

    private Nodo minimo(Nodo n) {
        // TODO: devuelve el nodo con el valor más pequeño del subárbol.
        while(n.getIzq() != null){
            n = n.getIzq();
        }
        return n;
    }
}