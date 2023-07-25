package springtest01.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springtest01.dao.UserDao;

@Service
public class UserBizImpl implements UserBiz {
    //将dao层的对象注入到biz  DI依赖注入 (将spring容器中托管的userDao的对象传到此处)
    //@Resource(name="userDaoImpl")  //由spring容器根据 id名为userDaoImpl到容器中找这个实例，并注入

    @Autowired  //根据类型来完成注入，在spring容器中根据类型UserDao接口类找实例
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    public UserBizImpl() {
        System.out.println("userDaoImpl的构造");
    }
    @Override
    public void add(String uname) {
        userDao.add(uname);
    }
}
