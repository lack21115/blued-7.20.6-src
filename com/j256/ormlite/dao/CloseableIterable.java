package com.j256.ormlite.dao;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/CloseableIterable.class */
public interface CloseableIterable<T> extends Iterable<T> {
    CloseableIterator<T> closeableIterator();
}
