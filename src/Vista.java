import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Vista {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = Controlador.cargarEmpleados();
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese un número del menú");
            System.out.println("1 - Buscar por una inicial del apellido");
            System.out.println("2 - Empleado con menor y mayor de edad");
            System.out.println("3 - Empleado con menor y mayor salario");
            System.out.println("0 - Salir");
            String ingreso = input.nextLine();

            if(ingreso.equals("1")){
                System.out.println("Ingrese una letra inicial del apellido: ");
                String letra = input.next();
                if(letra.length() > 1){
                    System.out.println("Solo debe ingresar la inicial\n");
                    continue;
                }
                List<Empleado> empleadosFiltrados = Controlador.listaEmpleadosPorInicial(listaEmpleados, letra);
                if (empleadosFiltrados.isEmpty()){
                    System.out.println("--------- No se encontraron resultados ----------\n");
                }
                else {
                    for (Empleado e : empleadosFiltrados) {
                        System.out.println(e + "\n");
                    }
                }

            }
            else if (ingreso.equals("2")){
                List<Empleado> empleadosXEdad = Controlador.empleadosEdad(listaEmpleados);
                System.out.println("------ Empleados ------\n");
                for (Empleado e : empleadosXEdad){
                    String nombre = String.format(
                            "Nombre: %s %s - Edad: %s", e.getNombre(), e.getApellido(), e.getEdad());
                    System.out.println(nombre + "\n");

                }


            }
            else if (ingreso.equals("3")){
                List<Empleado> empleadosXSalario = Controlador.empleadosSegunSalario(listaEmpleados);

                System.out.println("------ Empleados ------\n");
                for (Empleado e : empleadosXSalario){
                    String nombre = String.format(
                            "Nombre: %s %s - Salario: %s", e.getNombre(), e.getApellido(), e.getSalario());
                    System.out.println(nombre + "\n");

                }

            }
            else if (ingreso.equals("0")){
                System.out.println("----Muchas Gracias----");
                break;
            }
            else {
                System.out.println("Opción no válida\n");
            }
        }
    }
}
