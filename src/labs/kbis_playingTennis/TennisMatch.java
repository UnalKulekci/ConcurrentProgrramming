package labs.kbis_playingTennis;

public class TennisMatch {
    public static void main(String[] args) {

        Ball ball = new Ball(); // Shared source

        Player federer = new Player("Federer", ball);
        Player nadal = new Player("Nadal", ball);

        // Players know each other
        federer.setOtherPlayer(nadal);
        nadal.setOtherPlayer(federer);

        // Federer's game begins
        ball.setOwner(federer);

        Thread federerThread = new Thread(federer);
        Thread nadalThread = new Thread(nadal);

        federerThread.start();
        nadalThread.start();
    }
}





