package com.aserbao.aserbaosandroid.functions.database.greenDao.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.taxidata.ui.passengerpath.enity.OriginEndInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORIGIN_END_INFO".
*/
public class OriginEndInfoDao extends AbstractDao<OriginEndInfo, Long> {

    public static final String TABLENAME = "ORIGIN_END_INFO";

    /**
     * Properties of entity OriginEndInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Origin = new Property(1, String.class, "origin", false, "ORIGIN");
        public final static Property End = new Property(2, String.class, "end", false, "END");
        public final static Property OriginLng = new Property(3, double.class, "originLng", false, "ORIGIN_LNG");
        public final static Property OriginLat = new Property(4, double.class, "originLat", false, "ORIGIN_LAT");
        public final static Property EndLng = new Property(5, double.class, "endLng", false, "END_LNG");
        public final static Property EndLat = new Property(6, double.class, "endLat", false, "END_LAT");
    }


    public OriginEndInfoDao(DaoConfig config) {
        super(config);
    }
    
    public OriginEndInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORIGIN_END_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ORIGIN\" TEXT," + // 1: origin
                "\"END\" TEXT," + // 2: end
                "\"ORIGIN_LNG\" REAL NOT NULL ," + // 3: originLng
                "\"ORIGIN_LAT\" REAL NOT NULL ," + // 4: originLat
                "\"END_LNG\" REAL NOT NULL ," + // 5: endLng
                "\"END_LAT\" REAL NOT NULL );"); // 6: endLat
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORIGIN_END_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OriginEndInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String origin = entity.getOrigin();
        if (origin != null) {
            stmt.bindString(2, origin);
        }
 
        String end = entity.getEnd();
        if (end != null) {
            stmt.bindString(3, end);
        }
        stmt.bindDouble(4, entity.getOriginLng());
        stmt.bindDouble(5, entity.getOriginLat());
        stmt.bindDouble(6, entity.getEndLng());
        stmt.bindDouble(7, entity.getEndLat());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OriginEndInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String origin = entity.getOrigin();
        if (origin != null) {
            stmt.bindString(2, origin);
        }
 
        String end = entity.getEnd();
        if (end != null) {
            stmt.bindString(3, end);
        }
        stmt.bindDouble(4, entity.getOriginLng());
        stmt.bindDouble(5, entity.getOriginLat());
        stmt.bindDouble(6, entity.getEndLng());
        stmt.bindDouble(7, entity.getEndLat());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public OriginEndInfo readEntity(Cursor cursor, int offset) {
        OriginEndInfo entity = new OriginEndInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // origin
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // end
            cursor.getDouble(offset + 3), // originLng
            cursor.getDouble(offset + 4), // originLat
            cursor.getDouble(offset + 5), // endLng
            cursor.getDouble(offset + 6) // endLat
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OriginEndInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOrigin(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setEnd(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setOriginLng(cursor.getDouble(offset + 3));
        entity.setOriginLat(cursor.getDouble(offset + 4));
        entity.setEndLng(cursor.getDouble(offset + 5));
        entity.setEndLat(cursor.getDouble(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(OriginEndInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(OriginEndInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(OriginEndInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
