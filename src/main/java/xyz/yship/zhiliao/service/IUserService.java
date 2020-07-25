package xyz.yship.zhiliao.service;

import xyz.yship.zhiliao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.yship.zhiliao.vo.TokenVo;
import xyz.yship.zhiliao.vo.UserVo;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
public interface IUserService extends IService<User> {
	TokenVo login(UserVo userVo);

	TokenVo register(User user);
}
