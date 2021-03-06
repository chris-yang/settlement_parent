package com.settlement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.settlement.bo.PageData;
import com.settlement.co.WorkAttendanceCo;
import com.settlement.entity.BaWorkAttendance;
import com.settlement.mapper.BaWorkAttendanceMapper;
import com.settlement.service.BaWorkAttendanceService;
import com.settlement.utils.Const;
import com.settlement.utils.HttpResultEnum;
import com.settlement.utils.Result;
import com.settlement.vo.BaWorkAttendanceVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

/**
 * <p>
 * 考勤表 服务实现类
 * </p>
 *
 * @author kun
 * @since 2019-12-03
 */
@Service
public class BaWorkAttendanceServiceImpl extends ServiceImpl<BaWorkAttendanceMapper, BaWorkAttendance> implements BaWorkAttendanceService {

    /**
     * 加载列表页面
     * @param workAttendanceCo
     * @return
     */
    @Override
    public PageData listPageData(WorkAttendanceCo workAttendanceCo) {
        workAttendanceCo.setDelFlag(Const.DEL_FLAG_N);
        Page<BaWorkAttendanceVo> page = new Page<>(workAttendanceCo.getPage(),workAttendanceCo.getLimit());
        List<BaWorkAttendanceVo> baWorkAttendanceVos = this.baseMapper.getWorkAttendanceVoByProjectId(workAttendanceCo,page);
        page.setRecords(baWorkAttendanceVos);
        return new PageData(page.getTotal(),page.getRecords());
    }

    /**
     * 考勤申请修改页面数据
     * @param workAttendanceCo
     * @return
     */
    @Override
    public PageData listApplyPageData(WorkAttendanceCo workAttendanceCo) {
        workAttendanceCo.setDelFlag(Const.DEL_FLAG_N);
        /**查询条件-当前项目审核 S**/
        workAttendanceCo.setSubStatus(Const.SUB_STATUS_S);
        Page<BaWorkAttendanceVo> page = new Page<>(workAttendanceCo.getPage(),workAttendanceCo.getLimit());
        List<BaWorkAttendanceVo> baWorkAttendanceVos = this.baseMapper.getWorkAttendanceVoByProjectId(workAttendanceCo,page);
        page.setRecords(baWorkAttendanceVos);
        return new PageData(page.getTotal(),page.getRecords());
    }

    /**
     * 生成考勤记录
     * @param ids
     * @param pgId
     * @return
     */
    @Override
    public Result generateWorkAttendance(String ids, Integer pgId) {
        List<BaWorkAttendance> baWorkAttendances = new ArrayList<>();
        Result r = new Result(HttpResultEnum.GEN_CODE_500.getCode(), HttpResultEnum.GEN_CODE_500.getMessage());
        if (StringUtils.isNotBlank(ids)) {
            String[] idArr = ids.split(",");
            for(String id:idArr) {
                BaWorkAttendance baWorkAttendance = new BaWorkAttendance();
                baWorkAttendance.setWorkDays(21.5f);
                baWorkAttendance.setEmployeeId(Integer.parseInt(id));
                baWorkAttendance.setPgId(pgId);
                baWorkAttendance.setSubStatus(Const.SUB_STATUS_N);
                baWorkAttendance.setCreateTime(new Date());
                baWorkAttendances.add(baWorkAttendance);
            }
            Integer ret = this.baseMapper.insertBatch(baWorkAttendances);
            if(ret!=null && ret>0) {
                r.setCode(HttpResultEnum.GEN_CODE_200.getCode());
                r.setMsg(HttpResultEnum.GEN_CODE_200.getMessage());
            }
        }

        return r;
    }

    /**
     * 检查数据是否有修改中的数据,不能提交
     * @param ids
     * @return
     */
    @Override
    public Result checkStatus(Integer[] ids) {
        Result r = new Result(HttpResultEnum.CODE_1.getCode(), HttpResultEnum.CODE_1.getMessage());
        QueryWrapper<BaWorkAttendance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sub_status", Const.SUB_STATUS_A);
        queryWrapper.in("id",ids);
        List<BaWorkAttendance> baWorkAttendances = this.baseMapper.selectList(queryWrapper);
        if(baWorkAttendances!=null && baWorkAttendances.size()>0) {
            r.setCode(HttpResultEnum.CODE_0.getCode());
            r.setMsg(HttpResultEnum.CODE_0.getMessage());
            r.setData(baWorkAttendances);
        }
        return r;
    }

