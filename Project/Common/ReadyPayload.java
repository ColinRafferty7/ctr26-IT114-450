package Project.Common;

public class ReadyPayload extends Payload {
    private boolean isReady;
    private String deckCount;
    

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

    @Override
    public String toString() {
        return super.toString() + String.format(" isReady [%s]", isReady ? "ready" : "not ready");
    }
}