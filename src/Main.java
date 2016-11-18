
/**
 * Created by mrhri on 10.11.2016.
 */
public class Main {

    public static void main(String[] args){

        ArrayList list = new ArrayList(10);
        list.add(0, "Hello ");
        list.add(1, "Konstantin");
        list.add(2, ", in this World");
        list.add(3, ", You like this World?");
        list.add(4, ", You don't like this World?");

        for (int i = 0; i<list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.println("\n"+list.size());

        list.remove(4);

        System.out.println("\n"+list.size());

        for (int i = 0; i<list.size(); i++){
            System.out.print(list.get(i));
        }
    }
}
