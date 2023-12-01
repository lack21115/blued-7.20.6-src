package com.soft.blued.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.common_contract.ISelectPhotoBarCallback;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/SelectPhotoBarView.class */
public class SelectPhotoBarView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private CheckBox f14823a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f14824c;
    private TextView d;
    private View e;
    private ISelectPhotoBarCallback f;

    public SelectPhotoBarView(Context context) {
        this(context, null);
    }

    public SelectPhotoBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectPhotoBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        a(context);
        this.f14823a = (CheckBox) findViewById(R.id.photo_burn_btn);
        this.b = (TextView) findViewById(R.id.photo_album_tv);
        this.f14824c = (TextView) findViewById(R.id.photo_send_tv);
        this.e = findViewById(R.id.photo_send_btn);
        this.d = (TextView) findViewById(R.id.photo_num_tv);
        String string = context.getString(R.string.msg_look_burn);
        String str = string;
        if (!TextUtils.isEmpty(FlashPhotoManager.a().b().flash_prompt)) {
            str = string + "\n" + FlashPhotoManager.a().b().flash_prompt;
        }
        this.f14823a.setText(str);
        this.e.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.f14823a.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.customview.SelectPhotoBarView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (DateTodayManager.f18714a.e()) {
                    AppMethods.d((int) R.string.date_today_flash_toast);
                    return true;
                }
                return false;
            }
        });
        this.f14823a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.customview.SelectPhotoBarView.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (SelectPhotoBarView.this.f14823a != null) {
                    SelectPhotoBarView.this.f.a(z);
                }
            }
        });
    }

    private void setBurnBtnEnable(boolean z) {
        CheckBox checkBox = this.f14823a;
        if (checkBox != null) {
            checkBox.setEnabled(z);
        }
    }

    private void setNumTv(int i) {
        TextView textView = this.d;
        if (textView != null) {
            if (i <= 0) {
                if (textView.getVisibility() == 0) {
                    this.d.setVisibility(8);
                    return;
                }
                return;
            }
            textView.setText(String.valueOf(i));
            if (this.d.getVisibility() == 8) {
                this.d.setVisibility(0);
            }
        }
    }

    private void setSendBtnEnable(boolean z) {
        TextView textView = this.f14824c;
        if (textView != null) {
            textView.setEnabled(z);
        }
        View view = this.e;
        if (view != null) {
            view.setEnabled(z);
        }
    }

    private void setSendBtnSelected(boolean z) {
        TextView textView = this.f14824c;
        if (textView != null) {
            textView.setSelected(z);
        }
        View view = this.e;
        if (view != null) {
            view.setEnabled(z);
        }
    }

    protected View a(Context context) {
        return View.inflate(context, R.layout.view_select_pic_bottom_bar, this);
    }

    public void a(int i) {
        setNumTv(i);
        if (i <= 0) {
            setBurnBtnEnable(false);
            setSendBtnEnable(false);
            return;
        }
        setBurnBtnEnable(true);
        setSendBtnEnable(true);
        setSendBtnSelected(true);
    }

    public boolean a() {
        return this.f14823a.isChecked();
    }

    public void b() {
        CheckBox checkBox = this.f14823a;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
    }

    public void c() {
        CheckBox checkBox = this.f14823a;
        if (checkBox != null) {
            checkBox.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.f != null) {
            int id = view.getId();
            if (id == 2131368848) {
                this.f.c();
            } else if (id != 2131368856) {
            } else {
                this.f.b();
            }
        }
    }

    public void setBurnBtnChecked(boolean z) {
        CheckBox checkBox = this.f14823a;
        if (checkBox == null || z == checkBox.isChecked()) {
            return;
        }
        this.f14823a.setChecked(z);
        this.f.a(z);
    }

    public void setBurnBtnText(String str) {
        if (this.f14823a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f14823a.setText(str);
    }

    public void setOperationCallback(ISelectPhotoBarCallback iSelectPhotoBarCallback) {
        this.f = iSelectPhotoBarCallback;
    }
}
