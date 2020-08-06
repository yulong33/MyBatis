package cn.tedu.test;

import cn.tedu.config.Config;
import cn.tedu.dao.UserMapper;
import cn.tedu.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class TestCase {
    AnnotationConfigApplicationContext ctx;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    @After
    public void destory(){
        ctx.close();
    }

    @Test
    public void testDataSource(){
        DataSource ds=ctx.getBean(DataSource.class);
        String sql="select 'Hello World'";
        try (Connection conn=ds.getConnection()){
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertProduct(){
        Product product = new Product();
        product.setName("苹果手机");
        product.setCategory("手机");
        product.setBrand("苹果");
        product.setDescription("多功能只能手机");
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        int n=userMapper.insertProduct(product);
        System.out.println(n);
    }

    @Test
    public void testUpdateProduct(){
        Product product = new Product();
        product.setId(3);
        product.setName("联想笔记本");
        product.setCategory("电脑");
        product.setBrand("联想");
        product.setDescription("多功能游戏本");
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        int n = userMapper.updateProduct(product);
        System.out.println(n);
    }

    @Test
    public void testDeleteProduct(){
        Product product = new Product();
        product.setId(1);
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        int n = userMapper.deleteProduct(product);
        System.out.println(n);
    }

    @Test
    public void testGetAllProduct(){
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        List<Product> list = userMapper.getAllProducts();
        list.forEach(product -> System.out.println(product));
    }
}
