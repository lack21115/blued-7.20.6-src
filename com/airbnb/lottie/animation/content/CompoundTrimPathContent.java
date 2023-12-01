package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/CompoundTrimPathContent.class */
public class CompoundTrimPathContent {
    private List<TrimPathContent> a = new ArrayList();

    public void a(Path path) {
        int size = this.a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            Utils.a(path, this.a.get(i));
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TrimPathContent trimPathContent) {
        this.a.add(trimPathContent);
    }
}
