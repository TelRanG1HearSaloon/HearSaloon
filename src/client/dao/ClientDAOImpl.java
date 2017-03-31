package client.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import master.models.Client;
import master.models.Master;

@Repository("clientDAO")
public class ClientDAOImpl implements ClientDAO{
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
	
	
	
	@Override
	@Transactional
	public Client insertNewClientInfo(Client client) {
		   if(em.find(client.getClass(), client.getClientEmail())!=null){
	            return null;
	        }
	       
	        em.persist(client);

		return client;
	}

	@Override
	public Client loginClient(Client client) {
		Client client2 = new Client();
		if((client2 = em.find(Client.class, client.getClientEmail()))!=null){
//			Master master = em.find(Master.class, updateMaster.getEmail());
			if(client.getClientPassword().equals(client2.getClientPassword())){
				return client2;
			}
		}
		return null;
	}

	@Override
	public Client updateClientInfo(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client removeClientInfo(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

}
