package xyz.yship.zhiliao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yship.zhiliao.entity.Friendship;
import xyz.yship.zhiliao.service.IFriendService;
import xyz.yship.zhiliao.util.UserUtil;
import xyz.yship.zhiliao.vo.FriendVo;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户好友关系表 前端控制器
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private IFriendService friendService;


	@GetMapping
	public List<FriendVo> getAllFriend() {
		int userId = UserUtil.getUserId();
		List<FriendVo> allFriend = friendService.getAllFriend(userId);
		return allFriend;
	}

	@GetMapping("/{ledgerId}")
	public List<FriendVo> getMember(@PathVariable Integer ledgerId) {
		int userId = UserUtil.getUserId();
		List<FriendVo> allFriend = friendService.getMember(userId,ledgerId);
		return allFriend;
	}

	@PostMapping
	public void addFriend(@RequestBody FriendVo friendVo){
		int i = friendService.addFriend(friendVo);
	}
}

