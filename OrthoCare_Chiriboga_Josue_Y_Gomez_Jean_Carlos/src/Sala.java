import java.util.ArrayList;
import java.util.List;

public class Sala {

    private int numeroSala;
    private String nombreSala;
    private Doctor doctorAsignado;
    private List<Paciente> pacientes;

    public Sala(int numeroSala, String nombreSala, Doctor doctorAsignado) {
        this.numeroSala = numeroSala;
        this.nombreSala = nombreSala;
        this.doctorAsignado = doctorAsignado;
        this.pacientes = new ArrayList<Paciente>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public int getIdSala() {
        return numeroSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    @Override
    public String toString() {
        return  "Sala: " + nombreSala + '\n' +
                "Numero: " + numeroSala + '\n' +
                "Doctor: " + doctorAsignado.getNombreDoctor() + " " + doctorAsignado.getApellidoDoctor() + '\n' +
                "Pacientes en la sala: " + pacientes.size();
    }
}
