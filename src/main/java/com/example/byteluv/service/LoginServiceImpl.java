package com.example.byteluv.service;

import com.example.byteluv.pojo.base.Permissions;
import com.example.byteluv.pojo.base.Role;
import com.example.byteluv.pojo.base.User;
import com.sun.javaws.security.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.stereotype.Service;


import java.io.InputStream;
import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

//    @Autowired
//    private static DataSource dataSource;


    @Override
    public User getUserByName(String getMapByName) {
        return getMapByName(getMapByName);
    }


//    static {
//
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet userResultSet = statement.executeQuery("select * from users");
//            ResultSet permissionSet = statement.executeQuery("select * from permissions");
//            ResultSet rolesSet = statement.executeQuery("select * from roles");
//            ResultSet companysSet = statement.executeQuery("select * from companys");
//            ResultSet rolePermissionSet = statement.executeQuery("select * from role-permission");
//            ResultSet userRoleSet = statement.executeQuery("select * from user-role");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        
//    }

    /**
     * 模拟数据库查询
     *
     * @param userName 用户名
     * @return User
     */
    private User getMapByName(String userName) {

        String resource = "/mybatis-config.xml";
        InputStream inputStream = Resource.class.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<User> userList = session.selectList("getUser");
            for(User user : userList){
                System.out.println("ID:" + user.getUserId() + ",name:" + user.getUserName());
            }
        }

        Permissions permissions1 = new Permissions(1, "query");
        Permissions permissions2 = new Permissions(2, "add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role(1, "admin", permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User(1, "wzy", "123456","", "", roleSet);
        Map<String, User> map = new HashMap<>();
        map.put(user.getUserName(), user);
        
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions1);
        Role role1 = new Role(2, "user", permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User(2, "zhangsan", "123456","", "", roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }
}