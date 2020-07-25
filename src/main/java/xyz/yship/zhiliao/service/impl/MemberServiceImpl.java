package xyz.yship.zhiliao.service.impl;

import xyz.yship.zhiliao.entity.Member;
import xyz.yship.zhiliao.mapper.MemberMapper;
import xyz.yship.zhiliao.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账本与成员桥梁表 服务实现类
 * </p>
 *
 * @author yship
 * @since 2020-04-03
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
