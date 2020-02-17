package com.settlement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.settlement.entity.SysDeptRole;
import com.settlement.utils.Result;
import com.settlement.vo.SysDeptVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kun
 * @since 2019-12-01
 */
public interface SysDeptRoleService extends IService<SysDeptRole> {
    /**添加部门角色**/
    Result add(SysDeptVo sysDeptVo);
    /**修改部门角色**/
    Result update(SysDeptVo sysDeptVo);
    /**修改部门角色**/
    Result delete(Integer deptId);

}
