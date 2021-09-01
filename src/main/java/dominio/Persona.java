package dominio;

import excepciones.*;

import java.time.LocalDate;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaDeNacimiento;
    private double peso;
    private double altura;

    public static Persona instancia(int id, String nombre, String apellido, String dni, LocalDate fechaDeNacimiento, double peso, double altura) throws ExceptionPersona {
        if(nombre==null || nombre.isEmpty())
            throw new ExceptionPersonaNull("Nombre es obligatorio");
        if (apellido.equals(""))
            throw new ExceptionApellidoVacio("apellido vacio");
        if (dni.length()<7 || dni.length()>10)
            throw new ExceptionCantidadDeCaracteresDNI("cantidad de caracteres invalida");
        if (peso<0)
            throw new ExceptionPesoInvalido("valor invalido");
        return new Persona(id,nombre,apellido,dni,fechaDeNacimiento,peso,altura);
    }

    private Persona(int id, String nombre, String apellido, String dni, LocalDate fechaDeNacimiento, double peso, double altura) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.peso = peso;
        this.altura = altura;

    }

}
