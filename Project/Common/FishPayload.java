package Project.Common;

public class FishPayload extends Payload 
{
    private CardType cardType;
    private long targetId;
    public FishPayload(long targetId, CardType cardType)
    {
        setPayloadType(PayloadType.FISH);
        this.targetId = targetId;;
        this.cardType = cardType;
    }

    public CardType getCardType()
    {
        return cardType;
    }

    public long getTargetId()
    {
        return targetId;
    }

    public String toString()
    {
        return super.toString() + "{Target ID = " + targetId + "} {Card Type = " + cardType.getCardType() + "}";
    }

}
