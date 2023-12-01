package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYReportView.class */
public class YYReportView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    BaseYYStudioFragment f18432a;
    EditText b;

    /* renamed from: c  reason: collision with root package name */
    ShapeTextView f18433c;
    public PopYyDialog d;
    private YYReportModel e;
    private int f;
    private boolean g;

    public YYReportView(Context context) {
        super(context);
        a();
    }

    public YYReportView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYReportView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_report_layout, (ViewGroup) this, true);
        this.f18433c = (ShapeTextView) findViewById(R.id.btn_report);
        EditText editText = (EditText) findViewById(R.id.et_report_view);
        this.b = editText;
        editText.setFilters(new InputFilter[]{new EnglishCharFilter(280)});
        this.f18433c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYReportView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYReportView.this.g) {
                    return;
                }
                YYReportView.this.g = true;
                YYReportView.this.a(YYReportView.this.b.getText().toString().trim());
            }
        });
    }

    private void a(YYRoomModel yYRoomModel) {
        List<YYSeatMemberModel> list = yYRoomModel.mics;
        if (list == null) {
            return;
        }
        if (this.e.members == null) {
            this.e.members = new ArrayList();
        }
        this.e.members.clear();
        for (YYSeatMemberModel yYSeatMemberModel : list) {
            if (!TextUtils.isEmpty(yYSeatMemberModel.getUid()) && !TextUtils.equals("0", yYSeatMemberModel.getUid())) {
                this.e.members.add(yYSeatMemberModel.getUid());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || this.e == null) {
            return;
        }
        a(b);
        this.e.room_id = b.room_id;
        this.e.anchor = b.uid;
        this.e.reason = str;
        Logger.e("onMessge", "report model: " + this.e.toString());
        int i = this.f;
        if (i == 1) {
            c();
        } else if (i != 2) {
            b();
        } else {
            d();
        }
    }

    private void b() {
        YYRoomHttpUtils.a(this.e.room_id, this.e.anchor, this.e.uid, this.e.reason, this.e.members, getCallback(), this.f18432a.getFragmentActive());
    }

    private void c() {
        YYRoomHttpUtils.a(this.e.room_id, this.e.anchor, this.e.reason, this.e.members, getCallback(), this.f18432a.getFragmentActive());
    }

    private void d() {
        YYRoomHttpUtils.a(this.e.room_id, this.e.anchor, this.e.uid, this.e.reason, this.e.members, this.e.msg, getCallback(), this.f18432a.getFragmentActive());
    }

    private BluedUIHttpResponse getCallback() {
        return new BluedUIHttpResponse(this.f18432a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYReportView.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                YYReportView.this.g = false;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                ToastUtils.a("平台将尽快处理你的反馈", 0);
                YYReportView.this.g = false;
                if (YYReportView.this.d != null) {
                    YYReportView.this.d.dismissAllowingStateLoss();
                }
            }
        };
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, YYReportModel yYReportModel) {
        this.f18432a = baseYYStudioFragment;
        this.e = yYReportModel;
        this.f = yYReportModel.reportType;
        baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYReportView.2
            @Override // java.lang.Runnable
            public void run() {
                YYReportView.this.b.setFocusableInTouchMode(true);
                YYReportView.this.b.setFocusable(true);
                YYReportView.this.b.requestFocus();
                ((InputMethodManager) YYReportView.this.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(YYReportView.this.b, 0);
            }
        }, 300L);
    }
}
