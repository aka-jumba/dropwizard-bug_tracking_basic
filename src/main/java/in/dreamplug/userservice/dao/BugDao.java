package in.dreamplug.userservice.dao;

import in.dreamplug.userservice.domain.Bug;
import in.dreamplug.userservice.domain.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Optional;

public interface BugDao {
    @GetGeneratedKeys
    @SqlUpdate ("INSERT INTO bugs (bug_name, bug_description, priority, created_at, updated_at) VALUES (:b.bugName, :b.bugDescription, :b.priority, :b.createdAt, :b.updatedAt)")
    long insert(@BindBean ("b") Bug bug);

    @GetGeneratedKeys
    @SqlUpdate ("INSERT INTO bugs_users (bug_name, external_id) VALUES (:b.bugName, :u.externalId)")
    long insertAssignedUser(@BindBean ("b") Bug bug, @BindBean ("u") User user);

    @SqlUpdate ("UPDATE bugs SET bug_description = :b.bugDescription, priority = :b.priority, updated_at = :b.updatedAt WHERE bug_name = :b.bugName")
    void update(@BindBean ("b") Bug bug);

    @SqlQuery ("SELECT id, bug_name, bug_description, priority, created_at, updated_at FROM bugs WHERE bug_name = :bugName")
    @RegisterBeanMapper (Bug.class)
    Optional<Bug> getByBugName(@Bind ("bugName") String bugName);
}
