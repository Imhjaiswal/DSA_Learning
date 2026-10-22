import java.nio.channels.Pipe.SourceChannel;
import java.util.*;

class JCF {
    static void main () {
        ArrayList<Integer> arrList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Collection<Integer> collection = new ArrayList<>();

        arrList.add(10);
        arrList.add(20);
        arrList.add(30);
        arrList.add(40);
        System.out.println(arrList);

        arrList.remove(0);
        System.out.println(arrList);

        list.add(40);
        list.add(50);
        arrList.addAll(list);
        System.out.println(arrList);
        arrList.removeAll(list);
        System.out.println(arrList);

        arrList.get(1);
        System.out.println(arrList);

        list.toArray();
        System.out.println(list.getClass());

        arrList.set(1,50);
        System.out.println(arrList.size());

        Iterator<Integer> iterator = arrList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element : "+ iterator.next());
        }

        for (Integer integer : arrList) {
            System.out.println("Element : "+integer);
        }

        Object [] arr = arrList.toArray();
        for (Object object : arr) {
            System.out.println(object);
        }
        System.out.println(arr.getClass());

        arrList.add(5);
        arrList.add(12);

        Collections.sort(arrList);
        System.out.println(arrList);   
        
        Collections.sort(arrList,Collections.reverseOrder());
        System.out.println(arrList);   
    }
}