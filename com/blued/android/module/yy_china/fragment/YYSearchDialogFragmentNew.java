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
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYSearchDialogFragmentNew.class */
public final class YYSearchDialogFragmentNew extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f17449a;
    private YYRoomModel b;

    /* renamed from: c  reason: collision with root package name */
    private DialogYySearchLayoutNewBinding f17450c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYSearchDialogFragmentNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYRecommendPkModel yYRecommendPkModel) {
        getParentFragmentManager().setFragmentResult("search_name", BundleKt.bundleOf(TuplesKt.a("host_name", yYRecommendPkModel)));
    }

    private final void a(String str) {
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.a(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYRecommendPkModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYSearchDialogFragmentNew$searchHostByName$1
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
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this$0.f17450c;
        EditText editText2 = dialogYySearchLayoutNewBinding == null ? null : dialogYySearchLayoutNewBinding.b;
        if (editText2 != null) {
            editText2.setFocusableInTouchMode(true);
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding2 = this$0.f17450c;
        EditText editText3 = dialogYySearchLayoutNewBinding2 == null ? null : dialogYySearchLayoutNewBinding2.b;
        if (editText3 != null) {
            editText3.setFocusable(true);
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding3 = this$0.f17450c;
        if (dialogYySearchLayoutNewBinding3 != null && (editText = dialogYySearchLayoutNewBinding3.b) != null) {
            editText.requestFocus();
        }
        Object systemService = this$0.requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding4 = this$0.f17450c;
        inputMethodManager.showSoftInput(dialogYySearchLayoutNewBinding4 == null ? null : dialogYySearchLayoutNewBinding4.b, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYSearchDialogFragmentNew this$0, View view) {
        EditText editText;
        Intrinsics.e(this$0, "this$0");
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this$0.f17450c;
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
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this.f17450c;
        if (dialogYySearchLayoutNewBinding != null && (view = dialogYySearchLayoutNewBinding.f16456a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYSearchDialogFragmentNew$zTaGsyC5wuBfXdXzvpKLbSVd6cA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYSearchDialogFragmentNew.a(YYSearchDialogFragmentNew.this, view2);
                }
            });
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding2 = this.f17450c;
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
                        dialogYySearchLayoutNewBinding5 = YYSearchDialogFragmentNew.this.f17450c;
                        ShapeTextView shapeTextView2 = dialogYySearchLayoutNewBinding5 == null ? null : dialogYySearchLayoutNewBinding5.f16457c;
                        if (shapeTextView2 != null) {
                            shapeTextView2.setEnabled(false);
                        }
                        dialogYySearchLayoutNewBinding6 = YYSearchDialogFragmentNew.this.f17450c;
                        ShapeHelper.a(dialogYySearchLayoutNewBinding6 == null ? null : dialogYySearchLayoutNewBinding6.f16457c, R.color.syc_dark_j, R.color.syc_dark_j);
                        return;
                    }
                    dialogYySearchLayoutNewBinding3 = YYSearchDialogFragmentNew.this.f17450c;
                    ShapeTextView shapeTextView3 = dialogYySearchLayoutNewBinding3 == null ? null : dialogYySearchLayoutNewBinding3.f16457c;
                    if (shapeTextView3 != null) {
                        shapeTextView3.setEnabled(true);
                    }
                    dialogYySearchLayoutNewBinding4 = YYSearchDialogFragmentNew.this.f17450c;
                    ShapeHelper.a(dialogYySearchLayoutNewBinding4 == null ? null : dialogYySearchLayoutNewBinding4.f16457c, R.color.syc_00E0AB, R.color.syc_3883FD);
                }
            });
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding3 = this.f17450c;
        if (dialogYySearchLayoutNewBinding3 != null && (shapeTextView = dialogYySearchLayoutNewBinding3.f16457c) != null) {
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
        Object systemService = activity == null ? null : activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding = this.f17450c;
        KeyboardUtils.b(dialogYySearchLayoutNewBinding == null ? null : dialogYySearchLayoutNewBinding.b);
        Context context = this.f17449a;
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding2 = this.f17450c;
        KeyboardUtils.b(context, dialogYySearchLayoutNewBinding2 == null ? null : dialogYySearchLayoutNewBinding2.b);
        KeyboardUtils.a(getActivity());
        View view = getView();
        if (view != null) {
            view.requestFocus();
        }
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding3 = this.f17450c;
        if (dialogYySearchLayoutNewBinding3 != null && (editText = dialogYySearchLayoutNewBinding3.b) != null) {
            editText.clearFocus();
        }
        FragmentActivity activity2 = getActivity();
        inputMethodManager.hideSoftInputFromWindow((activity2 == null || (currentFocus = activity2.getCurrentFocus()) == null) ? null : currentFocus.getWindowToken(), 2);
        DialogYySearchLayoutNewBinding dialogYySearchLayoutNewBinding4 = this.f17450c;
        inputMethodManager.restartInput(dialogYySearchLayoutNewBinding4 == null ? null : dialogYySearchLayoutNewBinding4.b);
        dismiss();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17449a = getActivity();
        this.b = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_search_layout_new, viewGroup, false);
        this.f17450c = DialogYySearchLayoutNewBinding.a(inflate);
        g();
        return inflate;
    }
}
