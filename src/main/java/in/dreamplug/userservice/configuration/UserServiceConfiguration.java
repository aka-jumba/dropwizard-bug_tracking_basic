package in.dreamplug.userservice.configuration;

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserServiceConfiguration extends Configuration {
    private DatabaseConfiguration databaseConfiguration;
}
