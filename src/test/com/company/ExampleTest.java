package test.com.company;

import com.company.Example;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ExampleTest {

    private Example example;

    @Before
    public void init() {
        example = new Example();
        example.add("Toyota");
        example.add("BMW");
        example.add("Honda");
    }

    @Test
    public void testSizeSuccess() {
        int size = example.size();

        assertEquals(3, size);
    }

    @Test
    public void testSizeNull() {
        example = null;

        try {
            int size = example.size();
        } catch (Exception ex) {
            assertEquals(NullPointerException.class, ex.getClass());
        }
    }

    @Test
    public void testIsEmptyReturnsFalse() {
        boolean isEmpty = example.isEmpty();

        assertFalse(isEmpty);
    }

    @Test
    public void testIsEmptyReturnsTrue() {
        example = new Example();

        boolean isEmpty = example.isEmpty();

        assertTrue(isEmpty);
    }

    @Test
    public void testContainsReturns() {
        assertTrue(example != null);

        assertTrue(example.contains("Toyota"));
        assertTrue(example.contains("Honda"));
        assertTrue(example.contains("BMW"));
        assertFalse(example.contains("Test"));
        assertFalse(example.contains(new ArrayList()));
    }

    @Test
    public void testIterator() {
    }

    @Test
    public void testToArrayEmpty() {
        example = new Example();

        assertNotNull(example.toArray());
        assertEquals(Object[].class, example.toArray().getClass());
        assertEquals(0, example.toArray().length);

    }

    @Test
    public void testToArrayNotEmpty() {

        Object[] result = example.toArray();
        assertNotNull(result);
        assertEquals(3, result.length);
        List list = Arrays.asList(result);
        assertTrue(list.contains("Honda"));
        assertTrue(list.contains("BMW"));
        assertTrue(list.contains("Toyota"));

    }


    @Test
    public void testAdd() {
        assertEquals(3, example.size());

        example.add("Mercedes");

        assertEquals(4, example.size());

        //Test for duplicate records
        example.add("Mercedes");
        assertEquals(4, example.size());

    }

    @Test
    public void testRemove() {
        assertFalse(example == null);
        assertFalse(example.contains("Test"));
        assertFalse(example.remove("Test"));
        assertEquals(3, example.size());

        assertTrue(example.contains("BMW"));
        assertTrue(example.remove("BMW"));
        assertEquals(2, example.size());
    }


    @Test
    public void testAddAll() {
        example = new Example();
        List list = new ArrayList();
        list.add("Car1");
        list.add("Car2");
        list.add("Car3");
        assertEquals(0, example.size());

        boolean result = example.addAll(list);

        assertTrue(result);
        assertEquals(list.size(), example.size());

    }

    @Test
    public void testClear() {
        example.clear();
        assertTrue(example.isEmpty());
        assertEquals(0, example.size());
    }

    @Test
    public void testRemoveAll() {
        List list = new ArrayList();
        list.add("Honda");
        list.add("Toyota");
        list.add("Test");
        assertEquals(3, example.size());
        assertEquals(3, list.size());

        boolean result = example.removeAll(list);

        assertTrue(result);
        assertEquals(1, example.size());
        assertTrue(example.contains("BMW"));
    }

    @Test
    public void testRetainAll() {
        List list = new ArrayList();
        list.add("Honda");
        list.add("Toyota");
        list.add("Test");
        assertEquals(3, example.size());
        assertEquals(3, list.size());

        boolean result = example.retainAll(list);

        assertTrue(result);
        assertEquals(2, example.size());
        assertFalse(example.contains("BMW"));
    }

    @Test
    public void testContainsAll() {
    }

    @Test
    public void testToArray2() {
    }
}