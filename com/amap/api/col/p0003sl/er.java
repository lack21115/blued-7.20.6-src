package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* renamed from: com.amap.api.col.3sl.er  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/er.class */
public final class er implements View.OnClickListener {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f4936c;
    private TextView d;
    private ImageView e;
    private TextView f;
    private OfflineMapManager g;
    private OfflineMapCity h;
    private View k;
    private DownloadProgressView l;

    /* renamed from: a  reason: collision with root package name */
    private int f4935a = 0;
    private boolean i = false;
    private Handler j = new Handler() { // from class: com.amap.api.col.3sl.er.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                er.this.a(message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public er(Context context, OfflineMapManager offlineMapManager) {
        this.b = context;
        b();
        this.g = offlineMapManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) throws Exception {
        if (this.f4935a != 2 || i2 <= 3 || i2 >= 100) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setProgress(i2);
        }
        if (i == -1) {
            f();
        } else if (i == 0) {
            if (this.f4935a != 1) {
                j();
                return;
            }
            this.e.setVisibility(8);
            this.f.setText("下载中");
            this.f.setTextColor(Color.parseColor("#4287ff"));
        } else if (i == 1) {
            i();
        } else if (i == 2) {
            e();
        } else if (i == 3) {
            g();
        } else if (i == 4) {
            h();
        } else if (i == 6) {
            c();
        } else if (i == 7) {
            d();
        } else {
            switch (i) {
                case 101:
                case 102:
                case 103:
                    f();
                    return;
                default:
                    return;
            }
        }
    }

    private void b() {
        View a2 = ev.a(this.b, (int) R.array.age_array_key_more);
        this.k = a2;
        this.l = (DownloadProgressView) a2.findViewById(2131165200);
        this.f4936c = (TextView) this.k.findViewById(2131165195);
        this.d = (TextView) this.k.findViewById(2131165199);
        this.e = (ImageView) this.k.findViewById(2131165198);
        this.f = (TextView) this.k.findViewById(2131165197);
        this.e.setOnClickListener(this);
    }

    private void b(int i, int i2) {
        OfflineMapCity offlineMapCity = this.h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i);
            this.h.setCompleteCode(i2);
        }
        Message message = new Message();
        message.arg1 = i;
        message.arg2 = i2;
        this.j.sendMessage(message);
    }

    private void c() {
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setImageResource(2130837506);
    }

    private void d() {
        this.f.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setImageResource(2130837506);
        this.f.setText("已下载-有更新");
    }

    private void e() {
        if (this.f4935a == 1) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText("等待中");
            this.f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#4287ff"));
        this.f.setText("等待中");
    }

    private void f() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(-65536);
        this.f.setText("下载出现异常");
    }

    private void g() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(Color.GRAY);
        this.f.setText("暂停");
    }

    private void h() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setText("已下载");
        this.f.setTextColor(Color.parseColor("#898989"));
    }

    private void i() {
        if (this.f4935a == 1) {
            return;
        }
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setText("解压中");
        this.f.setTextColor(Color.parseColor("#898989"));
    }

    private void j() {
        if (this.h == null) {
            return;
        }
        this.f.setVisibility(0);
        this.f.setText("下载中");
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#4287ff"));
    }

    private void k() {
        synchronized (this) {
            this.g.pause();
            this.g.restart();
        }
    }

    private boolean l() {
        synchronized (this) {
            try {
                this.g.downloadByCityName(this.h.getCity());
            } catch (AMapException e) {
                e.printStackTrace();
                Toast.makeText(this.b, e.getErrorMessage(), 0).show();
                return false;
            }
        }
        return true;
    }

    public final View a() {
        return this.k;
    }

    public final void a(int i) {
        this.f4935a = i;
    }

    public final void a(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.h = offlineMapCity;
            this.f4936c.setText(offlineMapCity.getCity());
            double size = ((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d;
            TextView textView = this.d;
            textView.setText(String.valueOf(size) + " M");
            b(this.h.getState(), this.h.getcompleteCode());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        try {
            if (!dw.d(this.b)) {
                Toast.makeText(this.b, "无网络连接", 0).show();
            } else if (this.h != null) {
                int state = this.h.getState();
                this.h.getcompleteCode();
                if (state == 0) {
                    k();
                    g();
                } else if (state == 1 || state == 4) {
                } else {
                    if (l()) {
                        e();
                    } else {
                        f();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
