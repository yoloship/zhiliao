package xyz.yship.zhiliao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yship.zhiliao.entity.Bill;
import xyz.yship.zhiliao.entity.User;
import xyz.yship.zhiliao.service.IBillService;
import xyz.yship.zhiliao.service.IUserService;
import xyz.yship.zhiliao.service.impl.UserServiceImpl;
import xyz.yship.zhiliao.util.UserUtil;
import xyz.yship.zhiliao.vo.BillVo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 账单信息表 前端控制器
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private IBillService billService;
	@Autowired
	private IUserService userService;

	@GetMapping("/{ledgerId}")
	public List<BillVo> getBillByLedger(@PathVariable Integer ledgerId) {
		List<BillVo> billByLedger = billService.getBillByLedger(ledgerId);
		return billByLedger;
	}

	@PostMapping
	public boolean addBill(@RequestBody Bill bill) {
		User user = userService.getById(UserUtil.getUserId());
		bill.setCreatedTime(LocalDateTime.now());
		bill.setCreatedBy(user.getUserName());
		boolean save = billService.save(bill);
		return save;
	}

}

