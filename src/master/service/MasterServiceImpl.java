package master.service;

import master.dao.MasterDAO;
import master.models.Master;
import master.types.AuthType;
import master.types.MasterType;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/masterservice")
public class MasterServiceImpl implements IMasterService {



	@Autowired
	private MasterDAO masterDAO;

	// http://localhost:8080/HearSaloon/rest/masterservice/master
	@POST
	@Path("master")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrSaveMasterInfo(MasterType masterType) {
		Master newMaster = new Master();
		newMaster.setEmail(masterType.getEmail());
//		newMaster.setInfo(masterType.getInfo());
		newMaster.setLastName(masterType.getLastName());
		newMaster.setName(masterType.getName());
		newMaster.setPassword(masterType.getPassword());
		newMaster.setPhoneNumber(masterType.getPhoneNumber());

		Master master = new Master();
		if (masterDAO.insertNewMasterInfo(newMaster) == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		MasterType masterType2 = new MasterType();

		masterType2.setEmail(master.getEmail());
//		masterType2.setInfo(master.getInfo());
		masterType2.setLastName(master.getLastName());
		masterType2.setName(master.getName());
		masterType2.setPassword(master.getPassword());
		masterType2.setPhoneNumber(master.getPhoneNumber());

		return Response.status(Response.Status.ACCEPTED).build();
	}

	// http://localhost:8080/HearSaloon/rest/masterservice/getmaster/1
	@GET
	@Path("master/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getMasterInfo(@PathParam("id") String phoneNumber) {
		Master masterType = masterDAO.getMasterInfo(phoneNumber);
		if (masterType == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		return Response.accepted(masterType).build();
	}

	// http://localhost:8080/HearSaloon/rest/masterservice/master
	@PUT
	@Path("master")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMasterInfo(AuthType authType) {
		if(authType == null){
			return Response.status(Response.Status.NO_CONTENT).build();
		}else if(masterDAO.updateMasterInfo(authType) == null){
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		Master master = masterDAO.updateMasterInfo(authType);
		MasterType masterType = new MasterType();
		
		masterType.setEmail(master.getEmail());
		masterType.setLastName(master.getLastName());
		masterType.setName(master.getName());
		masterType.setPassword(master.getPassword());
		masterType.setPhoneNumber(master.getPhoneNumber());
		return Response.status(Response.Status.ACCEPTED).entity(masterType).build();
		
	}

	// http://localhost:8080/HearSaloon/rest/masterservice/deletemaster/5
	@DELETE
	@Path("master")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public Response deleteMasterInfo(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	// http://localhost:8080/HearSaloon/rest/masterservice/getallmaster
	@GET
	@Path("getAllMaster")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllMasterInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
