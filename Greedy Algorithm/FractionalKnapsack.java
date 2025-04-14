
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

class Item{
    int value;
    int weight;
    Double costPerUnit;

    public Item(int value, int weight){
        this.value=value;
        this.weight=weight;
        this.costPerUnit=(double)value/weight;
    }

    public String toString(){
        return "value:"+this.value+" weight:"+this.weight+" costPerUnit:"+costPerUnit;
    }
}
public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int val[]={1, 5, 7, 2, 7, 10}; //{60, 100}; //{60, 100, 120};
        int wt[]={4, 9, 6, 3, 7, 3}; //{10, 20}; //{10, 20, 30};
        int capacity=24;

        Item items[]=new Item[val.length];
        for(int i=0;i<val.length;i++){
            items[i]=new Item(val[i], wt[i]);
        }

        Arrays.sort(items, new Comparator<Item>() {

            @Override
            public int compare(Item a1, Item b1) {
                return b1.costPerUnit.compareTo(a1.costPerUnit);
            }
        });

        for(Item item: items){
            System.out.println(item);
        }

        double sum=0;
        for(Item item: items){
            if(capacity>0){
                if(item.weight<=capacity){
                    sum=sum+item.value;
                    capacity=capacity-item.weight;
                }else{
                    double fraction = (double) capacity / item.weight;
                    sum=sum+(item.value*fraction);
                    capacity=0;
                }
            }else{
                break;
            }
        }

        String formatted = String.format("%.6f", sum);

        System.out.println(Double.parseDouble(formatted));
    }
}
