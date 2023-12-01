package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyModifyClubNameBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYModifyClubNameDialog.class */
public final class YYModifyClubNameDialog extends BaseFullScreenDialog {
    private String a;
    private int b;
    private YYRoomModel c;
    private DialogYyModifyClubNameBinding d;

    public YYModifyClubNameDialog(String clubName, int i) {
        Intrinsics.e(clubName, "clubName");
        this.a = clubName;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYModifyClubNameDialog this$0) {
        AppCompatEditText appCompatEditText;
        Integer valueOf;
        AppCompatEditText appCompatEditText2;
        Intrinsics.e(this$0, "this$0");
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding = this$0.d;
        AppCompatEditText appCompatEditText3 = dialogYyModifyClubNameBinding == null ? null : dialogYyModifyClubNameBinding.c;
        if (appCompatEditText3 != null) {
            appCompatEditText3.setFocusableInTouchMode(true);
        }
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding2 = this$0.d;
        AppCompatEditText appCompatEditText4 = dialogYyModifyClubNameBinding2 == null ? null : dialogYyModifyClubNameBinding2.c;
        if (appCompatEditText4 != null) {
            appCompatEditText4.setFocusable(true);
        }
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding3 = this$0.d;
        if (dialogYyModifyClubNameBinding3 != null && (appCompatEditText2 = dialogYyModifyClubNameBinding3.c) != null) {
            appCompatEditText2.requestFocus();
        }
        Context context = this$0.getContext();
        Object systemService = context == null ? null : context.getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding4 = this$0.d;
            inputMethodManager.showSoftInput(dialogYyModifyClubNameBinding4 == null ? null : dialogYyModifyClubNameBinding4.c, 0);
        }
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding5 = this$0.d;
        if (dialogYyModifyClubNameBinding5 == null || (appCompatEditText = dialogYyModifyClubNameBinding5.c) == null) {
            return;
        }
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding6 = this$0.d;
        if (dialogYyModifyClubNameBinding6 == null) {
            valueOf = null;
        } else {
            AppCompatEditText appCompatEditText5 = dialogYyModifyClubNameBinding6.c;
            if (appCompatEditText5 == null) {
                valueOf = null;
            } else {
                Editable text = appCompatEditText5.getText();
                valueOf = text == null ? null : Integer.valueOf(text.length());
            }
        }
        Intrinsics.a(valueOf);
        appCompatEditText.setSelection(valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYModifyClubNameDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void a(String str) {
        if (this.c == null) {
            return;
        }
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.w(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYModifyClubNameDialog$setNewName$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                ToastUtils.a("提交成功，待审核通过后粉丝团铭牌生效。", 0);
                YYModifyClubNameDialog.this.dismissAllowingStateLoss();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                DialogYyModifyClubNameBinding f = YYModifyClubNameDialog.this.f();
                FrameLayout frameLayout = f == null ? null : f.e;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogYyModifyClubNameBinding f = YYModifyClubNameDialog.this.f();
                FrameLayout frameLayout = f == null ? null : f.e;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(0);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYModifyClubNameDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYModifyClubNameDialog this$0, View view) {
        AppCompatEditText appCompatEditText;
        Intrinsics.e(this$0, "this$0");
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding = this$0.d;
        String str = null;
        String obj = StringsKt.b((CharSequence) String.valueOf((dialogYyModifyClubNameBinding == null || (appCompatEditText = dialogYyModifyClubNameBinding.c) == null) ? null : appCompatEditText.getText())).toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_FANS_EDIT_SUBMIT_CLICK;
        YYRoomModel yYRoomModel = this$0.c;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.c;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.c(event, str2, str, this$0.b);
        this$0.a(obj);
    }

    private final void g() {
        AppCompatEditText appCompatEditText;
        ShapeTextView shapeTextView;
        FrameLayout frameLayout;
        View view;
        ImageView imageView;
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding = this.d;
        if (dialogYyModifyClubNameBinding != null && (imageView = dialogYyModifyClubNameBinding.f) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYModifyClubNameDialog$8muhPTGKs2Rr9nAyiOeMS-tU3l4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYModifyClubNameDialog.a(YYModifyClubNameDialog.this, view2);
                }
            });
        }
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding2 = this.d;
        if (dialogYyModifyClubNameBinding2 != null && (view = dialogYyModifyClubNameBinding2.b) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYModifyClubNameDialog$G-trWKBNSJ9rELQV0sE_EixMtDY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYModifyClubNameDialog.b(YYModifyClubNameDialog.this, view2);
                }
            });
        }
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding3 = this.d;
        if (dialogYyModifyClubNameBinding3 != null && (frameLayout = dialogYyModifyClubNameBinding3.d) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYModifyClubNameDialog$xQfUpFDTiXqDNkB0opuzxDa22GU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYModifyClubNameDialog.a(view2);
                }
            });
        }
        DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding4 = this.d;
        if (dialogYyModifyClubNameBinding4 != null && (shapeTextView = dialogYyModifyClubNameBinding4.a) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYModifyClubNameDialog$CGLum6mvTxsSd6-l9DkG7d3cABA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYModifyClubNameDialog.c(YYModifyClubNameDialog.this, view2);
                }
            });
        }
        if (TextUtils.isEmpty(this.a)) {
            DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding5 = this.d;
            AppCompatEditText appCompatEditText2 = dialogYyModifyClubNameBinding5 == null ? null : dialogYyModifyClubNameBinding5.c;
            if (appCompatEditText2 != null) {
                appCompatEditText2.setHint(getResources().getString(R.string.yy_live_notice));
            }
        } else {
            DialogYyModifyClubNameBinding dialogYyModifyClubNameBinding6 = this.d;
            if (dialogYyModifyClubNameBinding6 != null && (appCompatEditText = dialogYyModifyClubNameBinding6.c) != null) {
                appCompatEditText.setText(this.a);
            }
        }
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYModifyClubNameDialog$d4Fst6G5McnJN_AIGMizOcdLtkw
            @Override // java.lang.Runnable
            public final void run() {
                YYModifyClubNameDialog.a(YYModifyClubNameDialog.this);
            }
        }, 200L);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final DialogYyModifyClubNameBinding f() {
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_modify_club_name, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…ub_name, container, true)");
        this.d = DialogYyModifyClubNameBinding.a(inflate);
        this.c = YYRoomInfoManager.e().b();
        g();
        return inflate;
    }
}
