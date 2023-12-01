package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/MergePaths.class */
public class MergePaths implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4348a;
    private final MergePathsMode b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4349c;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/MergePaths$MergePathsMode.class */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f4348a = str;
        this.b = mergePathsMode;
        this.f4349c = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (lottieDrawable.a()) {
            return new MergePathsContent(this);
        }
        Logger.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String a() {
        return this.f4348a;
    }

    public MergePathsMode b() {
        return this.b;
    }

    public boolean c() {
        return this.f4349c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
