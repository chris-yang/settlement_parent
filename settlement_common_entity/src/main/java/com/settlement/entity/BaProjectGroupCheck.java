package com.settlement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 项目审核表
 * </p>
 *
 * @author admin
 * @since 2019-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaProjectGroupCheck extends Model<BaProjectGroupCheck> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String checkStatus;

    private String remark;

    private Integer checkUserId;

    private Integer pgId;

    private Date checkTime;

    private Date applyTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
