package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.bytedance.applog.tracker.Tracker;

/* renamed from: com.amap.api.col.3sl.ep  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ep.class */
public final class ep extends eq implements View.OnClickListener {
    private OfflineMapManager a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private String h;

    public ep(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.a = offlineMapManager;
    }

    @Override // com.amap.api.col.p0003sl.eq
    protected final void a() {
        View a = ev.a(getContext(), 2130903041);
        this.b = a;
        setContentView(a);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3sl.ep.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                ep.this.dismiss();
            }
        });
        this.c = (TextView) this.b.findViewById(2131165191);
        TextView textView = (TextView) this.b.findViewById(2131165192);
        this.d = textView;
        textView.setText("暂停下载");
        this.e = (TextView) this.b.findViewById(2131165193);
        this.f = (TextView) this.b.findViewById(2131165194);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public final void a(int i, String str) {
        this.c.setText(str);
        if (i == 0) {
            this.d.setText("暂停下载");
            this.d.setVisibility(0);
            this.e.setText("取消下载");
        }
        if (i == 2) {
            this.d.setVisibility(8);
            this.e.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.d.setText("继续下载");
            this.d.setVisibility(0);
        } else if (i == 3) {
            this.d.setVisibility(0);
            this.d.setText("继续下载");
            this.e.setText("取消下载");
        } else if (i == 4) {
            this.e.setText("删除");
            this.d.setVisibility(8);
        }
        this.g = i;
        this.h = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        try {
            int id = view.getId();
            if (id != 2131165192) {
                if (id != 2131165193) {
                    if (id == 2131165194) {
                        dismiss();
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(this.h)) {
                    return;
                } else {
                    this.a.remove(this.h);
                    dismiss();
                    return;
                }
            }
            if (this.g == 0) {
                this.d.setText("继续下载");
                this.a.pauseByName(this.h);
            } else if (this.g == 3 || this.g == -1 || this.g == 101 || this.g == 102 || this.g == 103) {
                this.d.setText("暂停下载");
                this.a.downloadByCityName(this.h);
            }
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
