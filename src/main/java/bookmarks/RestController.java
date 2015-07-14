package bookmarks;

import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Retman on 2015-07-01.
 * This is comment for this class.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("{userId}")
public class RestController {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping(value="/bookmarks",method = RequestMethod.GET)
    List<Account> get(@PathVariable String userId) {
        List<Account> byUsername = accountRepository.findByUsername(userId);
        return byUsername;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET)
    String del(@PathVariable String userId){
        return "It will delete userID: "+userId;
    }

    @RequestMapping(value="{name}/add",method = RequestMethod.GET)
    String add(@PathVariable String name){
        entityManager.getTransaction().begin();
//        String query = "INSERT INTO ACCOUNT(password,username) VALUES(:password,:username)";
//        entityManager.createNativeQuery(query);
        Account acc = new Account();
        acc.setPassword("1234");
        acc.setUsername(name);
        entityManager.persist(acc);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Added user:"+name;
    }
}
