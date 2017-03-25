package client.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import master.models.Client;

@Repository("clientDAO")
public class ClientDAOImpl implements ClientDAO{
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
	@Override
	public Client insertNewClientInfo(Client client) {
		   if(em.find(client.getClass(), client.getLogin())!=null){
	            return null;
	        }
	       
	        em.persist(client);

		return client;
	}

	@Override
	public Client getClietnInfo(Client client) {
		// TODO Auto-generated method stub
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
