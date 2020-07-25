package xyz.yship.zhiliao.service;

import xyz.yship.zhiliao.entity.Bill;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.yship.zhiliao.vo.BillVo;

import java.util.List;

/**
 * <p>
 * 账单信息表 服务类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
public interface IBillService extends IService<Bill> {

	List<BillVo> getBillByLedger(Integer ledgerId);

}
