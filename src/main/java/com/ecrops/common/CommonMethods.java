//package com.ecrops.common;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.StringReader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Properties;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.xml.sax.InputSource;
//
//import com.ecrops.entity.Base64Utils;
//import com.ecrops.entity.ResponseBean;
//import com.ecrops.entity.XmlUtilityMethods;
//import com.ecrops.util.SqlDBUtil;
//
//public class CommonMethods {
//
//	@SuppressWarnings("unused")
//	public String authenticateasaEkycOtpGen
////	(String Uid, String servType, String lat, String lng, String macaddr,
////			String consent, String env, String deviceid, String shrc, String version, String rrn, String ref)
//	(String Uid)
//			throws Exception {
//		SqlDBUtil sql = new SqlDBUtil();
//		PreparedStatement ps = null, ps1 = null;
//		ResultSet rs = null;
//		Connection conn = null;
//
//		String rc = "Y";
//		String udc = "123456";
//		String rrnStr = "";
//		String res = "";
//		String slk = "";
//		String piddataxml = "";
//		String txnOtp = "";
//	//	deviceid = "public";
//		String ASA_lk = "", postal_code = "", cert_ExpDate = "";
//
//		Properties props;
//
//		ResponseBean responseBean = new ResponseBean();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		String time = sdf.format(new Date());
//
//		props = new Properties();
//
//		Authentication authentication = null;
//		String resp = "", statusDes = "";
//		int status = 0;
//		conn = sql.getConnection();
//		try {
////			props.load(new FileInputStream(
////					"/usr/share/apache-tomcat-8.5.68/webapps/eKarshakServices/WEB-INF/resources/application.properties"));
//			props.load(new FileInputStream("D:/FM LiveCode/farmmechanization_22012025/farmmechanization/src/main/resources/application.properties"));
//		} catch (FileNotFoundException e) {
//			try {
//
//				props.load(new FileInputStream("D:/FM LiveCode/farmmechanization_22012025/farmmechanization/src/main/resources/application.properties"));
//			} catch (Exception ex) {
//				responseBean.setStatus("0");
//				responseBean.setMsg(ex.getMessage());
//			}
//			e.printStackTrace();
//			responseBean.setStatus("0");
//			responseBean.setMsg(e.getMessage());
//		} catch (Exception e) {
//			responseBean.setStatus("0");
//			responseBean.setMsg(e.getMessage());
//		}
//
//		try {
//			authentication = new Authentication(props);
//			AUAKUAParameters ekycauakuaOtpGenParameters = new AUAKUAParameters();
//			ekycauakuaOtpGenParameters.setLAT("1.0");
//			ekycauakuaOtpGenParameters.setLONG("1.0");
//			ekycauakuaOtpGenParameters.setDEVMACID("1.5567868");
//			ekycauakuaOtpGenParameters.setDEVID("deviceid");
//			ekycauakuaOtpGenParameters.setCONSENT("Y");
//			ekycauakuaOtpGenParameters.setSHRC("Y");
//			ekycauakuaOtpGenParameters.setVER("2.5");
//			ekycauakuaOtpGenParameters.setSERTYPE("10");
//			ekycauakuaOtpGenParameters.setENV("2");
//			ekycauakuaOtpGenParameters.setCH("1");
//			ekycauakuaOtpGenParameters.setUDC("123456");
//			ekycauakuaOtpGenParameters.setAADHAARID(Uid);
//			ekycauakuaOtpGenParameters.setRRN("Y");
//			ekycauakuaOtpGenParameters.setREF("Y");
//
//			AUAKUAResponse ekycauakuaResponse = authentication.generateOTP(ekycauakuaOtpGenParameters);
//			status = ekycauakuaResponse.getStatus();
//			statusDes = ekycauakuaResponse.getStatusDescription();
//			resp = ekycauakuaResponse.getResponse();
//			
//			System.out.println("ACTUALRESPONSE--------------------->"+resp);
//			JSONObject authResp = new JSONObject(resp);
//			System.out.println("response---->"+authResp);
//			String txn = authResp.getString("txn");
//			String uidValues[], uidToken = "", uidType = "";
//			String ptxnStr = authResp.getString("txn");
//			if (status == 200) {
//
//				uidToken = "";
//				uidType = "";
//
//				if ("y".equalsIgnoreCase(authResp.getString("ret"))) {
//
//					responseBean.setStatus("1");
//					responseBean.setMsg("Authentication Succeded");
//
//					String data = new String(Base64Utils.base64Decode(authResp.getString("responseXML")));
//
//					String infoattr = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//							.parse(new InputSource(new StringReader(data))).getDocumentElement().getAttribute("info");
//
//					uidValues = infoattr.substring(infoattr.indexOf("{") + 1, infoattr.indexOf("}")).split(",");
//					uidToken = uidValues[0];
//					uidType = uidValues[1];
//				} else {
//					responseBean.setStatus("0");
//					responseBean.setMsg("Authentication Failed");
//
//				}
//			} else {
//				responseBean.setStatus("0");
//				responseBean.setMsg("Authentication Failed");
//			}
//		} catch (Exception e) {
//			responseBean.setMsg("Improper Data");
//			responseBean.setStatus("0");
//			e.printStackTrace();
//
//		} finally {
//			if (conn != null) {
//				conn.close();
//			}
//			if (rs != null) {
//				rs.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//		}
//		return resp;
//	}
//	
//	
//	
////	@SuppressWarnings("unused")
////	public ResponseBean authenticateasaEkycOtpGen(String Uid, String servType, String lat, String lng, String macaddr,
////			String consent, String env, String deviceid, String shrc, String version, String rrn, String ref)
////			throws Exception {
////		SqlDBUtil sql = new SqlDBUtil();
////		PreparedStatement ps = null, ps1 = null;
////		ResultSet rs = null;
////		Connection conn = null;
////
////		String rc = "Y";
////		String udc = "123456";
////		String rrnStr = "";
////		String res = "";
////		String slk = "";
////		String piddataxml = "";
////		String txnOtp = "";
////		deviceid = "public";
////		String ASA_lk = "", postal_code = "", cert_ExpDate = "";
////
////		Properties props;
////
////		ResponseBean responseBean = new ResponseBean();
////
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
////		String time = sdf.format(new Date());
////
////		props = new Properties();
////
////		Authentication authentication = null;
////		String resp = "", statusDes = "";
////		int status = 0;
////		conn = sql.getConnection();
////		try {
//////			props.load(new FileInputStream(
//////					"/usr/share/apache-tomcat-8.5.68/webapps/eKarshakServices/WEB-INF/resources/application.properties"));
////			props.load(new FileInputStream("C:/Users/HP/Desktop/Virat/farmmechanization/farmmechanization/src/main/resources/application.properties"));
////		} catch (FileNotFoundException e) {
////			try {
////
////				props.load(new FileInputStream("C:/Users/HP/Desktop/Virat/farmmechanization/farmmechanization/src/main/resources/application.properties"));
////			} catch (Exception ex) {
////				responseBean.setStatus("0");
////				responseBean.setMsg(ex.getMessage());
////			}
////			e.printStackTrace();
////			responseBean.setStatus("0");
////			responseBean.setMsg(e.getMessage());
////		} catch (Exception e) {
////			responseBean.setStatus("0");
////			responseBean.setMsg(e.getMessage());
////		}
////
////		try {
////			authentication = new Authentication(props);
////			AUAKUAParameters ekycauakuaOtpGenParameters = new AUAKUAParameters();
////			ekycauakuaOtpGenParameters.setLAT(lat);
////			ekycauakuaOtpGenParameters.setLONG(lng);
////			ekycauakuaOtpGenParameters.setDEVMACID(macaddr);
////			ekycauakuaOtpGenParameters.setDEVID(deviceid);
////			ekycauakuaOtpGenParameters.setCONSENT(consent);
////			ekycauakuaOtpGenParameters.setSHRC(shrc);
////			ekycauakuaOtpGenParameters.setVER(version);
////			ekycauakuaOtpGenParameters.setSERTYPE(servType);
////			ekycauakuaOtpGenParameters.setENV(env);
////			ekycauakuaOtpGenParameters.setCH("1");
////			ekycauakuaOtpGenParameters.setUDC("123456");
////			ekycauakuaOtpGenParameters.setAADHAARID(Uid);
////			ekycauakuaOtpGenParameters.setRRN(rrn);
////			ekycauakuaOtpGenParameters.setREF(ref);
////
////			AUAKUAResponse ekycauakuaResponse = authentication.generateOTP(ekycauakuaOtpGenParameters);
////			status = ekycauakuaResponse.getStatus();
////			statusDes = ekycauakuaResponse.getStatusDescription();
////			resp = ekycauakuaResponse.getResponse();
////			JSONObject authResp = new JSONObject(resp);
////			System.out.println("response---->"+authResp);
////			String txn = authResp.getString("txn");
////			String uidValues[], uidToken = "", uidType = "";
////			String ptxnStr = authResp.getString("txn");
////			if (status == 200) {
////
////				uidToken = "";
////				uidType = "";
////
////				if ("y".equalsIgnoreCase(authResp.getString("ret"))) {
////
////					responseBean.setStatus("1");
////					responseBean.setMsg("Authentication Succeded");
////
////					String data = new String(Base64Utils.base64Decode(authResp.getString("responseXML")));
////
////					String infoattr = DocumentBuilderFactory.newInstance().newDocumentBuilder()
////							.parse(new InputSource(new StringReader(data))).getDocumentElement().getAttribute("info");
////
////					uidValues = infoattr.substring(infoattr.indexOf("{") + 1, infoattr.indexOf("}")).split(",");
////					uidToken = uidValues[0];
////					uidType = uidValues[1];
////				} else {
////					responseBean.setStatus("0");
////					responseBean.setMsg("Authentication Failed");
////
////				}
////			} else {
////				responseBean.setStatus("0");
////				responseBean.setMsg("Authentication Failed");
////			}
////		} catch (Exception e) {
////			responseBean.setMsg("Improper Data");
////			responseBean.setStatus("0");
////			e.printStackTrace();
////
////		} finally {
////			if (conn != null) {
////				conn.close();
////			}
////			if (rs != null) {
////				rs.close();
////			}
////			if (ps != null) {
////				ps.close();
////			}
////		}
////		return responseBean;
////	}
//
//	
//	
//	
////	@SuppressWarnings({ "unused", "static-access" })
////	public ResponseBean authenticateasaEkycOtpAuth(String Uid, String servType, String otp,String txnOtp) throws Exception {
////		SqlDBUtil sql = new SqlDBUtil();
////		PreparedStatement ps = null, ps1 = null, ps2 = null;
////		ResultSet rs = null;
////		Connection conn = null;
////		String devid = "public";
////		String Name = "";
////		String DOB = "";
////		String Gender = "";
////		String MS = "";
////		String MV = "";
////		String AV = "";
////		String Hno = "";
////		String slk = "";
////		String piddataxml = "";
////		Properties props;
////		ResponseBean responseBean = new ResponseBean();
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
////		String time = sdf.format(new Date());
////		props = new Properties();
////		Authentication authentication = null;
////		String resp = "", statusDes = "";
////		int status = 0;
////		conn = sql.getConnection();
////		try {
//////			props.load(new FileInputStream(
//////					"/usr/share/apache-tomcat-8.5.68/webapps/eKarshakServices/WEB-INF/resources/application.properties"));
////			 props.load(new FileInputStream("C:/Users/HP/Desktop/Virat/farmmechanization/farmmechanization/src/main/resources/application.properties"));
////		} catch (FileNotFoundException e) {
////			try {
////				props.load(new FileInputStream("C:/Users/HP/Desktop/Virat/farmmechanization/farmmechanization/src/main/resources/application.properties"));
////			} catch (Exception ex) {
////				responseBean.setStatus("0");
////				responseBean.setMsg(ex.getMessage());
////			}
////			e.printStackTrace();
////			responseBean.setStatus("0");
////			responseBean.setMsg(e.getMessage());
////		} catch (Exception e) {
////			responseBean.setStatus("0");
////			responseBean.setMsg(e.getMessage());
////		}
////		try {
////			authentication = new Authentication(props);
////			AUAKUAParameters ekycOtpauakuaParameters = new AUAKUAParameters();
////			ekycOtpauakuaParameters.setLAT("17.678765");
////			ekycOtpauakuaParameters.setLONG("78.3456");
////			ekycOtpauakuaParameters.setDEVMACID("76:de:45:ed:4e:4e");
////			ekycOtpauakuaParameters.setDEVID("public");
////			ekycOtpauakuaParameters.setCONSENT("Y");
////			ekycOtpauakuaParameters.setSHRC("Y");
////			ekycOtpauakuaParameters.setVER("2.5");
////			ekycOtpauakuaParameters.setSERTYPE("05");
////			ekycOtpauakuaParameters.setENV("2");
////			ekycOtpauakuaParameters.setAADHAARID(Uid);
////			ekycOtpauakuaParameters.setSLK(slk);
////			ekycOtpauakuaParameters.setRRN(time);
////			ekycOtpauakuaParameters.setREF("REF:" + time);
////			ekycOtpauakuaParameters.setTXN(txnOtp);
////			ekycOtpauakuaParameters.setUDC("123456");
////			ekycOtpauakuaParameters.setDATA(piddataxml);
////			ekycOtpauakuaParameters.setOTP(otp);
////			ekycOtpauakuaParameters.setPFR("N");
////			ekycOtpauakuaParameters.setLANG("N");
////			AUAKUAResponse ekycOtpauakuaResponse = authentication.doKYC(ekycOtpauakuaParameters);
////			status = ekycOtpauakuaResponse.getStatus();
////			statusDes = ekycOtpauakuaResponse.getStatusDescription();
////			resp = ekycOtpauakuaResponse.getResponse();
////			JSONObject authResp = new JSONObject(resp);
////			String txn = authResp.getString("txn");
////			String uidValues[], uidToken = "", uidType = "";
////			if (status == 200) {
////				uidToken = "";
////				uidType = "";
////				if ("n".equalsIgnoreCase(authResp.getString("ret"))) {
////					responseBean.setStatus("0");
////					responseBean.setMsg(authResp.getString("errdesc"));
////				} else if ("y".equalsIgnoreCase(authResp.getString("ret"))) {
////					responseBean.setStatus("1");
////					responseBean.setMsg("Authentication Succeded");
////					XmlUtilityMethods method = new XmlUtilityMethods();
////					String data = new String(Base64Utils.base64Decode(authResp.getString("responseXML")));
////					HashMap<String, String> encElementMap = method.getEkycMapData(data);
////					System.out.println("Name: " + encElementMap.get("Poi_name"));
////					System.out.println("Gender: " + encElementMap.get("Poi_gender"));
////					System.out.println("Dob: " + encElementMap.get("Poi_dob"));
////					System.out.println("house: " + encElementMap.get("Poa_house"));
////					System.out.println("street: " + encElementMap.get("Poa_street"));
////					System.out.println("co: " + encElementMap.get("Poa_co"));
////					System.out.println("country: " + encElementMap.get("Poa_country"));
////					System.out.println("dist: " + encElementMap.get("Poa_dist"));
////					System.out.println("lm: " + encElementMap.get("Poa_lm"));
////					System.out.println("loc: " + encElementMap.get("Poa_loc"));
////					System.out.println("vtc: " + encElementMap.get("Poa_vtc"));
////					System.out.println("pc: " + encElementMap.get("Poa_pc"));
////
////				} else {
////					responseBean.setStatus("0");
////					responseBean.setMsg("Authentication Failed2");
////				}
////			} else {
////				responseBean.setStatus("0");
////				responseBean.setMsg("Authentication Failed3");
////			}
////		} catch (Exception e) {
////			responseBean.setMsg("Improper Data");
////			responseBean.setStatus("0");
////			e.printStackTrace();
////		} finally {
////			if (conn != null) {
////				conn.close();
////			}
////			if (rs != null) {
////				rs.close();
////			}
////			if (ps != null) {
////				ps.close();
////			}
////		}
////		return responseBean;
////	}
//	
//	
//	
//	
//	@SuppressWarnings({ "unused", "static-access" })
//	public JSONObject authenticateasaEkycOtpAuth(String Uid, String otp, String txnOtp) throws Exception {
//	    SqlDBUtil sql = new SqlDBUtil();
//	    PreparedStatement ps = null, ps1 = null, ps2 = null;
//	    ResultSet rs = null;
//	    Connection conn = null;
//	    String devid = "public";
//	    String Name = "";
//	    String DOB = "";
//	    String Gender = "";
//	    String MS = "";
//	    String MV = "";
//	    String AV = "";
//	    String Hno = "";
//	    String slk = "";
//	    String piddataxml = "";
//	    Properties props;
//	    JSONObject jsonResponse = null;
//	    ResponseBean responseBean = new ResponseBean();
//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//	    String time = sdf.format(new Date());
//	    props = new Properties();
//	    Authentication authentication = null;
//	    String resp = "", statusDes = "";
//	    int status = 0;
//	    conn = sql.getConnection();
//
//	    try {
//	        // Load properties file
//	        props.load(new FileInputStream("D:/FM LiveCode/farmmechanization_22012025/farmmechanization/src/main/resources/application.properties"));
//
//	        authentication = new Authentication(props);
//	        AUAKUAParameters ekycOtpauakuaParameters = new AUAKUAParameters();
//	        
//	        ekycOtpauakuaParameters.setLAT("17.678765");
//	        ekycOtpauakuaParameters.setLONG("78.3456");
//	        ekycOtpauakuaParameters.setDEVMACID("76:de:45:ed:4e:4e");
//	        ekycOtpauakuaParameters.setDEVID("public");
//	        ekycOtpauakuaParameters.setCONSENT("Y");
//	        ekycOtpauakuaParameters.setSHRC("Y");
//	        ekycOtpauakuaParameters.setVER("2.5");
//	        ekycOtpauakuaParameters.setSERTYPE("05");
//	        ekycOtpauakuaParameters.setENV("2");
//	        ekycOtpauakuaParameters.setAADHAARID(Uid);
//	        ekycOtpauakuaParameters.setSLK(slk);
//	        ekycOtpauakuaParameters.setRRN(time);
//	        ekycOtpauakuaParameters.setREF("REF:" + time);
//	        ekycOtpauakuaParameters.setTXN(txnOtp);
//	        ekycOtpauakuaParameters.setUDC("123456");
//	        ekycOtpauakuaParameters.setDATA(piddataxml);
//	        ekycOtpauakuaParameters.setOTP(otp);
//	        ekycOtpauakuaParameters.setPFR("N");
//	        ekycOtpauakuaParameters.setLANG("N");
//	        
//	        AUAKUAResponse ekycOtpauakuaResponse = authentication.doKYC(ekycOtpauakuaParameters);
//	        
//	        status = ekycOtpauakuaResponse.getStatus();
//	        System.out.println("status----------------------------->" + status);
//	        statusDes = ekycOtpauakuaResponse.getStatusDescription();
//	        System.out.println("statusDes----------------------------->" + statusDes);
//
//	        resp = ekycOtpauakuaResponse.getResponse();
//	        System.out.println("resp----------------------------->" + resp);
//
//	        JSONObject authResp = new JSONObject(resp);
//	        System.out.println("authResp----------------------------->" + authResp);
//
//	        String txn = authResp.getString("txn");
//	        
//	        if (status == 200) {
//	        	if ("n".equalsIgnoreCase(authResp.getString("ret"))) {
//	                responseBean.setStatus("0");
//	                responseBean.setMsg(authResp.getString("errdesc"));
//	                System.out.println("authResp.getString(\"errdesc\")------------>" + authResp.getString("errdesc"));
//
//	                // Ensure the responseXML exists
//	                if (authResp.has("responseXML")) {
//	                    String data = new String(Base64Utils.base64Decode(authResp.getString("responseXML")));
//	                    System.out.println("Decoded XML Data------------------->" + data);
//
//	                    XmlUtilityMethods method = new XmlUtilityMethods();
//	                    HashMap<String, String> encElementMap = method.getEkycMapData(data);
//
//	                    if (encElementMap != null) {
//	                        jsonResponse = new JSONObject();
//	                        jsonResponse.put("errdesc",  authResp.getString("errdesc"));
//	                        jsonResponse.put("err",  authResp.getString("err"));
//
//	                    } else {
//	                        System.out.println("Failed to parse XML data.");
//	                        jsonResponse = new JSONObject();
//	                        jsonResponse.put("errdesc", "Parsing error");
//	                    }
//	                } else {
//	                    System.out.println("No responseXML found in authResp.");
//	                    jsonResponse = new JSONObject();
//	                    jsonResponse.put("errdesc", "responseXML not found");
//	                }
//	            }
//	            
//	            else if ("y".equalsIgnoreCase(authResp.getString("ret"))) 
//	            
//	            
//	            {
//	                responseBean.setStatus("1");
//	                responseBean.setMsg("Authentication Succeeded");
//	                XmlUtilityMethods method = new XmlUtilityMethods();
//	                String data = new String(Base64Utils.base64Decode(authResp.getString("responseXML")));
//	                HashMap<String, String> encElementMap = method.getEkycMapData(data);
//
//	                encElementMap.forEach((key, value) -> System.out.println("key--->" + key + " value---------->" + value));
//
//	                // Create JSONObject with only required fields
//	                jsonResponse = new JSONObject();
//	                jsonResponse.put("Name", encElementMap.get("Poi_name"));
//	                jsonResponse.put("Gender", encElementMap.get("Poi_gender"));
//	                jsonResponse.put("Dob", encElementMap.get("Poi_dob"));
//	                jsonResponse.put("house", encElementMap.get("Poa_house"));
//	                jsonResponse.put("street", encElementMap.get("Poa_street"));
//	                jsonResponse.put("co", encElementMap.get("Poa_co"));
//	                jsonResponse.put("country", encElementMap.get("Poa_country"));
//	                jsonResponse.put("dist", encElementMap.get("Poa_dist"));
//	                jsonResponse.put("lm", encElementMap.get("Poa_lm"));
//	                jsonResponse.put("loc", encElementMap.get("Poa_loc"));
//	                jsonResponse.put("vtc", encElementMap.get("Poa_vtc"));
//	                jsonResponse.put("pc", encElementMap.get("Poa_pc"));
//	            }
////	            } else {
////	                responseBean.setStatus("0");
////	                responseBean.setMsg("Authentication Failed");
////	            }
////	        } else {
////	            responseBean.setStatus("0");
////	            responseBean.setMsg("Authentication Failed");
////	        }
//	    } 
//	    }catch (Exception e) {
//	        responseBean.setMsg("Improper Data");
//	        responseBean.setStatus("0");
//	        e.printStackTrace();
//	    } finally {
//	        if (conn != null) {
//	            conn.close();
//	        }
//	        if (rs != null) {
//	            rs.close();
//	        }
//	        if (ps != null) {
//	            ps.close();
//	        }
//	    }
//	    
//	    return jsonResponse;
//	}
//
//
//
//}
