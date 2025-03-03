import java.util.*;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the array:");
        int size = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        int tmp = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            tmp = sc.nextInt();
            list.add(tmp);
        }

        System.out.println("List before sort"+list);
        sortArray(list);

        System.out.println("List elements are:");

        for(Integer temp : list){
            System.out.print(temp+" ");
        }

    }

    private static void sortArray(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }

        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        System.out.println("list before insert:"+list);
        sortArray(list);
        insert(list, temp);
        System.out.println("list after insert:"+list);
    }

    private static void insert(List<Integer> list, int temp) {
          if(list.size()==0 || list.get(list.size()-1)<=temp){
                list.add(temp);
                return;
          }

          int val=list.get(list.size()-1);
          list.remove(list.size()-1);
          System.out.println("list during insert:"+list+" and temp:"+temp);
          insert(list,temp);
          list.add(val);
    }
}
