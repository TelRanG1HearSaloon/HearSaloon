package master.dao;

import java.util.List;

import master.models.Master;

public interface MasterDAO {
	public Master insertNewMasterInfo(Master addMaster);
    public Master getMasterInfo(String phoneNumber);
    public String updateMasterInfo(Master updateMaster);
    public String removeMasterInfo(Master removeMaster);
    public List<Master> getAllBookInfo();
}
