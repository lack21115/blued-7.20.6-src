package com.tencent.cloud.huiyansdkface.facelight.ui.widget.a;

import android.graphics.Path;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f35778a = 0;
    private Path b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private int f35779c = 0;
    private float[] d = new float[6];

    public void a(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("path 不能为 null");
        }
        this.b = path;
        path.rewind();
    }
}
