package com.tencent.thumbplayer.utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/m.class */
public class m extends ReentrantReadWriteLock {

    /* renamed from: a  reason: collision with root package name */
    private Condition f39442a = writeLock().newCondition();
}
