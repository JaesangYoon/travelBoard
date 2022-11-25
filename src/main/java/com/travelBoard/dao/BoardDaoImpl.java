package com.travelBoard.dao;


import com.travelBoard.domain.BoardDto;
import com.travelBoard.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    SqlSession session;
    String namespace = "com.travelBoard.dao.BoardMapper.";

    @Override
    public int countAll(){
        return session.selectOne(namespace + "countAll");
    }

    @Override
    public BoardDto select(int bno) throws Exception { // �߻��ϴ� ���ܸ� ���� �������� ������� �ϹǷ� throws Exception ���ش�
        return session.selectOne(namespace + "select", bno); // Ŭ���� �̸� �տ� ��Ű�� �̸� �ٵ�, SQL id�� select �տ� namespace ���δ�
    }

    @Override
    public int update(BoardDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    }

    @Override
    public int deleteAll() {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int delete(Integer bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace+"delete", map);
    } // int delete(String statement, Object parameter)
    @Override
    public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

//    public List selectPage(Map map)  {
//        return session.selectMap(namespace + "selectPage", map);
//    }

    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage", map);
    } // List<E> selectList(String statement, Object parameter)

    public int increaseViewCnt(int bno) throws Exception {
        return session.update(namespace + "increaseViewCnt", bno);
    }

    @Override
    public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    } // List<E> selectList(String statement, Object parameter)

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
    @Override
    public int updateCommnentCnt(Integer bno, int cnt) {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("cnt", cnt);
        return session.update(namespace + "updateCommnentCnt", map);
    }
}
