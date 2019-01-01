package dsa;

public class Main
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++)
        {
            list.addFirst(i);
            System.out.println(list);
        }

        list.add(2, 66);
        System.out.println(list);
    }
}
