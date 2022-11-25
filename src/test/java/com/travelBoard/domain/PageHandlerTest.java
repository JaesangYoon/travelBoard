package com.travelBoard.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class PageHandlerTest {

    @Test
    public void test() {
//        PageHandler ph = new PageHandler(220, 10); // page=20일 때 다음 페이지로 넘어가버리는 문제
//        ph.print();
//        assertTrue(ph.getBeginPage() == 11);



    }
}