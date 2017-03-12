package master.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import master.models.Master;

@Repository("masterDAO")
public class MasterDAOImpl implements MasterDAO {
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
    private EntityManager em;


	@Override
	@Transactional
	public Master insertNewMasterInfo(Master addMaster) {
		   if(em.find(addMaster.getClass(), addMaster.getPhoneNumber())!=null){
	            return null;
	        }
	       
	        em.persist(addMaster);

		return addMaster;
	}

	@Override
	public Master getMasterInfo(String phoneNumber) {
		if(em.find(Master.class, phoneNumber)!=null){
			return em.find(Master.class, phoneNumber);
		}
		return null;
	}

	@Override
	public String updateMasterInfo(Master updateMaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeMasterInfo(Master removeMaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Master> getAllBookInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
