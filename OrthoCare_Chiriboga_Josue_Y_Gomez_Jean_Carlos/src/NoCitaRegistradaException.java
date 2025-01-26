public class NoCitaRegistradaException extends Exception {

    @Override
    public String toString() {
        return "ATENCION: La cita del paciente no fue registrada";
    }

}
