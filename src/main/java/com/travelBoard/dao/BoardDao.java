package com.travelBoard.dao;

import com.travelBoard.domain.BoardDto;
import com.travelBoard.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    BoardDto select(int bno) throws Exception;

    int update(BoardDto dto) throws Exception;

    int deleteAll();

    int delete(Integer bno, String writer) throws Exception;
    int countAll();

    int insert(BoardDto dto) throws Exception;

    List<BoardDto> selectAll() throws Exception;

    List<BoardDto> selectPage(Map map) throws Exception // List<E> selectList(String statement, Object parameter)
    ;
    int increaseViewCnt(int bno) throws Exception;

    List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;

    int updateCommnentCnt(Integer bno, int cnt);
}
