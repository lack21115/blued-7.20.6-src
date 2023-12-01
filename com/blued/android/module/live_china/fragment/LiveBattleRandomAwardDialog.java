package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveBattleRandomAwardDialogBinding;
import com.blued.android.module.live_china.fitem.FitemBattlePassRandomAward;
import com.blued.android.module.live_china.fitem.FitemBattlePassRandomAwardDesc;
import com.blued.android.module.live_china.fitem.FitemBattlePassRandomAwardTitle;
import com.blued.android.module.live_china.model.LiveBattleGiftExtra;
import com.blued.android.module.live_china.model.LiveBattleGiftModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleRandomAwardDialog.class */
public final class LiveBattleRandomAwardDialog extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12735a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private FreedomAdapter f12736c;
    private final Lazy b = LazyKt.a(new Function0<LiveBattleRandomAwardDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleRandomAwardDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleRandomAwardDialogBinding invoke() {
            return LiveBattleRandomAwardDialogBinding.a(LayoutInflater.from(LiveBattleRandomAwardDialog.this.getContext()));
        }
    });
    private ArrayList<FreedomItem> d = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleRandomAwardDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Fragment fragment, int i) {
            Intrinsics.e(fragment, "fragment");
            LiveBattleRandomAwardDialog liveBattleRandomAwardDialog = new LiveBattleRandomAwardDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(BatteryManager.EXTRA_LEVEL, i);
            liveBattleRandomAwardDialog.setArguments(bundle);
            liveBattleRandomAwardDialog.show(fragment.getChildFragmentManager(), "LiveBattleRandomAwardDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattleRandomAwardDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<LiveBattleGiftModel> list, LiveBattleGiftExtra liveBattleGiftExtra) {
        this.d.add(new FitemBattlePassRandomAwardTitle());
        for (LiveBattleGiftModel liveBattleGiftModel : list) {
            this.d.add(new FitemBattlePassRandomAward(liveBattleGiftModel));
        }
        if (liveBattleGiftExtra != null) {
            String alert_desc = liveBattleGiftExtra.getAlert_desc();
            if (!(alert_desc == null || alert_desc.length() == 0)) {
                this.d.add(new FitemBattlePassRandomAwardDesc(liveBattleGiftExtra.getAlert_desc()));
            }
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveBattleRandomAwardDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleRandomAwardDialogBinding d() {
        return (LiveBattleRandomAwardDialogBinding) this.b.getValue();
    }

    private final void e() {
        SVGAParser.a(SVGAParser.f15958a.b(), "live_battle_fly_gift.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.fragment.LiveBattleRandomAwardDialog$initView$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                LiveBattleRandomAwardDialogBinding d;
                LiveBattleRandomAwardDialogBinding d2;
                Intrinsics.e(videoItem, "videoItem");
                d = LiveBattleRandomAwardDialog.this.d();
                d.e.setVideoItem(videoItem);
                d2 = LiveBattleRandomAwardDialog.this.d();
                d2.e.a(0, true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        d().f12144c.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(450L).setInterpolator(new OvershootInterpolator()).start();
        d().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleRandomAwardDialog$GUciZEtCWBG-DZwftPg8mureLaU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleRandomAwardDialog.a(LiveBattleRandomAwardDialog.this, view);
            }
        });
        d().f12143a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleRandomAwardDialog$S9Iq0zpypmHwhjKVJox9_y_bfw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleRandomAwardDialog.b(LiveBattleRandomAwardDialog.this, view);
            }
        });
        f();
    }

    private final void f() {
        Bundle arguments = getArguments();
        int i = 0;
        if (arguments != null) {
            i = arguments.getInt(BatteryManager.EXTRA_LEVEL, 0);
        }
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.f(i, new BluedUIHttpResponse<BluedEntity<LiveBattleGiftModel, LiveBattleGiftExtra>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattleRandomAwardDialog$getData$2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LiveBattleRandomAwardDialogBinding d;
                super.onUIFinish();
                d = LiveBattleRandomAwardDialog.this.d();
                ProgressBar progressBar = d.b;
                Intrinsics.c(progressBar, "vb.loading");
                BluedViewExKt.a(progressBar);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveBattleGiftModel, LiveBattleGiftExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                List<LiveBattleGiftModel> list = bluedEntity.data;
                if (list == null) {
                    return;
                }
                LiveBattleRandomAwardDialog.this.a(list, bluedEntity.extra);
            }
        }, a());
    }

    private final void g() {
        FreedomAdapter freedomAdapter = this.f12736c;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveBattleRandomAwardDialog$notifyList$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                ArrayList arrayList;
                arrayList = LiveBattleRandomAwardDialog.this.d;
                return ((FreedomItem) arrayList.get(i)).a(gridLayoutManager.getSpanCount());
            }
        });
        d().d.setLayoutManager(gridLayoutManager);
        this.f12736c = new FreedomAdapter(getContext(), a(), this.d);
        d().d.setAdapter(this.f12736c);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(Color.argb(204, 0, 0, 0)));
        window.setWindowAnimations(R.style.alpha_menu_slow_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            num = Integer.valueOf(defaultDisplay.getWidth());
        }
        Intrinsics.a(num);
        attributes.width = num.intValue();
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        window.setFlags(67108864, 67108864);
        e();
        return dialog;
    }
}
