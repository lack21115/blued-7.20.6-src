package com.lxj.easyadapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/EasyAdapter.class */
public abstract class EasyAdapter<T> extends MultiItemTypeAdapter<T> {
    private int b;

    @Metadata
    /* renamed from: com.lxj.easyadapter.EasyAdapter$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/EasyAdapter$1.class */
    public static final class AnonymousClass1 implements ItemDelegate<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EasyAdapter f23929a;

        @Override // com.lxj.easyadapter.ItemDelegate
        public int a() {
            return this.f23929a.a();
        }

        @Override // com.lxj.easyadapter.ItemDelegate
        public void a(ViewHolder holder, T t, int i) {
            Intrinsics.d(holder, "holder");
            this.f23929a.a(holder, (ViewHolder) t, i);
        }

        @Override // com.lxj.easyadapter.ItemDelegate
        public boolean a(T t, int i) {
            return true;
        }
    }

    protected final int a() {
        return this.b;
    }

    protected abstract void a(ViewHolder viewHolder, T t, int i);
}
