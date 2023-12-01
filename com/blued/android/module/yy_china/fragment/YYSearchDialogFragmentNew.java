package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYySearchLayoutNewBinding;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRecommendPkModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYSearchDialogFragmentNew.class */
public final class YYSearchDialogFragmentNew extends BaseFullScreenDialog {
    private Context a;
    private YYRoomModel b;
    private DialogYySearchLayoutNewBinding c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYSearchDialogFragmentNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYRecommendPkModel yYRecommendPkModel) {
        getParentFragmentManager().setFragmentResult("search_name", BundleKt.bundleOf(new Pair[]{TuplesKt.a("host_name", yYRecommendPkModel)}));
    }

    private final void a(String str) {
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.a(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYRecommendPkModel>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYSearchDialogFragmentNew$searchHostByName$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRecommendPkModel> bluedEntityA) {
                YYRecommendPkModel singleData;
                YYSearchDialogFragmentNew.this.f();
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYSearchDialogFragmentNew.this.a(singleData);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYSearchDialogFragmentNew this$0) {
        EditText editText;
        Intrinsics.e(this$0, "this$0");
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this$0.c;
        EditText editText2 = dialogYySearchLayoutNewBinding == null ? null : dialogYySearchLayoutNewBinding.b;
        if (editText2 != null) {
            editText2.setFocusableInTouchMode(true);
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding2 = this$0.c;
        EditText editText3 = dialogYySearchLayoutNewBinding2 == null ? null : dialogYySearchLayoutNewBinding2.b;
        if (editText3 != null) {
            editText3.setFocusable(true);
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding3 = this$0.c;
        if (dialogYySearchLayoutNewBinding3 != null && (editText = dialogYySearchLayoutNewBinding3.b) != null) {
            editText.requestFocus();
        }
        Object systemService = this$0.requireContext().getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding4 = this$0.c;
        inputMethodManager.showSoftInput(dialogYySearchLayoutNewBinding4 == null ? null : dialogYySearchLayoutNewBinding4.b, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYSearchDialogFragmentNew this$0, View view) {
        EditText editText;
        Intrinsics.e(this$0, "this$0");
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this$0.c;
        Editable editable = null;
        if (dialogYySearchLayoutNewBinding != null && (editText = dialogYySearchLayoutNewBinding.b) != null) {
            editable = editText.getText();
        }
        String obj = StringsKt.b((CharSequence) String.valueOf(editable)).toString();
        if (obj.length() == 0) {
            return;
        }
        this$0.a(obj);
    }

    private final void g() {
        ShapeTextView shapeTextView;
        EditText editText;
        View view;
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this.c;
        if (dialogYySearchLayoutNewBinding != null && (view = dialogYySearchLayoutNewBinding.a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYSearchDialogFragmentNew$zTaGsyC5wuBfXdXzvpKLbSVd6cA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYSearchDialogFragmentNew.a(YYSearchDialogFragmentNew.this, view2);
                }
            });
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding2 = this.c;
        if (dialogYySearchLayoutNewBinding2 != null && (editText = dialogYySearchLayoutNewBinding2.b) != null) {
            editText.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYSearchDialogFragmentNew$initView$2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding3;
                    DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding4;
                    DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding5;
                    DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding6;
                    CharSequence b = editable == null ? null : StringsKt.b(editable);
                    if (b == null || b.length() == 0) {
                        dialogYySearchLayoutNewBinding5 = YYSearchDialogFragmentNew.this.c;
                        ShapeTextView shapeTextView2 = dialogYySearchLayoutNewBinding5 == null ? null : dialogYySearchLayoutNewBinding5.c;
                        if (shapeTextView2 != null) {
                            shapeTextView2.setEnabled(false);
                        }
                        dialogYySearchLayoutNewBinding6 = YYSearchDialogFragmentNew.this.c;
                        ShapeHelper.a(dialogYySearchLayoutNewBinding6 == null ? null : dialogYySearchLayoutNewBinding6.c, R.color.syc_dark_j, R.color.syc_dark_j);
                        return;
                    }
                    dialogYySearchLayoutNewBinding3 = YYSearchDialogFragmentNew.this.c;
                    ShapeTextView shapeTextView3 = dialogYySearchLayoutNewBinding3 == null ? null : dialogYySearchLayoutNewBinding3.c;
                    if (shapeTextView3 != null) {
                        shapeTextView3.setEnabled(true);
                    }
                    dialogYySearchLayoutNewBinding4 = YYSearchDialogFragmentNew.this.c;
                    ShapeHelper.a(dialogYySearchLayoutNewBinding4 == null ? null : dialogYySearchLayoutNewBinding4.c, R.color.syc_00E0AB, R.color.syc_3883FD);
                }
            });
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding3 = this.c;
        if (dialogYySearchLayoutNewBinding3 != null && (shapeTextView = dialogYySearchLayoutNewBinding3.c) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYSearchDialogFragmentNew$C4R2lNFxvbf0-MOFX2HIod6RFhQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYSearchDialogFragmentNew.b(YYSearchDialogFragmentNew.this, view2);
                }
            });
        }
        h();
    }

    private final void h() {
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYSearchDialogFragmentNew$RKHbQWSdghI3q5rsd9Ra2OULZRU
            @Override // java.lang.Runnable
            public final void run() {
                YYSearchDialogFragmentNew.b(YYSearchDialogFragmentNew.this);
            }
        }, 200L);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final void f() {
        View currentFocus;
        EditText editText;
        FragmentActivity activity = getActivity();
        Object systemService = activity == null ? null : activity.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this.c;
        KeyboardUtils.b(dialogYySearchLayoutNewBinding == null ? null : dialogYySearchLayoutNewBinding.b);
        Context context = this.a;
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding2 = this.c;
        KeyboardUtils.b(context, dialogYySearchLayoutNewBinding2 == null ? null : dialogYySearchLayoutNewBinding2.b);
        KeyboardUtils.a(getActivity());
        View view = getView();
        if (view != null) {
            view.requestFocus();
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding3 = this.c;
        if (dialogYySearchLayoutNewBinding3 != null && (editText = dialogYySearchLayoutNewBinding3.b) != null) {
            editText.clearFocus();
        }
        FragmentActivity activity2 = getActivity();
        inputMethodManager.hideSoftInputFromWindow((activity2 == null || (currentFocus = activity2.getCurrentFocus()) == null) ? null : currentFocus.getWindowToken(), 2);
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding4 = this.c;
        inputMethodManager.restartInput(dialogYySearchLayoutNewBinding4 == null ? null : dialogYySearchLayoutNewBinding4.b);
        dismiss();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = getActivity();
        this.b = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_search_layout_new, viewGroup, false);
        this.c = DialogYySearchLayoutNewBinding.a(inflate);
        g();
        return inflate;
    }
}
