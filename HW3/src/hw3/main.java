package hw3;
import java.util.*;
import static java.util.Arrays.asList;

public class main 
{
    public static void main(String[] args) 
    {
        ArrayList<String> aray = new ArrayList<String>();
        
        aray.add("Jon");
        aray.add("Tyrian");
        aray.add("Arya");
        aray.add("Daenerys");
        aray.add("Jamie");
        
        System.out.println(aray);
        
        aray = sort(aray);
        
        System.out.println(aray);
    }
    
    static ArrayList<String> sort(ArrayList<String> array_)
    {
        ArrayList<String> array = new ArrayList<String>();
        array = array_;
        Collections.sort(array);
        return array;
    }
}
