package xyz.yship.zhiliao.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BillVo {
	int billId;
	String billType;
	int ledgerId;
	BigDecimal money;
	String createdBy;
	long createdTime;
	String categoryName;
	String image;
}
