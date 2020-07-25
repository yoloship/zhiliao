package xyz.yship.zhiliao.vo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import lombok.Data;
import xyz.yship.zhiliao.entity.User;

@Data
public class UserVo {
	String email;
	String password;

}
