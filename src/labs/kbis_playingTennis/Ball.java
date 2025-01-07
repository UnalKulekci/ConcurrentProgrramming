package labs.kbis_playingTennis;

import java.sql.Time;

public class Ball {

    private Player owner;

    public synchronized Player getOwner() {
        return owner;
    }

    public synchronized void setOwner(Player owner) {
        this.owner = owner;
        notify();
        //notifyAll();
    }

    public synchronized void waitForTurn(Player player) {
        while (owner != player) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}



