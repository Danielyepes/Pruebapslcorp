package pruebapsl;

/**
 *
 * @author Danie
 * 
 * En esta clase encontraremos los metodos para validar los rangos
 * 
 */
public class ValidateRange {

    /**
    *
    * Metodo encargado de validar el tamaño de la matriz
    * 
    * @param sizeImp tamaño de la matriz
    * 
    */ 
    public static void CheckSizeImp(int sizeImp) {
        // se valida que el size este entre 1 y 10
        if (sizeImp < 1 || sizeImp > 10) {
            throw new IllegalArgumentException("El parametro size [" + sizeImp
                    + "] debe estar entre 1 y 10");
        }
    }
    
      /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     * @return true if es un numero y false si no lo es
     */
    public static boolean CheckIsNumeric(String cadena) {
        try 
        {
            Integer.parseInt(cadena);
            return true;
        } 
        catch (NumberFormatException ex) 
        {
            return false;
        }
    }
    
    /**
     *
     * Metodo encargado de el espacio de los numeros está en el rango correcto
     *
     * @param espacioDig Espacio entre numeros
     */
    public static void CheckEspacioDig(int espacioDig) {
        // se valida que el espaciado este entre 0 y 5
        if(espacioDig <0 || espacioDig >5)
        {
            throw new IllegalArgumentException("El espacio entre "
                    + "digitos debe estar entre 0 y 5");
        }
    }


}
