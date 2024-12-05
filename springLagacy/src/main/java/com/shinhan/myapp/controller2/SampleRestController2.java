//package com.shinhan.myapp.controller2;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.shinhan.myapp.emp.EmpDTO;
//import com.shinhan.myapp.emp.EmpService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@ResponseBody
//@RequestMapping("/rest")
//@RequiredArgsConstructor
//public class SampleRestController2 {
//	
//	final EmpService empService;
//	@GetMapping(value = "/test2.do",produces = "text/plain;charset=utf-8")
//	public String f1() {
//		return "rest 방식2(4version @restcontroller)";
//	}
//	//직원 조회
//	//jackson 라이브러리가 data를 json으로 변경해서  return함
//	@GetMapping("/emplist.do")
//	public List<EmpDTO> f2() {
//		return empService.selectAllService();
//	}
//	@GetMapping("/emplist.do/{empid}")
//	public EmpDTO f3(@PathVariable int empid) {
//		return empService.selectByIdService(empid);
//	}
//	
//	@GetMapping(value="/test")
//	public String f4() {
//		EmpDTO emp =empService.selectByIdService(100);
//		return "rest방식 연습2 "+emp.getFirst_name();
//	}
//	//4. 모든직원 조회 후 return은 Map<직원번호,직원DTO>
//	@GetMapping(value = "/empmap.do", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<Integer, EmpDTO> f5() {
//		Map<Integer, EmpDTO> map = new HashMap<>();
//		List<EmpDTO> emplist =  empService.selectAllService();
//		emplist.forEach(emp->{
//			map.put(emp.getEmployee_id(), emp);
//		});
//	return map;
//	}
//	
//	//5.입력 post 들어오는 data가 있음 요청문서의 body로 온다 (주의: @requestParam아님)
//	@PostMapping(value = "/empinsert.do",
//			consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = "text/plain;charset=utf-8"
//			)
//	public String insert(@RequestBody EmpDTO emp) {
//		int result = empService.insertService(emp);
//		return result>0?"성공":"실패";
//	}
//	//6.update put사용
//	@PutMapping(value="/empupdate.do",
//			consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = "text/plain;charset=utf-8")
//	public String update(@RequestBody EmpDTO emp) {
//		int result = empService.updateService(emp);
//		return result>0?"성공":"실패";
//	}
//	//7.delete
//	@DeleteMapping(value="/empdelete.do",
//			consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = "text/plain;charset=utf-8")
//	public String delete(@PathVariable int empid) {
//		int result = empService.deleteService(empid);
//		return result>0?"성공":"실패";
//	}
//	
//	
//}
