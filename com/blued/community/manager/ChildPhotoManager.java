package com.blued.community.manager;

import com.blued.community.ui.send.model.ChildImageInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/ChildPhotoManager.class */
public class ChildPhotoManager {

    /* renamed from: a  reason: collision with root package name */
    private static ChildPhotoManager f19081a = new ChildPhotoManager();
    private List<ChildImageInfo> b = new ArrayList();

    private ChildPhotoManager() {
    }

    public static ChildPhotoManager a() {
        return f19081a;
    }

    public ChildImageInfo a(int i) {
        try {
            return this.b.get(i);
        } catch (Exception e) {
            return new ChildImageInfo();
        }
    }

    public void a(int i, ChildImageInfo childImageInfo) {
        this.b.add(i, childImageInfo);
    }

    public void a(List<ChildImageInfo> list) {
        if (list == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
    }

    public int b() {
        return this.b.size();
    }

    public List<ChildImageInfo> c() {
        return this.b;
    }

    public void d() {
        if (this.b.size() > 0) {
            this.b.clear();
        }
    }
}
