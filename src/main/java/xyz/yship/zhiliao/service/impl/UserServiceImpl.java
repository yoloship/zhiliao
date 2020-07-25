package xyz.yship.zhiliao.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yship.zhiliao.entity.User;
import xyz.yship.zhiliao.mapper.UserMapper;
import xyz.yship.zhiliao.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.yship.zhiliao.vo.TokenVo;
import xyz.yship.zhiliao.vo.UserVo;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public TokenVo login(UserVo userVo) {
		QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
		userQueryWrapper.eq("email", userVo.getEmail());
		userQueryWrapper.eq("password", userVo.getPassword());
		User user = userMapper.selectOne(userQueryWrapper);
		TokenVo tokenVo = new TokenVo();
		if (user != null) {
			tokenVo.setToken(getToken(user));
			tokenVo.setUsername(user.getUserName());
			tokenVo.setAvatarUrl(user.getAvatarUrl());
		}else {
			tokenVo.setToken("");
		}
		return tokenVo;
	}

	@Override
	public TokenVo register(User user) {
		user.setCreatedTime(LocalDateTime.now());
		user.setAvatarUrl("https://images.unsplash.com/photo-1425321395722-b1dd54a97cf3?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjF9");
		int insert = userMapper.insert(user);
		TokenVo tokenVo = new TokenVo();
		if (insert != 0) {
			tokenVo.setToken(getToken(user));
			tokenVo.setUsername(user.getUserName());
			tokenVo.setAvatarUrl(user.getAvatarUrl());
		} else {
			tokenVo.setToken("");
		}
		return tokenVo;
	}

	public String getToken(User user) {
		String token="";
		token= JWT.create().withAudience(String.valueOf(user.getUserId()))
				.sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}

}
