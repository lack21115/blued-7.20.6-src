package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupJoinVerifyFragment.class */
public class GroupJoinVerifyFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private View f17116c;
    private EditText d;
    private String e;
    private String f;
    private Context g;
    private Dialog h;
    private TextView i;
    private String b = GroupJoinVerifyFragment.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f17115a = new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.GroupJoinVerifyFragment.1
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupJoinVerifyFragment.this.h);
        }

        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupJoinVerifyFragment.this.h);
        }

        public void onUIUpdate(BluedEntity bluedEntity) {
            try {
                AppMethods.d((int) R.string.group_apply_feedback);
                GroupJoinVerifyFragment.this.getActivity().finish();
            } catch (Exception e) {
                AppMethods.d(2131887272);
                e.printStackTrace();
            }
        }
    };
    private TextWatcher j = new TextWatcher() { // from class: com.soft.blued.ui.group.GroupJoinVerifyFragment.2
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f17119c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                this.b = GroupJoinVerifyFragment.this.d.getSelectionStart();
                this.f17119c = GroupJoinVerifyFragment.this.d.getSelectionEnd();
                GroupJoinVerifyFragment.this.d.removeTextChangedListener(GroupJoinVerifyFragment.this.j);
                while (editable.length() > 90) {
                    editable.delete(this.b - 1, this.f17119c);
                    this.b--;
                    this.f17119c--;
                }
                int length = editable.length();
                GroupJoinVerifyFragment.this.i.setText(length + " ");
                GroupJoinVerifyFragment.this.d.setSelection(this.b);
                GroupJoinVerifyFragment.this.d.addTextChangedListener(GroupJoinVerifyFragment.this.j);
            } catch (Exception e) {
                e.printStackTrace();
                GroupJoinVerifyFragment.this.i.setText("");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    private void a() {
        CommonTopTitleNoTrans findViewById = this.f17116c.findViewById(R.id.top_title);
        findViewById.setCenterText(getString(R.string.group_join_validation));
        findViewById.setRightText(getString(R.string.send));
        findViewById.setLeftClickListener(this);
        findViewById.setRightClickListener(this);
    }

    private void b() {
        this.f = getArguments().getString("gid");
    }

    private void c() {
        this.h = DialogUtils.a(this.g);
        this.d = (EditText) this.f17116c.findViewById(R.id.et_validation_info);
        TextView textView = (TextView) this.f17116c.findViewById(R.id.tv_word_count);
        this.i = textView;
        textView.setText(((Object) getResources().getText(R.string.group_name_count)) + " ");
        this.d.addTextChangedListener(this.j);
        EditText editText = this.d;
        editText.setSelection(editText.length());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            String obj = this.d.getText().toString();
            this.e = obj;
            GroupHttpUtils.b(this.g, this.f17115a, this.f, obj, getFragmentActive());
        }
    }

    public void onCreate(Bundle bundle) {
        this.g = getActivity();
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(21);
        this.f17116c = layoutInflater.inflate(R.layout.fragment_group_join_verify, viewGroup, false);
        c();
        a();
        b();
        return this.f17116c;
    }
}
