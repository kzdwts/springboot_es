package cn.imooc.demo.springboot.es.repository.mysql;

import cn.imooc.demo.springboot.es.entity.mysql.MysqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MysqlBlogRepository extends JpaRepository<MysqlBlog, Integer> {

    @Query("SELECT e from MysqlBlog e ORDER BY e.createTime DESC ")
    List<MysqlBlog> queryAll();

    @Query("SELECT e from MysqlBlog e where e.title like concat('%', :keyword, '%') or e.content like concat('%', :keyword, '%') ORDER BY e.createTime DESC ")
    List<MysqlBlog> queryBlogs(@Param("keyword") String keyword);

}
