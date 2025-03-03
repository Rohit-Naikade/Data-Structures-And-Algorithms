import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxHeap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());

        int choice = 0, tmp = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("***************** Menu *****************");
            System.out.println("1. Add element to the heap:");
            System.out.println("2. Remove element from heap:");
            System.out.println("3. Print heap:");
            System.out.println("4. Get peak element:");
            System.out.println("4. Exit:");
            System.out.println("Enter your Choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element:");
                    tmp = sc.nextInt();
                    queue.add(tmp);
                    System.out.println("Heap Elements:"+queue);
                    break;
                case 2:
                    System.out.println("Enter Element:");
                    tmp = sc.nextInt();
                    queue.remove(tmp);
                    System.out.println("Heap Elements:"+queue);
                    break;
                case 3:
                    Iterator itr=queue.iterator();
                    System.out.println("Heap Elements");
                    while(itr.hasNext()){
                        System.out.print(itr.next()+" ");
                    }
                    break;
                case 4:
                    System.out.println("Peak Element: "+queue.poll());
                    break;
                case 5:
                    break;
            }
        }
        
    }
}
