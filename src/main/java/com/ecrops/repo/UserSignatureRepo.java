package com.ecrops.repo;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ecrops.entity.UserSignature;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserSignatureRepo {

	@PersistenceContext
	private EntityManager entitymanger;

	public List<UserSignature> getData() {
		
		String qry = "select \r\n"
				+ "	a.userid, \r\n"
				+ "	a.signature,\r\n"
				+ "	b.name,c.divname\r\n"
				+ "from farmmechanization.user_signatures a,user_registration b,public.adadivisions_v c  where a.userid like 'ADA%'  "
				+ "and a.status='A'\r\n"
				+ "and a.userid=b.userid and c.newdivcode=b.blockortehsil and c.newdivcode= right(a.userid, length(a.userid)-4) "
				+ " and b.blockortehsil = right(a.userid, length(a.userid)-4)\r\n"
				+ "order by a.userid::::varchar";

	    Query query = entitymanger.createNativeQuery(qry);

	    List<Object[]> result = query.getResultList();
	    
	    List<UserSignature> list = new ArrayList<>();

	    for (Object[] bean : result) {
	    	
	    	UserSignature userSignature = new UserSignature();
	        
	    	userSignature.setUserid((String) bean[0]);
	    	userSignature.setSignature((String) bean[1]);
	    	userSignature.setUserName(bean[2].toString());
	    	userSignature.setDivName(bean[3].toString());
	    	
	        list.add(userSignature);
	    }
	    return list;
	}
	
public List<UserSignature> getDataForAda(String userid) {
		
		String qry = "select \r\n"
				+ "	a.userid, \r\n"
				+ "	a.signature,\r\n"
				+ "	b.name,c.divname\r\n"
				+ "from farmmechanization.user_signatures a,user_registration b,public.adadivisions_v c  where a.userid = ?  "
				+ "and a.status='A'\r\n"
				+ "and a.userid=b.userid and c.newdivcode=b.blockortehsil and c.newdivcode= right(a.userid, length(a.userid)-4) "
				+ " and b.blockortehsil = right(a.userid, length(a.userid)-4)\r\n"
				+ "order by a.userid::::varchar";

	    Query query = entitymanger.createNativeQuery(qry);
	    query.setParameter(1, userid);

	    List<Object[]> result = query.getResultList();
	    
	    List<UserSignature> list = new ArrayList<>();

	    for (Object[] bean : result) {
	    	
	    	UserSignature userSignature = new UserSignature();
	        
	    	userSignature.setUserid((String) bean[0]);
	    	userSignature.setSignature((String) bean[1]);
	    	userSignature.setUserName(bean[2].toString());
	    	userSignature.setDivName(bean[3].toString());
	    	
	        list.add(userSignature);
	    }
	    return list;
	}

	
}
