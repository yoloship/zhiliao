package xyz.yship.zhiliao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yship.zhiliao.entity.Moment;
import xyz.yship.zhiliao.service.IMomentService;
import xyz.yship.zhiliao.service.impl.MomentServiceImpl;
import xyz.yship.zhiliao.util.UserUtil;
import xyz.yship.zhiliao.vo.MomentVo;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yship
 * @since 2020-04-14
 */
@RestController
@RequestMapping("/moment")
public class MomentController {

	@Autowired
	private IMomentService momentService;

	@GetMapping
	public List<MomentVo> getMoment(){
		List<MomentVo> momentByUserId = momentService.getMomentByUserId(UserUtil.getUserId());
		return momentByUserId;
	}

	@PostMapping
	public boolean publishMoment(@RequestBody Moment moment) {
		moment.setCreateTime(LocalDate.now());
		moment.setUserId(UserUtil.getUserId());
		boolean save = momentService.save(moment);
		return save;
	}
}

