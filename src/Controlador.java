import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Controlador {

    public static List<Empleado> empleadosSegunSalario(List<Empleado> empleados) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        empleados.sort(Comparator.comparing(Empleado::getSalario));

        listaEmpleados.add(empleados.get(0));
        listaEmpleados.add(empleados.get(empleados.size() - 1));
        return listaEmpleados;
    }

    public static List<Empleado> empleadosEdad(List<Empleado> empleados) {
        List<Empleado> empleadosEdadMap = new ArrayList<>();
        empleados.sort(Comparator.comparing(Empleado::getEdad));

        empleadosEdadMap.add(empleados.get(0));
        empleadosEdadMap.add(empleados.get(empleados.size() - 1));

        return empleadosEdadMap;
    }

    public static List<Empleado> listaEmpleadosPorInicial(List<Empleado> empleados, String letra) {
        List<Empleado> listaFiltrada = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (letra.equalsIgnoreCase(String.valueOf(empleado.getApellido().charAt(0))))
                listaFiltrada.add(empleado);
        }

        return listaFiltrada;
    }

    public static List<Empleado> cargarEmpleados() {
        File file = null;
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String[] empleado;
        List<Empleado> listaEmpleados = new ArrayList<>();

        try {
            file = new File("src/empleados.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                empleado = linea.split(",");
                listaEmpleados.add(new Empleado(empleado[0], empleado[1], empleado[2], empleado[3]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (null != fileReader)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listaEmpleados;
    }

}
