import static org.junit.Assert.*; // Importante para usar assertEquals
import org.junit.Test;
import org.junit.Before;

public class PostfixCalculatorTest {

    private Calculator calc;

    @Before
    public void setup() {
        // Inicializamos la calculadora antes de cada prueba
        calc = new PostfixCalculator();
    }

    @Test
    public void testSumar() {
        // assertEquals(valor_esperado, valor_real)
        assertEquals(3, calc.sumar(1, 2));
    }

    @Test
    public void testMultiplicar() {
        assertEquals(12, calc.multiplicar(3, 4));
    }

    @Test
    public void testRestar() {
        assertEquals(5, calc.restar(10, 5));
    }

    @Test
    public void testDividir() {
        assertEquals(2, calc.dividir(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionPorCero() {
        // Esta prueba pasa si el código lanza un error al dividir por cero
        calc.dividir(10, 0);
    }
}
