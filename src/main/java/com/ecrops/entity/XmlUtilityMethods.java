package com.ecrops.entity;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtilityMethods {

	public  static HashMap<String, String> getMapData(String XmlData)
			throws ParserConfigurationException, SAXException, IOException {
		System.out.println("===========================================getMapData\n\n");
		HashMap<String, String> dataMap = new HashMap<String, String>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(XmlData));
		Document doc = db.parse(is);
		if (doc.hasChildNodes()) {
			NodeList nodeList = doc.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node childNode = nodeList.item(i);
				System.out.println("childNode: "+childNode.getNodeName()+"="+childNode.getTextContent());
				if (childNode.getTextContent() != null) {
					dataMap.put(childNode.getNodeName(), childNode.getTextContent());
				}
				if (childNode.hasAttributes()) {
					NamedNodeMap atrList = childNode.getAttributes();
					System.out.println("atrList: "+atrList);
					for (int j = 0; j < atrList.getLength(); j++) {
						Node childAttr = atrList.item(j);
						System.out.println("childAttr: "+childNode.getNodeName()+"_"+childAttr.getNodeName()+"="+childAttr.getNodeValue());
						if (childAttr.getNodeValue() != null) {
							dataMap.put(childNode.getNodeName() + "_" + childAttr.getNodeName(),
									childAttr.getNodeValue());
						}
					}
				}
				if (childNode.hasChildNodes()) {
					NodeList innerNodeList = childNode.getChildNodes();
					for (int k = 0; k < innerNodeList.getLength(); k++) {
						Node innerChildNode = innerNodeList.item(k);
						System.out.println("innerChildNode: "+innerChildNode.getNodeName());
						if (innerChildNode.getTextContent() != null) {
							dataMap.put(innerChildNode.getNodeName(), innerChildNode.getTextContent());
						}
						if (innerChildNode.hasAttributes()) {
							NamedNodeMap innerAtrList = innerChildNode.getAttributes();
							for (int l = 0; l < innerAtrList.getLength(); l++) {
								Node innerChildAttr = innerAtrList.item(l);
								System.out.println("innerChildAttr: "+innerChildNode.getNodeName()+"_"+innerChildAttr.getNodeName()+"="+innerChildAttr.getNodeValue());
								if (innerChildAttr.getNodeValue() != null) {
									dataMap.put(innerChildNode.getNodeName() + "_" + innerChildAttr.getNodeName(),
											innerChildAttr.getNodeValue());
								}
							}
						}
					}
				}
			}
		}
		System.out.println("===========================================getMapData END\n\n");
		return dataMap;
	}
	
	public  static HashMap<String, String> getEkycMapData(String XmlData)
			throws ParserConfigurationException, SAXException, IOException {
//		System.out.println("===========================================getMapData\n\n");
		HashMap<String, String> dataMap = new HashMap<String, String>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(XmlData));
		Document doc = db.parse(is);
		if (doc.hasChildNodes()) {
			NodeList nodeList = doc.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node childNode = nodeList.item(i);
//				System.out.println("childNode: "+childNode.getNodeName()+"="+childNode.getTextContent());
				if (childNode.getTextContent() != null) {
					dataMap.put(childNode.getNodeName(), childNode.getTextContent());
				}
				if (childNode.hasAttributes()) {
					NamedNodeMap atrList = childNode.getAttributes();
//					System.out.println("atrList: "+atrList);
					for (int j = 0; j < atrList.getLength(); j++) {
						Node childAttr = atrList.item(j);
//						System.out.println("childAttr: "+childNode.getNodeName()+"_"+childAttr.getNodeName()+"="+childAttr.getNodeValue());
						if (childAttr.getNodeValue() != null) {
							dataMap.put(childNode.getNodeName() + "_" + childAttr.getNodeName(),
									childAttr.getNodeValue());
						}
					}
				}
				if (childNode.hasChildNodes()) {
					NodeList innerNodeList = childNode.getChildNodes();
					for (int k = 0; k < innerNodeList.getLength(); k++) {
						Node innerChildNode = innerNodeList.item(k);
//						System.out.println("innerChildNode: "+innerChildNode.getNodeName());
						if (innerChildNode.getTextContent() != null) {
							dataMap.put(innerChildNode.getNodeName(), innerChildNode.getTextContent());
						}
						if (innerChildNode.hasAttributes()) {
							NamedNodeMap innerAtrList = innerChildNode.getAttributes();
							for (int l = 0; l < innerAtrList.getLength(); l++) {
								Node innerChildAttr = innerAtrList.item(l);
//								System.out.println("innerChildAttr: "+innerChildNode.getNodeName()+"_"+innerChildAttr.getNodeName()+"="+innerChildAttr.getNodeValue());
								if (innerChildAttr.getNodeValue() != null) {
									dataMap.put(innerChildNode.getNodeName() + "_" + innerChildAttr.getNodeName(),
											innerChildAttr.getNodeValue());
								}
							}
						}
						
						if(innerChildNode.hasChildNodes()) {
							NodeList secondInnerNodeList = innerChildNode.getChildNodes();
							
							for(int m=0; m < secondInnerNodeList.getLength(); m++) {
								Node secondInnerChildNode = secondInnerNodeList.item(m);
								if(secondInnerChildNode.getTextContent() != null) {
									dataMap.put(secondInnerChildNode.getNodeName(), secondInnerChildNode.getTextContent());
								}
								if(secondInnerChildNode.hasAttributes()) {
									NamedNodeMap secondInnerAtrList = secondInnerChildNode.getAttributes();
									for(int n=0; n < secondInnerAtrList.getLength(); n++) {
										Node secondnnerChildAttr = secondInnerAtrList.item(n);
										if(secondnnerChildAttr.getNodeValue() != null) {
											dataMap.put(secondInnerChildNode.getNodeName() + "_" + secondnnerChildAttr.getNodeName(), 
													secondnnerChildAttr.getNodeValue());
										}
									}
								}
							}
						}
					}
				}
			}
		}
