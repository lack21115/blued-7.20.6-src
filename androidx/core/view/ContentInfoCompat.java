package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
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
    private final Compat f2570a;

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
        private final BuilderCompat f2571a;

        public Builder(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f2571a = new BuilderCompat31Impl(clipData, i);
            } else {
                this.f2571a = new BuilderCompatImpl(clipData, i);
            }
        }

        public Builder(ContentInfoCompat contentInfoCompat) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f2571a = new BuilderCompat31Impl(contentInfoCompat);
            } else {
                this.f2571a = new BuilderCompatImpl(contentInfoCompat);
            }
        }

        public ContentInfoCompat build() {
            return this.f2571a.build();
        }

        public Builder setClip(ClipData clipData) {
            this.f2571a.setClip(clipData);
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f2571a.setExtras(bundle);
            return this;
        }

        public Builder setFlags(int i) {
            this.f2571a.setFlags(i);
            return this;
        }

        public Builder setLinkUri(Uri uri) {
            this.f2571a.setLinkUri(uri);
            return this;
        }

        public Builder setSource(int i) {
            this.f2571a.setSource(i);
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
        private final ContentInfo.Builder f2572a;

        BuilderCompat31Impl(ClipData clipData, int i) {
            this.f2572a = new ContentInfo.Builder(clipData, i);
        }

        BuilderCompat31Impl(ContentInfoCompat contentInfoCompat) {
            this.f2572a = new ContentInfo.Builder(contentInfoCompat.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f2572a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData clipData) {
            this.f2572a.setClip(clipData);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.f2572a.setExtras(bundle);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.f2572a.setFlags(i);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            this.f2572a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int i) {
            this.f2572a.setSource(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$BuilderCompatImpl.class */
    static final class BuilderCompatImpl implements BuilderCompat {

        /* renamed from: a  reason: collision with root package name */
        ClipData f2573a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f2574c;
        Uri d;
        Bundle e;

        BuilderCompatImpl(ClipData clipData, int i) {
            this.f2573a = clipData;
            this.b = i;
        }

        BuilderCompatImpl(ContentInfoCompat contentInfoCompat) {
            this.f2573a = contentInfoCompat.getClip();
            this.b = contentInfoCompat.getSource();
            this.f2574c = contentInfoCompat.getFlags();
            this.d = contentInfoCompat.getLinkUri();
            this.e = contentInfoCompat.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData clipData) {
            this.f2573a = clipData;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.e = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.f2574c = i;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$Compat31Impl.class */
    public static final class Compat31Impl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f2575a;

        Compat31Impl(ContentInfo contentInfo) {
            this.f2575a = (ContentInfo) Preconditions.checkNotNull(contentInfo);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.f2575a.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.f2575a.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.f2575a.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.f2575a.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.f2575a.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return this.f2575a;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f2575a + "}";
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ContentInfoCompat$CompatImpl.class */
    static final class CompatImpl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f2576a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2577c;
        private final Uri d;
        private final Bundle e;

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.f2576a = (ClipData) Preconditions.checkNotNull(builderCompatImpl.f2573a);
            this.b = Preconditions.checkArgumentInRange(builderCompatImpl.b, 0, 5, "source");
            this.f2577c = Preconditions.checkFlagsArgument(builderCompatImpl.f2574c, 1);
            this.d = builderCompatImpl.d;
            this.e = builderCompatImpl.e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.f2576a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.f2577c;
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
            sb.append(this.f2576a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.a(this.b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.b(this.f2577c));
            if (this.d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.e == null ? "" : ", hasExtras");
            sb.append("}");
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
        this.f2570a = compat;
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
        return this.f2570a.getClip();
    }

    public Bundle getExtras() {
        return this.f2570a.getExtras();
    }

    public int getFlags() {
        return this.f2570a.getFlags();
    }

    public Uri getLinkUri() {
        return this.f2570a.getLinkUri();
    }

    public int getSource() {
        return this.f2570a.getSource();
    }

    public Pair<ContentInfoCompat, ContentInfoCompat> partition(androidx.core.util.Predicate<ClipData.Item> predicate) {
        ClipData clip = this.f2570a.getClip();
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
        return this.f2570a.getWrapped();
    }

    public String toString() {
        return this.f2570a.toString();
    }
}
