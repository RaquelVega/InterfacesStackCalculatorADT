/**
 * Implementación de la calculadora para operaciones aritméticas básicas.
 * @author Raquel Vega 25469 Wilfred Orrellana
 * @version 1.0
 */
public interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    int size();
}