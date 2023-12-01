package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.media.MediaFormat;
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

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/ModifyGroupProfileFragment.class */
public class ModifyGroupProfileFragment extends BaseFragment implements View.OnClickListener {
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f30875c;
    private TextView d;
    private Context e;
    private String f;

    /* renamed from: a  reason: collision with root package name */
    private String f30874a = ModifyGroupProfileFragment.class.getSimpleName();
    private TextWatcher g = new TextWatcher() { // from class: com.soft.blued.ui.group.ModifyGroupProfileFragment.1
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f30877c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                this.b = ModifyGroupProfileFragment.this.f30875c.getSelectionStart();
                this.f30877c = ModifyGroupProfileFragment.this.f30875c.getSelectionEnd();
                ModifyGroupProfileFragment.this.f30875c.removeTextChangedListener(ModifyGroupProfileFragment.this.g);
                while (editable.length() > 256) {
                    editable.delete(this.b - 1, this.f30877c);
                    this.b--;
                    this.f30877c--;
                }
                int length = editable.length();
                ModifyGroupProfileFragment.this.d.setText(length + " ");
                ModifyGroupProfileFragment.this.f30875c.setSelection(this.b);
                ModifyGroupProfileFragment.this.f30875c.addTextChangedListener(ModifyGroupProfileFragment.this.g);
            } catch (Exception e) {
                e.printStackTrace();
                ModifyGroupProfileFragment.this.d.setText("");
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
        String string = getArguments().getString(MediaFormat.KEY_PROFILE);
        this.f = string;
        this.f30875c.setText(string);
        EditText editText = this.f30875c;
        editText.setSelection(editText.length());
        TextView textView = this.d;
        textView.setText(this.f30875c.length() + " ");
    }

    private void b() {
        this.d = (TextView) this.b.findViewById(R.id.tv_word_count);
        EditText editText = (EditText) this.b.findViewById(R.id.et_group_profile);
        this.f30875c = editText;
        editText.addTextChangedListener(this.g);
        EditText editText2 = this.f30875c;
        editText2.setSelection(editText2.length());
        getActivity().getWindow().setSoftInputMode(21);
    }

    private void c() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.setCenterText(getString(R.string.group_intro_modification));
        commonTopTitleNoTrans.setRightText(R.string.save);
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.setRightClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            if (this.f30875c.length() <= 15) {
                AppMethods.a((CharSequence) getResources().getString(R.string.modify_group_desc_fail));
                return;
            }
            Intent intent = new Intent();
            String obj = this.f30875c.getText().toString();
            this.f = obj;
            intent.putExtra(MediaFormat.KEY_PROFILE, obj);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.e = getActivity();
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.fragment_modify_group_profile, viewGroup, false);
        b();
        c();
        a();
        return this.b;
    }
}
