package testDominio;

import dominio.Persona;
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
    public void generarObjetoPersona(){
        Persona p1= Persona.instancia(1,"Gerbacio","Ayala",16320654, LocalDate.of(1966,12,02),60,1.80);
        assertNotNull(p1);
    }
}
