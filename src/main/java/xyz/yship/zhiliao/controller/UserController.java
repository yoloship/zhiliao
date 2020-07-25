package xyz.yship.zhiliao.controller;


import jdk.nashorn.internal.parser.Token;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.yship.zhiliao.entity.User;
import xyz.yship.zhiliao.service.IUserService;
import xyz.yship.zhiliao.vo.TokenVo;
import xyz.yship.zhiliao.vo.UserVo;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;
	//登录
	@PostMapping
	public TokenVo register(@RequestBody User user) throws JSONException {
		TokenVo token = userService.register(user);
		return token;
	}
}

