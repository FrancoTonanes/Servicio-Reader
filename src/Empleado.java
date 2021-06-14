import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Data
public class Empleado {

    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private Double salario;

    public Empleado(String nombre, String apellido, String nacimiento, String salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = LocalDate.parse(nacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.salario = Double.parseDouble(salario);
    }
    public void setNacimiento(String nacimiento) {
        this.nacimiento = LocalDate.parse(nacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    public int getEdad() {
        Period diferencia = Period.between(this.nacimiento, LocalDate.now());
        return diferencia.getYears();
    }
}