//		System.out.println("===========================================getMapData END\n\n");
		return dataMap;
	}

	public static String constructXML(String parentNode, HashMap<String, String> childNodeList,
			HashMap<String, String> attrMapList) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = df.newDocumentBuilder();
		Document doc1 = db.newDocument();

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement(parentNode);
		doc.appendChild(rootElement);

		Set<String> attrKeys = attrMapList.keySet();
		for (String strKey : attrKeys) {
			String arr[] = strKey.split("_");
			if (arr[0].equals(parentNode)) {
				rootElement.setAttribute(arr[1], attrMapList.get(strKey));
			}
		}

		Set<String> attrNodeKeys = childNodeList.keySet();

		for (String strNodeKey : attrNodeKeys) {
			Element childElement = doc.createElement(strNodeKey);
			rootElement.appendChild(childElement);

			childElement.setTextContent(childNodeList.get(strNodeKey));

			Set<String> childAttrKeys = attrMapList.keySet();
			for (String strKey : childAttrKeys) {
				String arr[] = strKey.split("_");
				if (arr[0].equals(strNodeKey)) {
					childElement.setAttribute(arr[1], attrMapList.get(strKey));
				}
			}
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
		return output;

	}

	public static HashMap<String, String> getXMLMapData(String XmlData)
			throws ParserConfigurationException, SAXException, IOException {
		HashMap<String, String> dataMap = new HashMap<String, String>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(XmlData));
		Document doc = db.parse(is);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("PidData");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				dataMap.put(eElement.getAttributes().toString(),
						eElement.getElementsByTagName("string").item(0).getTextContent());
			}
		}
		return dataMap;
	}

	public  String nodeToString(Node node) {
		StringWriter sw = new StringWriter();
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.transform(new DOMSource(node), new StreamResult(sw));
		} catch (TransformerException te) {
			System.out.println("nodeToString Transformer Exception");
		}
		return sw.toString();
	}

	public  Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[])
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		HashMap<String, String> childMapList = new HashMap<String, String>();
		childMapList.put("Input", "Input Text Content");
		childMapList.put("Aadhaar", "Aadhar Text Content");
		childMapList.put("Signature", "Signature Text Content");

		HashMap<String, String> mapAttrList = new HashMap<String, String>();
		/*mapAttrList.put("Esign_ver", "1.0");
		mapAttrList.put("Esign_sc", "2.0");
		mapAttrList.put("Esign_ts", "3.0");
		mapAttrList.put("Esign_txn", "4.0");
		mapAttrList.put("Esign_aspId", "5.0");
		mapAttrList.put("Esign_esignClass", "6.0");
		mapAttrList.put("Input_check", "checkValue");
		mapAttrList.put("Signature_check", "checkValue");*/

		String xmlString = constructXML("Esign", childMapList, mapAttrList);
		System.out.println(xmlString);

		System.out.println("\n\n");

		/*
		 * String xmlRecords =
		 * "<OTPResp status=\"0\" ts=\"2015-11-29T11:08:15\" txn=\"12345\" ver=\"1.0\">"
		 * +
		 * "<AadhaarResp1 check1=\"check1 value\" check11=\"check11 value\">aadhaar response otp asp</AadhaarResp1>"
		 * +
		 * "<AadhaarResp2 check2=\"check2 value\">aadhaar response otp asp</AadhaarResp2>"
		 * +
		 * "<AadhaarResp3 check3=\"check3 value\">aadhaar response otp asp</AadhaarResp3>"
		 * +
		 * "<AadhaarResp4 check4=\"check4 value\">aadhaar response otp asp</AadhaarResp4>"
		 * + "</OTPResp>";
		 */

		HashMap<String, String> map = getMapData(xmlString);
		Set<String> keySet = map.keySet();
		for (String strKey : keySet) {
			System.out.println(strKey + " = " + map.get(strKey));
		}

	}

}

