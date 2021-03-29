import com.xu.pojo.Boss;
import com.xu.pojo.Company;
import com.xu.pojo.Video;
import com.xu.spring.SpringConfiguration;
import com.xu.util.Log;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    /**
     * 通过configutato 注解配置注入
     */
    @Test
    public void test1()
    {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("app-config.xml");
        //注解的context 传入扫描的包
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.xu.pojo");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Video video1 = context.getBean("getP", Video.class);
        Video video2 = context.getBean("getP", Video.class);
        Log.d("hashCode:"+video1.hashCode());
        Log.d("hashCode:"+video2.hashCode());
    }
    /**
     * 通过configutato 注解配置注入
     */
    @Test
    public void test2()
    {
//
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Boss obj = context.getBean("getBoss", Boss.class);
        Log.d("hashCode:"+obj.toString());
    }
    @Test
    public void test3()
    {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("app-config.xml");
        Video company = context.getBean("video", Video.class);
        Log.d("company:"+company.toString());
    }
}
