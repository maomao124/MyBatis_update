package t1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：MyBatis_update
 * Package(包名): t1
 * Class(测试类名): SiteTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/13
 * Time(创建时间)： 12:16
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SiteTest
{

    @org.junit.jupiter.api.Test
    void updateSite() throws IOException
    {
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Site site = sqlSession.getMapper(Site.class);
        int i = site.updateSite("2", "百度", "17");
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void updateSiteByMap() throws IOException
    {
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        HashMap<String, Object> params = new HashMap<>();
        params.put("id", 2);
        params.put("name", "百度");
        params.put("age", 13);

        Site site = sqlSession.getMapper(Site.class);

        int i = site.updateSiteByMap(params);

        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();
    }
}