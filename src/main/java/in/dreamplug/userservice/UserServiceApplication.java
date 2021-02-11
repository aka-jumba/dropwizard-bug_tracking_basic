package in.dreamplug.userservice;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import in.dreamplug.userservice.configuration.UserServiceConfiguration;
import in.dreamplug.userservice.register.ResourceRegister;
import io.dropwizard.Application;
import io.dropwizard.configuration.ConfigurationSourceProvider;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserServiceApplication extends Application<UserServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new UserServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "user-service";
    }

    @Override
    public void initialize(Bootstrap<UserServiceConfiguration> bootstrap) {
        ConfigurationSourceProvider provider = new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                new EnvironmentVariableSubstitutor(false));
        bootstrap.setConfigurationSourceProvider(provider);
    }

    @Override
    public void run(UserServiceConfiguration configuration, Environment environment) {
        final ResourceRegister resourceRegister = new ResourceRegister();
        resourceRegister.register(environment, configuration);
        environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
}
