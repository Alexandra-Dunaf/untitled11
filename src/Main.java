/*
1. Примером использования хэш-таблиц может послужить кодировка ASCII, в которой букве «a» соответствует код 97, букве «b» — код 98 и т. д., до кода 122 для буквы «z».
2. Слово melioration имеет точно такой же хеш-код, что и слово demystify.
3. Криптографические хеш-функции MD и SHA. Алгоритмы CRC.
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DataItem dataItem;
        int aKey, size;
        size = 400;
        Random random = new Random();

        //task 4
        HashTableLinear hashTableLinear = new HashTableLinear(size);

        for (int i = 0; i < 100; i++) {
            aKey = random.nextInt(size);
            dataItem = new DataItem(aKey);
            hashTableLinear.insert(dataItem);
        }
        hashTableLinear.insert(new DataItem(31));
        hashTableLinear.insert(new DataItem(69));
        hashTableLinear.displayTable();
        System.out.println(hashTableLinear.find(69).getKey());
        System.out.println(hashTableLinear.delete(31).getKey());

        //task 5
        HashTableDouble hashTableDouble = new HashTableDouble(size);
        for (int i = 0; i < 100; i++) {
            aKey = random.nextInt(size);
            dataItem = new DataItem(aKey);
            hashTableDouble.insert(dataItem);
        }

        hashTableDouble.insert(new DataItem(31));
        hashTableDouble.insert(new DataItem(69));
        hashTableDouble.displayTable();
        System.out.println(hashTableDouble.find(69).getKey());
        System.out.println(hashTableDouble.delete(31).getKey());
    }
}
