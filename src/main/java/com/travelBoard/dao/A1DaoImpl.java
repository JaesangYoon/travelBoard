package com.travelBoard.dao;

import com.travelBoard.domain.A1Dto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class A1DaoImpl implements A1Dao {
    @Autowired
    SqlSession session;

    String namespace = "com.travelBoard.dao.A1Mapper.";

    @Override
    public A1Dto insert(A1Dto a1Dto) {
        return session.selectOne(namespace + "insert", a1Dto);
    }


}
