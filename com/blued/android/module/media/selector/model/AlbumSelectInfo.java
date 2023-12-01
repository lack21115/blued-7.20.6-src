package com.blued.android.module.media.selector.model;

import android.text.TextUtils;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/AlbumSelectInfo.class */
public class AlbumSelectInfo implements Serializable {
    private List<MediaInfo> a = new ArrayList();
    private int b;

    public int a(String str) {
        List<MediaInfo> list = this.a;
        if (list != null) {
            Iterator<MediaInfo> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().imagePath, str)) {
                    it.remove();
                }
            }
            return this.a.size();
        }
        return 0;
    }

    public void a() {
        b();
        this.b = 0;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(AlbumSelectInfo albumSelectInfo) {
        if (albumSelectInfo != null) {
            this.b = albumSelectInfo.b;
            this.a.addAll(albumSelectInfo.a);
        }
    }

    public void a(List<MediaInfo> list) {
        this.a.clear();
        this.a.addAll(list);
    }

    public boolean a(MediaInfo mediaInfo) {
        List<MediaInfo> list = this.a;
        return list != null && list.contains(mediaInfo);
    }

    public int b(MediaInfo mediaInfo) {
        List<MediaInfo> list;
        if (a(mediaInfo) || (list = this.a) == null) {
            return 0;
        }
        list.add(mediaInfo);
        return this.a.size();
    }

    public void b() {
        List<MediaInfo> list = this.a;
        if (list != null) {
            list.clear();
        }
    }

    public List<MediaInfo> c() {
        return this.a;
    }

    public int d() {
        List<MediaInfo> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int e() {
        return this.b;
    }
}
