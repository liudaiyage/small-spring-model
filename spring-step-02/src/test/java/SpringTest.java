import beans.UserService;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;
import com.ldyg.springframework.beans.factory.support.DefaultListTableBeanFactory;
import org.junit.Test;

public class SpringTest {

    @Test
    public void apiTest() {
        DefaultListTableBeanFactory beanFactory = new DefaultListTableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        // 注册bean定义
        beanFactory.beanDefinitionRegistry("UserService", beanDefinition);
        // 获取bean，没有就创建bean对象，并将其放入内存中
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();

        UserService userService1 = (UserService) beanFactory.getBean("UserService");
        userService1.queryUserInfo();
    }
}
