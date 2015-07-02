package bookmarks;

import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Retman on 2015-07-01.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("{userId}/bookmarks")
public class RestController {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Account> get(@PathVariable String userId) {
        List<Account> byUsername = accountRepository.findByUsername(userId);
        return byUsername;
    }
}
