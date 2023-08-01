package springtest01.dao;

import org.springframework.stereotype.Repository;
import springtest01.dao.UserDao;

@Repository //@Repository标识这是一个dao层的类，由spring托管
            //@Component                    由spring托管
public class UserDaoImpl implements UserDao {
    public UserDaoImpl(){
        System.out.println("UserDaoImpl类的构造...");
    }

    @Override
    public void add(String uname) {
        System.out.println("添加了:" + uname);
    }
}
