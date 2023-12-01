package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.DialogYyMatchingLayoutBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEventMatching;
import com.blued.android.module.yy_china.model.YYGlobalMsgModel;
import com.blued.android.module.yy_china.model.YYMatchingRoomModel;
import com.blued.android.module.yy_china.model.YYMsgMatchingInfoNewExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPKMatchingFragment.class */
public final class YYPKMatchingFragment extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17352a = new Companion(null);
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private DialogYyMatchingLayoutBinding f17353c;
    private YYEventMatching d;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPKMatchingFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final YYPKMatchingFragment a(YYEventMatching params) {
            Intrinsics.e(params, "params");
            Bundle bundle = new Bundle();
            YYPKMatchingFragment yYPKMatchingFragment = new YYPKMatchingFragment();
            bundle.putSerializable("matching_model", params);
            yYPKMatchingFragment.setArguments(bundle);
            return yYPKMatchingFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PK_CONNECT_FAIL;
                YYRoomModel b = YYRoomInfoManager.e().b();
                EventTrackYY.e(event, b == null ? null : b.room_id);
                return "连线失败～";
            }
            return "连线成功！";
        }
        return "正在连线中";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    private final void a(YYConstants.MatchingFromSource matchingFromSource) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.i(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYPKMatchingFragment$requestCancelPk$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding;
                DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding2;
                String a3;
                YYRoomInfoManager.e().u();
                dialogYyMatchingLayoutBinding = YYPKMatchingFragment.this.f17353c;
                TextView textView = dialogYyMatchingLayoutBinding == null ? null : dialogYyMatchingLayoutBinding.h;
                if (textView != null) {
                    a3 = YYPKMatchingFragment.this.a(2);
                    textView.setText(a3);
                }
                dialogYyMatchingLayoutBinding2 = YYPKMatchingFragment.this.f17353c;
                TextView textView2 = dialogYyMatchingLayoutBinding2 == null ? null : dialogYyMatchingLayoutBinding2.f16436a;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                YYPKMatchingFragment.this.g();
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKMatchingFragment this$0, View view) {
        YYConstants.MatchingFromSource matchingFromSource;
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PK_CANCEL_CLICK;
        YYRoomModel b = YYRoomInfoManager.e().b();
        EventTrackYY.e(event, b == null ? null : b.room_id);
        YYEventMatching yYEventMatching = this$0.d;
        if (yYEventMatching == null || (matchingFromSource = yYEventMatching.matchType) == null) {
            return;
        }
        this$0.a(matchingFromSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKMatchingFragment this$0, YYGlobalMsgModel yYGlobalMsgModel) {
        YYMsgMatchingInfoNewExtra yYMsgMatchingInfoNewExtra;
        Intrinsics.e(this$0, "this$0");
        if (yYGlobalMsgModel == null || yYGlobalMsgModel.type != 2 || (yYMsgMatchingInfoNewExtra = (YYMsgMatchingInfoNewExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYMsgMatchingInfoNewExtra.class)) == null) {
            return;
        }
        YYRoomInfoManager.e().u();
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding = this$0.f17353c;
        TextView textView = dialogYyMatchingLayoutBinding == null ? null : dialogYyMatchingLayoutBinding.h;
        if (textView != null) {
            textView.setText(this$0.a(yYMsgMatchingInfoNewExtra.status));
        }
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding2 = this$0.f17353c;
        TextView textView2 = dialogYyMatchingLayoutBinding2 == null ? null : dialogYyMatchingLayoutBinding2.f16436a;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (yYMsgMatchingInfoNewExtra.status == 2) {
            this$0.g();
            return;
        }
        YYMatchingRoomModel yYMatchingRoomModel = yYMsgMatchingInfoNewExtra.body;
        if (yYMatchingRoomModel == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        EventTrackYY.q(ChatRoomProtos.Event.YY_PK_CONNECT_SUCCESS, b == null ? null : b.room_id, yYMatchingRoomModel.room_id, yYMatchingRoomModel.uid);
        ImageWrapper b2 = ImageLoader.a(this$0.a(), yYMatchingRoomModel.avatar).b(R.color.syc_dark_b);
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding3 = this$0.f17353c;
        b2.a(dialogYyMatchingLayoutBinding3 == null ? null : dialogYyMatchingLayoutBinding3.g);
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding4 = this$0.f17353c;
        TextView textView3 = dialogYyMatchingLayoutBinding4 == null ? null : dialogYyMatchingLayoutBinding4.j;
        if (textView3 != null) {
            textView3.setText(yYMatchingRoomModel.name);
        }
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding5 = this$0.f17353c;
        TextView textView4 = dialogYyMatchingLayoutBinding5 == null ? null : dialogYyMatchingLayoutBinding5.f16436a;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final YYPKMatchingFragment this$0, String str) {
        TextView textView;
        Intrinsics.e(this$0, "this$0");
        if (!StringUtils.b(str)) {
            DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding = this$0.f17353c;
            TextView textView2 = dialogYyMatchingLayoutBinding == null ? null : dialogYyMatchingLayoutBinding.h;
            if (textView2 == null) {
                return;
            }
            textView2.setText(str);
            return;
        }
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding2 = this$0.f17353c;
        TextView textView3 = dialogYyMatchingLayoutBinding2 == null ? null : dialogYyMatchingLayoutBinding2.h;
        if (textView3 != null) {
            textView3.setText(this$0.a(2));
        }
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding3 = this$0.f17353c;
        TextView textView4 = dialogYyMatchingLayoutBinding3 == null ? null : dialogYyMatchingLayoutBinding3.f16436a;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding4 = this$0.f17353c;
        if (dialogYyMatchingLayoutBinding4 == null || (textView = dialogYyMatchingLayoutBinding4.j) == null) {
            return;
        }
        textView.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPKMatchingFragment$B8e-Z_wwk4a5lW6e6mI44XjtSiI
            @Override // java.lang.Runnable
            public final void run() {
                YYPKMatchingFragment.c(YYPKMatchingFragment.this);
            }
        }, m.ag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYPKMatchingFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYPKMatchingFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        TextView textView;
        View view;
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding = this.f17353c;
        if (dialogYyMatchingLayoutBinding != null && (view = dialogYyMatchingLayoutBinding.b) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPKMatchingFragment$jWiRqLyUJb9jd9nx_HsHmrjP6Wk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYPKMatchingFragment.a(view2);
                }
            });
        }
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding2 = this.f17353c;
        if (dialogYyMatchingLayoutBinding2 == null || (textView = dialogYyMatchingLayoutBinding2.f16436a) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPKMatchingFragment$KCtjYW_ZbuAhzPGKvTi60EFUMz8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPKMatchingFragment.a(YYPKMatchingFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        TextView textView;
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding = this.f17353c;
        if (dialogYyMatchingLayoutBinding == null || (textView = dialogYyMatchingLayoutBinding.j) == null) {
            return;
        }
        textView.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPKMatchingFragment$T9DjppWWcWi38Vvl6M5R_tBDWMM
            @Override // java.lang.Runnable
            public final void run() {
                YYPKMatchingFragment.d(YYPKMatchingFragment.this);
            }
        }, m.ag);
    }

    private final void h() {
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding = this.f17353c;
        TextView textView = dialogYyMatchingLayoutBinding == null ? null : dialogYyMatchingLayoutBinding.h;
        if (textView != null) {
            textView.setText(a(0));
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            ImageWrapper a2 = ImageLoader.a(a(), b.avatar);
            DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding2 = this.f17353c;
            a2.a(dialogYyMatchingLayoutBinding2 == null ? null : dialogYyMatchingLayoutBinding2.f);
            DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding3 = this.f17353c;
            TextView textView2 = dialogYyMatchingLayoutBinding3 == null ? null : dialogYyMatchingLayoutBinding3.i;
            if (textView2 != null) {
                textView2.setText(b.name);
            }
        }
        YYRoomInfoManager.e().c(30000L);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        YYPKMatchingFragment yYPKMatchingFragment = this;
        LiveEventBus.get("show_room_pk_connecting_time", String.class).observe(yYPKMatchingFragment, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPKMatchingFragment$XHmWuIC8buFraWDqwoVtS-uGiIM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYPKMatchingFragment.a(YYPKMatchingFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("room_pk_message", YYGlobalMsgModel.class).observe(yYPKMatchingFragment, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPKMatchingFragment$fQYw2hu1xlujQxk7WtgewTtvOrs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYPKMatchingFragment.a(YYPKMatchingFragment.this, (YYGlobalMsgModel) obj);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getActivity();
        Bundle arguments = getArguments();
        Serializable serializable = arguments == null ? null : arguments.getSerializable("matching_model");
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYEventMatching");
        }
        this.d = (YYEventMatching) serializable;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_matching_layout, viewGroup, false);
        this.f17353c = DialogYyMatchingLayoutBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        YYEventMatching yYEventMatching;
        YYConstants.MatchingFromSource matchingFromSource;
        TextView textView;
        super.onDestroyView();
        DialogYyMatchingLayoutBinding dialogYyMatchingLayoutBinding = this.f17353c;
        CharSequence charSequence = null;
        if (dialogYyMatchingLayoutBinding != null && (textView = dialogYyMatchingLayoutBinding.h) != null) {
            charSequence = textView.getText();
        }
        if ((StringsKt.b((CharSequence) String.valueOf(charSequence)).toString().length() > 0) && (yYEventMatching = this.d) != null && (matchingFromSource = yYEventMatching.matchType) != null) {
            a(matchingFromSource);
        }
        YYRoomInfoManager.e().u();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        h();
    }
}
