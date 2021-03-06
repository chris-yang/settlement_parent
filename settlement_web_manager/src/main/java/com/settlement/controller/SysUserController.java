package com.settlement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.settlement.bo.PageData;
import com.settlement.co.UserCo;
import com.settlement.entity.SysUser;
import com.settlement.service.SysUserRoleService;
import com.settlement.service.SysUserService;
import com.settlement.utils.Const;
import com.settlement.utils.HttpResultEnum;
import com.settlement.utils.Result;
import com.settlement.vo.SysUserVo;
import com.settlement.vo.UserStopVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author admin
 * @since 2019-11-07
 */

@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;


    /**
     * @description 用户列表
     *
     * @param userCo    用户查询条件
     * @return
     */
    @GetMapping("/sys-user/pagedata")
    public PageData getUserList(UserCo userCo) {
//        IPage<SysUser> page = new Page<SysUser>(userCo.getPage(), userCo.getLimit());
//        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
//        queryWrapper.eq("del_flag", Const.DEL_FLAG_N);
//        queryWrapper.like(StringUtils.isNotBlank(userCo.getKeyword()),"real_name",userCo.getKeyword());
//        queryWrapper.orderByDesc("create_time");
//        this.sysUserService.page(page, queryWrapper);
//        return new PageData(page.getTotal(), page.getRecords());
        return sysUserService.getUserList(userCo);
    }

    /**
     * @description  用户新增
     *
     * @param sysUser            用户信息
     * @param request
     * @return
     */
    @PostMapping("/sys-user/add")
    public Result userAdd(SysUserVo sysUser, HttpServletRequest request) {
        sysUser.setCreateTime(new Date());
        sysUser.setEnabled(Const.ENABLED_Y);
        sysUser.setSalt(Const.SALT);
        // session取得当前用户
      //  SysUser loginuser = (SysUser)request.getSession().getAttribute("user");
      //  sysUser.setCreateUserId(loginuser.getId());
        sysUser.setDelFlag(Const.DEL_FLAG_N);
        Result r = this.sysUserService.saveUser(sysUser);
        return r;
    }

    /**
     * @description 用户编辑
     *
     * @param sysUser              用户信息
     * @return
     */
    @PutMapping("/sys-user/edit")
    public Result userEdit(SysUserVo sysUser) {
        return this.sysUserService.updateUser(sysUser);
    }

    /**
     * @description 检查邮箱是否存在
     *
     * @param email               邮箱
     * @return
     */
    @GetMapping("/sys-user/isexist/{email}")
    public Result userIsExist(@PathVariable  String email) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("email",email);
       //  queryWrapper.eq("del_flag", Const.DEL_FLAG_N);
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        Result r = null;
        if (sysUser == null) {
            r = new Result(HttpResultEnum.USER_ISEXIST_0 .getCode(), HttpResultEnum.USER_ISEXIST_0.getMessage());
        } else {
            r = new Result(HttpResultEnum.USER_ISEXIST_1 .getCode(), HttpResultEnum.USER_ISEXIST_1.getMessage());
        }
        return r;
    }

    /**
     * @description  用户删除
     *
     * @param id             用户ID
     * @return
     */
    @DeleteMapping("/sys-user/del/{id}")
    public Result userDelete(@PathVariable Integer id) {
        // 如果启用中，不能删除

        return this.sysUserService.deleteUser(id);
    }

    /**
     * @description 重置密码
     *
     * @param id               用户ID
     * @return
     */
    @GetMapping("/sys-user/resetpass/{id}")
    public Result resetPass(@PathVariable  Integer id) {
        return sysUserService.updateUserDefaultPassword(id);
    }

    /**
     * 修改密码
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/sys-user/update/password")
    public Result updatePassword(String password, HttpSession session) {

        Result r = new Result(HttpResultEnum.EDIT_CODE_500.getCode(), HttpResultEnum.EDIT_CODE_500.getMessage());
        SysUser user = (SysUser)session.getAttribute("user");
        Integer userId=user.getId();
        user.setPassword(password);
        UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",userId);
        boolean ret = sysUserService.update(user,updateWrapper);
        if(ret) {
            r.setCode(HttpResultEnum.EDIT_CODE_200.getCode());
            r.setMsg(HttpResultEnum.EDIT_CODE_200.getMessage());
        }
        return r;
    }
    /**
     * @description 启用
     *
     * @param id              用户ID
     * @return
     */
    @PutMapping("/sys-user/start/{id}")
    public Result userStart(@PathVariable  Integer id) {
        return sysUserService.updateUserStart(id);
    }

    /**
     * 用户停用
     * @param userStopVo
     * @return
     */
    @PutMapping("/sys-user/stop/")
    public Result userStop(UserStopVo userStopVo){
        return sysUserService.userStop(userStopVo);
    }

    /**
     *@description 根据角色ID查询用户
     *
     * @param roleId
     * @return
     */
    @GetMapping("/sys-user/userselect/{roleId}/{userId}/{deptId}")
    public Result getUserSelectByRoleDept(@PathVariable Integer roleId, @PathVariable Integer userId, @PathVariable Integer deptId) {
        return sysUserService.getUserSelectByRoleDept(roleId, userId, deptId);
    }

    /**
     * @description 取得客户经理下拉框
     *
     * @auth admin
     * @date 2019-11-21
     * @return
     */
    @GetMapping("/sys-user/amselect")
    public Result getAmSelect() {
        // 从session中取得当前用户部门
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("deptId",user.getDeptId());
        paramMap.put("amRoleCode", Const.ROLE_CODE_AM);
        paramMap.put("enabled", Const.ENABLED_Y);
        return this.sysUserService.getAmSelect(paramMap);
    }

    /**
     * 根据deptId和roleCode获得当前部门下的AM角色的用户
     * @param deptId
     * @return
     */
    @GetMapping("/sys-user/dept/role/users/{deptId}")
    public Result getUserByDeptIdAndRoleCode(@PathVariable(value="deptId") Integer deptId) {
        return  this.sysUserService.getUserByDeptIdAndRoleCode(deptId);
    }
    /**
     * @description 助理下拉框
     *
     * @auth admin
     * @date 2019-11-22
     * @return
     */
    @GetMapping("/sys-user/assistant-select")
    public Result getAssistantSelect() {
        // 从session中取得当前用户部门
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("deptId",user.getDeptId());
        paramMap.put("assistantRoleCode", Const.ROLE_CODE_ASSISTANT);
        paramMap.put("enabled", Const.ENABLED_Y);
        return this.sysUserService.getAssistantSelect(paramMap);
    }

    /**
     * @description 结算负责人下拉框
     *
     * @auth admin
     * @date 2019-11-22
     * @return
     */
    @GetMapping("/sys-user/settlement-select")
    public Result getSettlementSelect() {
        // 从session中取得当前用户部门
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("settlementRoleCode", Const.ROLE_CODE_SETTLEMENT);
        paramMap.put("enabled", Const.ENABLED_Y);
        return this.sysUserService.getSettlementSelect(paramMap);
    }
}
