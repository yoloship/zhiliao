package xyz.yship.zhiliao.service;

import xyz.yship.zhiliao.entity.Ledger;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.yship.zhiliao.vo.LedgerVo;

import java.util.List;

/**
 * <p>
 * 账本信息表 服务类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
public interface ILedgerService extends IService<Ledger> {

	List<LedgerVo> getAllLedgert(int userId);
}
