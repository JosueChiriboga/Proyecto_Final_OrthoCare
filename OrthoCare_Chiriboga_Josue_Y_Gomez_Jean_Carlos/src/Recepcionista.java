public class Recepcionista implements Registrable {

    private int idRecepcionista;
    private String nombre;
    private String apellido;

    public Recepcionista(int idRecepcionista, String nombre, String apellido) {
        this.idRecepcionista = idRecepcionista;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public void cita() throws NoCitaRegistradaException {
        // Simulación de condición para lanzar la excepción
        boolean citaRegistrada = false; // Cambia este valor según la lógica
        if (!citaRegistrada) {
            throw new NoCitaRegistradaException();
        }
        System.out.println("La cita fue registrada con éxito.");
    }

    @Override
    public void paciente() throws NoPacienteRegistradoException {
        // Simulación de condición para lanzar la excepción
        boolean pacienteRegistrado = false; // Cambia este valor según la lógica
        if (!pacienteRegistrado) {
            throw new NoPacienteRegistradoException();
        }
        System.out.println("El paciente fue registrado con éxito.");
    }

    // Getters
    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return idRecepcionista + " " + nombre + " " + apellido;
    }
}
