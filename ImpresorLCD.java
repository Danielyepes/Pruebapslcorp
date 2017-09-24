

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
*
* @author Daniel Yepes
*/

public class ImpresorLCD {

    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    private String[][] matrizImpr;

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    // TODO code application logic here
    //String entrada = JOptionPane.showInputDialog("Digite el numero");
    private int size;

    // Calcula el numero de filasDig
    private int filasDig;
    private int columDig;
    private int totalFilas;
    private int totalColum;

    public ImpresorLCD() {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }

    /**
    *
    * Metodo encargado de añadir una linea a la matriz de Impresion
    *
    * @param matriz Matriz Impresion
    * @param punto Punto Pivote
    * @param posFija Posicion Fija
    * @param size Tamaño Segmento
    * @param caracter Caracter Segmento
    */
    private void adicionarLinea(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {

        if (posFija.equalsIgnoreCase(POSICION_X)) {
            
            AddLineInX(size, punto, matriz, caracter);
        }
        else
        {
            AddLineInY(size, punto, matriz, caracter);
        }
    }

    /**
    * 
    * Metodo encargado de añadir lineas en Y
    * 
    * @param matriz Matriz Impresion
    * @param punto Punto Pivote
    * @param size Tamaño Segmento
    * @param caracter Caracter Segmento
    * @return 
    */
    private String[][] AddLineInY(int size, int[] punto, String[][] matriz, String caracter) {
        
        for (int i = 1; i <= size; i++) {
            int valor = punto[0] + i;
            matriz[valor][punto[1]] = caracter;
        }
        return matriz;
    }
    
    /**
    * 
    * Metodo encargado de añadir lineas en X
    * 
    * @param matriz Matriz Impresion
    * @param punto Punto Pivote
    * @param size Tamaño Segmento
    * @param caracter Caracter Segmento
    * @return 
    */
    private String[][] AddLineInX(int size, int[] punto, String[][] matriz, String caracter) {
        for (int y = 1; y <= size; y++) {
            int valor = punto[1] + y;
            matriz[punto[0]][valor] = caracter;
        }
        return matriz;
    }

    /**
    *
    * Metodo encargado de adicionar un segmento a la matriz de Impresion
    *
    * @param segmento Segmento a adicionar
    */
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizImpr, this.pf3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
    *
    * Metodo encargado de definir los segmentos que componen un digito y a
    * partir de los segmentos adicionar la representacion del digito a la
    * matriz
    *
    * @param numero Digito
    */
    private void adicionarDigito(int numero) {

        // Establece los segmentos de cada numero
        List<Integer> segList = new ArrayList<>();

        switch (numero) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = segList.iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
    }

    /**
    *
    * Metodo encargado de imprimir un numero
    *
    * @param size Tamaño Segmento Digitos
    * @param numeroImp Numero a Imprimir
    * @param espacio Espacio Entre digitos
    */
    private void imprimirNumero(int size, String numeroImp, int espacio) {
        int pivotX = 0;
        char[] digitos;

        this.size = size;

        // Calcula el numero de filas cada digito
        this.filasDig = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        this.columDig = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDig;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (this.columDig * numeroImp.length())
                + (espacio * numeroImp.length());

        // crea matriz para almacenar los numero a imprimir
        this.matrizImpr = new String[this.totalFilas][this.totalColum];

        // crea el arreglo de digitos
        digitos = numeroImp.toCharArray();

        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }

        for (char digito : digitos) {

            //valida si es un digito
            CheckIsDigit(digito);

            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (this.filasDig / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (this.filasDig - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (this.columDig - 1);
            this.pf4[1] = (this.filasDig / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (this.columDig - 1) + pivotX;

            pivotX = pivotX + this.columDig + espacio;
            
            adicionarDigito(numero);
        }

            ImprimeMatriz();
    }

    private void ImprimeMatriz() {
        // Imprime matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }

    /**
    * Metodo encargado de  validar si es un digito y
    * lanza una excepcion si el numero no es un digito
    * @param digito numero
    */
    private void CheckIsDigit(char digito) throws IllegalArgumentException {
        //Valida que el caracter sea un digito
        
        if (!Character.isDigit(digito)) {
            throw new IllegalArgumentException("Caracter " + digito
                    + " no es un digito");
        }
    }

    /**
    *
    * Metodo encargado de procesar la entrada que contiene el size del segmento
    * de los digitos y los digitos a imprimir
    *
    * @param comando Entrada que contiene el size del segmento de los digito y
    * el numero a imprimir
    * @param espacioDig Espacio Entre digitos
    */
    public void procesar(String comando, int espacioDig) {

        String[] parametros;
        
        int sizeImp;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }

        //Se hace el split de la cadena
        parametros = comando.split(",");

        //Valida que el parametro este en el rango correcto
        CheckParametersIsValid(parametros.length,comando);

            //Valida que el parametro size sea un numerico
            if (isNumeric(parametros[0])) {
                sizeImp = Integer.parseInt(parametros[0]);
                
                // se valida que el size este entre 1 y 10
                CheckSizeImp(sizeImp);
                
            } else {
                throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                        + "] no es un numero");
            }

            // Realiza la impresion del numero
            imprimirNumero(sizeImp, parametros[1], espacioDig);

    }

    /**
    *
    * Metodo encargado de validar el tamaño de la matriz
    * 
    * @param sizeImp tamaño de la matriz
    * 
    */ 
    private void CheckSizeImp(int sizeImp) {
        // se valida que el size este entre 1 y 10
        if (sizeImp < 1 || sizeImp > 10) {
            throw new IllegalArgumentException("El parametro size [" + sizeImp
                    + "] debe estar entre 1 y 10");
        }
    }

    /**
    *
    *Metodo encargado de validar si el rango de los parametros es correcto
    * 
    *@param size Tamaño de los parametros
    *@param comando Entrada que contiene el size del segmento de los digito y
    * el numero a imprimir
    */
    private void CheckParametersIsValid(int size,String comando) {
        //Valida la que la cantidad de parametros sean los necesarios
        if (size < 2 || size >2) {
            
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");
        }
    }

    /**
    *
    * Metodo encargado de validar si una cadena es numerica
    *
    * @param cadena Cadena
    * @return true if es un numero y false si no lo es
    */
    public boolean isNumeric(String cadena) {
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
    public void CheckEspacioDig(int espacioDig) {
        // se valida que el espaciado este entre 0 y 5
        if(espacioDig <0 || espacioDig >5)
        {
            throw new IllegalArgumentException("El espacio entre "
                    + "digitos debe estar entre 0 y 5");
        }
    }

}
