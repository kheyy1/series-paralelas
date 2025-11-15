package src;
import java.util.Arrays;
import java.util.Scanner;

public class App{
    public static int[] llenarArreglo(int tamaño, Scanner scanner) {
        int i = 0;
        int[] arreglo = new int[tamaño];
        
        System.out.println("\n--- Llenando Arreglo de " + tamaño + " Elementos ---");
        
        for (i = 0; i < tamaño; i++) {
            System.out.print("Ingrese el número para la posición [" + i + "]: ");
            
            if (scanner.hasNextInt()) {
                arreglo[i] = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); 
                i--;
            }
        }
        System.out.println("Arreglo llenado con éxito.");
        return arreglo;
    }
    public static int[] sumaElementoElemento(int[] a, int[] b){
        int tamaño = a.length;
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = a[i] + b[i];
        }
        return arreglo;
    }
    public static int productoEscalar(int[] a, int[] b){
        int tamaño = a.length;
        int producto = 0;
        for (int i = 0; i < tamaño ; i++){
            producto += a[i] * b[i];
        }
        return producto;
    }
    public static int rotacionDerechaDeAParaObtenerB(int[] a, int[] b) {
        int k = 2; //Para simplificar, voy a usar k como un valor estatico (2) pero puede ser ingresado por teclado
        int N = a.length;
        if (N == 0) {
            return 0;
        }
        for (k = 2; k < N; k++) {
            boolean esIgual = true;
            for (int j = 0; j < N; j++) {
                int indiceOriginalA = (j - k + N) % N; //calcular el indice de A en el arreglo original
                if (a[indiceOriginalA] != b[j]) {
                    esIgual = false;
                    break;
                }
            }
            if (esIgual) {
                return k;
            }
        }
        return -1;
    }
    public static boolean mismosElementosComoMulticonjunto(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cuantos elementos quiere que tengan sus arreglos");
        int longitud = sc.nextInt();
        int[] arregloA = llenarArreglo(longitud, sc);
        System.out.print("Arreglo resultante de " + longitud + ": ");
        for (int numA : arregloA) {
            System.out.print(numA + " ");
        }
        int[] arregloB = llenarArreglo(longitud, sc);
        System.out.print("Arreglo resultante de " + longitud + ": ");
        for (int numB : arregloB) {
            System.out.print(numB + " ");
        }
        System.out.println();
        int[] sumatorias = sumaElementoElemento(arregloA, arregloB);
        System.out.println("Suma de los elementos");
        for (int i = 0; i < arregloA.length ; i++){
            System.out.print(sumatorias[i] + " ,");
        }
        System.out.println("");
        int producto = productoEscalar(arregloA, arregloB);
        System.out.println("Producto escalar de los vectores: ");
        System.out.println(producto);
        boolean multiconjunto = mismosElementosComoMulticonjunto(arregloA, arregloB);
        System.out.println(multiconjunto);
        int rotacion = rotacionDerechaDeAParaObtenerB(arregloA, arregloB);
        System.out.println(rotacion);
        sc.close();
    }
}