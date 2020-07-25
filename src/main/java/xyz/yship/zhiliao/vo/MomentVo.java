package xyz.yship.zhiliao.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MomentVo {
	private String createName;
	private LocalDate createTime;
	private String avatarUrl;
	private String categoryName;
	private String content;
	private BigDecimal money;
}
