package in.dreamplug.userservice.dao;

import java.util.List;
import java.util.Optional;

import in.dreamplug.userservice.domain.Bug;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import in.dreamplug.userservice.domain.User;

public interface UserDao {
    @GetGeneratedKeys
    @SqlUpdate ("INSERT INTO users (external_id, first_name, last_name, email, address, dob, phone, created_at, updated_at) VALUES (:u.externalId, :u.firstName, :u.lastName, :u.email, :u.address, :u.dob, :u.phone, :u.createdAt, :u.updatedAt)")
    long insert(@BindBean ("u") User user);

    @SqlUpdate ("UPDATE users SET first_name = :u.firstName, last_name = :u.lastName, email = :u.email, address = :u.address, dob = :u.dob, phone = :u.phone, updated_at = :u.updatedAt WHERE external_id = :u.externalId")
    void update(@BindBean ("u") User user);

    @SqlQuery ("SELECT id, external_id, first_name, last_name, email, address, dob, phone, created_at, updated_at FROM users WHERE phone = :phone")
    @RegisterBeanMapper (User.class)
    Optional<User> getByPhone(@Bind ("phone") String phone);

    @SqlQuery ("SELECT id, external_id, first_name, last_name, email, address, dob, phone, created_at, updated_at FROM users WHERE email = :email")
    @RegisterBeanMapper (User.class)
    Optional<User> getByEmail(@Bind ("email") String email);

    @SqlQuery ("SELECT id, external_id, first_name, last_name, email, address, dob, phone, created_at, updated_at FROM users WHERE external_id = :external_id")
    @RegisterBeanMapper (User.class)
    Optional<User> getById(@Bind ("external_id") String external_id);

    @SqlQuery ("select b.id, b.bug_name, b.bug_description, b.priority, b.created_at, b.updated_at from bugs b join bugs_users bu on bu.bug_name = b.bug_name where bu.external_id = :external_id")
    @RegisterBeanMapper (Bug.class)
    List<Bug> getAllBugs(@Bind ("external_id") String external_id);


}
