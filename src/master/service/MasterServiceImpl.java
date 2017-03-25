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
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML })
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_HTML })
	public Response createOrSaveMasterInfo(MasterType masterType) {
		Master newMaster = new Master();
		newMaster.setEmail(masterType.getEmail());
		newMaster.setPassword(masterType.getPassword());
		if (masterDAO.insertNewMasterInfo(newMaster) == null) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
		return Response.status(Response.Status.ACCEPTED).entity(newMaster).build();
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
		}else if(masterDAO.loginMaster(authType) == null){
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		Master master = masterDAO.loginMaster(authType);
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
	
	@POST
	@Path("update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMaster(MasterType masterType){
		Master master = new Master();
		master.setEmail(masterType.getEmail());
		master.setLastName(masterType.getLastName());
		master.setName(masterType.getName());
		master.setPassword(masterType.getPassword());
		master.setPhoneNumber(masterType.getPhoneNumber());
		
		String str = masterDAO.removeMasterInfo(master);
		if(str.equals("OK")){
			return Response.accepted().build();
		}else if(str.equals("Wrong password")){
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
}
