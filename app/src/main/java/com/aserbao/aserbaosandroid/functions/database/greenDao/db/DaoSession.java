package com.aserbao.aserbaosandroid.functions.database.greenDao.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.taxidata.bean.HotSpotHistorySearch;
import com.example.taxidata.bean.HotSpotOrigin;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.HotSpotHistorySearchDao;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.HotSpotOriginDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig hotSpotHistorySearchDaoConfig;
    private final DaoConfig hotSpotOriginDaoConfig;

    private final HotSpotHistorySearchDao hotSpotHistorySearchDao;
    private final HotSpotOriginDao hotSpotOriginDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        hotSpotHistorySearchDaoConfig = daoConfigMap.get(HotSpotHistorySearchDao.class).clone();
        hotSpotHistorySearchDaoConfig.initIdentityScope(type);

        hotSpotOriginDaoConfig = daoConfigMap.get(HotSpotOriginDao.class).clone();
        hotSpotOriginDaoConfig.initIdentityScope(type);

        hotSpotHistorySearchDao = new HotSpotHistorySearchDao(hotSpotHistorySearchDaoConfig, this);
        hotSpotOriginDao = new HotSpotOriginDao(hotSpotOriginDaoConfig, this);

        registerDao(HotSpotHistorySearch.class, hotSpotHistorySearchDao);
        registerDao(HotSpotOrigin.class, hotSpotOriginDao);
    }
    
    public void clear() {
        hotSpotHistorySearchDaoConfig.clearIdentityScope();
        hotSpotOriginDaoConfig.clearIdentityScope();
    }

    public HotSpotHistorySearchDao getHotSpotHistorySearchDao() {
        return hotSpotHistorySearchDao;
    }

    public HotSpotOriginDao getHotSpotOriginDao() {
        return hotSpotOriginDao;
    }

}
