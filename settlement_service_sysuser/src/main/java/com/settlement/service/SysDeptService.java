package com.settlement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.settlement.entity.SysDept;
import com.settlement.utils.Result;
import com.settlement.vo.SysDeptVo;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author kun
 * @since 2019-11-07
 */
public interface SysDeptService extends IService<SysDept> {

    Result getDeptSelect();
    /**加载部门树列表**/
    List<SysDeptVo>  getDeptTreeList() ;
    /**添加 **/
    Result add(SysDeptVo sysDeptVo);
    /**修改**/
    Result update(SysDeptVo sysDeptVo);
    /**删除 **/
    Result delete(Integer id);
    /**检查编码是否存在**/
    Result deptCodeIsExist(String dicCode);
    /**启用状态 **/
    Result updateEnableStart(Integer id);
    /**停用状态 **/
    Result updateEnableStop(Integer id);
    /**根据id获得SysPermissionVo**/
    SysDeptVo getSysDeptVoById(Integer id);
    /**根据id获得SysPermissionVo根结点信息**/
    SysDeptVo getRootSysDeptVoById(String rootCode);
    /**根据部门id下的角色获得用户**/
    Result getDeptRoleUsers(Integer deptId);
    /**根据客户id获得所在的部门**/
    SysDept getDeptByCustomerId(Integer customerId);
}
