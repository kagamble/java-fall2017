package hw2;
import java.util.Scanner;

public class Hw2
{
    public static void main(String[] args) 
    {
        int avg;
        int R1;
        int R2;
        
        Scanner in = new Scanner(System.in);
        
        R1 = in.nextInt();
        avg = in.nextInt();
        
        R2 = reverseavg(R1, avg);
        
        System.out.println(R2);
        
    }
    
    static int reverseavg(int R1_, int avg_)
    {
        int avg = avg_;
        int R1 = R1_;
        return avg * 2 - R1;
    }
}
