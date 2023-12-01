package com.blued.android.module.player.media.manager;

import android.app.Activity;
import android.content.Context;
import android.view.ViewParent;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.view.AbBaseVideoView;
import com.blued.android.module.player.media.view.PLTextureVideoViewINT;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.player.txplayer.view.BLTxPlayView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/manager/BLVideoViewCache.class */
public class BLVideoViewCache {

    /* renamed from: a  reason: collision with root package name */
    private Activity f15650a;
    private LinkedHashMap<String, AbBaseVideoView> b = new LinkedHashMap<>(8, 0.75f, true);

    private AbBaseVideoView a(Context context, String str) {
        Log.b("PLVideoViewCache", "getVideoView, url = " + str);
        LinkedHashMap<String, AbBaseVideoView> linkedHashMap = this.b;
        AbBaseVideoView abBaseVideoView = linkedHashMap.get(str);
        if (abBaseVideoView != null) {
            return abBaseVideoView;
        }
        if (linkedHashMap.size() < 3) {
            BLTxPlayView bLTxPlayView = new BLTxPlayView(context);
            linkedHashMap.put(str, bLTxPlayView);
            return bLTxPlayView;
        }
        Iterator<Map.Entry<String, AbBaseVideoView>> it = linkedHashMap.entrySet().iterator();
        AbBaseVideoView abBaseVideoView2 = abBaseVideoView;
        if (it.hasNext()) {
            abBaseVideoView2 = linkedHashMap.get(it.next().getKey());
        }
        return abBaseVideoView2;
    }

    private void a(AbBaseVideoView abBaseVideoView) {
        if (abBaseVideoView == null) {
            return;
        }
        abBaseVideoView.c();
        ViewParent parent = abBaseVideoView.getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (viewParent == null) {
                return;
            }
            if (viewParent instanceof PLVideoPageView) {
                PLVideoPageView pLVideoPageView = (PLVideoPageView) viewParent;
                pLVideoPageView.h();
                Log.c("PLVideoViewCache", "PLVideoPageView: it.remove() " + pLVideoPageView);
            } else if (viewParent instanceof PLTextureVideoViewINT) {
                ((PLTextureVideoViewINT) viewParent).h();
                Log.c("PLVideoViewCache", "PLTextureVideoViewINT: it.remove()");
            }
            parent = viewParent.getParent();
        }
    }

    private String b(String str) {
        String str2 = str;
        if (this.f15650a != null) {
            str2 = this.f15650a.toString() + str;
        }
        return str2;
    }

    public AbBaseVideoView a(String str) {
        String b = b(str);
        Log.b("PLVideoViewCache", "PLVideoPageView, getViewByKey url " + b);
        return this.b.get(b);
    }

    public AbBaseVideoView a(String str, Context context) {
        String str2 = str;
        if (this.f15650a != null) {
            str2 = this.f15650a.toString() + str;
        }
        return a(context, str2);
    }

    public void a() {
        Log.c("PLVideoViewCache", "clearViewCacheByActivity: activity = " + this.f15650a);
        Iterator<Map.Entry<String, AbBaseVideoView>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, AbBaseVideoView> next = it.next();
            AbBaseVideoView value = next.getValue();
            Log.b("PLVideoViewCache", "clearViewCacheByActivity: url " + next.getKey());
            if (next.getKey().contains(this.f15650a.toString())) {
                a(value);
                it.remove();
            }
        }
    }

    public void a(Activity activity) {
        Log.c("PLVideoViewCache", "setActivity: " + activity);
        this.f15650a = activity;
        BLVideoViewLifeFragment.a(this, activity);
    }

    public void a(String str, AbBaseVideoView abBaseVideoView) {
        String b = b(str);
        if (this.b.containsValue(abBaseVideoView)) {
            for (Map.Entry<String, AbBaseVideoView> entry : this.b.entrySet()) {
                if (entry.getValue().equals(abBaseVideoView)) {
                    this.b.remove(entry.getKey());
                    this.b.put(b, abBaseVideoView);
                    return;
                }
            }
        }
    }
}
