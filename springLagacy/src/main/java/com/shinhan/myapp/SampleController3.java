//package com.shinhan.myapp;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
////�������� ������ ��û �н� 
//
//@Controller
//public class SampleController3 {
//	
//	Logger logger = LoggerFactory.getLogger(SampleController3.class);
//	
//	//��û���ּҰ��� �Ѿ���� �Ķ���͵� Ȯ��(userid��� �Ķ������ ���� �� ���ƾ��Ѵ�. userpw����,email���� ���� 
//	@RequestMapping(value = "/second4.do", 
//			params = {"userid=zzilre","userpw","!email" }  )
//	public String f3(String userid,String userpw) {
//		logger.info("second4 ���̵�� " + userid );
//		logger.info("second4 ��й�ȣ�� " + userpw );
//	
//		return "jsptest/second3";
//	}
//	
//	@RequestMapping(value = { "/second3.do"}, method = RequestMethod.POST)
//	public String f2(@RequestParam("userid") String userid2, 
//			         @RequestParam("userpw") int userpw) {
//		logger.info("���̵�� " + userid2 );
//		logger.info("��й�ȣ�� " + userpw );
//		return "jsptest/second3";
//	}
//	
//	
//	
//
//	@RequestMapping(value = { "/second1.do", "/second2.do" }, method = RequestMethod.GET)
//	public String f1() {
//		return "jsptest/first1";
//	}
//
//}
