package in.dreamplug.userservice.service;

import java.util.Optional;

import in.dreamplug.userservice.dao.BugDao;
import in.dreamplug.userservice.domain.Bug;
import in.dreamplug.userservice.domain.User;
import in.dreamplug.userservice.exception.BugError;
import org.jdbi.v3.core.Jdbi;
import in.dreamplug.userservice.exception.Error;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BugService1 {
    private Jdbi jdbi;

    public Bug insert(final Bug bug) {
        bug.prePersist();
        final Long id = jdbi.withExtension(BugDao.class, dao -> dao.insert(bug));
        bug.setId(id);
        return bug;
    }

    public Long assignUser(final User user, final String bugName) {
        final Bug existingBug = getByName(bugName).orElseThrow(BugError.bug_not_found.getBuilder()::build);
        return jdbi.withExtension(BugDao.class, dao -> dao.insertAssignedUser(existingBug, user));
    }

    public Bug update(final Bug bug, String bugName) {
        final Bug existingBug = getByName(bugName).orElseThrow(BugError.bug_not_found.getBuilder()::build);
        existingBug.merge(bug);
        jdbi.useExtension(BugDao.class, dao -> dao.update(existingBug));
        return existingBug;
    }

    public Optional<Bug> getByName(final String name) {
        return jdbi.withExtension(BugDao.class, dao -> dao.getByBugName(name));
    }
}
