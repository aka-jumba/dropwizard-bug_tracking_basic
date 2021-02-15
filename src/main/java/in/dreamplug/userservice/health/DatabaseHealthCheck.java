package in.dreamplug.userservice.health;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.codahale.metrics.health.HealthCheck;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DatabaseHealthCheck extends HealthCheck {
    private HikariDataSource dataSource;

    @Override
    protected Result check() throws Exception {
        final Connection connection = this.dataSource.getConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("SELECT 1 FROM DUAL");
        try {
            final boolean res = preparedStatement.execute();
            if (res) {
                return Result.healthy();
            } else {
                return Result.unhealthy("Error Connecting to MYSQL");
            }
        } catch (final Exception ex) {
            return Result.unhealthy(ex);
        }
    }
}
