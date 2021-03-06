package com.mygdx.game.cheat;


import com.badlogic.gdx.Gdx;

/**
 * The type Cheat count thread.
 */
public class CheatCountThread extends Thread {

    private final CheatCountDown cheatCountDown;
    private static final String TAG = "CheatCountThread";

    /**
     * Instantiates a new Cheat count thread.
     *
     * @param cheatCountDown the cheat count down
     */
    public CheatCountThread(CheatCountDown cheatCountDown) {
        this.cheatCountDown = cheatCountDown;
    }


    @Override
    public void run() {
        Gdx.app.log(TAG, "Start thread");

        try {
            while (!isInterrupted()) {
                Thread.sleep(1500);
                Gdx.app.log(TAG, "Increase dice");
                cheatCountDown.increaseCurrentDiceValue();
            }
        } catch (InterruptedException e) {
            Gdx.app.log(TAG, "Interrupt thread");
            Thread.currentThread().interrupt();
        }
    }

}
