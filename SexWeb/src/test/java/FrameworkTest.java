import com.xu.mybatis.mappers.VideoMapper;
import com.xu.mybatis.util.Log;
import com.xu.mybatis.util.Utils;
import com.xu.pojo.Buniness;
import com.xu.pojo.Player;
import com.xu.pojo.Video;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameworkTest {

    /** spring 学习文档
     * https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-nature
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 测试各种感知接口
     */
    @Test
    public void iocTest2()
    {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Buniness buniness = classPathXmlApplicationContext.getBean("business", Buniness.class);
        //Log.d("video:"+video);
    }
    @Test
    public void iocTest()
    {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Player play = classPathXmlApplicationContext.getBean("play", Player.class);
        Log.d(play.toString());

        Object video3 = classPathXmlApplicationContext.getBean("video3");
        Log.d(video3.toString());
        Object video4 = classPathXmlApplicationContext.getBean("video4",Video.class);
        Log.d(video4.toString());
        Object video5 = classPathXmlApplicationContext.getBean("video5",Video.class);
        Log.d(video5.toString());
        Object video6 = classPathXmlApplicationContext.getBean("video5",Video.class);
        Log.d("hash5:"+video5.hashCode());
        Log.d("hash6:"+video6.hashCode());
    }
    @org.junit.Test
    public void test()
    {
        SqlSession session = Utils.getSession();
        VideoMapper mapper = session.getMapper(VideoMapper.class);
        List<Video> videos = mapper.getVideos();
        for (Video video : videos) {
            System.out.println(video);
        }
        Utils.close(session);
    }
    @org.junit.Test
    public void testLimit()
    {
        SqlSession session = Utils.getSession();
        VideoMapper mapper = session.getMapper(VideoMapper.class);
        Map<String,Integer> map =new HashMap<>();
        map.put("size",3);
        map.put("start",1);
        List<Video> videos = mapper.getVideosLimit(map);
        for (Video video : videos) {
            System.out.println(video);
        }
        Utils.close(session);
    }
    @org.junit.Test
    public void testDelete()
    {
        SqlSession session = Utils.getSession();
        VideoMapper mapper = session.getMapper(VideoMapper.class);
        int num=mapper.deleteVideo(1);
        System.out.println("num:"+num);
        Utils.close(session);
    }
    //一对多 多对一
    @org.junit.Test
    public void testMap()
    {
        SqlSession session = Utils.getSession();
        VideoMapper mapper = session.getMapper(VideoMapper.class);
        Player player=mapper.getPlayer(1);
        System.out.println("player:"+player);
        Utils.close(session);
    }
    //动态sql 默认session缓存
    @org.junit.Test
    public void testdynamicSql()
    {
        SqlSession session = Utils.getSession();
        VideoMapper mapper = session.getMapper(VideoMapper.class);
        Map<String,String> map =new HashMap<>();
        map.put("sex","男");
        List<Player> player=mapper.getPlayers(map);
        for (Player video : player) {
            System.out.println(video);
        }
        System.out.println("-----------------------------------------");
        List<Player> player2=mapper.getPlayers(map);

        Utils.close(session);
    }
    @org.junit.Test
    public void getVideosbyAni()
    {
        SqlSession session = Utils.getSession();
        VideoMapper mapper = session.getMapper(VideoMapper.class);
        List<Video> videos = mapper.getVideosbyAni();
        for (Video video : videos) {
            System.out.println(video);
        }
        Utils.close(session);
    }
    @org.junit.Test
    public void testA()
    {
        SQL sql= new SQL(){{
            SELECT("P.a, P.b, P.c, P.d");
            SELECT("P.e, P.f, P.g, P.h");
            FROM("xuxu AS P");
            WHERE("p.id=A.id");
            if(true)
            {

            }
        }};
        System.out.println("sql:"+sql.toString());
    }
    //测试jdbc
    @org.junit.Test
    public void testJDBC()
    {
        String url="jdbc:mysql://localhost:3306/sex?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
         String DRIVER = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(url, "root", "111111");
            System.out.println(conn);
            String sql ="select * from videos;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String author = resultSet.getString("author");
                System.out.println(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
