package com.app.cms.bb.dao;

import com.app.cms.bb.entity.IN_OUT_E;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 14-3-1.
 */
@Repository
@Transactional
public interface IN_OUT_D {
    public int insertIN_OUT_Case(IN_OUT_E inout);
    public List<Integer> getIN_IDS();
    public List<Integer> getOUT_IDS();
//public int countAll();
}
