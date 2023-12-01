package com.blued.android.module.common.base.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/config/ListConfig.class */
public final class ListConfig {
    public static final Companion a = new Companion(null);
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private int e = 20;
    private boolean f = true;
    private LoadMoreModel g = LoadMoreModel.PULL_UP;
    private boolean h;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/config/ListConfig$Builder.class */
    public static final class Builder {
        private boolean a;
        private boolean b = true;
        private boolean c = true;
        private boolean d = true;
        private int e = 20;
        private boolean f = true;
        private LoadMoreModel g = LoadMoreModel.PULL_UP;

        public final Builder a(int i) {
            this.e = i;
            return this;
        }

        public final Builder a(LoadMoreModel model) {
            Intrinsics.e(model, "model");
            this.g = model;
            return this;
        }

        public final Builder a(boolean z) {
            this.b = z;
            return this;
        }

        public final ListConfig a() {
            ListConfig listConfig = new ListConfig();
            listConfig.b(this.c);
            listConfig.c(this.d);
            listConfig.a(this.e);
            listConfig.d(this.f);
            listConfig.a(this.g);
            listConfig.a(this.b);
            listConfig.e(this.a);
            return listConfig;
        }

        public final Builder b(boolean z) {
            this.c = z;
            return this;
        }

        public final Builder c(boolean z) {
            this.d = z;
            return this;
        }

        public final Builder d(boolean z) {
            this.f = z;
            return this;
        }

        public final Builder e(boolean z) {
            this.a = z;
            return this;
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/config/ListConfig$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/config/ListConfig$LoadMoreModel.class */
    public enum LoadMoreModel {
        PULL_DOWN,
        PULL_UP
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a(LoadMoreModel loadMoreModel) {
        Intrinsics.e(loadMoreModel, "<set-?>");
        this.g = loadMoreModel;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final boolean a() {
        return this.b;
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final boolean b() {
        return this.c;
    }

    public final void c(boolean z) {
        this.d = z;
    }

    public final boolean c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final void d(boolean z) {
        this.f = z;
    }

    public final void e(boolean z) {
        this.h = z;
    }

    public final boolean e() {
        return this.f;
    }

    public final LoadMoreModel f() {
        return this.g;
    }

    public final boolean g() {
        return this.h;
    }
}
