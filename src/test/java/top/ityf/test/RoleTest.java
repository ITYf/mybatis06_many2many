package top.ityf.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.ityf.dao.RoleDao;
import top.ityf.dao.UserDao;
import top.ityf.domain.Role;
import top.ityf.domain.User;

import java.io.InputStream;
import java.util.List;

/**
 * ClassName:MybatisTest
 * Package: top.ityf.test
 * Description: 测试mybatis的CRUD操作
 *
 * @Date: 2019/11/19 8:33
 * @Author: YanFei
 */
public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before   //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1、读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        sqlSession = factory.openSession();
        //4、获取dao的代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After   //用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }


    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<Role> roles = roleDao.findAll();
        for(Role role:roles){
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }


}
