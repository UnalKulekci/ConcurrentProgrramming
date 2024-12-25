package labs.b_PausingExecution;

public class WithSleep {
    public static void main(String[] args) throws InterruptedException {

        String songWord[] = {
                "Georges Brassens (1964) - Les Copains d'abord",
                "Non, ce n'était pas le radeau",
                "De la Méduse, ce bateau",
                "Qu'on se le dise au fond des ports",
                "Dise au fond des ports",
                "Il naviguait en père peinard",
                "Sur la grand-mare des canards",
                "Et s'appelait les Copains d'abord",
                "Les Copains d'abord"
        };

        for (int word = 0; word < songWord.length; word++) {
            Thread.sleep(1000); // wait 1 second
            System.out.println(songWord[word]);
        }
    }
}
