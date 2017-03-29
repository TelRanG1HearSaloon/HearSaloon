package client.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import client.dao.ClientDAO;
import master.models.Client;
@Component
@Path("/clientservice")
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private ClientDAO clientDAO;

	@Override
	@POST
	@Path("client")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML })
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_HTML })
	public Response createOrSaveClientInfo(Client client) {
		if(clientDAO.insertNewClientInfo(client)==null){
			return Response.status(Response.Status.CONFLICT).build();
		}
		
		
		return Response.ok(client).build();
	}

}
