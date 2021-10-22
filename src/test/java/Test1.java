import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {

    @Test
    public void test1(){

        //Creating MyArrayList and ArrayList
        MyArrayList<Integer> test = new MyArrayList<>();
        ArrayList<Integer> test1 = new ArrayList<>();
        test.add(3);
        test.add(9);
        test.add(1);
        test.add(-80);
        test1.add(3);
        test1.add(9);
        test1.add(1);
        test1.add(-80);
        assertEquals(test.size(), test1.size());
        if (test.size() == test.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }

        //Checking add
        test.add(3, 9);
        test1.add(3, 9);
        assertEquals(test.size(), test1.size());
        if (test.size() == test1.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }


        //Checking clear
        test.clear();
        test1.clear();
        assertEquals(test.isEmpty(), test1.isEmpty());
        assertEquals(test.size(), test1.size());
        if (test.size() == test.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }

        //Checking addAll
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(8);
        tmp.add(3);
        tmp.add(-98765);
        test.addAll(tmp);
        test1.addAll(tmp);
        assertEquals(test.size(), test1.size());
        if (test.size() == test1.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }

        //Constructor(size)
        MyArrayList<Integer> c = new MyArrayList<>(0);
        ArrayList<Integer> c1 = new ArrayList<>(0);
        if (c.size() == c1.size())
        {
            int check = 0;
            for (int i = 0; i < c.size(); ++i)
                check += (c.get(i).equals(c1.get(i))) ? 1 : 0;
            assertEquals(check, c1.size());
        }

        //Checking constructor(Collection)
        MyArrayList<Integer> col = new MyArrayList<>(tmp);
        ArrayList<Integer> col1 = new ArrayList<>(tmp);
        assertEquals(col.size(), col1.size());
        if (col.size() == col1.size())
        {
            int check = 0;
            for (int i = 0; i < col.size(); ++i)
                check += (col.get(i).equals(col1.get(i))) ? 1 : 0;
            assertEquals(check, col1.size());
        }

        //Checking contains, indexOf, isEmpty and remove (index)
        assertEquals(test.contains(3), test1.contains(3));
        assertEquals(test.indexOf(3), test1.indexOf(3));
        assertEquals(test.isEmpty(), test1.isEmpty());
        assertEquals(test.remove(2),test1.remove(2));
        assertEquals(test.size(), test1.size());
        if (test.size() == test1.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }

        //remove(Object)
        Integer a = 3;
        test.remove(a);
        test1.remove(a);
        assertEquals(test.size(), test1.size());
        if (test.size() == test1.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }

        //set
        assertEquals(test.set(0, -876),test1.set(0, -876));
        assertEquals(test.size(), test1.size());
        if (test.size() == test1.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }

        //sort
        Comparator<Integer> com = Comparator.comparingInt(o -> o);
        test.quicksort(com);
        test1.sort(com);
        assertEquals(test.size(), test1.size());
        if (test.size() == test1.size())
        {
            int check = 0;
            for (int i = 0; i < test.size(); ++i)
                check += (test.get(i).equals(test1.get(i))) ? 1 : 0;
            assertEquals(check, test.size());
        }
    }
}
