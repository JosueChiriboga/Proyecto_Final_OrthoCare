public class Cita {

    private Paciente paciente;
    private Doctor doctor;
    private Fecha fechaCita;
    private Recepcionista recepcionista;

    public Cita(Paciente paciente, Doctor doctor, Fecha fechaCita, Recepcionista recepcionista) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaCita = fechaCita;
        this.recepcionista = recepcionista;
    }

    // Getters
    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Fecha getFechaCita() {
        return fechaCita;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    @Override
    public String toString() {
        return "Cita programada para el paciente: " + paciente.getNombre() + " " + paciente.getApellido() +
                "\nDoctor: " + doctor.getNombreDoctor() + " " + doctor.getApellidoDoctor() +
                "\nFecha de Cita: " + fechaCita.toString() +
                "\nRecepcionista Encargado: " + recepcionista.getNombre() + " " + recepcionista.getApellido();
    }
}
