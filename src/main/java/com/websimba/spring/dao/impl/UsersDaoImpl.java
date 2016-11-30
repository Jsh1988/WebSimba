package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.UsersDao;
import com.websimba.spring.entity.UserReg;
import com.websimba.spring.entity.Users;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    private static final Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Users users) {
        try {
            session.getCurrentSession().save(users);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add user");
        }
    }
    @Override
    public void addReg(UserReg userReg) {
        try {
            session.getCurrentSession().save(userReg);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add userReg");
        }
    }

    @Override
    public void edit(Users users) {
        try {
//    id = :newid,login = :newlogin,password = :newpassword, email =:newemail, firstname=:newfirstname, surname=:newsurname, phone=:newphone, country=:newcountry, region=:newregion, city=:newcity, indexs=:newindexs, street=:newstreet, house=:newhouse, isAdmin=:newisadmin
            String hql = "update from Users set     id = :newid,login = :newlogin,password = :newpassword, email =:newemail, firstname=:newfirstname, surname=:newsurname, phone=:newphone, country=:newcountry, region=:newregion, city=:newcity, indexs=:newindexs, street=:newstreet, house=:newhouse, isAdmin=:newisadmin where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);

            query.setInteger("newid", users.getId() );
            query.setString("newlogin", users.getLogin() );
            query.setString("newpassword", DigestUtils.md5Hex(users.getPassword()) );
            query.setString("newemail", users.getEmail() );
            query.setString("newfirstname", users.getFirstname() );
            query.setString("newsurname", users.getSurname() );
            query.setInteger("newphone", users.getPhone() );
            query.setString("newcountry", users.getCountry() );
            query.setString("newregion", users.getRegion() );
            query.setString("newcity", users.getCity() );
            query.setInteger("newindexs", users.getIndexs() );
            query.setString("newstreet", users.getStreet() );
            query.setInteger("newhouse", users.getHouse() );
            query.setByte("newisadmin", users.getIsAdmin() );


            query.setInteger("id", users.getId() );

            query.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error update user");
        }
    }

    @Override
    public void delete(int id) {
        try {
            Query query = session.getCurrentSession().createQuery("delete from Users where id = :id");
            query.setInteger("id", id );
            query.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete user");
        }
    }

    @Override
    public Users getUsers(int id) {
        Users users = new Users();
        try {
            users = (Users) session.getCurrentSession().get(Users.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error user");
        }
        return users;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> user = null;
        try {
            user = session.getCurrentSession().createQuery("from Users").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list user");
        }
        return user;
    }

}
