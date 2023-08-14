import java.util.Random;

class Localidad{

    private int numLocalidad;
    private float precioBoleto;
    private int espacios;
    
    public int getNumLocalidad() {
        return numLocalidad;
    }

    public void setNumLocalidad(int numLocalidad) {
        this.numLocalidad = numLocalidad;
    }

    public float getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(float precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public int getEspacios() {
        return espacios;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
    }

    public Localidad(int numLocalidad, float precioBoleto, int espacios) {
        this.numLocalidad = numLocalidad;
        this.precioBoleto = precioBoleto;
        this.espacios = espacios;
    }
    
}