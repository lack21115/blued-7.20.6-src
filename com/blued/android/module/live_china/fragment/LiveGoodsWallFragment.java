package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.databinding.FragmentGoodsWallBinding;
import com.blued.android.module.live_china.fitem.FitemGoodsWallCard;
import com.blued.android.module.live_china.fragment.LiveGoodsWallTaskDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GoodsWallDataModel;
import com.blued.android.module.live_china.model.GoodsWallInfoModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallFragment.class */
public final class LiveGoodsWallFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private FragmentGoodsWallBinding f12940a;

    /* renamed from: c  reason: collision with root package name */
    private FreedomAdapter f12941c;
    private FreedomAdapter e;
    private final ArrayList<FitemGoodsWallCard> b = new ArrayList<>();
    private final ArrayList<FitemGoodsWallCard> d = new ArrayList<>();
    private final String f = "@\\(word:([\\s\\S]*?)\\)";
    private Pattern g = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final CharSequence a(CharSequence charSequence, String str, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final void a() {
        FragmentGoodsWallBinding fragmentGoodsWallBinding = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding2 = fragmentGoodsWallBinding;
        if (fragmentGoodsWallBinding == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding2 = null;
        }
        fragmentGoodsWallBinding2.j.b();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.E(new BluedUIHttpResponse<BluedEntity<GoodsWallDataModel, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallFragment$getData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                FragmentGoodsWallBinding fragmentGoodsWallBinding3;
                super.onUIFinish();
                fragmentGoodsWallBinding3 = LiveGoodsWallFragment.this.f12940a;
                FragmentGoodsWallBinding fragmentGoodsWallBinding4 = fragmentGoodsWallBinding3;
                if (fragmentGoodsWallBinding3 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBinding4 = null;
                }
                fragmentGoodsWallBinding4.j.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<GoodsWallDataModel, ?> entity) {
                Intrinsics.e(entity, "entity");
                GoodsWallDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveGoodsWallFragment.this.a(singleData);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGoodsWallFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveGoodsWallTaskDialogFragment.Companion companion = LiveGoodsWallTaskDialogFragment.f12945a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager, this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0650, code lost:
        if (r0.isEmpty() != false) goto L167;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.blued.android.module.live_china.model.GoodsWallDataModel r7) {
        /*
            Method dump skipped, instructions count: 1863
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveGoodsWallFragment.a(com.blued.android.module.live_china.model.GoodsWallDataModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GoodsWallInfoModel it, View view) {
        Intrinsics.e(it, "$it");
        if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
            LiveSetDataObserver.a().b(it.getPlay_desc(), 25);
        } else {
            LiveRefreshUIObserver.a().b(it.getPlay_desc(), 25);
        }
    }

    private final void b() {
        FreedomAdapter freedomAdapter = this.f12941c;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.f12941c = new FreedomAdapter(getContext(), getFragmentActive(), this.b);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallFragment$notifyListAglow$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                ArrayList arrayList;
                arrayList = LiveGoodsWallFragment.this.b;
                Object obj = arrayList.get(i);
                Intrinsics.c(obj, "mListAglow[position]");
                return ((FreedomItem) obj).a(gridLayoutManager.getSpanCount());
            }
        });
        FragmentGoodsWallBinding fragmentGoodsWallBinding = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding2 = fragmentGoodsWallBinding;
        if (fragmentGoodsWallBinding == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding2 = null;
        }
        RecyclerView recyclerView = fragmentGoodsWallBinding2.k;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        FragmentGoodsWallBinding fragmentGoodsWallBinding3 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding4 = fragmentGoodsWallBinding3;
        if (fragmentGoodsWallBinding3 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding4 = null;
        }
        RecyclerView recyclerView2 = fragmentGoodsWallBinding4.k;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        FreedomAdapter freedomAdapter2 = this.f12941c;
        if (freedomAdapter2 != null) {
            freedomAdapter2.b("BaseFragment", this);
        }
        FragmentGoodsWallBinding fragmentGoodsWallBinding5 = this.f12940a;
        if (fragmentGoodsWallBinding5 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding5 = null;
        }
        RecyclerView recyclerView3 = fragmentGoodsWallBinding5.k;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.f12941c);
    }

    private final void c() {
        FreedomAdapter freedomAdapter = this.e;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.e = new FreedomAdapter(getContext(), getFragmentActive(), this.d);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallFragment$notifyListNotAglow$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                ArrayList arrayList;
                arrayList = LiveGoodsWallFragment.this.d;
                Object obj = arrayList.get(i);
                Intrinsics.c(obj, "mListNotAglow[position]");
                return ((FreedomItem) obj).a(gridLayoutManager.getSpanCount());
            }
        });
        FragmentGoodsWallBinding fragmentGoodsWallBinding = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding2 = fragmentGoodsWallBinding;
        if (fragmentGoodsWallBinding == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding2 = null;
        }
        RecyclerView recyclerView = fragmentGoodsWallBinding2.l;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        FragmentGoodsWallBinding fragmentGoodsWallBinding3 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding4 = fragmentGoodsWallBinding3;
        if (fragmentGoodsWallBinding3 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding4 = null;
        }
        RecyclerView recyclerView2 = fragmentGoodsWallBinding4.l;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        FreedomAdapter freedomAdapter2 = this.e;
        if (freedomAdapter2 != null) {
            freedomAdapter2.b("BaseFragment", this);
        }
        FragmentGoodsWallBinding fragmentGoodsWallBinding5 = this.f12940a;
        if (fragmentGoodsWallBinding5 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding5 = null;
        }
        RecyclerView recyclerView3 = fragmentGoodsWallBinding5.l;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.e);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        FragmentGoodsWallBinding a2 = FragmentGoodsWallBinding.a(getLayoutInflater(), viewGroup, false);
        Intrinsics.c(a2, "inflate(layoutInflater, container, false)");
        this.f12940a = a2;
        FragmentGoodsWallBinding fragmentGoodsWallBinding = a2;
        if (a2 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding = null;
        }
        if (fragmentGoodsWallBinding.getRoot().getParent() != null) {
            FragmentGoodsWallBinding fragmentGoodsWallBinding2 = this.f12940a;
            FragmentGoodsWallBinding fragmentGoodsWallBinding3 = fragmentGoodsWallBinding2;
            if (fragmentGoodsWallBinding2 == null) {
                Intrinsics.c("vb");
                fragmentGoodsWallBinding3 = null;
            }
            ViewParent parent = fragmentGoodsWallBinding3.getRoot().getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            FragmentGoodsWallBinding fragmentGoodsWallBinding4 = this.f12940a;
            FragmentGoodsWallBinding fragmentGoodsWallBinding5 = fragmentGoodsWallBinding4;
            if (fragmentGoodsWallBinding4 == null) {
                Intrinsics.c("vb");
                fragmentGoodsWallBinding5 = null;
            }
            viewGroup2.removeView(fragmentGoodsWallBinding5.getRoot());
        }
        FragmentGoodsWallBinding fragmentGoodsWallBinding6 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding7 = fragmentGoodsWallBinding6;
        if (fragmentGoodsWallBinding6 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding7 = null;
        }
        fragmentGoodsWallBinding7.q.getPaint().setFakeBoldText(true);
        FragmentGoodsWallBinding fragmentGoodsWallBinding8 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding9 = fragmentGoodsWallBinding8;
        if (fragmentGoodsWallBinding8 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding9 = null;
        }
        fragmentGoodsWallBinding9.r.getPaint().setFakeBoldText(true);
        FragmentGoodsWallBinding fragmentGoodsWallBinding10 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding11 = fragmentGoodsWallBinding10;
        if (fragmentGoodsWallBinding10 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding11 = null;
        }
        fragmentGoodsWallBinding11.w.getPaint().setFakeBoldText(true);
        FragmentGoodsWallBinding fragmentGoodsWallBinding12 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding13 = fragmentGoodsWallBinding12;
        if (fragmentGoodsWallBinding12 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding13 = null;
        }
        fragmentGoodsWallBinding13.m.getPaint().setFakeBoldText(true);
        FragmentGoodsWallBinding fragmentGoodsWallBinding14 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding15 = fragmentGoodsWallBinding14;
        if (fragmentGoodsWallBinding14 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding15 = null;
        }
        fragmentGoodsWallBinding15.s.getPaint().setFakeBoldText(true);
        FragmentGoodsWallBinding fragmentGoodsWallBinding16 = this.f12940a;
        FragmentGoodsWallBinding fragmentGoodsWallBinding17 = fragmentGoodsWallBinding16;
        if (fragmentGoodsWallBinding16 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding17 = null;
        }
        fragmentGoodsWallBinding17.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGoodsWallFragment$TflCeUw7tN1Oe8XrZypl9BNmR5c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGoodsWallFragment.a(LiveGoodsWallFragment.this, view);
            }
        });
        a();
        FragmentGoodsWallBinding fragmentGoodsWallBinding18 = this.f12940a;
        if (fragmentGoodsWallBinding18 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBinding18 = null;
        }
        return fragmentGoodsWallBinding18.getRoot();
    }
}
