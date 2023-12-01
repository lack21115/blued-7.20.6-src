package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/CompoundTrimPathContent.class */
public class CompoundTrimPathContent {

    /* renamed from: a  reason: collision with root package name */
    private List<TrimPathContent> f4271a = new ArrayList();

    public void a(Path path) {
        int size = this.f4271a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            Utils.a(path, this.f4271a.get(i));
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TrimPathContent trimPathContent) {
        this.f4271a.add(trimPathContent);
    }
}
