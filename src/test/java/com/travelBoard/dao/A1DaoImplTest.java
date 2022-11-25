package com.travelBoard.dao;

import com.travelBoard.domain.A1Dto;
import com.travelBoard.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class A1DaoImplTest {

    @Autowired
    A1Dao a1Dao;

    @Test
    public void insert() {
        A1Dto a1Dto = new A1Dto(12, 345);
        a1Dao.insert(a1Dto);
        assertTrue(a1Dto.getkeyy() == 12);

    }
}