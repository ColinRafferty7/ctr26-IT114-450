package Project.Common;

public class PointsPayload extends Payload {
    private int points;
    public PointsPayload(int points)
    {
        setPayloadType(PayloadType.POINTS);
        this.points = points;
    }

    public int getPoints()
    {
        return points;
    }

    public String toString()
    {
        return super.toString() + " {Points = " + points + "}"; 
    }
    
}
