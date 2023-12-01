package com.blued.android.module.media.selector.model;

import android.text.TextUtils;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/AlbumSelectInfo.class */
public class AlbumSelectInfo implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private List<MediaInfo> f15565a = new ArrayList();
    private int b;

    public int a(String str) {
        List<MediaInfo> list = this.f15565a;
        if (list != null) {
            Iterator<MediaInfo> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().imagePath, str)) {
                    it.remove();
                }
            }
            return this.f15565a.size();
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
            this.f15565a.addAll(albumSelectInfo.f15565a);
        }
    }

    public void a(List<MediaInfo> list) {
        this.f15565a.clear();
        this.f15565a.addAll(list);
    }

    public boolean a(MediaInfo mediaInfo) {
        List<MediaInfo> list = this.f15565a;
        return list != null && list.contains(mediaInfo);
    }

    public int b(MediaInfo mediaInfo) {
        List<MediaInfo> list;
        if (a(mediaInfo) || (list = this.f15565a) == null) {
            return 0;
        }
        list.add(mediaInfo);
        return this.f15565a.size();
    }

    public void b() {
        List<MediaInfo> list = this.f15565a;
        if (list != null) {
            list.clear();
        }
    }

    public List<MediaInfo> c() {
        return this.f15565a;
    }

    public int d() {
        List<MediaInfo> list = this.f15565a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int e() {
        return this.b;
    }
}
