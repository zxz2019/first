package demo.test;


import demo.pojo.Goods;
import demo.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class GoodsTest {

    /**
     * 根据商品编号查询商品信息
     */
    @Test
    public void findGoodsByIdTest() throws Exception {
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream =
                Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行映射文件中定义的SQL，并返回映射结果
        Goods good = sqlSession.selectOne("demo.mapper"
                + ".GoodsMapper.findGoodsById", 1);
        // 打印输出结果
        System.out.println(good.toString());
        // 5、关闭SqlSession
        sqlSession.close();
    }

    /**
     * 根据用户名称来模糊查询用户信息列表
     */
    @Test
    public void findCustomerByNameTest() throws Exception {
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Goods> goods = sqlSession.selectList("demo.mapper"
                + ".GoodsMapper.findGoodByName", "到");
        for (Goods good : goods) {
            //打印输出结果集
            System.out.println(good);
        }
        // 5、关闭SqlSession
        sqlSession.close();
    }

    /**
     * 添加商品
     */
    @Test
    public void addGoodsTest() throws Exception {
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行添加操作
        // 4.1创建Customer对象，并向对象中添加数据
        Goods goods = new Goods();
        goods.setGoodname("牛奶");
        goods.setGooddescr("喝");
        goods.setGoodprice("10");
        // 4.2执行SqlSession的插入方法，返回的是SQL语句影响的行数
        int rows = sqlSession.insert("demo.mapper"
                + ".GoodsMapper.addGoods", goods);
//		// 4.3通过返回结果判断插入操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功插入了" + rows + "条数据！");
        } else {
            System.out.println("执行插入操作失败！！！");
        }


        // 4.4提交事务
        sqlSession.commit();
        // 5、关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void updateCustomerTest() throws Exception {
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行更新操作
        // 4.1创建Customer对象，对对象中的数据进行模拟更新
        Goods customer = new Goods();
        customer.setId(3);
        customer.setGoodname("薯片");
        customer.setGooddescr("吃");
        customer.setGoodprice("3");
        // 4.2执行SqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("demo.mapper"
                + ".GoodsMapper.updateGoods", customer);
        // 4.3通过返回结果判断更新操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        // 4.4提交事务
        sqlSession.commit();
        // 5、关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        // 1、读取配置文件
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 2、根据配置文件构建SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory =
//                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 4、SqlSession执行删除操作
        // 4.1执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int rows = sqlSession.delete("demo.mapper"
                + ".GoodsMapper.deleteGoods", 3);
        // 4.2通过返回结果判断删除操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！！！");
        }
        // 4.3提交事务
        sqlSession.commit();
        // 5、关闭SqlSession
        sqlSession.close();
    }

}
