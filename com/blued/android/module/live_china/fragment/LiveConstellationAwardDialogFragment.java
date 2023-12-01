package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live_china.databinding.DialogLiveConstellationAwardBinding;
import com.blued.android.module.live_china.fitem.FitemGiftConstellation;
import com.blued.android.module.live_china.fragment.LiveConstellationInfoDialogFragment;
import com.blued.android.module.live_china.model.GiftConstellationAwardItemModel;
import com.blued.android.module.live_china.model.GiftConstellationAwardModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationAwardDialogFragment.class */
public final class LiveConstellationAwardDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private static String g = "";
    private static String h = "";
    private FreedomAdapter c;
    private FreedomAdapter d;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveConstellationAwardBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveConstellationAwardBinding invoke() {
            return DialogLiveConstellationAwardBinding.a(LayoutInflater.from(LiveConstellationAwardDialogFragment.this.getContext()));
        }
    });
    private ArrayList<FitemGiftConstellation> e = new ArrayList<>();
    private ArrayList<FitemGiftConstellation> f = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationAwardDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LiveConstellationAwardDialogFragment a(FragmentManager manager, String link, String constellationID) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(link, "link");
            Intrinsics.e(constellationID, "constellationID");
            LiveConstellationAwardDialogFragment.g = link;
            LiveConstellationAwardDialogFragment.h = constellationID;
            LiveConstellationAwardDialogFragment liveConstellationAwardDialogFragment = new LiveConstellationAwardDialogFragment();
            liveConstellationAwardDialogFragment.setArguments(new Bundle());
            liveConstellationAwardDialogFragment.show(manager, LiveConstellationAwardDialogFragment.class.getSimpleName());
            return liveConstellationAwardDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationAwardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveConstellationAwardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveConstellationInfoDialogFragment.Companion companion = LiveConstellationInfoDialogFragment.a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager, g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveConstellationAwardBinding d() {
        return (DialogLiveConstellationAwardBinding) this.b.getValue();
    }

    private final void e() {
        String str = h;
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.u(str, new BluedUIHttpResponse<BluedEntityA<GiftConstellationAwardModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GiftConstellationAwardModel> bluedEntityA) {
                DialogLiveConstellationAwardBinding d;
                ArrayList<GiftConstellationAwardItemModel> spokesman;
                ArrayList<GiftConstellationAwardItemModel> king;
                ArrayList arrayList;
                ArrayList<GiftConstellationAwardItemModel> spokesman2;
                ArrayList arrayList2;
                ArrayList<GiftConstellationAwardItemModel> king2;
                DialogLiveConstellationAwardBinding d2;
                if ((bluedEntityA == null ? null : bluedEntityA.data) == null || bluedEntityA.data.isEmpty()) {
                    d = LiveConstellationAwardDialogFragment.this.d();
                    d.f.setVisibility(0);
                    return;
                }
                GiftConstellationAwardModel giftConstellationAwardModel = bluedEntityA.data.get(0);
                if ((giftConstellationAwardModel == null || (spokesman = giftConstellationAwardModel.getSpokesman()) == null || spokesman.size() != 0) ? false : true) {
                    GiftConstellationAwardModel giftConstellationAwardModel2 = bluedEntityA.data.get(0);
                    if ((giftConstellationAwardModel2 == null || (king2 = giftConstellationAwardModel2.getKing()) == null || king2.size() != 0) ? false : true) {
                        d2 = LiveConstellationAwardDialogFragment.this.d();
                        d2.f.setVisibility(0);
                        return;
                    }
                }
                GiftConstellationAwardModel giftConstellationAwardModel3 = bluedEntityA.data.get(0);
                if (giftConstellationAwardModel3 != null && (spokesman2 = giftConstellationAwardModel3.getSpokesman()) != null) {
                    ArrayList<GiftConstellationAwardItemModel> arrayList3 = spokesman2;
                    LiveConstellationAwardDialogFragment liveConstellationAwardDialogFragment = LiveConstellationAwardDialogFragment.this;
                    for (GiftConstellationAwardItemModel giftConstellationAwardItemModel : arrayList3) {
                        arrayList2 = liveConstellationAwardDialogFragment.e;
                        arrayList2.add(new FitemGiftConstellation(giftConstellationAwardItemModel));
                    }
                }
                GiftConstellationAwardModel giftConstellationAwardModel4 = bluedEntityA.data.get(0);
                if (giftConstellationAwardModel4 != null && (king = giftConstellationAwardModel4.getKing()) != null) {
                    ArrayList<GiftConstellationAwardItemModel> arrayList4 = king;
                    LiveConstellationAwardDialogFragment liveConstellationAwardDialogFragment2 = LiveConstellationAwardDialogFragment.this;
                    for (GiftConstellationAwardItemModel giftConstellationAwardItemModel2 : arrayList4) {
                        arrayList = liveConstellationAwardDialogFragment2.f;
                        arrayList.add(new FitemGiftConstellation(giftConstellationAwardItemModel2));
                    }
                }
                LiveConstellationAwardDialogFragment.this.f();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2, String str3) {
                DialogLiveConstellationAwardBinding d;
                DialogLiveConstellationAwardBinding d2;
                d = LiveConstellationAwardDialogFragment.this.d();
                d.e.setVisibility(8);
                d2 = LiveConstellationAwardDialogFragment.this.d();
                d2.d.setVisibility(8);
                return super.onUIFailure(i, str2, str3);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator alpha2;
        ViewPropertyAnimator duration2;
        FreedomAdapter freedomAdapter = this.c;
        if (freedomAdapter == null) {
            final RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment$notifyList$1
                public int getSpanSize(int i) {
                    ArrayList arrayList;
                    arrayList = LiveConstellationAwardDialogFragment.this.e;
                    Object obj = arrayList.get(i);
                    Intrinsics.c(obj, "mSpokesmanList[position]");
                    return ((FitemGiftConstellation) obj).a(gridLayoutManager.getSpanCount());
                }
            });
            d().h.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), ((this.e.size() / 4) + 1) * 100.0f)));
            ViewGroup.LayoutParams layoutParams = d().h.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            ((LinearLayout.LayoutParams) layoutParams).setMargins(0, DisplayUtil.a(getContext(), 15.0f), 0, 0);
            d().h.setPadding(DensityUtils.a(getContext(), 16.0f), 0, DensityUtils.a(getContext(), 22.0f), 0);
            this.c = new FreedomAdapter(getContext(), a(), this.e);
            d().h.setLayoutManager(gridLayoutManager);
            d().h.setItemAnimator(new DefaultItemAnimator());
            d().h.setAdapter(this.c);
            ViewPropertyAnimator animate = d().h.animate();
            if (animate != null && (alpha2 = animate.alpha(1.0f)) != null && (duration2 = alpha2.setDuration(300L)) != null) {
                duration2.start();
            }
        } else if (freedomAdapter != null) {
            freedomAdapter.notifyDataSetChanged();
        }
        if (this.d != null) {
            FreedomAdapter freedomAdapter2 = this.c;
            if (freedomAdapter2 != null) {
                freedomAdapter2.notifyDataSetChanged();
            }
            FreedomAdapter freedomAdapter3 = this.d;
            if (freedomAdapter3 == null) {
                return;
            }
            freedomAdapter3.notifyDataSetChanged();
            return;
        }
        final RecyclerView.LayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 4);
        gridLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment$notifyList$2
            public int getSpanSize(int i) {
                ArrayList arrayList;
                arrayList = LiveConstellationAwardDialogFragment.this.f;
                Object obj = arrayList.get(i);
                Intrinsics.c(obj, "mKingList[position]");
                return ((FitemGiftConstellation) obj).a(gridLayoutManager2.getSpanCount());
            }
        });
        d().g.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), (this.f.size() % 4 == 0 ? this.f.size() / 4 : (this.f.size() / 4) + 1) * 100.0f)));
        ViewGroup.LayoutParams layoutParams2 = d().g.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        ((LinearLayout.LayoutParams) layoutParams2).setMargins(0, DisplayUtil.a(getContext(), 15.0f), 0, 0);
        d().g.setPadding(DensityUtils.a(getContext(), 16.0f), 0, DensityUtils.a(getContext(), 22.0f), 0);
        this.d = new FreedomAdapter(getContext(), a(), this.f);
        d().g.setLayoutManager(gridLayoutManager2);
        d().g.setItemAnimator(new DefaultItemAnimator());
        d().g.setAdapter(this.d);
        ViewPropertyAnimator animate2 = d().g.animate();
        if (animate2 == null || (alpha = animate2.alpha(1.0f)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FrameLayout root;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.c(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationAwardDialogFragment$LE3NAINs9WixqCMSYDu5Uu4prFs
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean a2;
                a2 = LiveConstellationAwardDialogFragment.a(dialogInterface, i, keyEvent);
                return a2;
            }
        });
        onCreateDialog.setCanceledOnTouchOutside(true);
        DialogLiveConstellationAwardBinding d = d();
        ViewParent viewParent = null;
        if (d != null && (root = d.getRoot()) != null) {
            viewParent = root.getParent();
        }
        if (viewParent instanceof ViewGroup) {
            ViewParent parent = d().getRoot().getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(d().getRoot());
        }
        onCreateDialog.setContentView(d().getRoot());
        return onCreateDialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
            Intrinsics.a(attributes);
            attributes.dimAmount = 0.7f;
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        d().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationAwardDialogFragment$M8JvvXW2m04jCUyxop0N-esTMzU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationAwardDialogFragment.a(LiveConstellationAwardDialogFragment.this, view);
            }
        });
        d().i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationAwardDialogFragment$GLAQQ0TblA5kmZB3hXC3nKYuRv4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationAwardDialogFragment.b(LiveConstellationAwardDialogFragment.this, view);
            }
        });
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        e();
    }
}
