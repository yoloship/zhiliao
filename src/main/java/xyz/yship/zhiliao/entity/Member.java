package xyz.yship.zhiliao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账本与成员桥梁表
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Member implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
      @TableId(value = "ldeger_member_id", type = IdType.AUTO)
    private Integer ldegerMemberId;

    /**
     * 账本id
     */
    private Integer ledgerId;

    /**
     * 成员id
     */
    private Integer userId;

    /**
     * 成员角色 0为创建者，1为管理员，2为普通成员
     */
    private Integer memberRole;


}
