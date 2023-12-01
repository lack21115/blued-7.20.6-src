package com.blued.android.module.ui.mvp.presenter;

import com.blued.android.framework.ui.mvp.IFetchDataListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/presenter/MvpPresenter$fetchMoreData$1.class */
public final class MvpPresenter$fetchMoreData$1 implements IFetchDataListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MvpPresenter f16056a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MvpPresenter this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.c("_load_type_loadmore_");
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
        this$0.a("_load_type_loadmore_", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final MvpPresenter this$0, final String type, List list) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(type, "$type");
        final List<?> b = this$0.b(type, list);
        this$0.b("fetchmore_datafetch", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$fetchMoreData$1$sEQC3chnROkemoDIEKcHwrC1SlQ
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$fetchMoreData$1.a(MvpPresenter.this, type, b);
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
        final MvpPresenter mvpPresenter = this.f16056a;
        mvpPresenter.b("fetchmore_start", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$fetchMoreData$1$6Lqe9EbVqC2ku1EinwEPHj_yQxI
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$fetchMoreData$1.a(MvpPresenter.this);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
    public void a(final String type, final List<?> list) {
        Intrinsics.e(type, "type");
        final MvpPresenter mvpPresenter = this.f16056a;
        mvpPresenter.a("fetchmore_datafetch", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$fetchMoreData$1$GJqP4G4Q0kLwYGRLsovsQePdwkU
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$fetchMoreData$1.b(MvpPresenter.this, type, list);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
    public void a(final boolean z) {
        final MvpPresenter mvpPresenter = this.f16056a;
        mvpPresenter.b("fetchmore_end", new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$fetchMoreData$1$Ww_1KfpvczSxaclvwtt0Oc42iOU
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$fetchMoreData$1.a(MvpPresenter.this, z);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
    public void b(final boolean z) {
        MvpPresenter mvpPresenter = this.f16056a;
        String a2 = Intrinsics.a("fetchmore_onMoreData, hasMoreData:", (Object) Boolean.valueOf(z));
        final MvpPresenter mvpPresenter2 = this.f16056a;
        mvpPresenter.b(a2, new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$fetchMoreData$1$z6eisb0WPaKgr9C7glLhcVmKhS8
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter$fetchMoreData$1.b(MvpPresenter.this, z);
            }
        });
    }
}
