package xyz.yship.zhiliao.service;

import xyz.yship.zhiliao.entity.Moment;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.yship.zhiliao.vo.MomentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yship
 * @since 2020-04-14
 */
public interface IMomentService extends IService<Moment> {

	List<MomentVo> getMomentByUserId(int id);
}
