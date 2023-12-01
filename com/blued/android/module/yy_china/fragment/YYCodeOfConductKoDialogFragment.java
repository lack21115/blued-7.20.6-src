package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.OnClickHintFragmentLister;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCodeOfConductKoDialogFragment.class */
public final class YYCodeOfConductKoDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17160a = new Companion(null);
    private OnClickHintFragmentLister b;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCodeOfConductKoDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final YYCodeOfConductKoDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            YYCodeOfConductKoDialogFragment yYCodeOfConductKoDialogFragment = new YYCodeOfConductKoDialogFragment();
            yYCodeOfConductKoDialogFragment.show(manager, YYCodeOfConductKoDialogFragment.class.getSimpleName());
            return yYCodeOfConductKoDialogFragment;
        }
    }

    private final void a(final Dialog dialog) {
        ((ImageView) dialog.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCodeOfConductKoDialogFragment$RgZF0otW1ViFNOWHMDYUhj98amc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYCodeOfConductKoDialogFragment.a(YYCodeOfConductKoDialogFragment.this, view);
            }
        });
        ((LinearLayout) dialog.findViewById(R.id.ll_code_all)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCodeOfConductKoDialogFragment$eBseDYkijrTX5WnhsUQbL6kmc98
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYCodeOfConductKoDialogFragment.b(YYCodeOfConductKoDialogFragment.this, view);
            }
        });
        final TextView textView = (TextView) dialog.findViewById(R.id.tv_titl);
        WebView webView = (WebView) dialog.findViewById(R.id.web);
        webView.setBackgroundColor(0);
        new BluedWebView(this, webView, null, new BluedWebView.WebCallback() { // from class: com.blued.android.module.yy_china.fragment.YYCodeOfConductKoDialogFragment$initView$webViewHelper$1
            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a() {
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView<?> bluedWebView, int i) {
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView<?> bluedWebView, int i, String s, String s1) {
                Intrinsics.e(s, "s");
                Intrinsics.e(s1, "s1");
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView<?> bluedWebView, String str) {
                TextView.this.setText(str);
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView<?> bluedWebView, String url, boolean z) {
                Intrinsics.e(url, "url");
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(String s) {
                Intrinsics.e(s, "s");
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(String s, String s1, Fragment fragment, BluedWebView<?> bluedWebView) {
                Intrinsics.e(s, "s");
                Intrinsics.e(s1, "s1");
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(String s, String s1, String s2, String s3, int i, Map<String, String> map, BluedWebView<?> bluedWebView) {
                Intrinsics.e(s, "s");
                Intrinsics.e(s1, "s1");
                Intrinsics.e(s2, "s2");
                Intrinsics.e(s3, "s3");
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, BluedWebView<?> bluedWebView) {
                Intrinsics.e(s, "s");
                Intrinsics.e(s1, "s1");
                Intrinsics.e(s2, "s2");
                Intrinsics.e(s3, "s3");
                Intrinsics.e(s4, "s4");
                Intrinsics.e(s5, "s5");
                Intrinsics.e(s6, "s6");
                Intrinsics.e(s7, "s7");
                Intrinsics.e(s8, "s8");
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(Map<String, String> map, BluedWebView<?> bluedWebView) {
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public boolean a(Context context, String str) {
                return false;
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public boolean a(BluedWebView<?> bluedWebView, BluedUrlParser bluedUrlParser) {
                if (Intrinsics.a((Object) "yy_close", (Object) (bluedUrlParser == null ? null : bluedUrlParser.a()))) {
                    this.j();
                    return false;
                }
                if (Intrinsics.a((Object) "yy_read_norm_agree", (Object) (bluedUrlParser == null ? null : bluedUrlParser.a()))) {
                    this.k();
                    return false;
                }
                return false;
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void b() {
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void b(BluedWebView<?> bluedWebView, String url, boolean z) {
                Intrinsics.e(url, "url");
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public void b(String str) {
            }

            @Override // com.blued.android.framework.web.BluedWebView.WebCallback
            public boolean c(String s) {
                Intrinsics.e(s, "s");
                return false;
            }
        }).a(YYRoomInfoManager.e().c(-1));
        ((BottomSheetDialog) dialog).a().a(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.blued.android.module.yy_china.fragment.YYCodeOfConductKoDialogFragment$initView$3
            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View bottomSheet, float f) {
                Intrinsics.e(bottomSheet, "bottomSheet");
            }

            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View bottomSheet, int i) {
                Intrinsics.e(bottomSheet, "bottomSheet");
                if (i == 1) {
                    ((BottomSheetDialog) Dialog.this).a().d(4);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYCodeOfConductKoDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYCodeOfConductKoDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    private final void h() {
    }

    private final void i() {
        j();
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        OnClickHintFragmentLister onClickHintFragmentLister = this.b;
        if (onClickHintFragmentLister != null) {
            onClickHintFragmentLister.t();
        }
        j();
    }

    public final void a(OnClickHintFragmentLister onClickHintFragmentLister) {
        Intrinsics.e(onClickHintFragmentLister, "onClickHintFragmentLister");
        this.b = onClickHintFragmentLister;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(R.layout.fragment_yy_code_of_conduct);
        a(DensityUtils.a(getContext(), 500.0f));
        a(dialog);
    }
}
