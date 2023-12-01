package com.blued.android.module.live_china.fragment;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.live_china.fitem.FitemConstellationTab;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationDialogFragment$initTabListScrollListener$1.class */
public final class LiveConstellationDialogFragment$initTabListScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveConstellationDialogFragment f12797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveConstellationDialogFragment$initTabListScrollListener$1(LiveConstellationDialogFragment liveConstellationDialogFragment) {
        this.f12797a = liveConstellationDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveConstellationDialogFragment this$0, final RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        LinearLayoutManager linearLayoutManager2;
        ArrayList arrayList;
        ArrayList arrayList2;
        BaseViewHolder baseViewHolder;
        View view;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(recyclerView, "$recyclerView");
        linearLayoutManager = this$0.g;
        if (linearLayoutManager == null) {
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        linearLayoutManager2 = this$0.g;
        Intrinsics.a(linearLayoutManager2);
        intRef.f42543a = linearLayoutManager2.findFirstVisibleItemPosition();
        int i = intRef.f42543a;
        arrayList = this$0.e;
        intRef.f42543a = i % arrayList.size();
        arrayList2 = this$0.e;
        FitemConstellationTab fitemConstellationTab = (FitemConstellationTab) CollectionsKt.c((List<? extends Object>) arrayList2, intRef.f42543a);
        if (fitemConstellationTab == null || (baseViewHolder = fitemConstellationTab.f10935a) == null || (view = baseViewHolder.itemView) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$initTabListScrollListener$1$5kA723HRIEcWPWyBoHfj5CLCR_g
            @Override // java.lang.Runnable
            public final void run() {
                LiveConstellationDialogFragment$initTabListScrollListener$1.a(LiveConstellationDialogFragment.this, intRef, recyclerView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationDialogFragment this$0, Ref.IntRef firstItem, RecyclerView recyclerView) {
        ArrayList arrayList;
        LinearLayoutManager linearLayoutManager;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i;
        ArrayList arrayList7;
        int unused;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(firstItem, "$firstItem");
        Intrinsics.e(recyclerView, "$recyclerView");
        arrayList = this$0.e;
        ((FitemConstellationTab) arrayList.get(firstItem.f42543a)).g();
        linearLayoutManager = this$0.g;
        Intrinsics.a(linearLayoutManager);
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        arrayList2 = this$0.e;
        int size = findLastVisibleItemPosition % arrayList2.size();
        int i2 = size;
        if (size < firstItem.f42543a) {
            arrayList7 = this$0.e;
            i2 = size + arrayList7.size();
        }
        arrayList3 = this$0.e;
        arrayList3.size();
        unused = this$0.k;
        int width = recyclerView.getWidth() / 2;
        int i3 = width + 1;
        int i4 = -1;
        int i5 = firstItem.f42543a;
        int i6 = -1;
        if (i5 <= i2) {
            while (true) {
                arrayList5 = this$0.e;
                int size2 = i5 % arrayList5.size();
                arrayList6 = this$0.e;
                int g = ((FitemConstellationTab) arrayList6.get(size2)).g();
                i = this$0.k;
                int i7 = g + (i / 2);
                int i8 = i3;
                i6 = i4;
                if (i7 >= 0) {
                    int i9 = i7 - width;
                    i8 = i3;
                    i6 = i4;
                    if (Math.abs(i9) < i3) {
                        i8 = Math.abs(i9);
                        i6 = size2;
                    }
                }
                if (i5 == i2) {
                    break;
                }
                i5++;
                i3 = i8;
                i4 = i6;
            }
        }
        arrayList4 = this$0.e;
        FitemConstellationTab fitemConstellationTab = (FitemConstellationTab) CollectionsKt.c((List<? extends Object>) arrayList4, i6);
        if (fitemConstellationTab == null || fitemConstellationTab.f()) {
            return;
        }
        this$0.b(i6, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(final RecyclerView recyclerView, int i) {
        boolean z;
        FitemConstellationTab fitemConstellationTab;
        Intrinsics.e(recyclerView, "recyclerView");
        z = this.f12797a.i;
        if (z) {
            if (i == 0) {
                final LiveConstellationDialogFragment liveConstellationDialogFragment = this.f12797a;
                recyclerView.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$initTabListScrollListener$1$pyAuA1iiTVfiYcVXH55svfKcCaA
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveConstellationDialogFragment$initTabListScrollListener$1.a(LiveConstellationDialogFragment.this, recyclerView);
                    }
                });
            } else if (i != 1) {
            } else {
                fitemConstellationTab = this.f12797a.h;
                if (fitemConstellationTab != null) {
                    fitemConstellationTab.a(false);
                }
                this.f12797a.h = null;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        boolean z;
        LinearLayoutManager linearLayoutManager;
        LinearLayoutManager linearLayoutManager2;
        Intrinsics.e(recyclerView, "recyclerView");
        z = this.f12797a.i;
        if (z) {
            linearLayoutManager = this.f12797a.g;
            if (linearLayoutManager == null) {
                return;
            }
            linearLayoutManager2 = this.f12797a.g;
            Intrinsics.a(linearLayoutManager2);
            int findFirstVisibleItemPosition = linearLayoutManager2.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition <= 1000 || findFirstVisibleItemPosition >= 2147482647) {
                recyclerView.scrollToPosition(1073741823);
            }
        }
    }
}
