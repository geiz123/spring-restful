package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.config.SpringConfig;
import com.dao.PeopleDao;
import com.entity.People;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public List<People> getPersonByName(@RequestParam(value="name", defaultValue="") String name) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)) {
            PeopleDao pd = (PeopleDao) context.getBean("peopleDaoImpl");
            
            if (name.equals("")) {
                return pd.getAll();
            } else {
                return pd.getByName(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
    public People getPersonById(@PathVariable("id") int id) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)) {
            PeopleDao pd = (PeopleDao) context.getBean("peopleDaoImpl");
            
            return pd.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
