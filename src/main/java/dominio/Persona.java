package dominio;

import excepciones.ExceptionApellidoVacio;
import excepciones.ExceptionCantidadDeCaracteresDNI;
import excepciones.ExceptionPersona;
import excepciones.ExceptionPersonaNull;

import java.time.LocalDate;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaDeNacimiento;
    private double peso;
    private double altura;

    public static Persona instancia(int id, String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, double peso, double altura) throws ExceptionPersona {
        if(nombre==null)
            throw new ExceptionPersonaNull("nombre null");
        if (apellido.equals(""))
            throw new ExceptionApellidoVacio("apellido vacio");
        String cadena= String.valueOf(dni);
        if (cadena.length()<7)
            throw new ExceptionCantidadDeCaracteresDNI("cantidad de caracteres invalida");
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
