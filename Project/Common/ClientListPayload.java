package Project.Common;

import java.util.ArrayList;
import java.util.List;

public class ClientListPayload extends Payload 
{
    private List<Long> clients = new ArrayList<>();
    public ClientListPayload(List<Long> clients)
    {
        setPayloadType(PayloadType.CARDS);
        this.clients = clients;
    }

    public List<Long> getClients()
    {
        return clients;
    }
}
