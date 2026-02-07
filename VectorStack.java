import java.util.EmptyStackException;

/**
 * Implementación de la calculadora para operaciones aritméticas básicas.
 * @author Raquel Vega 25469 Wilfred Orrellana
 * @version 1.0
 */

public class VectorStack<T> implements Stack<T> {

    private T[] vector;
    private int count; // Cantidad actual de elementos
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public VectorStack() {
        // En Java no se pueden crear arreglos genéricos directamente, se hace casting
        this.vector = (T[]) new Object[INITIAL_CAPACITY];
        this.count = 0;
    }

    @Override
    public void push(T element) {
        if (count == vector.length) {
            resize();
        }
        vector[count] = element;
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = vector[count - 1];
        vector[count - 1] = null; // Evitar memory leaks
        count--;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return vector[count - 1];
    }

    @Override
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // Método para cumplir el requisito de "Vector de tamaño variable"
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newVector = (T[]) new Object[vector.length * 2];
        for (int i = 0; i < vector.length; i++) {
            newVector[i] = vector[i];
        }
        this.vector = newVector;
    }
}