package client.service;

import javax.ws.rs.core.Response;

import master.models.Client;
import master.types.MasterType;

public interface IClientService {
	public Response createOrSaveClientInfo(Client client);

}
