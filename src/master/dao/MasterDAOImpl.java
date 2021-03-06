package master.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import master.models.Master;
import master.types.AuthType;

@Repository("masterDAO")
public class MasterDAOImpl implements MasterDAO {
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
    private EntityManager em;


	@Override
	@Transactional
	public Master insertNewMasterInfo(Master addMaster) {
		   if(em.find(addMaster.getClass(), addMaster.getEmail())!=null){
	            return null;
	        }
	       
	        em.persist(addMaster);

		return addMaster;
	}

	@Override
	public Master getMasterInfo(Master master) {
		Master master1 = new Master();		
		if((master1 = em.find(Master.class, master.getEmail()))!=null){
//			Master master = em.find(Master.class, updateMaster.getEmail());
			if(master1.getPassword().equals(master.getPassword())){
				return master1;
			}
		}
		return null;
	}

	@Override
	public Master loginMaster(AuthType updateMaster) {
		Master master = new Master();
		
		if((master = em.find(Master.class, updateMaster.getEmail()))!=null){
//			Master master = em.find(Master.class, updateMaster.getEmail());
			if(master.getPassword().equals(updateMaster.getPassword())){
				return master;
			}
		}
		return null;
	}

	@Override
	public String removeMasterInfo(Master removeMaster) {
		 if(em.find(removeMaster.getClass(), removeMaster.getEmail())!=null){
			 Master master = em.find(removeMaster.getClass(), removeMaster.getEmail());
			 em.getTransaction().begin();
			 
			 if( master.getPassword().equals(removeMaster.getPassword())){
				 
			 return "OK";
			 }
			 return "Wrong password";
	        }
		 return "NULL";
	}

	@Override
	public List<Master> getAllBookInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
