package labs.kbis_playingTennis;

public class Player implements Runnable {

    private String name;
    private Ball ball;
    private Player otherPlayer; // Opposing player

    public Player(String name, Ball ball) {
        this.name = name;
        this.ball = ball;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    @Override
    public void run() {
        while (true) {
            ball.waitForTurn(this); // Waiting for his turn
            System.out.println(name + " plays the ball");
            ball.setOwner(otherPlayer); // Passes the ball to the other player
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}





