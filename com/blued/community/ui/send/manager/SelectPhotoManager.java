package com.blued.community.ui.send.manager;

import com.blued.community.ui.send.model.ChildImageInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/manager/SelectPhotoManager.class */
public class SelectPhotoManager {

    /* renamed from: a  reason: collision with root package name */
    private static SelectPhotoManager f20072a = new SelectPhotoManager();
    private List<ChildImageInfo> b = new ArrayList();

    private SelectPhotoManager() {
    }

    public static SelectPhotoManager a() {
        return f20072a;
    }

    public ChildImageInfo a(int i) {
        return (i < 0 || i >= this.b.size()) ? new ChildImageInfo() : this.b.get(i);
    }

    public void a(ChildImageInfo childImageInfo) {
        this.b.add(childImageInfo);
    }

    public void a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            if (str.equals(this.b.get(i2).mImagePath)) {
                this.b.remove(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    public int b() {
        return this.b.size();
    }

    public void b(ChildImageInfo childImageInfo) {
        if (this.b.remove(childImageInfo)) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            if (childImageInfo.mImagePath.equals(this.b.get(i2).mImagePath)) {
                this.b.remove(i2);
                return;
            }
            i = i2 + 1;
        }
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
