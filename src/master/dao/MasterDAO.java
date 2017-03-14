package master.dao;

import java.util.List;

import master.models.Master;
import master.types.AuthType;

public interface MasterDAO {
	public Master insertNewMasterInfo(Master addMaster);
    public Master getMasterInfo(String phoneNumber);
    public Master updateMasterInfo(AuthType updateMaster);
    public String removeMasterInfo(Master removeMaster);
    public List<Master> getAllBookInfo();
}
