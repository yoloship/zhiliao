package xyz.yship.zhiliao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yship.zhiliao.entity.*;
import xyz.yship.zhiliao.mapper.*;
import xyz.yship.zhiliao.service.IFriendService;
import xyz.yship.zhiliao.service.IMomentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.yship.zhiliao.vo.FriendVo;
import xyz.yship.zhiliao.vo.MomentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yship
 * @since 2020-04-14
 */
@Service
public class MomentServiceImpl extends ServiceImpl<MomentMapper, Moment> implements IMomentService {

	@Autowired
	private MomentMapper momentMapper;
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private IFriendService friendService;
	@Autowired
	private ExpenCategoryMapper expenCategoryMapper;
	@Autowired
	private IncomeCategoryMapper incomeCategoryMapper;

	@Override
	public List<MomentVo> getMomentByUserId(int id) {
		List<FriendVo> allFriend = friendService.getAllFriend(id);
		User user = userMapper.selectById(id);
		FriendVo me = new FriendVo();
		me.setUserId(user.getUserId());
		me.setUsername(user.getUserName());
		me.setAvatarUrl(user.getAvatarUrl());
		allFriend.add(me);
		List<MomentVo> momentVos = new ArrayList<>();
		for (FriendVo friendVo : allFriend) {
			QueryWrapper<Moment> momentQueryWrapper = new QueryWrapper<>();
			momentQueryWrapper.eq("user_id",friendVo.getUserId());
			List<Moment> moments = momentMapper.selectList(momentQueryWrapper);
			List<MomentVo> momentVos1 = new ArrayList<>();
			for (Moment moment : moments) {
				Integer billId = moment.getBillId();
				Bill bill = billMapper.selectById(billId);
				MomentVo momentVo = new MomentVo();
				if (bill.getBillType() == 0) {
					ExpenCategory expenCategory = expenCategoryMapper.selectById(bill.getCategoryId());
					momentVo.setCategoryName(expenCategory.getName());
				} else {
					IncomeCategory incomeCategory = incomeCategoryMapper.selectById(bill.getCategoryId());
					momentVo.setCategoryName(incomeCategory.getName());
				}
				momentVo.setAvatarUrl(friendVo.getAvatarUrl());
				momentVo.setCreateName(friendVo.getUsername());
				momentVo.setCreateTime(moment.getCreateTime());
				momentVo.setContent(moment.getComent());
				momentVo.setMoney(bill.getMoney());
				momentVos1.add(momentVo);
			}
			momentVos.addAll(momentVos1);
		}
		momentVos.sort((o1, o2) -> {
			if (o1.getCreateTime().isBefore(o2.getCreateTime())) {
				return 0;
			}else {
				return 1;
			}
		});
		return momentVos;
	}
}