    /**
     *  添加
     * @param baWorkAttendanceVo
     * @return
     */
    @Override
    public Result add(BaWorkAttendanceVo baWorkAttendanceVo) {
        Result r =  new Result(HttpResultEnum.ADD_CODE_500.getCode(), HttpResultEnum.ADD_CODE_500.getMessage());
        baWorkAttendanceVo.setCreateTime(new Date());
        try {
            Integer ret = this.baseMapper.insert(baWorkAttendanceVo);
            if (ret != null && ret > 0) {
                r.setCode(HttpResultEnum.ADD_CODE_200.getCode());
                r.setMsg(HttpResultEnum.ADD_CODE_200.getMessage());
            }
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return  r;
    }

    /**
     * 修改
     * @param baWorkAttendance
     * @return
     */
    @Override
    public Result update(BaWorkAttendance baWorkAttendance) {
        Result r = new Result(HttpResultEnum.EDIT_CODE_500.getCode(), HttpResultEnum.EDIT_CODE_500.getMessage());
        UpdateWrapper<BaWorkAttendance> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",baWorkAttendance.getId());
        try {
            Integer ret = this.baseMapper.update(baWorkAttendance, updateWrapper);
            if (ret != null && ret > 0) {
                r.setCode(HttpResultEnum.EDIT_CODE_200.getCode());
                r.setMsg(HttpResultEnum.EDIT_CODE_200.getMessage());
            }
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return r;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public BaWorkAttendanceVo getBaWorkAttendanceVoById(Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("delFlag", Const.DEL_FLAG_N);
        map.put("id",id);
        BaWorkAttendanceVo baWorkAttendanceVo = this.baseMapper.getBaWorkAttendanceVoById(map);
        return baWorkAttendanceVo;
    }

    /**
     * 根据年月查询考勤记录
     * @param map
     * @return
     */
    @Override
    public List<BaWorkAttendance> getBaWorkAttendanceVoByNextMonth(Map<String,String> map) {
        map.put("delFlag", Const.DEL_FLAG_N);
        return this.baseMapper.getBaWorkAttendanceVoByNextMonth(map);
    }

    /**
     * 提交考勤记录
     * @param ids
     * @return
     */
    @Override
    public Result commitWorkAttendance(String[] ids) {
        Result r = new Result(HttpResultEnum.COMMIT_CODE_500.getCode(), HttpResultEnum.COMMIT_CODE_500.getMessage());
        List<BaWorkAttendance> baWorkAttendances = new ArrayList<>();
        for(String id:ids) {
            BaWorkAttendance baWorkAttendance = this.baseMapper.selectById(id);
            baWorkAttendance.setSubStatus(Const.EMP_SUBMIT_STATUS_S);
            baWorkAttendances.add(baWorkAttendance);
            //ret = this.baseMapper.updateById(baWorkAttendance);
        }
        Integer ret = this.baseMapper.updateSubStatusBatch(baWorkAttendances);
        if(ret != null && ret > 0 ) {
            r.setCode(HttpResultEnum.COMMIT_CODE_200.getCode());
            r.setMsg(HttpResultEnum.COMMIT_CODE_200.getMessage());
        }
        return r;
    }

    /**
     * 根据申请修改的考勤id获得要修改的数据
     * @param workAttendanceCo
     * @return
     */
    @Override
    public PageData getWorkAttendanceByApplyId(WorkAttendanceCo workAttendanceCo) {
        Map<String,Object> map = new HashMap<>();
        workAttendanceCo.setDelFlag(Const.DEL_FLAG_N);
        workAttendanceCo.setSubStatus(Const.EMP_SUBMIT_STATUS_N);
        Page<BaWorkAttendanceVo> page = new Page<>(workAttendanceCo.getPage(),workAttendanceCo.getLimit());
        List<BaWorkAttendanceVo> baWorkAttendanceVos = this.baseMapper.getWorkAttendanceByApplyId(workAttendanceCo,page);
        page.setRecords(baWorkAttendanceVos);
        return new PageData(page.getTotal(),page.getRecords());
    }
}
