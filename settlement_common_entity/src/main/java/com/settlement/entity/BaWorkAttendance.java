package com.settlement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 考勤表
 * </p>
 *
 * @author kun
 * @since 2019-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaWorkAttendance extends Model<BaWorkAttendance> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Float workDays;

    private Float attendanceDays;

    private Float absenteeismDays;

    private BigDecimal floatPerformance;

    private BigDecimal bonus;

    private Integer checkWorkDays;

    private Float workDayOvertimeH;

    private Float weekendOvertimeH;

    private Float festivalOvertimeH;

    private Float workDayOvertimeD;

    private Float weekendOvertimeD;

    private Float festivalOvertimeD;

    private Float remainderOvertimeLmH;

    private Float monthOvertimeH;

    private Float takeHoursOff;

    private String details;

    private Float remainderOvertimeMH;

    private BigDecimal taxiFare;

    private BigDecimal travelExpenses;

    private BigDecimal meals;

    private BigDecimal telephoneBill;

    private BigDecimal overtimeAllowance;

    private BigDecimal otherAddCost;

    private BigDecimal otherSubCost;

    private String remark;

    private String subStatus;

    private Date createTime;

    private Integer pgId;

    private Integer employeeId;

    private String workMonth;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
