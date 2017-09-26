
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
*
* @author Daniel Yepes
* 
* Esta es una prueba parametrizada para evaluar los metodos de 
* la clase ImpresorLCD
* 
*/
@RunWith(value = Parameterized.class)
public class ImpresorLCDTest {
    
    private String cadena;
    private boolean esperado;
    
    //inicializamos las variables
    public ImpresorLCDTest(String cadena, boolean esperado) {
        this.cadena = cadena;
        this.esperado = esperado;
    }
    
    /**
    * 
    * @return los parametros necesarios para la ejecucion de los Test
    * 
    */
    @Parameters
    public static Iterable<Object[]> Datos(){
        
        return Arrays.asList(
                new Object[][]{
                    {"222",true},
                    {"cad",false},
                    {"2sdd12",false},
                    {"123",true},
                    {"2,32",false},
                    {",",false},
                    {"0",true}
                }
        );
        
    }
            
    /**
    * Test para validar el metodo IsNumeric
    *
    */
    @Test
    public void testIsNumeric() {
        
        ImpresorLCD impresorLCD = new ImpresorLCD();
        
        boolean result = impresorLCD.isNumeric(cadena);
        assertEquals(esperado, result);
    }
    
}
