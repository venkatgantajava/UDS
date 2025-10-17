

package com.ecrops.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ecrops.dto.MAOresetPassword;
import com.ecrops.dto.ReportMaoDTO;
import com.ecrops.entity.MandalsFusersho;








@Repository
@Transactional
public class UDSReportsRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ReportMaoDTO> getQuantity(HttpSession session) {

    	Integer role=Integer.parseInt( session.getAttribute("role").toString());
		
    	
    	
        String sql = "SELECT count(transactionid) as count, wbedname, wbemname, vsname, SUM(quantity_req) AS quantity FROM uds.input_distribution_det_v  "
        		+ "  ";
        if(role == 9)
        		sql+= "WHERE wbdcode = ? ";
        else if(role == 5)
        	sql+= "WHERE wbdcode=? and wbmcode = ? ";
        else  if(role == 25)
        	sql+= "WHERE wbdcode=? and  wbmcode = ? and regunitcode=? ";

        
        		sql+= " GROUP BY  wbedname, wbemname, vsname;";
        		


        Query query = entityManager.createNativeQuery(sql);
        if(role == 9) {
        query.setParameter(1, (Integer) session.getAttribute("wbdcode"));
        }
        else  if(role == 5) {
        	 query.setParameter(1, (Integer) session.getAttribute("wbdcode"));
        	 query.setParameter(2, (Integer) session.getAttribute("wbmcode"));
        }
        else if(role == 25) {
        	 query.setParameter(1, (Integer) session.getAttribute("wbdcode"));
        	 query.setParameter(2, (Integer) session.getAttribute("wbmcode"));
        	 query.setParameter(3,Integer.parseInt( session.getAttribute("vscode").toString()));
        	 
        }

       
        List<Object[]> results = query.getResultList();

        List<ReportMaoDTO> dtos = new ArrayList<>();
        for (Object[] row : results) {
            ReportMaoDTO dto = new ReportMaoDTO();
            dto.setTransactionId((Number)row[0]);            
            dto.setWbedName((String) row[1]);                   
            dto.setWbemName((String) row[2]);                  
            dto.setVsName((String) row[3]);                    
            dto.setQuantity(((Number) row[4]).intValue());      
            dtos.add(dto);
        }

        return dtos;
    }
    
    
    
    public List<ReportMaoDTO> getQuantityQ(HttpSession session) {
    	
    	Integer role= Integer.parseInt( session.getAttribute("role").toString());
    	String sql = "SELECT count(transactionid) as count, wbedname, wbemname, vsname, cropnameeng,cr_crop, SUM(quantity_req) AS quantity FROM uds.input_distribution_det_v "
    			+ " ";
    	  if(role == 9)
      		sql+= "WHERE wbdcode = ? ";
    	  else if(role == 5)
      	sql+= "WHERE wbdcode=? and wbmcode = ? ";
    	  else  if(role == 25)
      	sql+= "WHERE wbdcode=? and  wbmcode = ? and regunitcode=? ";
    		
    			sql+= " GROUP BY  wbedname, wbemname, vsname, cropnameeng,cr_crop";


    			System.err.println("sql===>"+sql);
    			
        Query query = entityManager.createNativeQuery(sql);
        if(role == 9) {
            query.setParameter(1, (Integer) session.getAttribute("wbdcode"));
            }
        else if(role == 5) {
            	 query.setParameter(1, (Integer) session.getAttribute("wbdcode"));
            	 query.setParameter(2, (Integer) session.getAttribute("wbmcode"));
            }
        else if(role == 25) {
            	 query.setParameter(1, (Integer) session.getAttribute("wbdcode"));
            	 query.setParameter(2, (Integer) session.getAttribute("wbmcode"));
            	 query.setParameter(3, Integer.parseInt( session.getAttribute("vscode").toString()));
            	 
            }

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();

        List<ReportMaoDTO> dtos = new ArrayList<>();
        for (Object[] row : results) {
            ReportMaoDTO dto = new ReportMaoDTO();
            dto.setTransactionId(((Number) row[0]).longValue());   
            dto.setWbedName((String) row[1]);                      
            dto.setWbemName((String) row[2]);                      
            dto.setVsName((String) row[3]);                        
            dto.setCropNameEng((String) row[4]);                   
            dto.setCrCrop(((Number) row[5]).intValue());           
            dto.setQuantity(((Number) row[6]).intValue());  
           
            dtos.add(dto);
        }

        return dtos;
    }



    public List<MAOresetPassword> getRsk(String useridPattern) {
        String sql = "SELECT userid FROM user_registration WHERE userid LIKE 'RBK_%' AND blockortehsil = ?";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, useridPattern);
        
        List<MAOresetPassword> dt = new ArrayList<>();
        List<String> results = query.getResultList();
        
        for (String row : results) {
        	MAOresetPassword dto = new MAOresetPassword();
            dto.setMandalName(row);
            dt.add(dto);
        }
        

        return dt;
    }


    public List<MAOresetPassword> getMao(String dcode) {
        String sql = "select userid from user_registration where userid like 'MAO_%' and district = ?;";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, dcode);
        
        List<MAOresetPassword> dt = new ArrayList<>();
        List<String> results = query.getResultList();
        
        for (String row : results) {
        	MAOresetPassword dto = new MAOresetPassword();
            dto.setDistName(row);
            dt.add(dto);
        }
        

        return dt;
    }
    
    
}
