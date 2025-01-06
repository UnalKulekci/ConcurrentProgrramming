package cp5_ProfCodes.slides_exmp.Atomic;

/*
- Counter class'i thread-safe olmayan bir class'dir.
- Counter: Basit bir sayaç sınıfıdır, ancak çoklu iş parçacıkları tarafından erişildiğinde tutarsız sonuçlar verebilir.
*/
public class Counter {
    private int counter;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getValue() {
        return counter;
    }
}
