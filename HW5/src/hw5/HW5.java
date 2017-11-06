package hw5;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class HW5
{
    static int sum = 0;
       
    public static void main(String[] args)
    {
        String[] string1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        System.out.println("-------\nRunning sequential\n-------");
        run(Arrays.stream(string1).sequential());
        System.out.println("sum = " + sum);
        System.out.println("-------\nRunning parallel\n-------");
        run(Arrays.stream(string1).parallel());
        System.out.println("sum = " + sum);
        
    }
    
    public static int run (Stream<String> stream)
    {
        sum = 0;
        
        stream.forEach( s ->
        {
            System.out.println(LocalTime.now() + " - value: " + s +
                " - thread: " + Thread.currentThread().getName());
            sum += Integer.parseInt(s);
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
       
        return sum;
    }
}
