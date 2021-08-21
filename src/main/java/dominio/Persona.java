package dominio;

import java.time.LocalDate;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaDeNacimiento;
    private double peso;
    private double altura;

    public static Persona instancia(int id, String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, double peso, double altura) {

        return new Persona(id,nombre,apellido,dni,fechaDeNacimiento,peso,altura);
    }

    private Persona(int id, String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, double peso, double altura) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.peso = peso;
        this.altura = altura;

    }
}
