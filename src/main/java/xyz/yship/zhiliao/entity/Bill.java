package xyz.yship.zhiliao.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账单信息表
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Bill implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 账单id
     */
      @TableId(value = "bill_id", type = IdType.AUTO)
    private Integer billId;

    /**
     * 账本id
     */
    private Integer ledgerId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 账单金额
     */
    private BigDecimal money;

    /**
     * 账单类型 0为收入，1为支出
     */
    private Integer billType;

    private Integer categoryId;


}
