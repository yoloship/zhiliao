package xyz.yship.zhiliao.controller;//package xyz.yship.zhiliao.annotation;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yship.zhiliao.service.IUserService;
import xyz.yship.zhiliao.vo.TokenVo;
import xyz.yship.zhiliao.vo.UserVo;


@RestController
public class TokenController {
	@Autowired
	IUserService userService;
	//登录
	@PostMapping("/token")
	public TokenVo login(@RequestBody UserVo userVo) {
		TokenVo token = userService.login(userVo);
		return token;
	}
}
