package EnterosConjunto;

/**
 * Created by hammer on 15/01/17.
 */
public class MyMap {
    private int clave;
    private int valor;
    private int indice;

    public MyMap(int clave, int valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
