package xyz.yship.zhiliao.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserLedger implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer userId;

    private Integer ledgerId;

    private Integer role;

}
