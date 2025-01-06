package labs.cp5.s2_ComparingAtomicArraysAndStandardArrays;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class TestArray {

    public static void main(String[] args) {
        // 1. Standart dizi oluşturma
        int[] standardArray = {0, 1, 2, 3, 4};

        // 2. AtomicIntegerArray oluşturma
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(standardArray.length);

        // 3. Dizileri başlatma
        for (int i = 0; i < standardArray.length; i++) {
            atomicArray.set(i, standardArray[i]);
        }

        // Başlangıç değerlerini yazdırma
        System.out.println("Starting values atomic array: " + Arrays.toString(getAtomicArrayValues(atomicArray)));
        System.out.println("Starting values non atomic array: " + Arrays.toString(standardArray));

        // 4. İş parçacıklarını oluşturma
        runTest(standardArray, atomicArray);
    }

    private static void runTest(int[] standardArray, AtomicIntegerArray atomicArray) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 3 eşit iş parçacığı oluşturma
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    for (int k = 0; k < standardArray.length; k++) {
                        // Standart dizi için artırma
                        standardArray[k]++;
                        // AtomicIntegerArray için artırma
                        atomicArray.incrementAndGet(k);
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Bekle
        }

        // Sonuçları yazdırma
        System.out.println("Final values atomic array: " + Arrays.toString(getAtomicArrayValues(atomicArray)));
        System.out.println("Final values of non atomic array: " + Arrays.toString(standardArray));
    }

    // AtomicIntegerArray'dan değerleri almak için yardımcı metod
    private static int[] getAtomicArrayValues(AtomicIntegerArray atomicArray) {
        int[] values = new int[atomicArray.length()];
        for (int i = 0; i < atomicArray.length(); i++) {
            values[i] = atomicArray.get(i);
        }
        return values;
    }
}