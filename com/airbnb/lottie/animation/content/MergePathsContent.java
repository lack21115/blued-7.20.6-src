package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/MergePathsContent.class */
public class MergePathsContent implements GreedyContent, PathContent {
    private final String d;
    private final MergePaths f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f4281a = new Path();
    private final Path b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f4282c = new Path();
    private final List<PathContent> e = new ArrayList();

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/MergePathsContent$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4283a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f4283a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4283a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4283a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4283a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4283a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.d = mergePaths.a();
        this.f = mergePaths;
    }

    private void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return;
            }
            this.f4282c.addPath(this.e.get(i2).e());
            i = i2 + 1;
        }
    }

    private void a(Path.Op op) {
        this.b.reset();
        this.f4281a.reset();
        int size = this.e.size();
        while (true) {
            int i = size - 1;
            if (i < 1) {
                break;
            }
            PathContent pathContent = this.e.get(i);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> c2 = contentGroup.c();
                int size2 = c2.size();
                while (true) {
                    int i2 = size2 - 1;
                    if (i2 >= 0) {
                        Path e = c2.get(i2).e();
                        e.transform(contentGroup.d());
                        this.b.addPath(e);
                        size2 = i2;
                    }
                }
            } else {
                this.b.addPath(pathContent.e());
            }
            size = i;
        }
        PathContent pathContent2 = this.e.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> c3 = contentGroup2.c();
            for (int i3 = 0; i3 < c3.size(); i3++) {
                Path e2 = c3.get(i3).e();
                e2.transform(contentGroup2.d());
                this.f4281a.addPath(e2);
            }
        } else {
            this.f4281a.set(pathContent2.e());
        }
        this.f4282c.op(this.f4281a, this.b, op);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return;
            }
            this.e.get(i2).a(list, list2);
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void a(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof PathContent) {
                this.e.add((PathContent) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path e() {
        this.f4282c.reset();
        if (this.f.c()) {
            return this.f4282c;
        }
        int i = AnonymousClass1.f4283a[this.f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            a(Path.Op.UNION);
        } else if (i == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            a(Path.Op.INTERSECT);
        } else if (i == 5) {
            a(Path.Op.XOR);
        }
        return this.f4282c;
    }
}
