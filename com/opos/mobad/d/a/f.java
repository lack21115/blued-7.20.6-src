package com.opos.mobad.d.a;

import android.content.Context;
import android.widget.RemoteViews;
import com.anythink.expressad.foundation.h.i;
import com.heytap.msp.mobad.api.R;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f12275a;
    private Map<Integer, RemoteViews> b = new ConcurrentHashMap();

    public f(Context context) {
        this.f12275a = context;
    }

    public RemoteViews a(String str, String str2, int i, int i2, int i3) {
        int a2;
        Map<Integer, RemoteViews> map = this.b;
        RemoteViews remoteViews = map != null ? map.get(Integer.valueOf(i3)) : null;
        RemoteViews remoteViews2 = remoteViews;
        if (remoteViews == null) {
            remoteViews2 = new RemoteViews(this.f12275a.getPackageName(), com.opos.mobad.service.e.a(this.f12275a, "opos_mob_layout_download_manager", "layout"));
            this.b.put(Integer.valueOf(i3), remoteViews2);
        }
        remoteViews2.setImageViewResource(com.opos.mobad.service.e.a(this.f12275a, "dl_icon_iv", "id"), com.opos.mobad.service.e.a(this.f12275a, "opos_mob_drawable_download_icon", i.f5112c));
        remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_app_name_tv", "id"), str);
        remoteViews2.setCharSequence(com.opos.mobad.service.e.a(this.f12275a, "dl_delete_bt", "id"), "setText", this.f12275a.getResources().getString(R.string.download_delete_bt_txt));
        if (i != 102) {
            if (i == 103) {
                remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_process_tv", "id"), str2);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_tv", "id"), 0);
                remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_status_tv", "id"), this.f12275a.getResources().getString(R.string.download_status_pause_txt));
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_status_tv", "id"), 0);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id"), 8);
                remoteViews2.setCharSequence(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), "setText", this.f12275a.getResources().getString(R.string.download_continue_bt_txt));
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), 0);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_bar", "id"), 4);
                return remoteViews2;
            }
            if (i == 106) {
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_status_tv", "id"), 8);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_tv", "id"), 8);
                remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id"), this.f12275a.getResources().getString(R.string.download_status_fail_txt));
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id"), 0);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), 0);
                remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), this.f12275a.getResources().getString(R.string.download_retry_bt_txt));
            } else if (i == 105) {
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_status_tv", "id"), 8);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_tv", "id"), 8);
                remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id"), this.f12275a.getResources().getString(R.string.download_status_complete_txt));
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id"), 0);
                remoteViews2.setCharSequence(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), "setText", this.f12275a.getResources().getString(R.string.download_install_bt_txt));
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), 0);
            } else if (i != 107) {
                return remoteViews2;
            } else {
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_status_tv", "id"), 8);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_bar", "id"), 8);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_tv", "id"), 8);
                remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), 4);
                remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id"), this.f12275a.getResources().getString(R.string.download_status_waiting_txt));
                a2 = com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id");
            }
            remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_bar", "id"), 8);
            return remoteViews2;
        }
        remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_process_tv", "id"), str2);
        remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_process_tv", "id"), 0);
        remoteViews2.setTextViewText(com.opos.mobad.service.e.a(this.f12275a, "dl_status_tv", "id"), this.f12275a.getResources().getString(R.string.download_status_downloading_txt));
        remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_status_tv", "id"), 0);
        remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_fail_tv", "id"), 8);
        remoteViews2.setCharSequence(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), "setText", this.f12275a.getResources().getString(R.string.download_pause_bt_txt));
        remoteViews2.setViewVisibility(com.opos.mobad.service.e.a(this.f12275a, "dl_ctrl_bt", "id"), 0);
        remoteViews2.setProgressBar(com.opos.mobad.service.e.a(this.f12275a, "dl_process_bar", "id"), 100, i2, false);
        a2 = com.opos.mobad.service.e.a(this.f12275a, "dl_process_bar", "id");
        remoteViews2.setViewVisibility(a2, 0);
        return remoteViews2;
    }

    public void a() {
        Map<Integer, RemoteViews> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.b.clear();
    }

    public void a(int i) {
        Map<Integer, RemoteViews> map = this.b;
        if (map == null || map.size() <= 0 || !this.b.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.b.remove(Integer.valueOf(i));
    }
}
