package com.ecrops.repo;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component; 

@Component
public class UserRegistrationUpdate {
	
	@javax.persistence.PersistenceContext
	private javax.persistence.EntityManager entityManager;
	
	@javax.transaction.Transactional
	public int updateUserReg(String newpassword, String username, String dcode) {
//		System.out.println("newpassword------------->"+newpassword);
//		System.out.println("username------------->"+username);
//		System.out.println("dcode------------->"+dcode);
		String qry="update user_registration set  uds_encpassword=? ,last_pwdupd_dt=now() where district=?  and userid=?";
	     Query   query =   entityManager.createNativeQuery(qry);
		query.setParameter(1, newpassword);
		query.setParameter(2, dcode);
		query.setParameter(3, username);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
		
		@javax.transaction.Transactional
			public int updateUserReg(String newpassword, String username) {
//			System.out.println("newpassword------------->"+newpassword);
//			System.out.println("username------------->"+username);
			String qry="update user_registration set  uds_encpassword=? ,last_pwdupd_dt=now() where  userid=?";
		     Query   query =   entityManager.createNativeQuery(qry);
			query.setParameter(1, newpassword);
			query.setParameter(2, username);
			int executeUpdate = query.executeUpdate();
			return executeUpdate;
		}
		
	
	@javax.transaction.Transactional
	public int updateUserRegMao(String newpassword, String username, String dcode,String mcode) {
//		System.out.println("--------->"+newpassword);
//		System.out.println("--------->"+username);
//		System.out.println("--------->"+dcode);
//		System.out.println("--------->"+mcode);
		String qry="update user_registration set  uds_encpassword=? ,last_pwdupd_dt=now() where district=?  and userid=? and blockortehsil=?";
	     Query   query =   entityManager.createNativeQuery(qry);
		query.setParameter(1, newpassword);
		query.setParameter(2, dcode);
		query.setParameter(3, username);
		query.setParameter(4, mcode);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
	
	@Transactional
	public int insertTracer(String userid, String username, String dcode) {
		System.out.println("userid---------->"+userid);
		System.out.println("username---------->"+username);
		String qry="insert into tracerweb(username,status,affecteduser) values(?,?,?)";
	    Query query = entityManager.createNativeQuery(qry);
		query.setParameter(1, userid);
		query.setParameter(2, "Password Reset by Admin");
		query.setParameter(3, username);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
	
	@Transactional
	public int insertTracer(String userid, String username) {
		System.out.println("userid---------->"+userid);
		System.out.println("username---------->"+username);
		String qry="insert into tracerweb(username,status,affecteduser) values(?,?,?)";
	    Query query = entityManager.createNativeQuery(qry);
		query.setParameter(1, userid);
		query.setParameter(2, "Password Reset by Admin");
		query.setParameter(3, username);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
	
	@Transactional
	public int insertTracerMao(String userid, String username, String dcode,String mcode) {
		String qry="insert into tracerweb(username,status,affecteduser) values(?,?,?)";
	    Query query = entityManager.createNativeQuery(qry);
		query.setParameter(1, userid);
		query.setParameter(2, "Password Reset by MAO");
		query.setParameter(3, username);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
	
	@javax.transaction.Transactional
	public int updateUserRegMro(String newpassword, String username, String dcode,String mcode) {
//		System.out.println("--------->"+newpassword);
//		System.out.println("--------->"+username);
//		System.out.println("--------->"+dcode);
//		System.out.println("--------->"+mcode);
		String qry="update user_registration set  uds_encpassword=? ,last_pwdupd_dt=now() where district=?  and userid=? and blockortehsil=?";
	     Query   query =   entityManager.createNativeQuery(qry);
		query.setParameter(1, newpassword);
		query.setParameter(2, dcode);
		query.setParameter(3, username);
		query.setParameter(4, mcode);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
	
	
	@Transactional
	public int insertTracerMro(String userid, String username, String dcode,String mcode) {
//		System.out.println("----------->"+userid);
//		System.out.println("----------->"+username);
//		System.out.println("----------->"+dcode);
//		System.out.println("----------->"+userid);
		String qry="insert into tracerweb(username,status,affecteduser) values(?,?,?)";
	    Query query = entityManager.createNativeQuery(qry);
		query.setParameter(1, userid);
		query.setParameter(2, "Password Reset by MRO");
		query.setParameter(3, username);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}


}
