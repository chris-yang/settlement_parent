package com.settlement.utils;

/**
 * @description 常量类
 *
 * @author  admin
 * @date 2019/11/11.
 */
public class Const {
    /** 功能类型M 菜单*/
    public final static String MENU_TYPE_M = "M";
    /** 功能类型 B 按钮 */
    public final static String MENU_TYPE_B = "B";
    /** 功能类型 A Ajax */
    public final static String MENU_TYPE_A = "A";
    /** 启用状态Y-可用 */
    public final static String ENABLED_Y = "Y";
    /** 启用状态N-不可用*/
    public final static String ENABLED_N = "N";
    /** 删除状态N-使用中 */
    public final static String DEL_FLAG_N = "N";
    /** 删除状态D-删除 */
    public final static String DEL_FLAG_D = "D";
    /** 部门根节点CODE */
    public final static String DEPT_ROOT = "ROOT";
    /** 部门根节点ID */
    public final static Integer DEPT_ROOT_ID = 1;
    /** 数据字典根节点ID */
    public final static String DATA_DIC_ROOT = "DIC_ROOT";
    /** 权限菜单根节点ID */
    public final static Integer PERMISSION_ROOT_ID = 1;
    /** 添加标志 */
    public final static String MODE_ADD = "add";
    /** 修改标志 */
    public final static String MODE_UPDADTE = "update";
    /** slat */
    public final static String SALT = "12345678";
    /** 客户经理角色CODE:AM */
    public final static String ROLE_CODE_AM = "AM";
    /** 管理员角色CODE:ADMIN */
    public static final String ROLE_CODE_ADMIN = "ADMIN";
    /** 助理角色CODE：ASSISTANT */
    public final static String ROLE_CODE_ASSISTANT = "ASSISTANT";
    /** 结算负责人角色CODE：SETTLEMENT */
    public final static String ROLE_CODE_SETTLEMENT = "SETTLEMENT";
    /**审核状态父结点**/
    public static final String CHECK_STATUS_PARENT_CODE = "CHECKSTATUS";
    /** 审核状态NO_CHECK：待审核 */
    public final static String CHECK_STATUS_NO_CHECK = "NO_CHECK";
    /** 审核状态CHECK_PASS：审核通过*/
    public final static String CHECK_STATUS_CHECK_PASS = "CHECK_PASS";
    /** 审核状态CHECK_NOTPASS：审核未通过*/
    public final static String CHECK_STATUS_CHECK_NOPASS = "CHECK_NOPASS";
    /** 员工提交状态S：已提交 */
    public final static String EMP_SUBMIT_STATUS_S = "S";
    /** 员工提交状态N：未提交*/
    public final static String EMP_SUBMIT_STATUS_N = "N";
    /** 级别填写模式CODE： LEVEL_INPUT_TYPE*/
    public final static String LEVEL_TYPE_PARENT_CODE = "LEVEL_INPUT_TYPE";
    /** 合同状态 Y*/
    public final static String CONTRACT_STATUS_Y ="Y";
    /** 合同状态 N*/
    public final static String CONTRACT_STATUS_N ="N";
    ///////////////////////////////////////数据字典/////////////////////////////////////////////////////
    /**菜单类型根结点**/
    public final static String PERMISSION_TYPE_CODE="PERMISSION_TYPE";
    /** 级别填写模式F： 框架协议 */
    public final static String LEVEL_MODE_F = "F";
    /** 级别填写模式H：手动填写 */
    public final static String LEVEL_MODE_H = "H";
    /** 单位父CODE: UNIT */
    public final static String UNIT_PARENT_CODE = "UNIT";
    /** 上传图片存放实际路径 */
    public final static String IMG_UPLOAD_PATH = "file:F:/MyProjectName/";
    /**结算时间点参数 时间点**/
    public static final String TIME_PARAM_PARENT = "TIME_PARAM";
    /**结算时间点参数 结算时间点**/
    public final static String TIME_PRAMA_STOP="TIME_STOP";
    /**结算时间点参数 结算完成时间点**/
    public final static String TIME_PRAMA_COMPELETE="TIME_COMPLETE";
    /** 考勤提交状态父：已提交  未提交 */
    public final static String SUB_STATUS= "SUB_STATUS";
    /** 考勤提交状态S：申请修改中 */
    public static final String SUB_STATUS_A = "A";
    /** 考勤提交状态S：已提交 */
    public final static String SUB_STATUS_S = "S";
    /** 考勤提交状态N：未提交*/
    public final static String SUB_STATUS_N = "N";
    /**员工项目L: 离场 **/
    public static final String EMP_ENTRANCE_STATUS_L ="L" ;
    /**员工项目I: 在场**/
    public static final String EMP_ENTRANCE_STATUS_I ="I" ;
    /** 员工项目N：未入场 */
    public final static String EMP_ENTRANCE_STATUS_N = "N";
    /**员工O: 在职**/
    public static final String EMP_JOB_STATUS_O = "O";
    /**员工L: 离职**/
    public static final String EMP_JOB_STATUS_L = "L";
    /** 在职状态 */
    public final static String JOB_STATUS_O = "O";
    /** 离职状态 */
    public final static String JOB_STATUS_L = "L";
    /** 入场状态 */
    public final static String ENTRANCE_STATUS_I = "I";
    /** 离场状态 */
    public final static String ENTRANCE_STATUS_L = "L";
    /** 数据字典：项目组审核CODE */
    public final static String PG_CHECKSTATUS_CODE = "PG_CHECKSTATUS";
    /** 数据字典： 审核结果CODE */
    public final static String CHECK_RESULT_CODE = "CHECK_RESULT";
    /** 数据字典：审核结果：通过-PASS */
    public final static String CHECK_RESULT_PASS_CODE = "PASS";
    /** 数据字典：审核结果：不通过-NOPASS */
    public final static String CHECK_RESULT_NOPASS_CODE = "NOPASS";
    /** 数据字典：考勤 申请修改类型 */
    public static final Object APPLY_TYPE = "WORKATTENDANCE";
    /** 员工申请修改状态A：申请修改中 */
    public final static String EMP_APPLY_UPDATE_STATUS_A = "APPLYING";
    /** 员工申请修改状态F：修改完成 */
    public final static String EMP_APPLY_UPDATE_STATUS_F = "UPDATE_FINISH";
    /** 完成状态：完成 */
    public final static String END_STATUS_END_CODE = "END";
    /** 完成状态：未完成 */
    public final static String END_STATUS_NO_END_CODE = "NO_END";
    /** 完成状态CODE */
    public final static String END_STATUS_CODE = "END_STATSU";
    /** 用户停用类型CODE */
    public final static String USER_STOP_TYPE_CODE = "STOP_TYPE";
    /** 申请移交 **/
    public static final String APPLY_TRANSFER = "TRANSFER_TYPE";
    /** 申请移交 客户**/
    public static final String APPLY_TRANSFER_CUSTOMER = "TRANSFER_CUSTOMER";
    /** 申请移交 项目**/
    public static final String APPLY_TRANSFER_PROJECT = "TRANSFER_PROJECT";


}
