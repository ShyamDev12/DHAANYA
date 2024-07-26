package com.example.uzhavu;

public class CardsList {

    private final String id;
    private final int winAmount;
    //When user scartch a card then this value will true so user wont do same card again
    private boolean scartchStatus;

    public CardsList(String id, int winAmount, boolean scartchStatus) {
        this.id = id;
        this.winAmount = winAmount;
        this.scartchStatus = scartchStatus;
    }

    public String getId() {
        return id;
    }

    public int getWinAmount() {
        return winAmount;
    }

    public boolean isScartchStatus() {
        return scartchStatus;
    }

    public void setScratchStatus(boolean cardScratched){
        this.scartchStatus = cardScratched;

    }
}
