package Project.Client.Interfaces;

public interface ICardsEvent extends IGameEvents {
    /**
     * Receives the current phase
     * 
     * @param phase
     */
    void onCardsUpdate(long clientId, int cards);
}