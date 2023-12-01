package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYCPGuideView.class */
public class YYCPGuideView extends LinearLayout {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;

    public YYCPGuideView(Context context) {
        super(context);
        a();
    }

    public YYCPGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYCPGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private String a(int i) {
        return getResources().getString(i);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_cp_guide, (ViewGroup) this, true);
        this.a = (TextView) findViewById(R.id.tv_blind_introduction);
        this.b = (TextView) findViewById(R.id.tv_blind_heart);
        this.c = (TextView) findViewById(R.id.tv_blind_publish);
        this.d = (TextView) findViewById(R.id.tv_blind_result);
        this.e = (TextView) findViewById(R.id.tv_blind_bulletin);
        this.f = (TextView) findViewById(R.id.tv_mask_info);
    }

    private void b() {
        this.a.setText(a(YYRoomInfoManager.e().y() ? R.string.blind_introduction_host : R.string.blind_introduction_other));
        this.b.setText(a(YYRoomInfoManager.e().y() ? R.string.blind_heart_host : R.string.blind_heart_other));
        this.c.setText(a(YYRoomInfoManager.e().y() ? R.string.blind_publish_host : R.string.blind_publish_other));
        this.d.setText(a(YYRoomInfoManager.e().y() ? R.string.blind_result_host : R.string.blind_result_other));
        this.e.setText(YYRoomInfoManager.e().y() ? R.string.blind_bulletin_host : R.string.blind_bulletin_other);
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().mMaskedVeiledRoominfo == null) {
            return;
        }
        this.f.setText(String.format(a(R.string.blind_introduce_mask), YYRoomInfoManager.e().b().mMaskedVeiledRoominfo.getOpen_beans()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }
}
