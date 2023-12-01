package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/LocaleListPlatformWrapper.class */
final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f2513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListPlatformWrapper(LocaleList localeList) {
        this.f2513a = localeList;
    }

    public boolean equals(Object obj) {
        return this.f2513a.equals(((LocaleListInterface) obj).getLocaleList());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i) {
        return this.f2513a.get(i);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] strArr) {
        return this.f2513a.getFirstMatch(strArr);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.f2513a;
    }

    public int hashCode() {
        return this.f2513a.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        return this.f2513a.indexOf(locale);
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.f2513a.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f2513a.size();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.f2513a.toLanguageTags();
    }

    public String toString() {
        return this.f2513a.toString();
    }
}
