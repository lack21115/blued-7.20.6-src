package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveVipUpgradeBinding;
import com.blued.android.module.live_china.fragment.LiveVipDialogFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveVipUpgradeModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveVipUpgradeDialogFragment.class */
public final class LiveVipUpgradeDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13289a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogLiveVipUpgradeBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveVipUpgradeDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveVipUpgradeBinding invoke() {
            return DialogLiveVipUpgradeBinding.a(LayoutInflater.from(LiveVipUpgradeDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private LiveVipUpgradeModel f13290c;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveVipUpgradeDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LiveVipUpgradeDialogFragment a(FragmentManager manager, LiveVipUpgradeModel data) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(data, "data");
            LiveVipUpgradeDialogFragment liveVipUpgradeDialogFragment = new LiveVipUpgradeDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("vipModel", data);
            liveVipUpgradeDialogFragment.setArguments(bundle);
            liveVipUpgradeDialogFragment.show(manager, LiveVipUpgradeDialogFragment.class.getSimpleName());
            return liveVipUpgradeDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipUpgradeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_COPY_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveVipUpgradeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_CLOSE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this$0.e();
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveVipUpgradeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_DETAIL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LiveVipDialogFragment.Companion companion = LiveVipDialogFragment.f13281a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveVipUpgradeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_CLOSE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this$0.e();
        this$0.dismissAllowingStateLoss();
    }

    private final DialogLiveVipUpgradeBinding f() {
        return (DialogLiveVipUpgradeBinding) this.b.getValue();
    }

    private final void g() {
        LiveVipUpgradeModel liveVipUpgradeModel = this.f13290c;
        if (liveVipUpgradeModel != null) {
            ImageLoader.a(a(), ImgURLMap.f10885a.a("live_iv_bg")).a(f().b);
            ImageLoader.a(a(), ImgURLMap.f10885a.a("live_iv_write")).a(f().f);
            ImageLoader.a(a(), ImgURLMap.f10885a.a("live_iv_ok")).a(f().e);
            String a2 = Intrinsics.a(getString(R.string.live_vip_popup_text_2), (Object) liveVipUpgradeModel.getWechat());
            String a3 = Intrinsics.a(" ", (Object) getString(R.string.live_vip_popup_text_3));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(a2);
            spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, a2.length(), 33);
            spannableString.setSpan(new StyleSpan(1), 0, a2.length(), 33);
            SpannableString spannableString2 = new SpannableString(a3);
            spannableString2.setSpan(new AbsoluteSizeSpan(11, true), 0, a3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
            f().h.setText(spannableStringBuilder);
            f().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipUpgradeDialogFragment$Z9UhHc1uDd92V5oY-_FyiukBscs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveVipUpgradeDialogFragment.a(LiveVipUpgradeDialogFragment.this, view);
                }
            });
            int vip_level = liveVipUpgradeModel.getVip_level();
            ImageLoader.a(a(), vip_level != 1 ? vip_level != 2 ? vip_level != 3 ? vip_level != 4 ? "" : ImgURLMap.f10885a.a("live_vip_level_4") : ImgURLMap.f10885a.a("live_vip_level_3") : ImgURLMap.f10885a.a("live_vip_level_2") : ImgURLMap.f10885a.a("live_vip_level_1")).a(f().d);
            f().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipUpgradeDialogFragment$Qx9ZGEeEijq2GD0raMdhh_S9p6Y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveVipUpgradeDialogFragment.b(LiveVipUpgradeDialogFragment.this, view);
                }
            });
            f().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipUpgradeDialogFragment$gjvtp4rIBVhCYrmf8LMusJxSwUQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveVipUpgradeDialogFragment.c(LiveVipUpgradeDialogFragment.this, view);
                }
            });
            f().f11831c.setVisibility(0);
            f().f11831c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipUpgradeDialogFragment$cBJSbzoZHtvIFHHb4ihJw__EwiQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveVipUpgradeDialogFragment.d(LiveVipUpgradeDialogFragment.this, view);
                }
            });
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    public final void d() {
        try {
            LiveVipUpgradeModel liveVipUpgradeModel = this.f13290c;
            ClipData newPlainText = ClipData.newPlainText(r0, liveVipUpgradeModel == null ? null : liveVipUpgradeModel.getWechat());
            Object systemService = AppInfo.d().getSystemService(Context.CLIPBOARD_SERVICE);
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            ((ClipboardManager) systemService).setPrimaryClip(newPlainText);
            AppMethods.a((CharSequence) getString(R.string.live_vip_popup_text_6));
        } catch (Exception e) {
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
    }

    public final void e() {
        LiveVipUpgradeModel liveVipUpgradeModel = this.f13290c;
        if (liveVipUpgradeModel != null) {
            LiveRoomManager.a().p().vip_frame = liveVipUpgradeModel.getVip_frame();
            LiveRoomManager.a().p().vip_level = liveVipUpgradeModel.getVip_level();
        }
        LiveRoomHttpUtils.J(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.live_china.fragment.LiveVipUpgradeDialogFragment$notity$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, null);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int i = AppInfo.l;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipUpgradeDialogFragment$t1pcf_ruMq82Ns2B6JFUj5hxheM
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                boolean a2;
                a2 = LiveVipUpgradeDialogFragment.a(dialogInterface, i2, keyEvent);
                return a2;
            }
        });
        dialog.requestWindowFeature(1);
        dialog.setContentView(f().getRoot(), new ViewGroup.LayoutParams(i, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i;
        attributes.height = -1;
        attributes.gravity = 80;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
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
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        Intrinsics.a(attributes);
        attributes.dimAmount = 0.7f;
        Window window2 = dialog.getWindow();
        if (window2 == null) {
            return;
        }
        window2.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Serializable serializable;
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        if (arguments == null || (serializable = arguments.getSerializable("vipModel")) == null || !(serializable instanceof LiveVipUpgradeModel)) {
            return;
        }
        this.f13290c = (LiveVipUpgradeModel) serializable;
        g();
    }
}
