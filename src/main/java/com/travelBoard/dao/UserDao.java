package com.travelBoard.dao;

import com.travelBoard.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {
    @Autowired
    DataSource ds;


    // �Ű������� ���� ����� ������ user_info���̺��� update�ϴ� �޼���
    public int updateUser(User user) {
        return 0;
    }

    public void deleteAll() throws Exception {
        Connection conn = ds.getConnection();

        String sql = "delete from user_info ";

        PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection����, �������
        pstmt.executeUpdate(); //  insert, delete, update
    }

}
