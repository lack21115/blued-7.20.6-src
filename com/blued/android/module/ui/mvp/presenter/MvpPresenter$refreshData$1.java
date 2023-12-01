package com.blued.android.module.ui.mvp.presenter;

import com.blued.android.framework.ui.mvp.IFetchDataListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/presenter/MvpPresenter$refreshData$1.class */
public final class MvpPresenter$refreshData$1 implements IFetchDataListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MvpPresenter f16057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MvpPresenter$refreshData$1(MvpPresenter mvpPresenter) {
        this.f16057a = mvpPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MvpPresenter this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.c("_load_type_refresh_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MvpPresenter this$0, String type, List d) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(type, "$type");
        Intrinsics.e(d, "$d");
        this$0.c(type, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MvpPresenter this$0, boolean z) {
        Intrinsics.e(this$0, "this$0");
        this$0.a("_load_type_refresh_", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final MvpPresenter this$0, final String type, List list) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(type, "$type");
        final List<?> a2 = this$0.a(type, list);
        this$0.b("refresh_datafetch", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$refreshData$1$x5HyOotfyT42c4tn3XM7LT_yfI0
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$refreshData$1.a(MvpPresenter.this, type, a2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MvpPresenter this$0, boolean z) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(z);
    }

    @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
    public void a() {
        final MvpPresenter mvpPresenter = this.f16057a;
        mvpPresenter.b("refresh_start", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$refreshData$1$t7i2wjDC6yNqWfA4m7f_-fkD_tw
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$refreshData$1.a(MvpPresenter.this);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
    public void a(final String type, final List<?> list) {
        Intrinsics.e(type, "type");
        final MvpPresenter mvpPresenter = this.f16057a;
        mvpPresenter.a("refresh_datafetch", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$refreshData$1$cO_tsJzwWBxL27gjCypVMLgsKUo
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$refreshData$1.b(MvpPresenter.this, type, list);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
    public void a(final boolean z) {
        final MvpPresenter mvpPresenter = this.f16057a;
        mvpPresenter.b("refresh_end", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$refreshData$1$pBJ7p2xdt-x8yM38Uak5tjrSH_s
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$refreshData$1.a(MvpPresenter.this, z);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
    public void b(final boolean z) {
        MvpPresenter mvpPresenter = this.f16057a;
        String a2 = Intrinsics.a("refresh_onMoreData, hasMoreData:", (Object) Boolean.valueOf(z));
        final MvpPresenter mvpPresenter2 = this.f16057a;
        mvpPresenter.b(a2, new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$refreshData$1$As4aXWoj5MMxWkBlrZclkHY7B_k
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$refreshData$1.b(MvpPresenter.this, z);
            }
        });
    }
}
