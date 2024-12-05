package com.shinhan.myapp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardService {

    @Autowired
    SqlSession sqlSession;
    String namespace = "com.shinhan.board.";

    public List<BoardDTO> findAll() {
        return sqlSession.selectList(namespace + "findAll");
    }

    public int insert(BoardDTO board) {
        return sqlSession.insert(namespace + "insert", board);
    }

    public int delete(BoardDTO board) {
        return sqlSession.delete(namespace + "delete", board);
    }

    public int update(BoardDTO board) {
        return sqlSession.update(namespace + "update", board);
    }
    public List<BoardDTO> selectById() {
        return sqlSession.selectList(namespace + "findAll");
    }
}