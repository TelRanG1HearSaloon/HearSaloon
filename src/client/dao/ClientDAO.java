package client.dao;

import java.util.List;

import master.models.Client;
import master.models.Master;
import master.types.AuthType;

public interface ClientDAO {
	public Client insertNewClientInfo(Client client);
	public Client getClietnInfo(Client client);
	public Client updateClientInfo(Client client);
	public Client removeClientInfo(Client client);
}
