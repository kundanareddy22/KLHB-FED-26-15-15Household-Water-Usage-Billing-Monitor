public class Array
{
public static void main
{
Scanner sc = new Scanner(System.in);
int[] weekT = new int[7];
System.out.println("Enter week tmp");
	for(int i= 0 ; i < 7;i++)
{
System.out.println("Enter days"+ i +"temperature");
weekT[i] = sc.nextInt();
}
	}
}