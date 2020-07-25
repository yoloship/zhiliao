package xyz.yship.zhiliao.service;

import xyz.yship.zhiliao.entity.Friendship;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.yship.zhiliao.vo.FriendVo;
import xyz.yship.zhiliao.vo.LedgerVo;

import java.util.List;

/**
 * <p>
 * 用户好友关系表 服务类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
public interface IFriendService extends IService<Friendship> {

	List<FriendVo> getAllFriend(int userId);

	int addFriend(FriendVo friendVo);

	List<FriendVo> getMember(int userId, Integer ledgerId);
}
