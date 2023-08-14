/*
 * Universidad del Valle de Guatemala
 * Gadiel Amir Ocaña Veliz
 * Programacion Orientada a Objetos
 * 13/08/23
 */
class Usuario{
    //Definicion de los atributos
    private String nombre;
    private String email;
    private float presupuestoU;

    //Constructor para modificar los atributos
    public Usuario(String nombre, String email, float presupuestoU){
        this.nombre = nombre;
        this.email = email;
        this.presupuestoU = presupuestoU;
    }
//Gets y setts de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPresupuestoU() {
        return presupuestoU;
    }

    public void setPresupuestoU(float presupuestoU) {
        this.presupuestoU = presupuestoU;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", email=" + email + ", presupuestoU=" + presupuestoU + "]";
    }
    

}
