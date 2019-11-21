import com.po.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author ${user}
 * @create 2019-11-20-10:08
 */
public class Test {
    @org.junit.Test
    public void  test(){
        //1.获取会话工厂
        SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
        //2.生产会话 通过opensession 获取session对象
        Session session= sessionFactory .openSession();
        //3.开启一个事物
        Transaction tx = session.beginTransaction();
        //4.执行查询 get(要查询实体类型，参数)
        Emp emp=session.get(Emp.class,1);
        System.out.println("Emp="+emp);
      /*  transaction.commit();//提交事务
        session.close();//关闭session
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();*/
        //4.2执行查询
       Emp emp1 =session.get(Emp.class,1);
        System.out.println("Emp="+emp1);

        //4.3执行查询(查询单条数据)   hql语句
        Query query = session.createQuery("from Emp where id=1");
        Object o = query.uniqueResult();//只能在执行单条语句时使用
        System.out.println("o="+o);


        //查询全部
        Query query1 = session.createQuery("from Emp");
        List<Emp> list=query1.list();
        for (Emp emp2: list){
            System.out.println("emp2 = " + emp2);
        }
        //增加操作
        Emp  stu=new Emp();
        session.save("王五");
        //删除  先根据id查询是否存在对象（entity） 再去删除
        Emp stu1=session.get(Emp.class,1);
        if (stu1!=null){
            session.delete(stu1);
        }
        //修改操作
         Emp Emp=new Emp();
        Emp.setName("哈哈哈121");
        session.saveOrUpdate(Emp);
    }
}
