package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/misc/BaseDaoEnabled.class */
public abstract class BaseDaoEnabled<T, ID> {
    protected transient Dao<T, ID> dao;

    private void checkForDao() throws SQLException {
        if (this.dao != null) {
            return;
        }
        throw new SQLException("Dao has not been set on " + getClass() + " object: " + this);
    }

    public int create() throws SQLException {
        checkForDao();
        return this.dao.create(this);
    }

    public int delete() throws SQLException {
        checkForDao();
        return this.dao.delete((Dao<T, ID>) this);
    }

    public ID extractId() throws SQLException {
        checkForDao();
        return this.dao.extractId(this);
    }

    public Dao<T, ID> getDao() {
        return this.dao;
    }

    public String objectToString() {
        try {
            checkForDao();
            return this.dao.objectToString(this);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean objectsEqual(T t) throws SQLException {
        checkForDao();
        return this.dao.objectsEqual(this, t);
    }

    public int refresh() throws SQLException {
        checkForDao();
        return this.dao.refresh(this);
    }

    public void setDao(Dao<T, ID> dao) {
        this.dao = dao;
    }

    public int update() throws SQLException {
        checkForDao();
        return this.dao.update((Dao<T, ID>) this);
    }

    public int updateId(ID id) throws SQLException {
        checkForDao();
        return this.dao.updateId(this, id);
    }
}
