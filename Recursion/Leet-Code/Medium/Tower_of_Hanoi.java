import java.util.*;

public class Tower_of_Hanoi{

   public int move(int n,int from,int to,int aux){
    if(n==1){
        return 1;
    }

    int count=move(n-1,from,aux,to);
    count++;
    count+=move(n-1,aux,to,from);

    return count;

   }

    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);

        System.out.print("Enter total number of disks : ");
        int input=scan.nextInt();

        Tower_of_Hanoi obj=new Tower_of_Hanoi();
        int ans=obj.move(input,1,3,2);

        System.out.print("Total Moves : "+ans);
    }
}