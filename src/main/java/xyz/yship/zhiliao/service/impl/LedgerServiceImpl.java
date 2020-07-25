package xyz.yship.zhiliao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yship.zhiliao.entity.Ledger;
import xyz.yship.zhiliao.entity.UserLedger;
import xyz.yship.zhiliao.mapper.LedgerMapper;
import xyz.yship.zhiliao.mapper.UserLedgerMapper;
import xyz.yship.zhiliao.service.ILedgerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.yship.zhiliao.vo.LedgerVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 账本信息表 服务实现类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Service
public class LedgerServiceImpl extends ServiceImpl<LedgerMapper, Ledger> implements ILedgerService {

	@Autowired
	private LedgerMapper ledgerMapper;

	@Autowired
	private UserLedgerMapper userLedgerMapper;

	@Override
	public List<LedgerVo> getAllLedgert(int userId) {
		QueryWrapper<UserLedger> userLedgerQueryWrapper = new QueryWrapper<>();
		userLedgerQueryWrapper.eq("user_id", userId);
		List<UserLedger> userLedgers = userLedgerMapper.selectList(userLedgerQueryWrapper);
		List<LedgerVo> ledgerVos = new ArrayList<>();
		for (UserLedger userLedger : userLedgers) {
			Ledger ledger = ledgerMapper.selectById(userLedger.getLedgerId());
			LedgerVo ledgerVo = new LedgerVo();
			ledgerVo.setName(ledger.getLedgerName());
			ledgerVo.setLedgerId(ledger.getLedgerId());
			if (userLedger.getRole() == 0) {
				ledgerVo.setRole("创建者");
			} else if (userLedger.getRole() == 1) {
				ledgerVo.setRole("管理员");
			} else if (userLedger.getRole() == 2) {
				ledgerVo.setRole("成员");
			}
			ledgerVos.add(ledgerVo);
		}
		return ledgerVos;
	}
}
