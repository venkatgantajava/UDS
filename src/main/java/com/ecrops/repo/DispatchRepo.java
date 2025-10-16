package com.ecrops.repo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ecrops.entity.DispatchPojo;

import bsh.ParseException;


@Repository
public class DispatchRepo {
	
	@PersistenceContext
	EntityManager entityManager;	
	
	public List<DispatchPojo> getImplementName(int impltypeId){
		
		String sql="select distinct impl_id,impl_name"
				+ " from farmmechanization.impldet_v where impltype_id=? order by impl_name";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, impltypeId);
		
		List<DispatchPojo> pojos= new ArrayList<>();
		List<Object> objects = query.getResultList();

		if (objects != null && objects.size() > 0) {

			for (Object patta : objects) {

				Object[] row = (Object[]) patta;
				DispatchPojo pojo = new DispatchPojo();
				
				pojo.setImpl_id(row[0].toString());
				pojo.setImpl_name(row[1].toString());
				
				pojos.add(pojo);
			}
		}
			return pojos;
				
	}
	public List<DispatchPojo> getImplementName(int impltypeId,int grpid){
		
		String sql="select distinct impl_id,impl_name  from farmmechanization.impldet_v "
				+ "where impltype_id=? and grpid=? order by impl_name";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, impltypeId);
		query.setParameter(2, grpid);
		
		List<DispatchPojo> pojos= new ArrayList<>();
		List<Object> objects = query.getResultList();
		
		if (objects != null && objects.size() > 0) {
			
			for (Object patta : objects) {
				
				Object[] row = (Object[]) patta;
				DispatchPojo pojo = new DispatchPojo();
				
				pojo.setImpl_id(row[0].toString());
				pojo.setImpl_name(row[1].toString());
				
				pojos.add(pojo);
			}
		}
		return pojos;
		
	}
	
	public List<DispatchPojo> getSubCaste(Character caste){
		
		String sql="select subcaste,subcastecode from caste_sub_mst where castecode=? order by subcaste";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, caste);
		
		List<DispatchPojo> pojos= new ArrayList<>();
		List<Object> objects = query.getResultList();
		
		if (objects != null && objects.size() > 0) {
			
			for (Object patta : objects) {
				
				Object[] row = (Object[]) patta;
				DispatchPojo pojo = new DispatchPojo();
				
				pojo.setSubcaste(row[0].toString());
				pojo.setSubcastecode(row[1].toString());
				
				pojos.add(pojo);
			}
		}
		return pojos;
		
	}
	
	
	public List<DispatchPojo> getDet(int districtId,int mandalId, int vsnameId, String manfId){
		
		String qry =" Select wbvcode,  farmername,farmerfname,coalesce (mobileno :::: varchar,' ') as mobileno, address, farmeruid,wbdcode,wbmcode,case when gender='2'"
				+ " then cast('Female' as char) else cast('Male' as char) end as gender,impltype_name,impl_name,quantity,"
				+ "application_id,model_name,mnf_name,wbemname,wbevname,po_number,dt_release,dealer_id,dealer_name,rbkcode,to_char(dt_po,'dd-mm-yyyy') as dt_po from  farmmechanization.getlist_dispatchdetentry_v where wbdcode=? and manufacture_id=? ";
		if(mandalId !=0) {
			qry += "  and wbmcode=?  ";
		}
		if(vsnameId != 0) {
				qry+= "and rbkcode=? ";
		}
		qry +=" order by wbemname,wbevname,application_id";
		Query query = entityManager.createNativeQuery(qry);
		
		query.setParameter(1, districtId);
		query.setParameter(2, Integer.parseInt(manfId));
		if(mandalId !=0) {
		query.setParameter(3, mandalId);
		}
		if(vsnameId !=0) {
		query.setParameter(4, vsnameId);
		}
		
		List<DispatchPojo> pojos= new ArrayList<>();
		List<Object> objects = query.getResultList();

		if (objects != null && objects.size() > 0) {

			for (Object patta : objects) {

				Object[] row = (Object[]) patta;
				DispatchPojo pojo = new DispatchPojo();
				
				pojo.setWbvcode(row[0].toString());
				pojo.setFarmername(row[1].toString());
				pojo.setFathername(row[2].toString());
				pojo.setMobileno(row[3].toString());
				pojo.setAddress(row[4].toString());
				pojo.setFarmeruid(row[5].toString());
				pojo.setWbdcode(row[6].toString());
				pojo.setWbmcode(row[7].toString());
				pojo.setGender(row[8].toString());
				pojo.setImpltype_name(row[9].toString());
				pojo.setImpl_name(row[10].toString());
				pojo.setQuantity(row[11].toString());
				pojo.setApplication_id(row[12].toString());
				pojo.setModel_name(row[13].toString());
				pojo.setMnf_name(row[14].toString());
				pojo.setMandal(row[15].toString());
				pojo.setVillage(row[16].toString());
				pojo.setPo_number(row[17].toString());
				pojo.setRelease(row[18].toString());
				pojo.setDealer_id(((Integer) row[19]).toString());
				pojo.setDealer_name(row[20].toString());
				pojo.setRbkcode(row[21].toString());
				pojo.setDt_po(row[22].toString());
				
				pojos.add(pojo);
			}
		}
			return pojos;
	}
	
	
	
	
	
	
	@Transactional
	public int insert(DispatchPojo dispatchPojo,String userid) {
		
		
		
		
		String sql="select po_number,manufacture_id,dealer_id from farmmechanization.appl_details_v where application_id=?";
		 Query query1 = entityManager.createNativeQuery(sql);
		    query1.setParameter(1,Integer.parseInt(dispatchPojo.getApplication_id()));
		    
		    
	    String qry = "INSERT INTO farmmechanization.dispatch_details (" +
	                 "wbdcode, wbmcode, wbvcode, unitcode, appl_id, " +
	                 "dispatch_dt, dispatch_no, dispatch_address, po_number,mnf_id,dealer_id,crt_dt,crt_user) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?,now() AT TIME ZONE 'Asia/Kolkata',?)";

	    Query query = entityManager.createNativeQuery(qry);

	    query.setParameter(1,Integer.parseInt(dispatchPojo.getWbdcode()));
	    query.setParameter(2, Integer.parseInt(dispatchPojo.getWbmcode()));
	    query.setParameter(3, Integer.parseInt(dispatchPojo.getWbvcode()));
	    query.setParameter(4, Integer.parseInt(dispatchPojo.getRbkcode()));
	    query.setParameter(5, Integer.parseInt(dispatchPojo.getApplication_id()));
	  
	    try {
	    	  String dispatchDateStr = dispatchPojo.getDispatchDate(); // Get the String date in dd-MM-yyyy format
//	    	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy"); // Specify the format for parsing
//	    	    java.util.Date parsedDate = format.parse(dispatchDateStr); // Parse the String to java.util.Date
//	    	    java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

	    	  SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
	          java.util.Date utilDate = inputFormat.parse(dispatchDateStr);
	          java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	         System.out.println("-->"+sqlDate);

	        query.setParameter(6, sqlDate); 
	    } catch (Exception e) {
	    	query.setParameter(6,null);
	        e.printStackTrace();
	      
	    }
	    query.setParameter(7, dispatchPojo.getDispatchNo());
	    query.setParameter(8, dispatchPojo.getDispatchAddress());
	    List<Object[]> resultList = query1.getResultList();
	    Object[] row = resultList.get(0);
	    query.setParameter(9,Integer.parseInt(dispatchPojo.getPo_number())); // po_number

	    query.setParameter(10,Integer.parseInt( row[1].toString())); // manufacture_id
	    query.setParameter(11, Integer.parseInt(row[2].toString())); // dealer_id
	    query.setParameter(12, userid); 

	    int result = query.executeUpdate(); 

	    return result;
	}
	
	
	@Transactional
	   public String updateDispatchStatusMNF(String applicationId) throws ParseException {
	       String msg = "";
	       try {
	           int applId = Integer.parseInt(applicationId);

	          
	           String sqlQuery = "update farmmechanization.appl_details_t set dispatch_status_mnf='Y' where application_id = ?" ;

	           Query query = entityManager.createNativeQuery(sqlQuery);
	           query.setParameter(1, applId);

	           int count = query.executeUpdate();
	           msg = (count > 0) ? "Record updated successfully" : "Failed to insert record";
	       } catch (NumberFormatException e) {
	           msg = "Invalid application ID format: " + applicationId;
	           e.printStackTrace(); 
	       } catch (Exception e) {
	           msg = "Error inserting record: " + e.getMessage();
	           e.printStackTrace(); 
	       }

	       return msg;
	   }
	
	@Transactional
	public void insertWhenLogin(String userid,String ip) {
		String sql="insert into usrlogsweb values('"+userid+"',null,now()  AT TIME ZONE 'Asia/Kolkata',null,'"+ip+"','UDS')";
		 Query query = entityManager.createNativeQuery(sql);
		 query.executeUpdate();
	}
	
	@Transactional
	public String checkInUid(String uid) {
		String sql="select coalesce(farmer_type,' ') from ecrop2024.jointlpnos_uids where cr_farmeruid =?  and extent is not null and extent >0";
		Query qry=entityManager.createNativeQuery(sql);
		qry.setParameter(1, uid);
		try {
		return qry.getSingleResult().toString();
		}
		catch(Exception e) {
			return " ";
		}
	}
	

}
