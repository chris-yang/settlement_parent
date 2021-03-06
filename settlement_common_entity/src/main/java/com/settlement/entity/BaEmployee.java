package com.settlement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaEmployee extends Model<BaEmployee> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工编号
     */
    private String code;

    /**
     * 入场时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date entranceTime;

    /**
     * 证件号码
     */
    private String cardNo;

    /**
     * 员工所在地
     */
    private String place;

    /**
     * 客户负责人
     */
    private String responsiblePerson;

    /**
     * 客户负责人邮件地址
     */
    private String rpEmail;

    /**
     * 发送抄送人邮件地址
     */
    private String sendCopyEmail;

    /**
     * 岗位
     */
    private String position;

    /**
     * 级别模式: F-框架协议 H-手动填写
     */
    private String levelMode;

    /**
     * 级别
     */
    private Integer posLevel;

    /**
     * 级别-手填
     */
    private String posLevelInput;

    /**
     * 单价月
     */
    private BigDecimal priceMonth;

    /**
     * 单位
     */
    private String unit;

    /**
     * 单价天
     */
    private BigDecimal priceDay;

    /**
     * 报销接口人
     */
    private String claimExpensePerson;

    /**
     * 考勤负责人
     */
    private String workAttendencePerson;

    /**
     * 员工月薪
     */
    private BigDecimal salaryMonth;

    /**
     * 员工日薪
     */
    private BigDecimal salaryDay;

    /**
     * 上传客户rate邮件
     */
    private String uploadRateEmail;

    /**
     * rate邮件文件名称
     */
    private String rateEmailFilename;

    /**
     * 在职、离职状态
     */
    private String jobStatus;

    /**
     * 入场、离场状态
     */
    private String entranceStatus;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 申请修改状态
     */
    private String applyUpdateStatus;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标志
     */
    private String delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
