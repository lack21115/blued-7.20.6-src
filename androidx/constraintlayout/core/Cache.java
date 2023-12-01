package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/Cache.class */
public class Cache {

    /* renamed from: a  reason: collision with root package name */
    Pools.Pool<ArrayRow> f1940a = new Pools.SimplePool(256);
    Pools.Pool<ArrayRow> b = new Pools.SimplePool(256);

    /* renamed from: c  reason: collision with root package name */
    Pools.Pool<SolverVariable> f1941c = new Pools.SimplePool(256);
    SolverVariable[] d = new SolverVariable[32];
}
