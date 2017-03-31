package master.service;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import master.types.AuthType;
import master.types.MasterType;

public interface IMasterService {
	public Response createOrSaveMasterInfo(MasterType masterType);

	public Response getMasterInfo(HttpHeaders headers, String email);

	public Response loginMaster(AuthType masterType);

	public Response deleteMasterInfo(String phoneNumber);

	public Response getAllMasterInfo();
	

}
