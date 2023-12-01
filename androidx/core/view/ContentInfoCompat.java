package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import com.alipay.sdk.util.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat.class */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;

    /* renamed from: a  reason: collision with root package name */
    private final Compat f2618a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$Api31Impl.class */
    static final class Api31Impl {
        private Api31Impl() {
        }

        public static Pair<ContentInfo, ContentInfo> partition(ContentInfo contentInfo, final Predicate<ClipData.Item> predicate) {
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() != 1) {
                Objects.requireNonNull(predicate);
                Pair<ClipData, ClipData> a2 = ContentInfoCompat.a(clip, new androidx.core.util.Predicate() { // from class: androidx.core.view.-$$Lambda$XrfWLNshFjqvbbSRgsJvpJ24Dt4
                    @Override // androidx.core.util.Predicate
                    public final boolean test(Object obj) {
                        return predicate.test((ClipData.Item) obj);
                    }
                });
                return a2.first == null ? Pair.create(null, contentInfo) : a2.second == null ? Pair.create(contentInfo, null) : Pair.create(new ContentInfo.Builder(contentInfo).setClip(a2.first).build(), new ContentInfo.Builder(contentInfo).setClip(a2.second).build());
            }
            boolean test = predicate.test(clip.getItemAt(0));
            ContentInfo contentInfo2 = test ? contentInfo : null;
            if (test) {
                contentInfo = null;
            }
            return Pair.create(contentInfo2, contentInfo);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final BuilderCompat f2619a;

        public Builder(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f2619a = new BuilderCompat31Impl(clipData, i);
            } else {
                this.f2619a = new BuilderCompatImpl(clipData, i);
            }
        }

        public Builder(ContentInfoCompat contentInfoCompat) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f2619a = new BuilderCompat31Impl(contentInfoCompat);
            } else {
                this.f2619a = new BuilderCompatImpl(contentInfoCompat);
            }
        }

        public ContentInfoCompat build() {
            return this.f2619a.build();
        }

        public Builder setClip(ClipData clipData) {
            this.f2619a.setClip(clipData);
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f2619a.setExtras(bundle);
            return this;
        }

        public Builder setFlags(int i) {
            this.f2619a.setFlags(i);
            return this;
        }

        public Builder setLinkUri(Uri uri) {
            this.f2619a.setLinkUri(uri);
            return this;
        }

        public Builder setSource(int i) {
            this.f2619a.setSource(i);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$BuilderCompat.class */
    public interface BuilderCompat {
        ContentInfoCompat build();

        void setClip(ClipData clipData);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setLinkUri(Uri uri);

        void setSource(int i);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$BuilderCompat31Impl.class */
    static final class BuilderCompat31Impl implements BuilderCompat {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f2620a;

        BuilderCompat31Impl(ClipData clipData, int i) {
            this.f2620a = new ContentInfo.Builder(clipData, i);
        }

        BuilderCompat31Impl(ContentInfoCompat contentInfoCompat) {
            this.f2620a = new ContentInfo.Builder(contentInfoCompat.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f2620a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData clipData) {
            this.f2620a.setClip(clipData);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.f2620a.setExtras(bundle);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.f2620a.setFlags(i);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            this.f2620a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int i) {
            this.f2620a.setSource(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$BuilderCompatImpl.class */
    static final class BuilderCompatImpl implements BuilderCompat {

        /* renamed from: a  reason: collision with root package name */
        ClipData f2621a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f2622c;
        Uri d;
        Bundle e;

        BuilderCompatImpl(ClipData clipData, int i) {
            this.f2621a = clipData;
            this.b = i;
        }

        BuilderCompatImpl(ContentInfoCompat contentInfoCompat) {
            this.f2621a = contentInfoCompat.getClip();
            this.b = contentInfoCompat.getSource();
            this.f2622c = contentInfoCompat.getFlags();
            this.d = contentInfoCompat.getLinkUri();
            this.e = contentInfoCompat.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData clipData) {
            this.f2621a = clipData;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.e = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.f2622c = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            this.d = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int i) {
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$Compat.class */
    public interface Compat {
        ClipData getClip();

        Bundle getExtras();

        int getFlags();

        Uri getLinkUri();

        int getSource();

        ContentInfo getWrapped();
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$Compat31Impl.class */
    static final class Compat31Impl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f2623a;

        Compat31Impl(ContentInfo contentInfo) {
            this.f2623a = (ContentInfo) Preconditions.checkNotNull(contentInfo);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.f2623a.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.f2623a.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.f2623a.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.f2623a.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.f2623a.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return this.f2623a;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f2623a + i.d;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$CompatImpl.class */
    static final class CompatImpl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f2624a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2625c;
        private final Uri d;
        private final Bundle e;

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.f2624a = (ClipData) Preconditions.checkNotNull(builderCompatImpl.f2621a);
            this.b = Preconditions.checkArgumentInRange(builderCompatImpl.b, 0, 5, "source");
            this.f2625c = Preconditions.checkFlagsArgument(builderCompatImpl.f2622c, 1);
            this.d = builderCompatImpl.d;
            this.e = builderCompatImpl.e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.f2624a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.f2625c;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.d;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.b;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f2624a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.a(this.b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.b(this.f2625c));
            if (this.d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.e == null ? "" : ", hasExtras");
            sb.append(i.d);
            return sb.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$Flags.class */
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$Source.class */
    public @interface Source {
    }

    ContentInfoCompat(Compat compat) {
        this.f2618a = compat;
    }

    static ClipData a(ClipDescription clipDescription, List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return clipData;
            }
            clipData.addItem(list.get(i2));
            i = i2 + 1;
        }
    }

    static Pair<ClipData, ClipData> a(ClipData clipData, androidx.core.util.Predicate<ClipData.Item> predicate) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i = 0; i < clipData.getItemCount(); i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (predicate.test(itemAt)) {
                ArrayList arrayList3 = arrayList;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList3.add(itemAt);
                arrayList = arrayList3;
            } else {
                ArrayList arrayList4 = arrayList2;
                if (arrayList2 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList4.add(itemAt);
                arrayList2 = arrayList4;
            }
        }
        return arrayList == null ? Pair.create(null, clipData) : arrayList2 == null ? Pair.create(clipData, null) : Pair.create(a(clipData.getDescription(), arrayList), a(clipData.getDescription(), arrayList2));
    }

    static String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    static String b(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    public static Pair<ContentInfo, ContentInfo> partition(ContentInfo contentInfo, Predicate<ClipData.Item> predicate) {
        return Api31Impl.partition(contentInfo, predicate);
    }

    public static ContentInfoCompat toContentInfoCompat(ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    public ClipData getClip() {
        return this.f2618a.getClip();
    }

    public Bundle getExtras() {
        return this.f2618a.getExtras();
    }

    public int getFlags() {
        return this.f2618a.getFlags();
    }

    public Uri getLinkUri() {
        return this.f2618a.getLinkUri();
    }

    public int getSource() {
        return this.f2618a.getSource();
    }

    public Pair<ContentInfoCompat, ContentInfoCompat> partition(androidx.core.util.Predicate<ClipData.Item> predicate) {
        ClipData clip = this.f2618a.getClip();
        ContentInfoCompat contentInfoCompat = null;
        if (clip.getItemCount() != 1) {
            Pair<ClipData, ClipData> a2 = a(clip, predicate);
            return a2.first == null ? Pair.create(null, this) : a2.second == null ? Pair.create(this, null) : Pair.create(new Builder(this).setClip(a2.first).build(), new Builder(this).setClip(a2.second).build());
        }
        boolean test = predicate.test(clip.getItemAt(0));
        ContentInfoCompat contentInfoCompat2 = test ? this : null;
        if (!test) {
            contentInfoCompat = this;
        }
        return Pair.create(contentInfoCompat2, contentInfoCompat);
    }

    public ContentInfo toContentInfo() {
        return this.f2618a.getWrapped();
    }

    public String toString() {
        return this.f2618a.toString();
    }
}
