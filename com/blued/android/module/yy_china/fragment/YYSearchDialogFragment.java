package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRecommendPkModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYSearchDialogFragment.class */
public final class YYSearchDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f17446a;
    private EditText b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17447c;
    private YYRoomModel d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYSearchDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYSearchDialogFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYRecommendPkModel yYRecommendPkModel) {
        getParentFragmentManager().setFragmentResult("search_name", BundleKt.bundleOf(TuplesKt.a("host_name", yYRecommendPkModel)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYSearchDialogFragment this$0, View view) {
        Boolean valueOf;
        Intrinsics.e(this$0, "this$0");
        EditText editText = this$0.b;
        String obj = StringsKt.b((CharSequence) String.valueOf(editText == null ? null : editText.getText())).toString();
        if (obj == null) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(obj.length() == 0);
        }
        if (valueOf.booleanValue()) {
            this$0.dismiss();
        } else {
            this$0.a(obj);
        }
    }

    public final void a(View root) {
        Intrinsics.e(root, "root");
        View findViewById = root.findViewById(R.id.conver_view);
        this.f17447c = (TextView) root.findViewById(R.id.btn_search);
        this.b = (EditText) root.findViewById(R.id.et_input);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYSearchDialogFragment$Kvm80nQOsPPmWnK0TRD-3oDefxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYSearchDialogFragment.a(YYSearchDialogFragment.this, view);
            }
        });
        TextView textView = this.f17447c;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYSearchDialogFragment$n6A7D5Oi7Krhmi7pcPzRiVz6-9k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYSearchDialogFragment.b(YYSearchDialogFragment.this, view);
            }
        });
    }

    public final void a(String name) {
        Intrinsics.e(name, "name");
        YYRoomModel yYRoomModel = this.d;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.a(str, name, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYRecommendPkModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYSearchDialogFragment$searchHostByName$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRecommendPkModel> bluedEntityA) {
                YYRecommendPkModel singleData;
                KeyboardUtils.b(YYSearchDialogFragment.this.e());
                KeyboardUtils.b(YYSearchDialogFragment.this.d(), YYSearchDialogFragment.this.e());
                KeyboardUtils.a(YYSearchDialogFragment.this.getActivity());
                YYSearchDialogFragment.this.dismiss();
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYSearchDialogFragment.this.a(singleData);
            }
        }, a());
    }

    public final Context d() {
        return this.f17446a;
    }

    public final EditText e() {
        return this.b;
    }

    public final void f() {
        IBinder windowToken;
        FragmentActivity activity = getActivity();
        Object systemService = activity == null ? null : activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText = this.b;
        boolean z = false;
        if (editText != null && editText.hasFocus()) {
            z = true;
        }
        if (!z) {
            dismiss();
            return;
        }
        KeyboardUtils.b(this.b);
        KeyboardUtils.b(this.f17446a, this.b);
        KeyboardUtils.a(getActivity());
        View view = getView();
        if (view != null) {
            view.requestFocus();
        }
        EditText editText2 = this.b;
        if (editText2 != null) {
            editText2.clearFocus();
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            windowToken = null;
        } else {
            View currentFocus = activity2.getCurrentFocus();
            windowToken = currentFocus == null ? null : currentFocus.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 2);
        inputMethodManager.restartInput(this.b);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Intrinsics.a(dialog);
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        Dialog dialog2 = getDialog();
        Intrinsics.a(dialog2);
        Window window2 = dialog2.getWindow();
        Intrinsics.a(window2);
        window2.setSoftInputMode(16);
        LiveEventBus.get(LiveEventBusConstant.d, String.class).observe(this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYSearchDialogFragment$hBaWGyYvJ2pi8G_jIisqIfW0wnY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYSearchDialogFragment.a(YYSearchDialogFragment.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17446a = getActivity();
        setStyle(0, 16973946);
        this.d = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View view = inflater.inflate(R.layout.dialog_yy_search_layout, viewGroup, false);
        Intrinsics.c(view, "view");
        a(view);
        return view;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
