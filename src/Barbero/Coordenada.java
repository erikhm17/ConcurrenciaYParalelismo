package Barbero;

/**
 * Created by hammer on 29/01/17.
 */
public class Coordenada {
    private int x;
    private int y;
    private boolean ocupado;
    public Coordenada(int x, int y,boolean ocupado) {
        this.x = x;
        this.y = y;
        this.ocupado = ocupado;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
