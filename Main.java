import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // 1. Instanciamos nuestra Pila (VectorStack) y Calculadora
        // Aquí se cumple el requisito de que el programa principal use la interfaz
        Stack<Integer> stack = new VectorStack<>(); 
        Calculator calculator = new PostfixCalculator();

        String archivo = "datos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                
                System.out.println("Evaluando expresión: " + linea);
                try {
                    int resultado = evaluarPostfix(linea, stack, calculator);
                    System.out.println("Resultado: " + resultado);
                } catch (Exception e) {
                    System.err.println("Error al evaluar la expresión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + archivo);
        }
    }

    private static int evaluarPostfix(String expresion, Stack<Integer> stack, Calculator calc) {
        // El PDF dice que los operandos y operadores están separados por espacio [cite: 17]
        // Ojo: Si el archivo no tiene espacios (ej: 12+), el split debe ser diferente.
        // Asumiremos espacios según la "Nota" del PDF, pero manejamos tokens.
        
        // Limpiamos espacios extra y dividimos
        String[] tokens = expresion.split("\\s+"); 

        for (String token : tokens) {
            // Si es un número (operando)
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } 
            // Si es operador
            else if (token.length() == 1 && "+-*/".contains(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión mal formada: faltan operandos.");
                }
                
                // Cuidado con el orden: primero sale el B, luego el A [cite: 28, 29]
                int b = stack.pop();
                int a = stack.pop();
                int resultado = 0;

                switch (token.charAt(0)) {
                    case '+': resultado = calc.sumar(a, b); break;
                    case '-': resultado = calc.restar(a, b); break;
                    case '*': resultado = calc.multiplicar(a, b); break;
                    case '/': resultado = calc.dividir(a, b); break;
                }
                stack.push(resultado);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión mal formada: sobran operandos.");
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}