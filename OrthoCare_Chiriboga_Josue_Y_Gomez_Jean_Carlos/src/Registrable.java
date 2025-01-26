public interface Registrable {

        public abstract void cita() throws NoCitaRegistradaException;
        public abstract void paciente() throws NoPacienteRegistradoException;

}
