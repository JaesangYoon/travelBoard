package com.travelBoard.service;

import com.travelBoard.domain.BoardDto;
import com.travelBoard.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BoardService {
    List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;

    int getCount();

    int remove(Integer bno, String writer) throws Exception;

    int write(BoardDto boardDto) throws Exception;

    List<BoardDto> getList() throws Exception;

    BoardDto read(Integer bno) throws Exception;

    List<BoardDto> getPage(Map map) throws Exception;

    int modify(BoardDto boardDto) throws Exception;
}
