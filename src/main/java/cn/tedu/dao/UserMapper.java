package cn.tedu.dao;

import cn.tedu.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Insert("insert into product(name,category,brand,description) values (#{name},#{category},#{brand},#{description})")
    int insertProduct(Product product);

    @Update("update product set name=#{name},category=#{category},brand=#{brand},description=#{description} where id=#{id}")
    int updateProduct(Product product);

    @Delete("delete from product where id=#{id}")
    int deleteProduct(Product product);

    @Select("select * from product")
    List<Product> getAllProducts();
}
