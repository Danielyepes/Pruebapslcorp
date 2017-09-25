package pruebapsl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel Yepes
 */

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();        
        
        ImpresorLCD impresorLCD = new ImpresorLCD();
        
        String comando;
        int espacioDig;
        
        try
        {
            try (Scanner lector = new Scanner(System.in))
            {
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un numero
                if (ValidateRange.CheckIsNumeric(comando)) 
                {
                    espacioDig = Integer.parseInt(comando);
                    
                    //valida si el espacio ingresado es correcto
                    ValidateRange.CheckEspacioDig(espacioDig);
                
                }
                else 
                {
                    throw new IllegalArgumentException("Cadena " + comando
                            + " no es un entero");
                }
                
                do
                {
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                        listaComando.add(comando);
                    }
                    
                }while (!comando.equalsIgnoreCase(CADENA_FINAL));
            }

            Iterator<String> iterator = listaComando.iterator();
            
            while (iterator.hasNext()) 
            {
                try
                {
                    impresorLCD.ProcessEntry(iterator.next(), espacioDig);
                }
                catch (Exception ex)
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
        catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }

}
