

public class Main {
    public static void main(String[] args) {

        SimpleHashMap simpleMap = new SimpleHashMap();
        //Condition 1 (When we add no colision elements)

        /*
            int i = 0;
            long value = 0;
            while(i<=12) {
                simpleMap.put(i,value);
                value ++;
                i++;
            }
        simpleMap.getArray();
        System.out.println("Your value: " + simpleMap.get(2) );
        System.out.println("Map size: "+ simpleMap.size());

*/

        //Condition 2 (When we add more elements(no collison) than threshold )
        /*
        int i = 0;
        long value = 0;
        while(i<=13) {
            simpleMap.put(i,value);
            value ++;
            i++;
        }
        simpleMap.getArray();
        System.out.println("Your value: " + simpleMap.get(13) );
        System.out.println("Map size: "+ simpleMap.size());
        */

        //Condition 3 (When we add elements with collision)
        /*
        simpleMap.put(0,33);
        simpleMap.getArray();
        simpleMap.put(0,33);
        simpleMap.getArray();     //Elements shifting
        System.out.println("Your value: " + simpleMap.get(1) );
        System.out.println("Map size: "+ simpleMap.size());
            */

        //Condition 4 (When collision between elements happen in threshold
        /*
        int i = 0;
        long value = 0;
        while(i<=12) {
            simpleMap.put(i,value);
            value ++;
            i++;
        }
        simpleMap.put(12,12) ;
        simpleMap.getArray();
        System.out.println("Your value: " + simpleMap.get(13) );
        System.out.println("Map size: "+ simpleMap.size());
         */

    }


}
