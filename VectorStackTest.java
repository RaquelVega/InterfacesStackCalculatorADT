import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class VectorStackTest {

    private Stack<Integer> stack;

    @Before
    public void setup() {
        // Inicializamos una nueva pila antes de cada test
        stack = new VectorStack<>();
    }

    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        // El último en entrar (20) debe ser el primero en salir
        int result = stack.pop();
        assertEquals(20, result);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeek() {
        stack.push(50);
        // Peek debe devolver el valor sin quitarlo de la pila
        int result = stack.peek();
        assertEquals(50, result);
        assertEquals(1, stack.size());
    }

    @Test
    public void testSize() {
        assertTrue(stack.size() == 0);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void testEmptyStackPop() {
        // Opcional: Probar qué pasa si intentas sacar algo de una pila vacía
        try {
            stack.pop();
            fail("Debería haber lanzado una excepción");
        } catch (Exception e) {
            // Test pasa si entra aquí
        }
    }
}
