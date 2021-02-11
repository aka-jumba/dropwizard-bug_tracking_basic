package in.dreamplug.userservice.register;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import com.google.common.base.Strings;
import com.zaxxer.hikari.HikariDataSource;
import in.dreamplug.userservice.configuration.DatabaseConfiguration;
import in.dreamplug.userservice.configuration.UserServiceConfiguration;
import in.dreamplug.userservice.exception.AppExceptionMapper;
import in.dreamplug.userservice.health.DatabaseHealthCheck;
import in.dreamplug.userservice.resource.UserResource;
import in.dreamplug.userservice.service.UserService;
import io.dropwizard.setup.Environment;
import lombok.AllArgsConstructor;

/**
 * @author sidhant.aggarwal
 * @since 12/01/2020
 */
@AllArgsConstructor
public class ResourceRegister {
    public void register(final Environment environment, final UserServiceConfiguration configuration) {
        final HikariDataSource dataSource = createDataSource(environment, configuration.getDatabaseConfiguration());
        final Jdbi jdbi = Jdbi.create(dataSource);
        jdbi.installPlugin(new SqlObjectPlugin());
        final UserService userService = new UserService(jdbi);
        environment.jersey().register(new UserResource(userService));
        environment.jersey().register(AppExceptionMapper.class);
        environment.healthChecks().register("MYSQL", new DatabaseHealthCheck(dataSource));
    }

    private HikariDataSource createDataSource(Environment environment, DatabaseConfiguration databaseConfig) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(databaseConfig.getUrl());
        dataSource.setUsername(databaseConfig.getUser());
        dataSource.setPassword(databaseConfig.getPassword());
        dataSource.setMinimumIdle(databaseConfig.getMinPoolSize());
        dataSource.setMaximumPoolSize(databaseConfig.getMaxPoolSize());
        dataSource.setIdleTimeout((long)databaseConfig.getMaxIdleTime());
        dataSource.setMaxLifetime((long)databaseConfig.getMaxLifeTime());
        dataSource.setAutoCommit(databaseConfig.isAutoCommit());
        dataSource.setReadOnly(databaseConfig.isReadOnly());
        dataSource.setConnectionInitSql(databaseConfig.getTestStatement());
        dataSource.setConnectionTimeout((long)databaseConfig.getConnectionTimeout());
        if (!Strings.isNullOrEmpty(databaseConfig.getPoolName())) {
            dataSource.setPoolName(databaseConfig.getPoolName());
        }
        dataSource.setMetricRegistry(environment.metrics());
        return dataSource;
    }
}
