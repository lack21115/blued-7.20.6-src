package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
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
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/ModifyGroupNameFragment.class */
public class ModifyGroupNameFragment extends BaseFragment implements View.OnClickListener {
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f17181c;
    private TextView d;
    private Context e;
    private String f;

    /* renamed from: a  reason: collision with root package name */
    private String f17180a = ModifyGroupNameFragment.class.getSimpleName();
    private TextWatcher g = new TextWatcher() { // from class: com.soft.blued.ui.group.ModifyGroupNameFragment.1
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f17183c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                this.b = ModifyGroupNameFragment.this.f17181c.getSelectionStart();
                this.f17183c = ModifyGroupNameFragment.this.f17181c.getSelectionEnd();
                ModifyGroupNameFragment.this.f17181c.removeTextChangedListener(ModifyGroupNameFragment.this.g);
                while (editable.length() > 15) {
                    editable.delete(this.b - 1, this.f17183c);
                    this.b--;
                    this.f17183c--;
                }
                int length = editable.length();
                ModifyGroupNameFragment.this.d.setText(length + " ");
                ModifyGroupNameFragment.this.f17181c.setSelection(this.b);
                ModifyGroupNameFragment.this.f17181c.addTextChangedListener(ModifyGroupNameFragment.this.g);
            } catch (Exception e) {
                e.printStackTrace();
                ModifyGroupNameFragment.this.d.setText("");
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
        String string = getArguments().getString("name");
        this.f = string;
        this.f17181c.setText(string);
        EditText editText = this.f17181c;
        editText.setSelection(editText.length());
        TextView textView = this.d;
        textView.setText(this.f17181c.length() + " ");
    }

    private void b() {
        this.d = (TextView) this.b.findViewById(R.id.tv_word_count);
        EditText editText = (EditText) this.b.findViewById(R.id.et_group_name);
        this.f17181c = editText;
        editText.addTextChangedListener(this.g);
        EditText editText2 = this.f17181c;
        editText2.setSelection(editText2.length());
    }

    private void c() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setCenterText(getString(R.string.group_name_modification));
        findViewById.setRightText((int) R.string.save);
        findViewById.setLeftClickListener(this);
        findViewById.setRightClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            if (this.f17181c.length() < 2) {
                AppMethods.a(getResources().getString(R.string.modify_group_name_fail));
                return;
            }
            Intent intent = new Intent();
            String obj = this.f17181c.getText().toString();
            this.f = obj;
            intent.putExtra("name", obj);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        this.e = getActivity();
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.fragment_modify_group_name, viewGroup, false);
        b();
        c();
        a();
        return this.b;
    }
}
