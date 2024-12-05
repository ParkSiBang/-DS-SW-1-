package com.shinhan.myapp.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.vo.MemberDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("boardlist",boardService.findAll());
		return "board/boardList";
	}
	@GetMapping("/detail.do")
	public String detailGet(Model model) {
		model.addAttribute("boardlist",boardService.findAll());
		return "board/boardDetail";
	}
	
	@GetMapping("/insert.do")
	public String insertGet() {
		return "board/boardInsert";
	}
	@PostMapping("/insert.do")
	public String insertPost(BoardDTO board,HttpSession session) {
		MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
		if(member ==null) {
			member = MemberDTO.builder().member_id("test").build();
		}
		String writer = member.getMember_id();
		board.setWriter(writer);
		boardService.insert(board);
		return "redirect:list.do";
	}
//	@PostMapping("/insert.do")
//	public String insertPost( MultipartHttpServletRequest multipart  , HttpSession session) {
//		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
//		if(member == null) member = MemberDTO.builder().member_id("guest").build();
//		String writer = member.getMember_id();
//		
//		HttpServletRequest request = (HttpServletRequest)multipart;
//		
//		String uploadPath = session.getServletContext().getRealPath("./resources/upload");
//		MultipartFile multipartFile = multipart.getFile("pic");
//		String fileName = multipartFile.getOriginalFilename(); //이미지이름 
//		String newfileName = "";
//		String ymdpath = UploadFileUtils.calcPath(uploadPath);
//		 
//		try {
//			newfileName = UploadFileUtils.fileUpload(uploadPath, fileName,
//					multipartFile.getBytes(), ymdpath);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "redirect:insert.do";
//		}
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		BoardDTO board = BoardDTO.builder().title(title).content(content).build(); 	
//		board.setWriter(writer);
//		board.setPic(ymdpath + File.separator + newfileName);
//		log.info(board.toString());
//		boardService.insert(board);
//		return "redirect:list.do";
//	}
}
