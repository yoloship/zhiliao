package xyz.yship.zhiliao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.yship.zhiliao.entity.UserLedger;
import xyz.yship.zhiliao.mapper.UserLedgerMapper;
import xyz.yship.zhiliao.service.IUserLedgerService;

@Service
public class UserLedgerServiceImpl extends ServiceImpl<UserLedgerMapper, UserLedger> implements IUserLedgerService {
}
