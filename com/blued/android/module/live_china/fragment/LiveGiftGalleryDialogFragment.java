package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveGiftGalleryBinding;
import com.blued.android.module.live_china.fitem.FitemGiftGallery;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GiftGalleryDataModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftGalleryDialogFragment.class */
public final class LiveGiftGalleryDialogFragment extends BaseDialogFragment implements OnClickCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12902a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private FreedomAdapter f12903c;
    private final Lazy b = LazyKt.a(new Function0<LiveGiftGalleryBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveGiftGalleryDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveGiftGalleryBinding invoke() {
            return LiveGiftGalleryBinding.a(LayoutInflater.from(LiveGiftGalleryDialogFragment.this.getContext()));
        }
    });
    private final ArrayList<FitemGiftGallery> d = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftGalleryDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveGiftGalleryDialogFragment a(FragmentManager manager, boolean z, BaseFragment fragment) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(fragment, "fragment");
            LiveGiftGalleryDialogFragment liveGiftGalleryDialogFragment = new LiveGiftGalleryDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isHost", z);
            liveGiftGalleryDialogFragment.setArguments(bundle);
            liveGiftGalleryDialogFragment.show(manager, LiveGiftGalleryDialogFragment.class.getSimpleName());
            return liveGiftGalleryDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftGalleryDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveGiftGalleryBinding d() {
        return (LiveGiftGalleryBinding) this.b.getValue();
    }

    private final void e() {
        d().f12219c.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.fragment.LiveGiftGalleryDialogFragment$initRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.e(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
            }
        });
    }

    private final void f() {
        String g = LiveRoomManager.a().g();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.t(g, new BluedUIHttpResponse<BluedEntityA<GiftGalleryDataModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveGiftGalleryDialogFragment$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GiftGalleryDataModel> bluedEntityA) {
                LiveGiftGalleryBinding d;
                LiveGiftGalleryBinding d2;
                ArrayList arrayList;
                if ((bluedEntityA == null ? null : bluedEntityA.data) == null || bluedEntityA.data.isEmpty()) {
                    d = LiveGiftGalleryDialogFragment.this.d();
                    d.b.setVisibility(0);
                    d2 = LiveGiftGalleryDialogFragment.this.d();
                    d2.f12219c.setVisibility(8);
                    return;
                }
                List<GiftGalleryDataModel> list = bluedEntityA.data;
                if (list != null) {
                    List<GiftGalleryDataModel> list2 = list;
                    LiveGiftGalleryDialogFragment liveGiftGalleryDialogFragment = LiveGiftGalleryDialogFragment.this;
                    for (GiftGalleryDataModel it : list2) {
                        arrayList = liveGiftGalleryDialogFragment.d;
                        Intrinsics.c(it, "it");
                        arrayList.add(new FitemGiftGallery(it));
                    }
                }
                LiveGiftGalleryDialogFragment.this.g();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                LiveGiftGalleryBinding d;
                LiveGiftGalleryBinding d2;
                d = LiveGiftGalleryDialogFragment.this.d();
                d.b.setVisibility(0);
                d2 = LiveGiftGalleryDialogFragment.this.d();
                d2.f12219c.setVisibility(8);
                return super.onUIFailure(i, str, str2);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        FreedomAdapter freedomAdapter = this.f12903c;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveGiftGalleryDialogFragment$notifyList$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                ArrayList arrayList;
                arrayList = LiveGiftGalleryDialogFragment.this.d;
                Object obj = arrayList.get(i);
                Intrinsics.c(obj, "list[position]");
                return ((FitemGiftGallery) obj).a(gridLayoutManager.getSpanCount());
            }
        });
        this.f12903c = new FreedomAdapter(getContext(), a(), this.d, this);
        d().f12219c.setLayoutManager(gridLayoutManager);
        d().f12219c.setItemAnimator(new DefaultItemAnimator());
        d().f12219c.setAdapter(this.f12903c);
        ViewPropertyAnimator animate = d().f12219c.animate();
        if (animate == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        for (FitemGiftGallery fitemGiftGallery : this.d) {
            fitemGiftGallery.e();
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 511.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null) {
            window.setWindowAnimations(R.style.main_menu_animstyle);
        }
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
        }
        if (attributes != null) {
            attributes.height = a2;
        }
        if (attributes != null) {
            attributes.gravity = 80;
        }
        dialog.onWindowAttributesChanged(attributes);
        d().f12219c.setPadding(DensityUtils.a(getContext(), 11.0f), DensityUtils.a(getContext(), 10.0f), DensityUtils.a(getContext(), 11.0f), DensityUtils.a(getContext(), 10.0f));
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        d().f12218a.f12221a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftGalleryDialogFragment$s6eAAwAiBIPHDqPPAYdssyurr0M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftGalleryDialogFragment.a(LiveGiftGalleryDialogFragment.this, view);
            }
        });
        f();
    }
}
