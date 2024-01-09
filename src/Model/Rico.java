
package Model;


public class Rico {
   private int id ;
   private String nombre;
   private int edad;
   private String origen;
   private int fortuna;

    public Rico() {
    }

    public Rico(int id, String nombre, int edad, String origen, int fortuna) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.origen = origen;
        this.fortuna = fortuna;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the fortuna
     */
    public int getFortuna() {
        return fortuna;
    }

    /**
     * @param fortuna the fortuna to set
     */
    public void setFortuna(int fortuna) {
        this.fortuna = fortuna;
    }
   
   
    
}
