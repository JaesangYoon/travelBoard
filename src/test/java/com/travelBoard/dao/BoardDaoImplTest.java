package com.travelBoard.dao;

import com.travelBoard.domain.BoardDto;
import com.travelBoard.domain.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest  {
    @Autowired
    private BoardDao boardDao;

    @Test
    public void searchSelectPageTest() throws Exception {
        boardDao.deleteAll();
        for (int i = 1; i <= 20; i++) {
            BoardDto boardDto = new BoardDto("title" + i, "test", "asdf");
            boardDao.insert(boardDto);
        }

        SearchCondition sc = new SearchCondition(1, 10, "title2", "T"); // title2%
        List<BoardDto> list = boardDao.searchSelectPage(sc);
        System.out.println("list = " + list);
        assertTrue(list.size()==2);

    }

    @Test
    public void insertTestData() throws Exception {
        boardDao.deleteAll();
        for (int i = 1; i <= 220; i++) {
            BoardDto boardDto = new BoardDto("title" + i, "no content", "asdf");
            boardDao.insert(boardDto);
        }
    }

    @Test
    public void select() throws Exception {
        assertTrue(boardDao != null);
        System.out.println("boardDao = " + boardDao);
        BoardDto boardDto = boardDao.select(1);
        System.out.println("boardDto = " + boardDto);
        assertTrue(boardDto.getBno().equals(1));
    }

    @Test
    public void update() throws Exception {
        BoardDto boardDto = boardDao.select(1);
        boardDto.setTitle("First update1");
        boardDto.setContent("updated content1");
        boardDao.update(boardDto);
        System.out.println("boardDto.getContent = " + boardDto.getContent());
        assertTrue(boardDto.getContent().equals("updated content1"));
    }

    @Test
    public void countTest() {
        System.out.println("countTest= " +boardDao.countAll());
    }

    @Test
    public void delete() throws Exception {
        boardDao.deleteAll();
        BoardDto dto = new BoardDto("Friday night", "Let's go to the river!!", "Han");
        boardDao.insert(dto);
        Map map = new HashMap();
        map.put("bno", 15);
        map.put("writer", "Han");
        System.out.println("map = " + map);

//        boardDao.delete(Integer bno, String writer);
        assertTrue(boardDao.countAll() == 0);

    }

    @Test
    public void deleteAll() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.countAll() == 0);
    }

    @Test
    public void insert() throws Exception {
        BoardDto dto = new BoardDto("Nice to meet you", "Great sunny day", "JS");
        boardDao.insert(dto);
        assertTrue(dto.getTitle().equals("Nice to meet you"));

    }

    @Test
    public void selectAll() throws Exception {
        boardDao.deleteAll();
        BoardDto dto = new BoardDto("Friday night", "Let's go to the river!!", "Han");
        BoardDto dto2 = new BoardDto("Friday night2", "Let's go to the river2!!", "Han2");
        boardDao.insert(dto);
        boardDao.insert(dto2);

        assertTrue(boardDao.countAll() == 2);

    }

    @Test
    public void selectPage() {
        Map map = new HashMap();
        map.put("offset", 1);
        map.put("pageSize", 10);




    }


}