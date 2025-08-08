package Project.Common;

public class ReadyPayload extends Payload {
    private boolean isReady;
    private String deckCount;
    private boolean jokers;

    public ReadyPayload(String deckCount) {
        setPayloadType(PayloadType.READY);
        this.deckCount = deckCount;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public String getDeckCount()
    {
        return deckCount;
    }

    public void setJokers(boolean jokers)
    {
        this.jokers = jokers;
    }

    public boolean getJokers()
    {
        return this.jokers;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" isReady [%s]", isReady ? "ready" : "not ready");
    }
}