package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/LazyForeignCollection.class */
public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5460708106909626233L;
    private transient CloseableIterator<T> lastIterator;

    public LazyForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        super(dao, obj, obj2, fieldType, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloseableIterator<T> seperateIteratorThrow(int i) throws SQLException {
        if (this.dao != null) {
            return this.dao.iterator(getPreparedQuery(), i);
        }
        throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public void closeLastIterator() throws SQLException {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return closeableIterator(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> closeableIterator(int i) {
        try {
            return iteratorThrow(i);
        } catch (SQLException e) {
            throw new IllegalStateException("Could not build lazy iterator for " + this.dao.getDataClass(), e);
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.util.Collection
    public boolean contains(Object obj) {
        CloseableIterator<T> it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                        return false;
                    } catch (SQLException e) {
                        return false;
                    }
                }
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException e2) {
                }
                throw th;
            }
        } while (!it.next().equals(obj));
        try {
            it.close();
            return true;
        } catch (SQLException e3) {
            return true;
        }
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet(collection);
        CloseableIterator<T> it = iterator();
        while (it.hasNext()) {
            try {
                hashSet.remove(it.next());
            } finally {
                try {
                    it.close();
                } catch (SQLException e) {
                }
            }
        }
        boolean isEmpty = hashSet.isEmpty();
        try {
            return isEmpty;
        } catch (SQLException e2) {
            return isEmpty;
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable() {
        return getWrappedIterable(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable(final int i) {
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() { // from class: com.j256.ormlite.dao.LazyForeignCollection.1
            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return LazyForeignCollection.this.seperateIteratorThrow(i);
                } catch (Exception e) {
                    throw new IllegalStateException("Could not build lazy iterator for " + LazyForeignCollection.this.dao.getDataClass(), e);
                }
            }

            @Override // java.lang.Iterable
            public CloseableIterator<T> iterator() {
                return closeableIterator();
            }
        });
    }

    @Override // java.util.Collection
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public boolean isEager() {
        return false;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        CloseableIterator<T> it = iterator();
        try {
            boolean z = !it.hasNext();
            try {
                return z;
            } catch (SQLException e) {
                return z;
            }
        } finally {
            try {
                it.close();
            } catch (SQLException e2) {
            }
        }
    }

    @Override // java.lang.Iterable, java.util.Collection
    public CloseableIterator<T> iterator() {
        return closeableIterator(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iterator(int i) {
        return closeableIterator(i);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow() throws SQLException {
        return iteratorThrow(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow(int i) throws SQLException {
        CloseableIterator<T> seperateIteratorThrow = seperateIteratorThrow(i);
        this.lastIterator = seperateIteratorThrow;
        return seperateIteratorThrow;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshCollection() {
        return 0;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean remove(Object obj) {
        CloseableIterator<T> it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                        return false;
                    } catch (SQLException e) {
                        return false;
                    }
                }
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException e2) {
                }
                throw th;
            }
        } while (!it.next().equals(obj));
        it.remove();
        try {
            it.close();
            return true;
        } catch (SQLException e3) {
            return true;
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        CloseableIterator<T> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            try {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException e) {
                }
                throw th;
            }
        }
        try {
            it.close();
            return z;
        } catch (SQLException e2) {
            return z;
        }
    }

    @Override // java.util.Collection
    public int size() {
        CloseableIterator<T> it = iterator();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (!it.hasNext()) {
                    try {
                        return i2;
                    } catch (SQLException e) {
                        return i2;
                    }
                }
                it.moveToNext();
                i = i2 + 1;
            } finally {
                try {
                    it.close();
                } catch (SQLException e2) {
                }
            }
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator<T> it = iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next());
            } finally {
                try {
                    it.close();
                } catch (SQLException e) {
                }
            }
        }
        Object[] array = arrayList.toArray();
        try {
            return array;
        } catch (SQLException e2) {
            return array;
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        int i;
        CloseableIterator<T> it = iterator();
        ArrayList arrayList = null;
        int i2 = 0;
        while (true) {
            try {
                i = i2;
                if (it.hasNext()) {
                    T next = it.next();
                    if (i >= eArr.length) {
                        ArrayList arrayList2 = arrayList;
                        if (arrayList == null) {
                            ArrayList arrayList3 = new ArrayList();
                            int length = eArr.length;
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                arrayList2 = arrayList3;
                                if (i4 >= length) {
                                    break;
                                }
                                arrayList3.add(eArr[i4]);
                                i3 = i4 + 1;
                            }
                        }
                        arrayList2.add(next);
                        arrayList = arrayList2;
                    } else {
                        eArr[i] = next;
                    }
                    i2 = i + 1;
                } else {
                    try {
                        break;
                    } catch (SQLException e) {
                    }
                }
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException e2) {
                }
                throw th;
            }
        }
        it.close();
        if (arrayList == null) {
            if (i < eArr.length - 1) {
                eArr[i] = 0;
            }
            return eArr;
        }
        return (E[]) arrayList.toArray(eArr);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int updateAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }
}
