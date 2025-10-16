//package com.ecrops.service;
//
//import org.ksoap2.SoapEnvelope;
//
//import org.ksoap2.serialization.SoapObject;
//import org.ksoap2.serialization.SoapSerializationEnvelope;
//import org.ksoap2.transport.HttpTransportSE;
//import org.springframework.stereotype.Service;
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import org.xml.sax.InputSource;
//import java.io.StringReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//@Service
//public class WebLandService {
//
//    public List<HashMap<String, String>> webLandClient(String UID, String webLandDcode) {
//        List<HashMap<String, String>> memberMapList = new ArrayList<>();
//        try {
//            String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
//            String SOAP_ADDRESS_statewise = "http://uatwebland.ap.gov.in/StateWiseSearchOnUID.asmx";
//            String OPERATION_NAME = "StateWiseSearchBasedonUID";
//            String SOAP_ACTION = WSDL_TARGET_NAMESPACE + OPERATION_NAME;
//
//            SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, OPERATION_NAME);
//            request.addProperty("UID", UID);
//            request.addProperty("Dcode", webLandDcode);
//            request.addProperty("usr_id", "WebLand");
//            request.addProperty("pwd", "WebLand@APNIC");
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//
//            HttpTransportSE httpTransportSE = new HttpTransportSE(SOAP_ADDRESS_statewise);
//            httpTransportSE.debug = true;
//            httpTransportSE.call(SOAP_ACTION, envelope);
//
//            Object soapResultAsObj = envelope.getResponse();
//            String strXML = soapResultAsObj.toString();
//
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            InputSource is = new InputSource(new StringReader(strXML));
//            Document doc = db.parse(is);
//
//            NodeList cardNodeList = doc.getElementsByTagName("DocumentElement");
//            if (cardNodeList.getLength() > 0) {
//                NodeList cardChildNodeList = cardNodeList.item(0).getChildNodes();
//                HashMap<String, String> cardMap = new HashMap<>();
//                for (int xx = 0; xx < cardChildNodeList.getLength(); xx++) {
//                    cardMap.put(cardChildNodeList.item(xx).getNodeName(), cardChildNodeList.item(xx).getTextContent());
//                }
//
//                NodeList memberNodeList = doc.getElementsByTagName("AadharDetails");
//                for (int yy = 0; yy < memberNodeList.getLength(); yy++) {
//                    HashMap<String, String> memberMap = new HashMap<>();
//                    NodeList memberChildNodeList = memberNodeList.item(yy).getChildNodes();
//                    for (int xx = 0; xx < memberChildNodeList.getLength(); xx++) {
//                        memberMap.put(memberChildNodeList.item(xx).getNodeName(), memberChildNodeList.item(xx).getTextContent());
//                    }
//                    memberMapList.add(memberMap);
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return memberMapList;
//    }
//}
