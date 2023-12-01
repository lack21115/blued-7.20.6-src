package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/DaoManager.class */
public class DaoManager {
    private static Map<ClassConnectionSource, Dao<?, ?>> classMap;
    private static Map<Class<?>, DatabaseTableConfig<?>> configMap;
    private static Logger logger = LoggerFactory.getLogger(DaoManager.class);
    private static Map<TableConfigConnectionSource, Dao<?, ?>> tableConfigMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/DaoManager$ClassConnectionSource.class */
    public static class ClassConnectionSource {
        Class<?> clazz;
        ConnectionSource connectionSource;

        public ClassConnectionSource(ConnectionSource connectionSource, Class<?> cls) {
            this.connectionSource = connectionSource;
            this.clazz = cls;
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassConnectionSource classConnectionSource = (ClassConnectionSource) obj;
            return this.clazz.equals(classConnectionSource.clazz) && this.connectionSource.equals(classConnectionSource.connectionSource);
        }

        public int hashCode() {
            return ((this.clazz.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/DaoManager$TableConfigConnectionSource.class */
    public static class TableConfigConnectionSource {
        ConnectionSource connectionSource;
        DatabaseTableConfig<?> tableConfig;

        public TableConfigConnectionSource(ConnectionSource connectionSource, DatabaseTableConfig<?> databaseTableConfig) {
            this.connectionSource = connectionSource;
            this.tableConfig = databaseTableConfig;
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TableConfigConnectionSource tableConfigConnectionSource = (TableConfigConnectionSource) obj;
            return this.tableConfig.equals(tableConfigConnectionSource.tableConfig) && this.connectionSource.equals(tableConfigConnectionSource.connectionSource);
        }

        public int hashCode() {
            return ((this.tableConfig.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }
    }

    public static void addCachedDatabaseConfigs(Collection<DatabaseTableConfig<?>> collection) {
        synchronized (DaoManager.class) {
            try {
                HashMap hashMap = configMap == null ? new HashMap() : new HashMap(configMap);
                for (DatabaseTableConfig<?> databaseTableConfig : collection) {
                    hashMap.put(databaseTableConfig.getDataClass(), databaseTableConfig);
                    logger.info("Loaded configuration for {}", databaseTableConfig.getDataClass());
                }
                configMap = hashMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void addDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        classMap.put(classConnectionSource, dao);
    }

    private static void addDaoToTableMap(TableConfigConnectionSource tableConfigConnectionSource, Dao<?, ?> dao) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        tableConfigMap.put(tableConfigConnectionSource, dao);
    }

    public static void clearCache() {
        synchronized (DaoManager.class) {
            try {
                if (configMap != null) {
                    configMap.clear();
                    configMap = null;
                }
                clearDaoCache();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void clearDaoCache() {
        synchronized (DaoManager.class) {
            try {
                if (classMap != null) {
                    classMap.clear();
                    classMap = null;
                }
                if (tableConfigMap != null) {
                    tableConfigMap.clear();
                    tableConfigMap = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        D d;
        synchronized (DaoManager.class) {
            try {
                if (connectionSource == null) {
                    throw new IllegalArgumentException("connectionSource argument cannot be null");
                }
                d = (D) doCreateDao(connectionSource, databaseTableConfig);
            } finally {
            }
        }
        return d;
    }

    public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao;
        synchronized (DaoManager.class) {
            try {
                if (connectionSource != null) {
                    D d = (D) lookupDao(new ClassConnectionSource(connectionSource, cls));
                    if (d != null) {
                        return d;
                    }
                    D d2 = (D) createDaoFromConfig(connectionSource, cls);
                    if (d2 != null) {
                        return d2;
                    }
                    DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
                    if (databaseTable != null && databaseTable.daoClass() != Void.class && databaseTable.daoClass() != BaseDaoImpl.class) {
                        Class<?> daoClass = databaseTable.daoClass();
                        Object[] objArr = new Object[2];
                        objArr[0] = connectionSource;
                        objArr[1] = cls;
                        Constructor<?> findConstructor = findConstructor(daoClass, objArr);
                        Constructor<?> constructor = findConstructor;
                        if (findConstructor == null) {
                            objArr = new Object[1];
                            objArr[0] = connectionSource;
                            constructor = findConstructor(daoClass, objArr);
                            if (constructor == null) {
                                throw new SQLException("Could not find public constructor with ConnectionSource and optional Class parameters " + daoClass + ".  Missing static on class?");
                            }
                        }
                        try {
                            createDao = (Dao) constructor.newInstance(objArr);
                            logger.debug("created dao for class {} from constructor", cls);
                            registerDao(connectionSource, createDao);
                            return (D) createDao;
                        } catch (Exception e) {
                            throw SqlExceptionUtil.create("Could not call the constructor in class " + daoClass, e);
                        }
                    }
                    DatabaseTableConfig<T> extractDatabaseTableConfig = connectionSource.getDatabaseType().extractDatabaseTableConfig(connectionSource, cls);
                    createDao = extractDatabaseTableConfig == null ? BaseDaoImpl.createDao(connectionSource, cls) : BaseDaoImpl.createDao(connectionSource, extractDatabaseTableConfig);
                    logger.debug("created dao for class {} with reflection", cls);
                    registerDao(connectionSource, createDao);
                    return (D) createDao;
                }
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static <D, T> D createDaoFromConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseTableConfig<?> databaseTableConfig;
        Map<Class<?>, DatabaseTableConfig<?>> map = configMap;
        if (map == null || (databaseTableConfig = map.get(cls)) == null) {
            return null;
        }
        return (D) doCreateDao(connectionSource, databaseTableConfig);
    }

    private static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao createDao;
        TableConfigConnectionSource tableConfigConnectionSource = new TableConfigConnectionSource(connectionSource, databaseTableConfig);
        D d = (D) lookupDao(tableConfigConnectionSource);
        if (d != null) {
            return d;
        }
        Class<T> dataClass = databaseTableConfig.getDataClass();
        ClassConnectionSource classConnectionSource = new ClassConnectionSource(connectionSource, dataClass);
        D d2 = (D) lookupDao(classConnectionSource);
        if (d2 != null) {
            addDaoToTableMap(tableConfigConnectionSource, d2);
            return d2;
        }
        DatabaseTable databaseTable = (DatabaseTable) databaseTableConfig.getDataClass().getAnnotation(DatabaseTable.class);
        if (databaseTable == null || databaseTable.daoClass() == Void.class || databaseTable.daoClass() == BaseDaoImpl.class) {
            createDao = BaseDaoImpl.createDao(connectionSource, databaseTableConfig);
        } else {
            Class<?> daoClass = databaseTable.daoClass();
            Object[] objArr = {connectionSource, databaseTableConfig};
            Constructor<?> findConstructor = findConstructor(daoClass, objArr);
            if (findConstructor == null) {
                throw new SQLException("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class " + daoClass);
            }
            try {
                createDao = (Dao) findConstructor.newInstance(objArr);
            } catch (Exception e) {
                throw SqlExceptionUtil.create("Could not call the constructor in class " + daoClass, e);
            }
        }
        addDaoToTableMap(tableConfigConnectionSource, createDao);
        logger.debug("created dao for class {} from table config", dataClass);
        if (lookupDao(classConnectionSource) == null) {
            addDaoToClassMap(classConnectionSource, createDao);
        }
        return (D) createDao;
    }

    private static Constructor<?> findConstructor(Class<?> cls, Object[] objArr) {
        boolean z;
        Constructor<?>[] constructors = cls.getConstructors();
        int length = constructors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Constructor<?> constructor = constructors[i2];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= parameterTypes.length) {
                        z = true;
                        break;
                    } else if (!parameterTypes[i4].isAssignableFrom(objArr[i4].getClass())) {
                        z = false;
                        break;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                if (z) {
                    return constructor;
                }
            }
            i = i2 + 1;
        }
    }

    private static <T> Dao<?, ?> lookupDao(ClassConnectionSource classConnectionSource) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        Dao<?, ?> dao = classMap.get(classConnectionSource);
        Dao<?, ?> dao2 = dao;
        if (dao == null) {
            dao2 = null;
        }
        return dao2;
    }

    private static <T> Dao<?, ?> lookupDao(TableConfigConnectionSource tableConfigConnectionSource) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        Dao<?, ?> dao = tableConfigMap.get(tableConfigConnectionSource);
        Dao<?, ?> dao2 = dao;
        if (dao == null) {
            dao2 = null;
        }
        return dao2;
    }

    public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        synchronized (DaoManager.class) {
            try {
                if (connectionSource != null) {
                    D d = (D) lookupDao(new TableConfigConnectionSource(connectionSource, databaseTableConfig));
                    if (d == null) {
                        return null;
                    }
                    return d;
                }
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            } finally {
            }
        }
    }

    public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, Class<T> cls) {
        D d;
        synchronized (DaoManager.class) {
            try {
                if (connectionSource == null) {
                    throw new IllegalArgumentException("connectionSource argument cannot be null");
                }
                d = (D) lookupDao(new ClassConnectionSource(connectionSource, cls));
            } finally {
            }
        }
        return d;
    }

    public static void registerDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            try {
                if (connectionSource == null) {
                    throw new IllegalArgumentException("connectionSource argument cannot be null");
                }
                addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } finally {
            }
        }
    }

    public static void registerDaoWithTableConfig(ConnectionSource connectionSource, Dao<?, ?> dao) {
        DatabaseTableConfig tableConfig;
        synchronized (DaoManager.class) {
            try {
                if (connectionSource == null) {
                    throw new IllegalArgumentException("connectionSource argument cannot be null");
                }
                if (!(dao instanceof BaseDaoImpl) || (tableConfig = ((BaseDaoImpl) dao).getTableConfig()) == null) {
                    addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
                } else {
                    addDaoToTableMap(new TableConfigConnectionSource(connectionSource, tableConfig), dao);
                }
            } finally {
            }
        }
    }

    private static void removeDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        Map<ClassConnectionSource, Dao<?, ?>> map = classMap;
        if (map != null) {
            map.remove(classConnectionSource);
        }
    }

    public static void unregisterDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            try {
                if (connectionSource == null) {
                    throw new IllegalArgumentException("connectionSource argument cannot be null");
                }
                removeDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } finally {
            }
        }
    }
}
