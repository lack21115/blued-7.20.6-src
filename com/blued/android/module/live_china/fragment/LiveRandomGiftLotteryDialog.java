package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveRandomGiftLotteryDialogBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RandomGiftDialogLotteryDataModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftLotteryDialog.class */
public final class LiveRandomGiftLotteryDialog extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13180a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<LiveRandomGiftLotteryDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftLotteryDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveRandomGiftLotteryDialogBinding invoke() {
            return LiveRandomGiftLotteryDialogBinding.a(LayoutInflater.from(LiveRandomGiftLotteryDialog.this.getContext()));
        }
    });

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftLotteryDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Fragment fragment, String goods_id) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(goods_id, "goods_id");
            LiveRandomGiftLotteryDialog liveRandomGiftLotteryDialog = new LiveRandomGiftLotteryDialog();
            Bundle bundle = new Bundle();
            bundle.putString("goods_id", goods_id);
            liveRandomGiftLotteryDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            liveRandomGiftLotteryDialog.show(childFragmentManager, LiveRandomGiftLotteryDialog.class.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRandomGiftLotteryDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(RandomGiftDialogLotteryDataModel randomGiftDialogLotteryDataModel) {
        LiveEventBusUtil.f(randomGiftDialogLotteryDataModel.getRemain_count());
        d().j.setText(AppInfo.d().getString(R.string.live_random_gift_record_dialog_title, LiveRoomManager.a().h()));
        d().j.setText(LiveUtils.a(d().j.getText(), "#FF7B00", false));
        ImageLoader.a(a(), randomGiftDialogLotteryDataModel.getGoods_icon()).a(d().e);
        d().h.setText(randomGiftDialogLotteryDataModel.getGoods_name());
        String label = randomGiftDialogLotteryDataModel.getLabel();
        boolean z = true;
        if (label != null) {
            z = label.length() == 0;
        }
        if (z) {
            ShapeTextView shapeTextView = d().i;
            Intrinsics.c(shapeTextView, "vb.tvTag");
            BluedViewExKt.a(shapeTextView);
        } else {
            d().i.setText(randomGiftDialogLotteryDataModel.getLabel());
            ShapeTextView shapeTextView2 = d().i;
            Intrinsics.c(shapeTextView2, "vb.tvTag");
            BluedViewExKt.b(shapeTextView2);
        }
        d().f.c();
        d().b.setAlpha(0.0f);
        FrameLayout frameLayout = d().b;
        Intrinsics.c(frameLayout, "vb.flRoot");
        BluedViewExKt.b(frameLayout);
        d().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftLotteryDialog$SlZ25rrTEqPbs6mxJwwTMUw9MHQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveRandomGiftLotteryDialog.c(LiveRandomGiftLotteryDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveRandomGiftLotteryDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveRandomGiftLotteryDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.d().b.animate().alpha(1.0f).setDuration(200L).start();
        this$0.d().f12397a.animate().alpha(1.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveRandomGiftLotteryDialogBinding d() {
        return (LiveRandomGiftLotteryDialogBinding) this.b.getValue();
    }

    private final void e() {
        d().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftLotteryDialog$8Lf6glI6BBvNw9Ar21u8SFIM70g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRandomGiftLotteryDialog.a(LiveRandomGiftLotteryDialog.this, view);
            }
        });
        d().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftLotteryDialog$Ifj7p0LoXmMCUNJm_-4khWULijY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRandomGiftLotteryDialog.b(LiveRandomGiftLotteryDialog.this, view);
            }
        });
        d().j.setText(AppInfo.d().getString(R.string.live_random_gift_record_dialog_title, LiveRoomManager.a().h()));
        d().j.setText(LiveUtils.a(d().j.getText(), "#FF7B00", false));
        f();
    }

    private final void f() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        String goods_id = arguments.getString("goods_id", "");
        String str = goods_id;
        if (str == null || str.length() == 0) {
            g();
            return;
        }
        d().f.b();
        Intrinsics.c(goods_id, "goods_id");
        int parseInt = Integer.parseInt(goods_id);
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.j(parseInt, new BluedUIHttpResponse<BluedEntity<Object, RandomGiftDialogLotteryDataModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftLotteryDialog$getData$1$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveRandomGiftLotteryDialog.this.g();
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LiveRandomGiftLotteryDialogBinding d;
                d = LiveRandomGiftLotteryDialog.this.d();
                d.f.c();
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, RandomGiftDialogLotteryDataModel> entity) {
                Intrinsics.e(entity, "entity");
                if (entity.extra == null) {
                    LiveRandomGiftLotteryDialog.this.g();
                    return;
                }
                LiveRandomGiftLotteryDialog liveRandomGiftLotteryDialog = LiveRandomGiftLotteryDialog.this;
                RandomGiftDialogLotteryDataModel randomGiftDialogLotteryDataModel = entity.extra;
                Intrinsics.c(randomGiftDialogLotteryDataModel, "entity.extra");
                liveRandomGiftLotteryDialog.a(randomGiftDialogLotteryDataModel);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        FrameLayout frameLayout = d().b;
        Intrinsics.c(frameLayout, "vb.flRoot");
        BluedViewExKt.a(frameLayout);
        SlopeLoadingView slopeLoadingView = d().f;
        Intrinsics.c(slopeLoadingView, "vb.loading");
        BluedViewExKt.a(slopeLoadingView);
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
        window.setBackgroundDrawable(new ColorDrawable(Color.argb(178, 0, 0, 0)));
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

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
