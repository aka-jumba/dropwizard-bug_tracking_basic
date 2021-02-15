package in.dreamplug.userservice.domain;

import java.sql.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import in.dreamplug.userservice.CreateCheck;
import in.dreamplug.userservice.Mergeable;
import in.dreamplug.userservice.UpdateCheck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User extends ExternalBase implements Mergeable<User> {
    @NotNull (groups = { CreateCheck.class })
    @Size (min = 1, max = 45, groups = { CreateCheck.class, UpdateCheck.class })
    private String firstName;

    @NotNull (groups = { CreateCheck.class })
    @Size (min = 1, max = 45, groups = { CreateCheck.class, UpdateCheck.class })
    private String lastName;

    @NotNull (groups = { CreateCheck.class })
    @Size (min = 1, max = 45, groups = { CreateCheck.class, UpdateCheck.class })
    private String email;

    private String address;

    @NotNull (groups = { CreateCheck.class })
    private Date dob;

    @NotNull (groups = { CreateCheck.class })
    @Size (min = 1, max = 25, groups = { CreateCheck.class, UpdateCheck.class })
    private String phone;

    @Override
    public void merge(User user) {
        if (StringUtils.isNotBlank(user.getFirstName())) {
            this.firstName = user.getFirstName();
        }
        if (StringUtils.isNotBlank(user.getLastName())) {
            this.lastName = user.getLastName();
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            this.email = user.getEmail();
        }
        if (StringUtils.isNotBlank(user.getAddress())) {
            this.address = user.getAddress();
        }
        if (user.getDob() != null) {
            this.dob = user.getDob();
        }
        if (StringUtils.isNotBlank(user.getPhone())) {
            this.phone = user.getPhone();
        }
    }
}
