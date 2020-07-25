package xyz.yship.zhiliao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yship.zhiliao.entity.Bill;
import xyz.yship.zhiliao.entity.ExpenCategory;
import xyz.yship.zhiliao.entity.IncomeCategory;
import xyz.yship.zhiliao.mapper.BillMapper;
import xyz.yship.zhiliao.mapper.ExpenCategoryMapper;
import xyz.yship.zhiliao.mapper.IncomeCategoryMapper;
import xyz.yship.zhiliao.service.IBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.yship.zhiliao.vo.BillVo;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 账单信息表 服务实现类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {

	@Autowired
	private BillMapper billMapper;
	@Autowired
	private ExpenCategoryMapper expenCategoryMapper;
	@Autowired
	private IncomeCategoryMapper incomeCategoryMapper;


	@Override
	public List<BillVo> getBillByLedger(Integer ledgerId) {
		QueryWrapper<Bill> billQueryWrapper = new QueryWrapper<>();
		billQueryWrapper.eq("ledger_id", ledgerId);
		List<Bill> bills = billMapper.selectList(billQueryWrapper);
		List<BillVo> billVos = new ArrayList<>();
		for (Bill bill : bills) {
			BillVo billVo = new BillVo();
			billVo.setBillId(bill.getBillId());
			billVo.setBillId(bill.getBillId());
			billVo.setMoney(bill.getMoney());
			if (bill.getBillType() == 0) {
				billVo.setBillType("Expen");
				ExpenCategory expenCategory = expenCategoryMapper.selectById(bill.getCategoryId());
				billVo.setImage(expenCategory.getImage());
				billVo.setCategoryName(expenCategory.getName());
			} else {
				billVo.setBillType("Income");
				IncomeCategory incomeCategory = incomeCategoryMapper.selectById(bill.getCategoryId());
				billVo.setImage(incomeCategory.getImage());
				billVo.setCategoryName(incomeCategory.getName());
			}
			billVo.setCreatedBy(bill.getCreatedBy());
			billVo.setCreatedTime(bill.getCreatedTime().toInstant(ZoneOffset.of("+8")).toEpochMilli());
			billVos.add(billVo);
		}
		return billVos;

	}
}
