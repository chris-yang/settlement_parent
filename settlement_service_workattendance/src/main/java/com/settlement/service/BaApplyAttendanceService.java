package com.settlement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.settlement.entity.BaApplyAttendance;
import com.settlement.utils.Result;

/**
 * <p>
 * 申请考勤关联 服务类
 * </p>
 *
 * @author kun
 * @since 2019-12-03
 */
public interface BaApplyAttendanceService extends IService<BaApplyAttendance> {
    /**添加申请修改记录**/
    Result add(BaApplyAttendance baApplyAttendance);
    /**检查数据是否有修改中的数据,不能提交**/
    Result checkApplyModify(Integer[] ids);
}
