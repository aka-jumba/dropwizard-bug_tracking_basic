package in.dreamplug.userservice.domain;

import java.sql.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class Bug extends Base implements Mergeable<Bug> {
    @NotNull(groups = { CreateCheck.class })
    @Size (min = 1, max = 45, groups = { CreateCheck.class, UpdateCheck.class })
    private String bugName;

    @NotNull (groups = { CreateCheck.class })
    @Size (min = 1, max = 45, groups = { CreateCheck.class, UpdateCheck.class })
    private String bugDescription;

    @NotNull (groups = { CreateCheck.class })
    @Max(value = 10, groups = { CreateCheck.class, UpdateCheck.class })
    @Min(value = 0, groups = { CreateCheck.class, UpdateCheck.class })
    private Integer priority;


    @Override
    public void merge(Bug bug) {
        if (StringUtils.isNotBlank(bug.getBugName())) {
            this.bugName = bug.getBugName();
        }
        if (StringUtils.isNotBlank(bug.bugDescription)) {
            this.bugDescription = bug.getBugDescription();
        }
        if (bug.priority != null) {
            this.priority = bug.getPriority();
        }

    }
}
