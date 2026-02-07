/**
 * Implementación de la calculadora para operaciones aritméticas básicas.
 * @author Raquel Vega 25469 Wilfred Orrellana
 * @version 1.0
 */
public class PostfixCalculator implements Calculator {

    /**
     * @pre Se reciben dos números enteros.
     * @post Se devuelve la suma aritmética de a y b.
     */
    @Override
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * @pre Se reciben dos números enteros.
     * @post Se devuelve la resta de a menos b.
     */
    @Override
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * @pre Se reciben dos números enteros.
     * @post Se devuelve el producto de a por b.
     */
    @Override
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * @pre El divisor 'b' no debe ser cero.
     * @post Se devuelve el cociente entero de la división.
     * @throws ArithmeticException si b es cero.
     */
    @Override
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}