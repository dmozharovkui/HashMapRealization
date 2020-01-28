import java.util.Arrays;


public class SimpleHashMap {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private long[] valueArray = new long[DEFAULT_INITIAL_CAPACITY];
    private boolean[] collisionArray = new boolean[DEFAULT_INITIAL_CAPACITY];
    int count = 0;


    public long put (int key,long value) {
        int hashCode = hashCode(key);
        int indexArray = indexFor(hashCode, valueArray.length);
            if(size() == 0) {
           valueArray[indexArray] = value;
           collisionArray[indexArray] = true;
                count = count+1;
       }
       else if(size() <threshold)  {
                if(containsKey(indexArray)) {
                    addColisionElement(indexArray,value);
           }
                else {
                    valueArray[indexArray] = value;
                    collisionArray[indexArray] = true;
                    count = count+1;
                }
       }
       else if (size() >=threshold ) {
           valueArray = resizeValueArray(valueArray.length);
           collisionArray= resizeCollisionArray(collisionArray.length);
                if(containsKey(indexArray)) {
                    addColisionElement(indexArray,value);
                }
                else {
                    valueArray[indexArray] = value;
                    collisionArray[indexArray] = true;
                    count = count+1;
                }
       }

        return  value;
    }


        private void addColisionElement(int indexArray,long value) {
            for(int i = indexArray+1; i < valueArray.length; i++) {
                if(collisionArray[i] == false) {
                    valueArray[i] = value;
                    collisionArray[i] = true;
                    count = count+1;
                    break;
                }
            }
        }

    public long get(int key) {
        int indexArray = indexFor(hashCode(key), valueArray.length);
        return valueArray[indexArray];
    }


    public void getArray() {
        System.out.println(Arrays.toString(valueArray));
    }

    public int size() {
        return count;
    }

    private long [] resizeValueArray(int newCapacity) {
        long[] resizeArray = new long[newCapacity*2];
        System.arraycopy(valueArray, 0, resizeArray, 0, valueArray.length);
        threshold = (int) (resizeArray.length*DEFAULT_LOAD_FACTOR);
        return resizeArray;
    }

    private boolean [] resizeCollisionArray(int newCapacity) {
       boolean[] resizeArray = new boolean[newCapacity*2];
        System.arraycopy(collisionArray, 0, resizeArray, 0, collisionArray.length);
        return resizeArray;
    }

        boolean containsKey (int indexArray) {
            for (int i = 0; i < valueArray.length; i++) {
                if (indexArray == i && collisionArray[i] == true) {
                        return true;
                }
            }
            return false;
        }


           private final int hashCode(int key) {
                return (key >> 15) ^ key;
            }
            private final int indexFor(int hash, int length) {

                return hash & (length - 1);
        }
}
