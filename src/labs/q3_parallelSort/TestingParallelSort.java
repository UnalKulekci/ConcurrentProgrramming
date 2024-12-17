package labs.q3_parallelSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestingParallelSort {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        Random randomizer = new Random();

        for (int i = 0; i < 2222321; i++) {
            books.add(new Book(
                    String.valueOf((char) ((i + 65) % 90)),
                    String.valueOf((char) ((i + 65) % 90)),
                    String.valueOf((char) ((i + 65) % 90)),
                    randomizer.nextInt(1900, 2023)
            ));
        }

        // ArrayList'i diziye dönüştürme
        Book[] booksArray = books.toArray(new Book[0]);
        Book[] booksCopy = booksArray.clone();

        // Sıralama işlemleri
        long startTime1 = System.currentTimeMillis();
        Arrays.sort(booksArray);
        System.out.println("Simple sort took -> " + (System.currentTimeMillis() - startTime1) + " ms.");

        long startTime2 = System.currentTimeMillis();
        Arrays.parallelSort(booksCopy);
        System.out.println("Parallel sort took -> " + (System.currentTimeMillis() - startTime2) + " ms.");

        /* Comparator Kullanmak
        - Eğer Book sınıfını değiştirmek istemiyorsak yani "compareTo" metodunu implement
        etmek istemiyorsak bir Comparator sağlayarak sıralama yapabiliriz.

        Book[] booksArray = books.toArray(new Book[0]);
        Book[] booksCopy = booksArray.clone();

        long startTime1 = System.currentTimeMillis();
        Arrays.sort(booksArray, Comparator.comparingInt(Book::getYear));
        System.out.println("Simple sort took -> " + (System.currentTimeMillis() - startTime1) + " ms.");

        long startTime2 = System.currentTimeMillis();
        Arrays.parallelSort(booksCopy, Comparator.comparingInt(Book::getYear));
        System.out.println("Parallel sort took -> " + (System.currentTimeMillis() - startTime2) + " ms.");
         */


    }
} // End of the TestingParallelSort Class
