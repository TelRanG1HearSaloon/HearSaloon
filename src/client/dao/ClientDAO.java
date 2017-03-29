package client.dao;


import master.models.Client;

public interface ClientDAO {
	public Client insertNewClientInfo(Client client);
	public Client getClietnInfo(Client client);
	public Client updateClientInfo(Client client);
	public Client removeClientInfo(Client client);
}
