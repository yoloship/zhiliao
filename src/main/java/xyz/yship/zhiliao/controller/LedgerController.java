package xyz.yship.zhiliao.controller;


import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yship.zhiliao.entity.Ledger;
import xyz.yship.zhiliao.entity.UserLedger;
import xyz.yship.zhiliao.service.ILedgerService;
import xyz.yship.zhiliao.service.IUserLedgerService;
import xyz.yship.zhiliao.util.UserUtil;
import xyz.yship.zhiliao.vo.LedgerVo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 账本信息表 前端控制器
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/ledger")
public class LedgerController {

	@Autowired
	private ILedgerService ledgerService;
	@Autowired
	private IUserLedgerService userLedgerService;

	@GetMapping
	public List<LedgerVo> getAllLedger() {
		int userId = UserUtil.getUserId();
		List<LedgerVo> allLedgert = ledgerService.getAllLedgert(userId);
		return allLedgert;
	}

	@PostMapping
	public void createLedger(@RequestBody Ledger ledger){
		ledger.setCreatedTime(LocalDateTime.now());
		ledger.setUpdatedTime(LocalDateTime.now());
		ledgerService.save(ledger);
		Integer ledgerId = ledger.getLedgerId();
		UserLedger userLedger = new UserLedger();
		userLedger.setLedgerId(ledgerId);
		userLedger.setUserId(UserUtil.getUserId());
		userLedger.setRole(0);
		userLedgerService.save(userLedger);
	}

}

