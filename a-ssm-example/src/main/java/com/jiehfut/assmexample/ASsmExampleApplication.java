package com.jiehfut.assmexample;

import com.jiehfut.assmexample.bean.Dog;
import com.jiehfut.assmexample.bean.Person;
import com.jiehfut.assmexample.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.HashMap;
import java.util.Map;

/**
 * 主入口类别
 * 程序启动的入口
 */

@SpringBootApplication
public class ASsmExampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(ASsmExampleApplication.class, args);
        System.out.println("ioc = " + ioc);

        System.out.println("=====ioc 容器创建完成========");
        Dog dog = ioc.getBean(Dog.class);
        System.out.println("dog = " + dog);


        Dog dog1 = ioc.getBean(Dog.class);
        System.out.println("dog1 = " + dog1);
        Dog dog2 = ioc.getBean(Dog.class);
        System.out.println("dog2 = " + dog2);

        /**
         * 正在创建 Dog 组件...
         * 2024-12-25T09:28:19.295+08:00  INFO 25692 --- [a-ssm-example] [           main] c.j.assmexample.ASsmExampleApplication   : Started ASsmExampleApplication in 0.814 seconds (process running for 1.291)
         * ioc = org.springframework.context.annotation.AnnotationConfigApplicationContext@5ce8d869, started on Wed Dec 25 09:28:18 CST 2024
         * =====ioc 容器创建完成========
         * dog = Dog(name=dog, age=0)
         * dog1 = Dog(name=dog, age=0)
         * dog2 = Dog(name=dog, age=0)
         *
         * 组件术语框架的一些底层配置
         * 可见容器在启动过程中就会创建组件对象，把单实例的对象创建完毕
         * 组件在容器中是单实例的，每次获取直接从容器中拿就可以了
         *
         * 可以使用配置类来进行分类管理组件
         * 配置类也是一个组件
         *
         */

        /**
         * 1.@Controller 控制器组件
         * 2.@Service    服务层组件
         * 3.@Repository 持久层组件
         * 4.@Component  其他组件
         * 5.@ComponentScan(basePackages = "com.jiehfut") 主程序使用该注解设置扫描路径 => 批量扫描该路径下使用注解的组件
         *
         */
        UserController userController = ioc.getBean(UserController.class);
        System.out.println("userController = " + userController);
        // userController = com.jiehfut.assmexample.controller.UserController@2d84cb86

        /**
         * 导入第三方组件
         * 1.自己 new 出来一个对象后使用 @Bean 将其注册进容器中
         * 2.通过注解导入 @Import(Arrays.class) 整个项目标注一次即可，可以专门写一个配置类进行整合
         */
        Map map = ioc.getBean(HashMap.class);
        System.out.println("map = " + map); // map = {}


        /**
         * @Scope 调整组件的作用域
         * 1.@Scope("prototype")，表示该组件为 非单实例
         *     容器启动的时候不会创建非单实例对象，什么时候获取什么时候创建
         *     为
         * 2.@Scope("singleton")，表示该组件为 单实例，默认值
         *     容器启动会创建单实例对象，容器启动完成前会创建该组件对象
         *     可以使用 @lazy 注解表明该组件为懒加载
         * 3.@Scope("request")，表示该组件为 同一个请求的单实例
         * 4.@Scope("session")，表示该组件为 同一次会话的单实例
         *
         */
        Object firstCat = ioc.getBean("first-cat");
        System.out.println("firstCat = " + firstCat);
        // first-cat 组件使用 @Scope("prototype") 修饰，可见在 ioc 容器启动过程中没有进行创建，在获取该对象的时候才会创建该组件

        Object secondCat = ioc.getBean("second-cat");
        System.out.println("secondCat = " + secondCat);
        // second-cat 组件使用 @scope("singleton") && @lazy 注解使该组件在使用的时候才会创建，不会在容器启动的时候就去创建

        /**
         * 还可以使用 FacyoryBean 进行组件的创建
         * FacyoryBean 是一种特殊的组件
         *
         */


    }













    public static void testBeanAnnotation(String[] args) {
        // 跑起来一个 spring 的应用：即为 IoC 容器
        // 1.SpringBoot 创建并且管理 Spring 上下文：ApplicationContext
        // public interface ConfigurableApplicationContext extends ApplicationContext, Lifecycle, Closeable {}
        ConfigurableApplicationContext ioc = SpringApplication.run(ASsmExampleApplication.class, args);
        System.out.println("ioc = " + ioc);
        // ioc = org.springframework.context.annotation.AnnotationConfigApplicationContext@528c868


        // 2.ioc 容器中有哪些组件（一个类就算一个组件）
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // TODO:获取容器中的组件对象：组件的四大特性：名字，类型，对象，作用域
        Object person = ioc.getBean("person");
        System.out.println("按照名字拿到组件对象：" + person);
        // 按照名字拿到组件对象：PersonConfig(name=person, age=0, gender=男)
        // 如果组件不存在：NoSuchBeanDefinitionException

        // TODO:按照组件类型获取对象
        // PersonConfig person1 = (PersonConfig) ioc.getBean(PersonConfig.class);
        // System.out.println("按照组件类型获取组件对象：" + person1);
        // Dog dog = (Dog) ioc.getBean(Dog.class);
        // System.out.println("按照组件类型获取组件对象：" + dog);
        // 按照组件类型获取组件对象：PersonConfig(name=person, age=0, gender=男)
        // 按照组件类型获取组件对象：Dog(name=dog, age=0)
        // 没有该组件对象：NoSuchBeanDefinitionException

        // TODO:组件有多个
        // PersonConfig person2 = (PersonConfig) ioc.getBean(PersonConfig.class);
        // System.out.println("该组件类型有多个：" + person2);
        // 组件不存在异常：NoSuchBeanDefinitionException
        // 组件不唯一异常：NoUniqueBeanDefinitionException


        // todo: 组件有多个的时候，按照组件的类型获取所有对象
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("组件对象有多个，按照组件类型获取全部组件：");
        for (Map.Entry<String, Person> entry : beansOfType.entrySet()) {
            System.out.println(entry.getValue());
        }
        // 组件对象有多个，按照组件类型获取全部组件：
        // PersonConfig(name=person, age=0, gender=男)
        // PersonConfig(name=zhangsan, age=0, gender=男)
        // PersonConfig(name=lisi, age=0, gender=男)


        // todo:组件不唯一，但是只要一个组件对象：lisi.  如果组件名称（value中值）不唯一，获取先注册的对象，没有先后顺序就按字母顺序
        Object lisi = ioc.getBean("lisi");
        System.out.println("组件名称一定全局唯一：李四 = " + lisi);
        // 组件名称一定全局唯一：李四 = PersonConfig(name=lisi, age=0, gender=男)


        // todo:按照类型加名字
        Person lisi1 = ioc.getBean("lisi", Person.class);
        System.out.println("按照类型加组件名称：" + lisi1);
        // 按照类型加组件名称：PersonConfig(name=lisi, age=0, gender=男)
    }




}
