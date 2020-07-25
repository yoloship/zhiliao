package xyz.yship.zhiliao.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yship.zhiliao.entity.User;
import xyz.yship.zhiliao.entity.UserLedger;
import xyz.yship.zhiliao.service.IUserLedgerService;
import xyz.yship.zhiliao.service.IUserService;
import xyz.yship.zhiliao.service.impl.UserServiceImpl;
import xyz.yship.zhiliao.vo.UserLedgerVo;

/**
 * <p>
 * 账本与成员桥梁表 前端控制器
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private IUserLedgerService userLedgerService;
	@Autowired
	private IUserService userService;

	@PostMapping
	public boolean addMember(@RequestBody UserLedgerVo userLedgerVo) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("email",userLedgerVo.getEmail());
		User user = userService.getOne(queryWrapper);
		UserLedger userLedger = new UserLedger();
		userLedger.setUserId(user.getUserId());
		userLedger.setLedgerId(Integer.valueOf(userLedgerVo.getLedgerId()));
		userLedger.setRole(1);
		boolean save = userLedgerService.save(userLedger);
		return save;
	}
}

