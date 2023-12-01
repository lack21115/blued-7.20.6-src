package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
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
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveConstellationHonourBinding;
import com.blued.android.module.live_china.fitem.FitemGiftConstellationHonour;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GiftConstellationHonourModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationHonourDialogFragment.class */
public final class LiveConstellationHonourDialogFragment extends BaseDialogFragment implements OnClickCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12800a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private FreedomAdapter f12801c;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveConstellationHonourBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationHonourDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveConstellationHonourBinding invoke() {
            return DialogLiveConstellationHonourBinding.a(LayoutInflater.from(LiveConstellationHonourDialogFragment.this.getContext()));
        }
    });
    private ArrayList<FitemGiftConstellationHonour> d = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationHonourDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LiveConstellationHonourDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LiveConstellationHonourDialogFragment liveConstellationHonourDialogFragment = new LiveConstellationHonourDialogFragment();
            liveConstellationHonourDialogFragment.setArguments(new Bundle());
            liveConstellationHonourDialogFragment.show(manager, LiveConstellationHonourDialogFragment.class.getSimpleName());
            return liveConstellationHonourDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationHonourDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveConstellationHonourBinding d() {
        return (DialogLiveConstellationHonourBinding) this.b.getValue();
    }

    private final void e() {
        String g = LiveRoomManager.a().g();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.v(g, new BluedUIHttpResponse<BluedEntityA<GiftConstellationHonourModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveConstellationHonourDialogFragment$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GiftConstellationHonourModel> bluedEntityA) {
                DialogLiveConstellationHonourBinding d;
                ArrayList arrayList;
                if ((bluedEntityA == null ? null : bluedEntityA.data) == null || bluedEntityA.data.isEmpty()) {
                    d = LiveConstellationHonourDialogFragment.this.d();
                    d.d.setVisibility(0);
                    return;
                }
                List<GiftConstellationHonourModel> list = bluedEntityA.data;
                Intrinsics.c(list, "entity.data");
                List<GiftConstellationHonourModel> list2 = list;
                LiveConstellationHonourDialogFragment liveConstellationHonourDialogFragment = LiveConstellationHonourDialogFragment.this;
                for (GiftConstellationHonourModel it : list2) {
                    arrayList = liveConstellationHonourDialogFragment.d;
                    Intrinsics.c(it, "it");
                    arrayList.add(new FitemGiftConstellationHonour(it));
                }
                LiveConstellationHonourDialogFragment.this.f();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                return super.onUIFailure(i, str, str2);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        FreedomAdapter freedomAdapter = this.f12801c;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationHonourDialogFragment$notifyList$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                ArrayList arrayList;
                arrayList = LiveConstellationHonourDialogFragment.this.d;
                Object obj = arrayList.get(i);
                Intrinsics.c(obj, "mList[position]");
                return ((FitemGiftConstellationHonour) obj).a(gridLayoutManager.getSpanCount());
            }
        });
        this.f12801c = new FreedomAdapter(getContext(), a(), this.d, this);
        d().e.setLayoutManager(gridLayoutManager);
        d().e.setItemAnimator(new DefaultItemAnimator());
        d().e.setAdapter(this.f12801c);
        ViewPropertyAnimator animate = d().e.animate();
        if (animate == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        EventTrackLive.b(LiveProtos.Event.LIVE_STAR_HONOUR_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        int a2 = DensityUtils.a(getContext(), 608.0f);
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
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
        d().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationHonourDialogFragment$AFKFsY9Q0s4rkTsGiwKImEo5SFo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationHonourDialogFragment.a(LiveConstellationHonourDialogFragment.this, view);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        e();
    }
}
