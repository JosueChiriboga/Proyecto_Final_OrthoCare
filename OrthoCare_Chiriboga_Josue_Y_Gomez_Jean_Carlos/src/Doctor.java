public class Doctor {

    private int idDoctor;
    private String nombreDoctor;
    private String apellidoDoctor;

    public Doctor(int idDoctor, String nombreDoctor, String apellidoDoctor) {
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.apellidoDoctor = apellidoDoctor;
    }

    // Getters
    public int getIdDoctor() {
        return idDoctor;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public String getApellidoDoctor() {
        return apellidoDoctor;
    }

    // Setters
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public void setApellidoDoctor(String apellidoDoctor) {
        this.apellidoDoctor = apellidoDoctor;
    }

    @Override
    public String toString() {
        return  this.idDoctor + " " + this.nombreDoctor + " " + this.apellidoDoctor;
    }
}
