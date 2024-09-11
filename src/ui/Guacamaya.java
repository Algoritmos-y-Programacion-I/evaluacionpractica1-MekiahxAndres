package ui;

import java.util.Scanner;

public class Guacamaya {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        int referencias = reader.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }
    /**
     * Descripcion: Permite guardar cantidades y precios en los arreglos
     * pre: El arreglo unidades debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
     * pos: El arreglo unidades queda modificado con nuevo valor
     * pos: El arreglo precios queda modificado con nuevo valor
     */
    public static void solicitarDatos(){
        for (int i = 0; i < unidades.length; i++) {
            System.out.print("Cual es la Cantidad del producto " + (i+1) + ": ");
            unidades[i] = reader.nextInt();
            System.out.print("Cual es el precio de ese producto: ");
            precios[i] = reader.nextDouble();
        }
     
    }
    /**
     * Descripcion: Permite calcular el total de unidades que fueron vendidas
     * pre: El arreglo unidades debe estar inicializado
     * @return unidatot Cantidad de unidades vendidas.
     */
    public static int calcularTotalUnidadesVendidas(){

        int unidadtot = 0;
        for(int i=0; i<unidades.length; i++){
            unidadtot += unidades[i];
        }

        return unidadtot;

    }
    /**
     * Descripcion: Permite calcular el precio promedio de todos los productos
     * pre: El arreglo precios debe estar inicializado
     * @return suma Valor del precio promedio de todos los precios.
     */
    public static double calcularPrecioPromedio(){

        double suma = 0;
        for (int i = 0; i < precios.length; i++) {
            suma += precios[i];
        }

        return suma / precios.length;
    }
    /**
     * Descripcion: Permite calcular las ventas totales
     * pre: El arreglo unidades debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
     * @return totalVentas Valor de todas las ventas totales
     */
    public static double calcularVentasTotales(){
        double totalventas = 0;
        for(int i= 0; i<unidades.length; i++){
            totalventas += unidades[i]*precios[i];
        }
        return totalventas;

    }
    /**
     * Descripcion: Permite calcular el precio promedio de todos los productos
     * pre: El arreglo precios debe estar inicializado
     * @return contador Cantidad de productos que cumplen con el limite
     */
    public static int consultarReferenciasSobreLimite(double limite){
        int contador = 0;
        for (int i = 0; i < precios.length; i++) {
            double totalVentasProducto = unidades[i] * precios[i];
            if (totalVentasProducto >= limite){
                contador++;
            }
        }
        return contador;

    }
    
}
