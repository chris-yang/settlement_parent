package com.settlement.controller;


import com.settlement.bo.PageData;
import com.settlement.co.ApplyTransferCo;
import com.settlement.service.BaApplyTransferService;
import com.settlement.utils.Result;
import com.settlement.vo.ApplyTransferCheckVo;
import com.settlement.vo.BaApplyTransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 申请移交项目和客户 前端控制器
 * </p>
 *
 * @author kun
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/ba-apply-transfer")
public class BaApplyTransferController {

    @Autowired
    private BaApplyTransferService baApplyTransferService;

    /**
     * 加载移交审核列表
     * @param applyTransferCo
     * @return
     */
    @GetMapping("/check/pagedata")
    public PageData listPage(ApplyTransferCo applyTransferCo) {
        return baApplyTransferService.listPage(applyTransferCo);
    }

    /**
     * 审核列表-详细
     * @param applyTransferCo
     * @return
     */
    @GetMapping("/check/detail/pagedata")
    public PageData detailListPage(ApplyTransferCo applyTransferCo){
        return baApplyTransferService.detailListPage(applyTransferCo);
    }

    /**
     * 审核移交操作
     * @param applyTransferCheckVo
     * @return
     */
    @PutMapping("/check")
    public Result checkApply(ApplyTransferCheckVo applyTransferCheckVo) {
        return baApplyTransferService.checkApply(applyTransferCheckVo);
    }

    /**
     * 项目移交
     * @return
     */
    @PostMapping("/apply/pg/transfer")
    public Result projectApplyTransfer(BaApplyTransferVo baApplyTransferVo){
        return this.projectApplyTransfer(baApplyTransferVo);
    }

    /**
     * 客户移交
     * @return
     */
    @PostMapping("/apply/customer/transfer")
    public Result customerApplyTransfer(BaApplyTransferVo baApplyTransferVo){
        return this.customerApplyTransfer(baApplyTransferVo);
    }
}
