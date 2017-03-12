package master.service;

import javax.ws.rs.core.Response;

import master.types.MasterType;

public interface IMasterService {
	public Response createOrSaveMasterInfo(MasterType masterType);

	public Response getMasterInfo(String phoneNumber);

	public Response updateMasterInfo(MasterType masterType);

	public Response deleteMasterInfo(String phoneNumber);

	public Response getAllMasterInfo();
}
