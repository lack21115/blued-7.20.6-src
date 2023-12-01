package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.utils.EditTextHeightAnimHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYytypingBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ISendMsgListener;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYTypingDialog.class */
public final class YYTypingDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogYytypingBinding f18528a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private final ISendMsgListener f18529c;
    private BaseYYStudioFragment d;
    private String e;
    private String f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYTypingDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().f16460a.setFocusableInTouchMode(true);
        this$0.f().f16460a.setFocusable(true);
        this$0.f().f16460a.requestFocus();
        Object systemService = this$0.f().f16460a.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).showSoftInput(this$0.f().f16460a, 0);
        this$0.f().f16460a.setSelection(this$0.f().f16460a.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYTypingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity fragmentActivity = null;
        if (YYRoomInfoManager.e().c().a(this$0.getContext(), (View.OnClickListener) null)) {
            return;
        }
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
        if (yYUserInfo != null && TextUtils.equals(yYUserInfo.mute, "1")) {
            ToastUtils.a("你已被禁言，暂不可在此房间发言", 0);
            return;
        }
        String obj = this$0.f().f16460a.getText().toString();
        String str = obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.a((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (TextUtils.isEmpty(str.subSequence(i, length + 1).toString())) {
            return;
        }
        Logger.e("IM msg", Intrinsics.a("原始 msg = ", (Object) obj));
        YYImMsgManager.a().a(EncryptTool.b(this$0.e), this$0.f, obj, this$0.b, this$0.d);
        ISendMsgListener iSendMsgListener = this$0.f18529c;
        if (iSendMsgListener != null) {
            iSendMsgListener.a();
        }
        BaseYYStudioFragment baseYYStudioFragment = this$0.d;
        if (baseYYStudioFragment != null) {
            fragmentActivity = baseYYStudioFragment.getActivity();
        }
        KeyboardUtils.a(fragmentActivity);
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYTypingDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void g() {
        if (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(this.f)) {
            HashMap hashMap = new HashMap();
            String str = this.f;
            Intrinsics.a((Object) str);
            String str2 = this.e;
            Intrinsics.a((Object) str2);
            hashMap.put(str, str2);
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append((Object) YYRoomInfoManager.e().a(this.e, this.f));
            sb.append(' ');
            this.b = sb.toString();
            YYRoomInfoManager.e().c().a(getContext(), f().f16460a, 16, getResources().getColor(R.color.syc_00E0AB), this.b, hashMap);
        }
        f().f16460a.setFilters(new InputFilter[]{new EnglishCharFilter(280)});
        f().d.setEnabled(false);
        EditTextHeightAnimHelper.a(f().f16460a, 1.0f, 3.5f);
        BaseYYStudioFragment baseYYStudioFragment = this.d;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYTypingDialog$_0aeDa7AIgxgCzmDXA99b2xUGcU
            @Override // java.lang.Runnable
            public final void run() {
                YYTypingDialog.a(YYTypingDialog.this);
            }
        }, 200L);
    }

    private final void h() {
        f().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYTypingDialog$tD1z0hsf7h1zWmB2dFUD64w4SCE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYTypingDialog.a(YYTypingDialog.this, view);
            }
        });
        f().f16460a.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.view.YYTypingDialog$initListener$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.e(s, "s");
                if (TextUtils.isEmpty(s)) {
                    YYTypingDialog.this.f().d.setEnabled(false);
                    ShapeHelper.a(YYTypingDialog.this.f().d, R.color.syc_dark_j, R.color.syc_dark_j);
                    return;
                }
                YYTypingDialog.this.f().d.setEnabled(true);
                ShapeHelper.a(YYTypingDialog.this.f().d, R.color.syc_00E0AB, R.color.syc_3883FD);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYTypingDialog$zO081tahVk9i9TQ3hIK_82NmUbI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYTypingDialog.b(YYTypingDialog.this, view);
            }
        });
    }

    public final void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.d = baseYYStudioFragment;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final void b(String str) {
        this.f = str;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final DialogYytypingBinding f() {
        DialogYytypingBinding dialogYytypingBinding = this.f18528a;
        Intrinsics.a(dialogYytypingBinding);
        return dialogYytypingBinding;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18528a = DialogYytypingBinding.a(inflater.inflate(R.layout.dialog_yytyping, viewGroup, true));
        return f().getRoot();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        h();
        g();
    }
}
