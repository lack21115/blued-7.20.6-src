package com.blued.community.ui.common;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.community.R;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.view.EditInputNumView;
import com.blued.community.view.SelectionEditText;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/common/CommonEditDlgFragment.class */
public final class CommonEditDlgFragment extends LiveBaseDialogFragment {
    public static final Companion j = new Companion(null);
    private TextView k;
    private TextView l;
    private SelectionEditText m;
    private EditInputNumView n;
    private TextView o;
    private TextView p;
    private TextWatcher q;
    private CardView r;
    private String s = "";
    private boolean t;
    private String u;
    private boolean v;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/common/CommonEditDlgFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, String str, boolean z, String str2) {
            if (fragmentManager == null) {
                return;
            }
            CommonEditDlgFragment commonEditDlgFragment = new CommonEditDlgFragment();
            Bundle bundle = new Bundle();
            bundle.putString("aid", str);
            bundle.putBoolean("is_manager", z);
            bundle.putString("content", str2);
            commonEditDlgFragment.setArguments(bundle);
            commonEditDlgFragment.show(fragmentManager, CommonEditDlgFragment.class.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CommonEditDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, MotionEvent motionEvent) {
        if (view.getId() == R.id.feed_post_content_et) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 1) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CommonEditDlgFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
        KeyboardUtils.c(this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CommonEditDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CommonEditDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.u();
    }

    private final boolean m() {
        SelectionEditText selectionEditText = this.m;
        if (selectionEditText == null) {
            return false;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(String.valueOf(selectionEditText.getText()))) {
            z = false;
            if (String.valueOf(selectionEditText.getText()).length() <= o()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        if (m()) {
            TextView textView = this.p;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.syc_a));
            }
            TextView textView2 = this.p;
            if (textView2 == null) {
                return;
            }
            textView2.setEnabled(true);
            return;
        }
        if (this.v) {
            TextView textView3 = this.p;
            if (textView3 != null) {
                textView3.setTextColor(getResources().getColor(R.color.syc_dark_777777));
            }
        } else {
            TextView textView4 = this.p;
            if (textView4 != null) {
                textView4.setTextColor(getResources().getColor(R.color.syc_dark_d0d0d0));
            }
        }
        TextView textView5 = this.p;
        if (textView5 == null) {
            return;
        }
        textView5.setEnabled(false);
    }

    private final int o() {
        return 256;
    }

    private final String p() {
        String string = getString(R.string.event_introduce);
        Intrinsics.c(string, "getString(R.string.event_introduce)");
        return string;
    }

    private final String q() {
        String string = getString(R.string.event_valid_in_event);
        Intrinsics.c(string, "getString(R.string.event_valid_in_event)");
        return string;
    }

    private final String r() {
        if (this.t) {
            String string = getString(R.string.event_signature_hint_host);
            Intrinsics.c(string, "{\n            getString(…ture_hint_host)\n        }");
            return string;
        }
        String string2 = getString(R.string.event_signature_hint_guest);
        Intrinsics.c(string2, "{\n            getString(…ure_hint_guest)\n        }");
        return string2;
    }

    private final void s() {
        SelectionEditText selectionEditText = this.m;
        if (selectionEditText == null) {
            return;
        }
        if (selectionEditText.isFocusable()) {
            selectionEditText.setFocusable(true);
            selectionEditText.setFocusableInTouchMode(true);
        }
        selectionEditText.requestFocus();
        selectionEditText.setSelection(selectionEditText.length());
    }

    private final void t() {
        SelectionEditText selectionEditText = this.m;
        if (selectionEditText == null) {
            return;
        }
        KeyboardUtils.b(selectionEditText);
    }

    private final void u() {
        final SelectionEditText selectionEditText;
        if (m() && (selectionEditText = this.m) != null) {
            EventHttpUtils eventHttpUtils = EventHttpUtils.f19079a;
            final ActivityFragmentActive a2 = a();
            eventHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>(this, a2) { // from class: com.blued.community.ui.common.CommonEditDlgFragment$onClickConfirm$1$1
                final /* synthetic */ CommonEditDlgFragment b;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(a2);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> result) {
                    Intrinsics.e(result, "result");
                    ToastUtils.a(R.string.event_signature_post_success);
                    LiveEventBus.get("event_signature_post_success").post(String.valueOf(SelectionEditText.this.getText()));
                    this.b.j();
                }
            }, l(), String.valueOf(selectionEditText.getText()), a());
        }
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.s = str;
    }

    public final void a(boolean z) {
        this.t = z;
    }

    public final void b(String str) {
        this.u = str;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_common_edit;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.v = CommunityManager.f19086a.a().s();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("aid", "");
            Intrinsics.c(string, "it.getString(\"aid\", \"\")");
            a(string);
            a(arguments.getBoolean("is_manager"));
            b(arguments.getString("content", ""));
        }
        TextView textView = (TextView) this.b.findViewById(R.id.common_edit_title);
        this.k = textView;
        if (textView != null) {
            textView.setText(p());
        }
        this.l = (TextView) this.b.findViewById(R.id.common_edit_des);
        if (TextUtils.isEmpty(q())) {
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setText(q());
            }
            TextView textView4 = this.l;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        CardView cardView = (CardView) this.b.findViewById(R.id.common_edit_cv);
        this.r = cardView;
        if (this.v) {
            if (cardView != null) {
                cardView.setCardBackgroundColor(getResources().getColor(R.color.syc_0E0E0E));
            }
        } else if (cardView != null) {
            cardView.setCardBackgroundColor(getResources().getColor(R.color.syc_dark_f8f8f8));
        }
        this.m = (SelectionEditText) this.b.findViewById(R.id.common_edit_et);
        this.n = (EditInputNumView) this.b.findViewById(R.id.common_edit_num_tv);
        this.o = (TextView) this.b.findViewById(R.id.common_edit_cancel);
        this.p = (TextView) this.b.findViewById(R.id.common_edit_confirm);
        SelectionEditText selectionEditText = this.m;
        if (selectionEditText != null) {
            selectionEditText.setHint(r());
        }
        SelectionEditText selectionEditText2 = this.m;
        if (selectionEditText2 != null) {
            selectionEditText2.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.common.-$$Lambda$CommonEditDlgFragment$o1DvZSDkZncKa59rTzM1zC78Npg
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean a2;
                    a2 = CommonEditDlgFragment.a(view, motionEvent);
                    return a2;
                }
            });
        }
        TextWatcher textWatcher = new TextWatcher() { // from class: com.blued.community.ui.common.CommonEditDlgFragment$onInitView$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.e(s, "s");
                CommonEditDlgFragment.this.n();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.e(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.e(s, "s");
            }
        };
        this.q = textWatcher;
        SelectionEditText selectionEditText3 = this.m;
        if (selectionEditText3 != null) {
            selectionEditText3.addTextChangedListener(textWatcher);
        }
        EditInputNumView editInputNumView = this.n;
        if (editInputNumView != null) {
            editInputNumView.init(this.m, o());
        }
        TextView textView5 = this.o;
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.common.-$$Lambda$CommonEditDlgFragment$7fmuZsHrENlcG5Ra0TCJmUEak3w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonEditDlgFragment.a(CommonEditDlgFragment.this, view);
                }
            });
        }
        View view = this.b;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.common.-$$Lambda$CommonEditDlgFragment$888kboqUXh6vE1fQFdtSkuQCvxo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommonEditDlgFragment.b(CommonEditDlgFragment.this, view2);
                }
            });
        }
        TextView textView6 = this.p;
        if (textView6 != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.common.-$$Lambda$CommonEditDlgFragment$efGtYzFbn5T7PRjueyd1uaK5mUo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommonEditDlgFragment.c(CommonEditDlgFragment.this, view2);
                }
            });
        }
        String str = this.u;
        if (str == null) {
            return;
        }
        SelectionEditText k = k();
        if (k != null) {
            k.setText(str);
        }
        SelectionEditText k2 = k();
        if (k2 == null) {
            return;
        }
        k2.setSelection(str.length());
    }

    public final SelectionEditText k() {
        return this.m;
    }

    public final String l() {
        return this.s;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.c(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window == null) {
            return onCreateDialog;
        }
        window.setSoftInputMode(18);
        return onCreateDialog;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        a(new Runnable() { // from class: com.blued.community.ui.common.-$$Lambda$CommonEditDlgFragment$rALsAgb767rHNnJsaICYYDC2kqE
            @Override // java.lang.Runnable
            public final void run() {
                CommonEditDlgFragment.b(CommonEditDlgFragment.this);
            }
        }, 150L);
    }
}
