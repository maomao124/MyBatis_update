package t1;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * Project name(项目名称)：MyBatis_update
 * Package(包名): t1
 * Interface(接口名): Site
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/13
 * Time(创建时间)： 12:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface Site
{
    public int updateSite(@Param("id") String id, @Param("name") String name, @Param("age") String age);

    public int updateSiteByMap(HashMap<String,Object> map);
}
