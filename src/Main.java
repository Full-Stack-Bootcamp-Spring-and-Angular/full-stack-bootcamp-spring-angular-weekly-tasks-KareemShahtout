import com.beanScope.DatabaseOperations;
import com.beanScope.Shape.Circle;
import com.beanScope.Shape.Square;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle c = context.getBean("circleBean", Circle.class);
        c.draw();

        Square s = context.getBean("squareBean", Square.class);
        s.draw();

        DatabaseOperations db = context.getBean("databaseBean", DatabaseOperations.class);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
