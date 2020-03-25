import com.xl.MybatisUtils;
import com.xl.dao.UserDao;
import com.xl.dao.UserDaoTransation;
import com.xl.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringMybatisTest {

    @Test
    public void getUserList()
    {
        ApplicationContext cocntext = new ClassPathXmlApplicationContext("spring-dao.xml");

        //spring 自动接管mybatis,需要创建实现类
        UserDao curDao =  cocntext.getBean("userDao",UserDao.class);

        for(User user : curDao.getUserList())
        {
            System.out.println(user);
        }



        //手动接管，不需要创建实现类
        SqlSessionTemplate curTemplate =  cocntext.getBean("sqlSession", SqlSessionTemplate.class);
        UserDao userDao = curTemplate.getMapper(UserDao.class);

        for(User user :userDao.getUserList())
        {
            System.out.println(user);
        }


        //spring 自动接管mybatis,需要创建实现类 2,简化配置
        UserDao curDao2 =  cocntext.getBean("UserDaoImpl2",UserDao.class);

        for(User user : curDao2.getUserList())
        {
            System.out.println(user);
        }

        //实现事务

    }

    @Test
    public void TransationTest()
    {
        ApplicationContext cocntext = new ClassPathXmlApplicationContext("spring-dao.xml");

        UserDaoTransation curDaoTransation =  cocntext.getBean("UserDaoImplTransation",UserDaoTransation.class);


        for(User user : curDaoTransation.getUserList())
        {
            System.out.println(user);
        }

    }
}
