package com.shinhan.myapp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {

	@Autowired
	SqlSession sqlSession;
	String namespace = "com.shinhan.board";
	
	public  List<BoardDTO> findAll() {
		return sqlSession.selectList(namespace+" selectAll");
	}
	
	public int insert(BoardDTO board) {
		return sqlSession.insert(namespace+" insert",board);
	}
	public int delete(BoardDTO board) {
		return sqlSession.insert(namespace+" delete",board);
	}
	public int update(BoardDTO board) {
		return sqlSession.update(namespace+" update",board);
	}
}
