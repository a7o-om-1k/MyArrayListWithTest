import org.junit.Test;

import static org.junit.Assert.*;

public class AroListTest
{

    private AroList<Integer> list = new AroList<>();

    private void fillList() {
        list.add(34);
        list.add(120);
        list.add(-10);
        list.add(11);
        list.add(50);
    }

    @Test
    public void add() {
        assertEquals(list.size(), 0);
        list.add(34);
        list.add(120);
        list.add(-10);
        list.add(11);
        list.add(50);
        assertEquals(list.size(), 5);
    }

    @Test
    public void get() {
        fillList();
        assertEquals(list.get(1), 120);
    }



    @Test
    public void set() {
        fillList();
        list.set(1,777);
        assertEquals(list.get(1),777);
    }

    @Test
    public void remove() {
        fillList();
        assertEquals(list.size(), 5);
        list.remove(3);
        assertEquals(list.size(), 4);
        list.remove(1);
        assertEquals(list.size(), 3);
    }


    @Test
    public void size() {
        assertEquals(list.size(), 0);
        fillList();
        assertEquals(list.size(), 5);
    }

    @Test
    public void clear() {
        fillList();
        list.clear();
        assertEquals(list.size(),0);
    }
}