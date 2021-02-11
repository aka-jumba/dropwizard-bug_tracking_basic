package in.dreamplug.userservice.configuration;

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sidhant.aggarwal
 * @since 12/01/2020
 */
@Getter
@Setter
@NoArgsConstructor
public class UserServiceConfiguration extends Configuration {
    private DatabaseConfiguration databaseConfiguration;
}
