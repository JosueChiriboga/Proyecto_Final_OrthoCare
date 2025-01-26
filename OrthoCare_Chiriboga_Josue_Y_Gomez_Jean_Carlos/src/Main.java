/*Universidad De Las Americas
* Estudiante 1: Josue Chiriboga
* Estudiante 2: Jean Carlos Gomez
* Asigantura: Programacion II
* Actividad: Proyecto Final
* Fecha De Entrega: 23/01/2025*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Sala> salas = new ArrayList<Sala>();
        ArrayList<Cita> citas = new ArrayList<Cita>();
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        Scanner scanner = new Scanner(System.in);

        Recepcionista recepcionista = new Recepcionista(1, "Laura", "Gomez");

        System.out.println("----------------------ORTHOCARE----------------------");
        System.out.println("Recepcionista: " + recepcionista.toString());

        Doctor doctorInicial = new Doctor(1, "Carlos", "Martinez");
        doctores.add(doctorInicial);

        Sala salaInicial = new Sala(1, "Sala de Ortodoncia", doctorInicial);
        salas.add(salaInicial);

        int opcion;

        do {
            System.out.println("\n--------------GESTOR DE PACIENTES DE ORTODONCIA--------------");
            System.out.println("1. Registrar Nuevo Paciente");
            System.out.println("2. Mostrar Informacion Del Paciente");
            System.out.println("3. Modificar Informacion Del Paciente");
            System.out.println("4. Modificar Estado De Control De Ortodoncia");
            System.out.println("5. Modificar Fecha De Control");
            System.out.println("6. Modificar Valor A Pagar");
            System.out.println("7. Mostrar Valor Total A Pagar");
            System.out.println("8. Crear nueva cita");
            System.out.println("9. Asignar paciente a sala");
            System.out.println("10. Mostrar salas y pacientes");
            System.out.println("11. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarPaciente(scanner, pacientes);
                    break;
                case 2:
                    mostrarInformacionPaciente(scanner, pacientes, recepcionista);
                    break;
                case 3:
                    modificarInformacionPaciente(scanner, pacientes, recepcionista);
                    break;
                case 4:
                    modificarEstadoControl(scanner, pacientes, recepcionista);
                    break;
                case 5:
                    modificarFechasControl(scanner, pacientes, recepcionista);
                    break;
                case 6:
                    modificarValorPago(scanner, pacientes, recepcionista);
                    break;
                case 7:
                    mostrarValorTotal(scanner, pacientes, recepcionista);
                    break;
                case 8:
                    crearCita(scanner, pacientes, citas, recepcionista);
                    break;
                case 9:
                    asignarPacienteASala(scanner, pacientes, salas, recepcionista);
                    break;
                case 10:
                    mostrarSalasPacientes(salas);
                    break;
                case 11:
                    System.out.println("\nCerrando Sistema OrthoCare....");
                    break;
                default:
                    System.out.println("Opcion Incorrecta. Ingrese nuevamente.");
            }
        } while (opcion != 11);  // Continuar hasta que se elija la opción de salir
    }

    public static void registrarPaciente(Scanner scanner, ArrayList<Paciente> pacientes) {
        System.out.println("\n--------------REGISTRAR NUEVO PACIENTE--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del paciente: ");
        String apellido = scanner.nextLine();

        System.out.print("Fecha Ultimo Control(Dia/Mes/Anio)\n");
        System.out.print("Dia:");
        int diaUltimo = scanner.nextInt();
        System.out.print("Mes:");
        int mesUltimo = scanner.nextInt();
        System.out.print("Anio:");
        int anioUltimo = scanner.nextInt();
        scanner.nextLine();
        Fecha fechaUltimoControl = new Fecha(diaUltimo, mesUltimo, anioUltimo);

        System.out.print("Fecha Proximo Control(Dia/Mes/Anio)\n");
        System.out.print("Dia:");
        int diaProximo = scanner.nextInt();
        System.out.print("Mes:");
        int mesProximo = scanner.nextInt();
        System.out.print("Anio:");
        int anioProximo = scanner.nextInt();
        Fecha fechaProximoControl = new Fecha(diaProximo, mesProximo, anioProximo);
        scanner.nextLine();

        System.out.print("Ingrese el ID del doctor: ");
        int idDoctor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del doctor: ");
        String nombreDoctor = scanner.nextLine();
        System.out.print("Ingrese el apellido del doctor: ");
        String apellidoDoctor = scanner.nextLine();

        Doctor doctor = new Doctor(idDoctor, nombreDoctor, apellidoDoctor);

        System.out.print("Grupo Asignado(G1/G2/G3/G4): ");
        String grupo = scanner.nextLine();

        String asistencia = "Asiste";
        String estadoControl = "Armado";
        double valorControl = 30.0;

        Paciente paciente = new Paciente(id, nombre, apellido, fechaUltimoControl, fechaProximoControl, grupo, doctor, asistencia, estadoControl, valorControl);
        pacientes.add(paciente);

        System.out.println("Paciente Registrado Correctamente");
    }


    public static void mostrarInformacionPaciente(Scanner scanner, ArrayList<Paciente> pacientes, Recepcionista recepcionista) {
        System.out.println("\n--------------MOSTRAR INFORMACION DEL PACIENTE--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int id = scanner.nextInt();

        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == id) {
                System.out.println(paciente.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            //System.out.println("Paciente No Registrado");
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }

        }
    }

    public static void modificarInformacionPaciente(Scanner scanner, ArrayList<Paciente> pacientes, Recepcionista recepcionista) {
        System.out.println("\n--------------MODIFICAR INFORMACION DEL PACIENTE--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == id) {
                System.out.print("Ingrese el nuevo nombre del paciente: ");
                paciente.setNombre(scanner.nextLine());
                System.out.print("Ingrese el nuevo apellido del paciente: ");
                paciente.setApellido(scanner.nextLine());
                System.out.print("Ingrese el nuevo grupo asignado: ");
                paciente.setGrupo(scanner.nextLine());

                System.out.println("Informacion Actualizada");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            //System.out.println("Paciente No Registrado");
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }
        }
    }

    // Modificar el estado del control de ortodoncia
    public static void modificarEstadoControl(Scanner scanner, ArrayList<Paciente> pacientes, Recepcionista recepcionista) {
        System.out.println("\n--------------MODIFICAR ESTADO DE CONTROL DEL PACIENTE--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == id) {
                System.out.print("Ingrese el nuevo estado de control(Armado/En curso/Finalizado): ");
                paciente.setEstadoControl(scanner.nextLine());
                System.out.println("Estado De Control Actualizado");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            //System.out.println("Paciente No Registrado");
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }
        }
    }


    public static void modificarFechasControl(Scanner scanner, ArrayList<Paciente> pacientes, Recepcionista recepcionista) {
        System.out.println("\n--------------MODIFICAR FECHAS DE CONTROL DEL PACIENTE--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int id = scanner.nextInt();

        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == id) {
                scanner.nextLine();
                System.out.print("Nueva Fecha Ultimo Control(Dia/Mes/Anio)\n");
                System.out.print("Dia:");
                int dia = scanner.nextInt();
                System.out.print("Mes:");
                int mes = scanner.nextInt();
                System.out.print("Anio:");
                int anio = scanner.nextInt();
                paciente.setFechaUltimoControl(new Fecha(dia, mes, anio));

                System.out.print("Nueva Fecha Proximo Control(Dia/Mes/Anio)\n");
                System.out.print("Dia:");
                dia = scanner.nextInt();
                System.out.print("Mes:");
                mes = scanner.nextInt();
                System.out.print("Anio:");
                anio = scanner.nextInt();
                paciente.setFechaProximoControl(new Fecha(dia, mes, anio));

                System.out.println("Fechas Actualizadas");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            //System.out.println("Paciente No Registrado");
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }
        }
    }


    public static void modificarValorPago(Scanner scanner, ArrayList<Paciente> pacientes, Recepcionista recepcionista) {
        System.out.println("\n--------------MODIFICAR VALOR DE CONTROL DEL PACIENTE--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int id = scanner.nextInt();

        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == id) {
                System.out.print("Ingrese el nuevo valor que el paciente debe pagar: ");
                double valor = scanner.nextDouble();
                paciente.setValorControl(valor);
                System.out.println("Nuevo Valor De Pago Registrado.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            //System.out.println("Paciente No Registrado");
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }
        }
    }

    // Mostrar el valor total a pagar del paciente
    public static void mostrarValorTotal(Scanner scanner, ArrayList<Paciente> pacientes, Recepcionista recepcionista) {
        System.out.println("\n--------------MOSTRAR VALOR TOTAL A PAGAR--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int id = scanner.nextInt();

        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == id) {
                System.out.println("El valor total a pagar es: " + paciente.getValorControl());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            //System.out.println("Paciente No Registrado");
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }
        }
    }

    public static void crearCita(Scanner scanner, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, Recepcionista recepcionista) {
        System.out.println("\n--------------REGISTRAR CITA DEL PACIENTE--------------");
        System.out.print("Ingrese el ID del paciente para la cita: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        Paciente pacienteSeleccionado = null;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == id) {
                pacienteSeleccionado = paciente;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {

            System.out.print("Ingrese el ID del doctor: ");
            int idDoctor = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese el nombre del doctor: ");
            String nombreDoctor = scanner.nextLine();
            System.out.print("Ingrese el apellido del doctor: ");
            String apellidoDoctor = scanner.nextLine();

            Doctor doctor = new Doctor(idDoctor, nombreDoctor, apellidoDoctor);

            System.out.print("Fecha De La Cita(Dia/Mes/Anio)\n");
            System.out.print("Dia:");
            int dia = scanner.nextInt();
            System.out.print("Mes:");
            int mes = scanner.nextInt();
            System.out.print("Anio:");
            int anio = scanner.nextInt();
            Fecha fechaCita = new Fecha(dia, mes, anio);

            Cita cita = new Cita(pacienteSeleccionado, doctor, fechaCita, recepcionista);
            citas.add(cita);
            System.out.println("Cita Registrada");
        } else {
            //System.out.println("Paciente No Registrado");
            try {
                recepcionista.cita();
            } catch (NoCitaRegistradaException e) {
                System.out.println(e);
            }
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }
        }
    }

    public static void asignarPacienteASala(Scanner scanner, ArrayList<Paciente> pacientes, ArrayList<Sala> salas, Recepcionista recepcionista) {
        System.out.println("\n--------------ASIGNAR PACIENTE A CONSULTORIO--------------");
        System.out.print("Ingrese el ID del paciente: ");
        int idPaciente = scanner.nextInt();

        boolean encontrado = false;
        Paciente pacienteSeleccionado = null;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == idPaciente) {
                pacienteSeleccionado = paciente;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.print("Ingrese el numero de consultorio: ");
            int idSala = scanner.nextInt();
            scanner.nextLine();
            boolean salaEncontrada = false;
            Sala salaSeleccionada = null;

            for (Sala sala : salas) {
                if (sala.getIdSala() == idSala) {
                    salaSeleccionada = sala;
                    salaEncontrada = true;
                    break;
                }
            }

            if (salaEncontrada) {
                salaSeleccionada.agregarPaciente(pacienteSeleccionado);
                System.out.println("Paciente asignado a la sala exitosamente");
            } else {
                System.out.println("Sala No Encontrada.");
            }
        } else {
            //System.out.println("Paciente No Registrado.");
            try {
                recepcionista.paciente();
            } catch (NoPacienteRegistradoException e) {
                System.out.println(e);
            }
        }
    }

    public static void mostrarSalasPacientes(ArrayList<Sala> salas) {
        for (Sala sala : salas) {
            System.out.println(sala.toString());
        }
    }
}
