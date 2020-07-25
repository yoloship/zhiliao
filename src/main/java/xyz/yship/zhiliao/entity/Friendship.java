package xyz.yship.zhiliao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户好友关系表
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Friendship implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 关系id
     */
      @TableId(value = "friendship_id", type = IdType.AUTO)
    private Integer friendshipId;

    /**
     * 关系发起者id
     */
    private Integer userIdFrom;

    /**
     * 关系接受者id
     */
    private Integer userIdTo;


}
