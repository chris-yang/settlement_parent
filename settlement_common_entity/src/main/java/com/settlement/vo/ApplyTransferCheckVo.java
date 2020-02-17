package com.settlement.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplyTransferCheckVo implements Serializable {
    private String checkResult;
    private String checkRemark;
    private Integer applyId;
    private String applyType;
}
