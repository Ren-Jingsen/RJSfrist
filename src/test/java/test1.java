import com.po.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ${user}
 * @create 2019-11-21-10:39
 */
public class test1 {
    //会话工厂
    private SessionFactory sessionFactory;
    //会话
    private Session session;
    //事物
    private Transaction tx;
    @Before
    public void  before(){
        Configuration configure = new  Configuration().configure();
        //创建会话工厂
        sessionFactory =configure.buildSessionFactory();
        //生产会话
        session=sessionFactory.openSession();
        //开启事物
        tx=session.beginTransaction();
    }
    /***
     * 测试 单条查询
     */
    @Test
    public void test(){
        Emp emp = session.get(Emp.class, 1);
        System.out.println("emp = " + emp);
    }
    @After
    public void  after(){
        tx.commit();
        session.close();
    }
}
