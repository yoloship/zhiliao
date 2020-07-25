package xyz.yship.zhiliao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yship.zhiliao.entity.Friendship;
import xyz.yship.zhiliao.entity.User;
import xyz.yship.zhiliao.entity.UserLedger;
import xyz.yship.zhiliao.mapper.FriendshipMapper;
import xyz.yship.zhiliao.mapper.UserLedgerMapper;
import xyz.yship.zhiliao.mapper.UserMapper;
import xyz.yship.zhiliao.service.IFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.yship.zhiliao.util.UserUtil;
import xyz.yship.zhiliao.vo.FriendVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户好友关系表 服务实现类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendshipMapper, Friendship> implements IFriendService {


	@Autowired
	private UserMapper userMapper;

	@Autowired
	private FriendshipMapper friendshipMapper;

	@Autowired
	private UserLedgerMapper userLedgerMapper;


	@Override
	public List<FriendVo> getAllFriend(int userId) {
		QueryWrapper<Friendship> friendshipQueryWrapper = new QueryWrapper<>();
		friendshipQueryWrapper.eq("user_id_from", userId).or().eq("user_id_to", userId);
		List<Friendship> friendships = friendshipMapper.selectList(friendshipQueryWrapper);
		List<FriendVo> friendVos = new ArrayList<>();
		for (Friendship friendship : friendships) {
			FriendVo friendVo = new FriendVo();
			User user;
			if (friendship.getUserIdFrom() != userId) {
				user = userMapper.selectById(friendship.getUserIdFrom());
			}else {
				user = userMapper.selectById(friendship.getUserIdTo());
			}
			friendVo.setEmail(user.getEmail());
			friendVo.setUsername(user.getUserName());
			friendVo.setAvatarUrl(user.getAvatarUrl());
			friendVo.setUserId(user.getUserId());
			friendVos.add(friendVo);
		}
		return friendVos;
	}

	@Override
	public int addFriend(FriendVo friendVo) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("email",friendVo.getEmail());
		User friend = userMapper.selectOne(queryWrapper);
		Friendship friendship = new Friendship();
		friendship.setUserIdFrom(UserUtil.getUserId());
		friendship.setUserIdTo(friend.getUserId());
		int insert = friendshipMapper.insert(friendship);
		return insert;
	}

	@Override
	public List<FriendVo> getMember(int userId, Integer ledgerId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("ledger_id",ledgerId);
		List<UserLedger> list = userLedgerMapper.selectList(queryWrapper);
		List<Integer> userIds = new ArrayList<>();
		for (UserLedger userLedger : list) {
			userIds.add(userLedger.getUserId());
		}
		List<User> users = userMapper.selectBatchIds(userIds);
		List<FriendVo> friendVos = new ArrayList<>();
		for (User user : users) {
			FriendVo friendVo = new FriendVo();
			friendVo.setEmail(user.getEmail());
			friendVo.setUsername(user.getUserName());
			friendVo.setAvatarUrl(user.getAvatarUrl());
			friendVo.setUserId(user.getUserId());
			friendVos.add(friendVo);
		}
		return friendVos;
	}
}
