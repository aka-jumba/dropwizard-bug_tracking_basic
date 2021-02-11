package in.dreamplug.userservice.service;

import java.util.Optional;
import org.jdbi.v3.core.Jdbi;
import in.dreamplug.userservice.dao.UserDao;
import in.dreamplug.userservice.domain.User;
import in.dreamplug.userservice.exception.Error;
import lombok.AllArgsConstructor;

/**
 * @author sidhant.aggarwal
 * @since 12/01/2020
 */
@AllArgsConstructor
public class UserService {
    private Jdbi jdbi;

    public User insert(final User user) {
        user.prePersist();
        final Long id = jdbi.withExtension(UserDao.class, dao -> dao.insert(user));
        user.setId(id);
        return user;
    }

    public User update(final User user) {
        final User existingUser = getById(user.getExternalId()).orElseThrow(Error.user_not_found.getBuilder()::build);
        existingUser.merge(user);
        jdbi.useExtension(UserDao.class, dao -> dao.update(existingUser));
        return existingUser;
    }

    public Optional<User> getById(final String userId) {
        return jdbi.withExtension(UserDao.class, dao -> dao.getById(userId));
    }

    public Optional<User> getByPhone(final String phone) {
        return jdbi.withExtension(UserDao.class, dao -> dao.getByPhone(phone));
    }

    public Optional<User> getByEmail(final String email) {
        return jdbi.withExtension(UserDao.class, dao -> dao.getByEmail(email));
    }
}
