package testDominio;

import dominio.Persona;
import excepciones.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPersona {
    @Order(1)
    @Test
    public void generarObjetoPersona() throws ExceptionPersona {
        Persona p1= Persona.instancia(1,"Gerbacio","Ayala","16320654", LocalDate.of(1966,12,02),60.0,1.80);
        assertNotNull(p1);
    }
    @Order(2)
    @Test
    public void generarObjetoPersona_faltaNombre_ExceptionPersonaIncompleta(){
        Exception nombreNulo=assertThrows(ExceptionPersonaNull.class,()->{Persona p1= Persona.instancia(1,null,"Ayala","16320654", LocalDate.of(1966,12,02),60,1.80);});
        Exception nombreVacio=assertThrows(ExceptionPersonaNull.class,()->{Persona p1= Persona.instancia(1,"","Ayala","16320654", LocalDate.of(1966,12,02),60,1.80);});
        assertEquals("Nombre es obligatorio",nombreNulo.getMessage());
        assertEquals("Nombre es obligatorio",nombreVacio.getMessage());


    }
    @Order(3)
    @Test
    public void generarObjetoPersona_fallo_apellidoVacio(){
        assertThrows(ExceptionApellidoVacio.class,()->{Persona p1= Persona.instancia(1,"Jacinto","","16320654", LocalDate.of(1966,12,02),60,1.80);});

    }
    @Order(4)
    @Test
    public void generarObjetoPersona_fallo_cantidadDeCaracteresDNI(){
        assertThrows(ExceptionCantidadDeCaracteresDNI.class,()->{Persona p1= Persona.instancia(1,"Diego","Milito","1632", LocalDate.of(1966,12,02),60,1.80);});
        assertThrows(ExceptionCantidadDeCaracteresDNI.class,()->{Persona p1= Persona.instancia(1,"Diego","Milito","1632123123123123", LocalDate.of(1966,12,02),60,1.80);});

    }
    @Order(5)
    @Test
    public void generarObjetoPersona_fallo_pesoInvalido(){
        assertThrows(ExceptionPesoInvalido.class,()->{Persona p1= Persona.instancia(1,"Diego","Milito","14122014", LocalDate.of(1966,12,02),-5,1.80);});

    }
}
