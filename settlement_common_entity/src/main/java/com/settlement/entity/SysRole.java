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
    * 角色表
    * </p>
*
* @author kun
* @since 2019-11-07
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String roleCnName;

    private String roleEnName;

    private String roleCode;

    private String remark;

    private Integer createUserId;

    private Date createTime;

    private String delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
