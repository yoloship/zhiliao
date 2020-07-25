package xyz.yship.zhiliao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账本信息表
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Ledger implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 账本id
     */
      @TableId(value = "ledger_id", type = IdType.AUTO)
    private Integer ledgerId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    /**
     * 账本名字
     */
    private String ledgerName;

}
