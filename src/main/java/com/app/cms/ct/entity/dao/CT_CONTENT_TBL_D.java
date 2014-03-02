package com.app.cms.ct.entity.dao;

import com.app.cms.ct.entity.CT_CONTENT_TBL_E;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 14-2-23.
 */
@Repository
@Transactional
public interface CT_CONTENT_TBL_D {
    public int insertContent(CT_CONTENT_TBL_E content);
    public int countAll();
}
