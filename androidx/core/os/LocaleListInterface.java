package androidx.core.os;

import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/LocaleListInterface.class */
interface LocaleListInterface {
    Locale get(int i);

    Locale getFirstMatch(String[] strArr);

    Object getLocaleList();

    int indexOf(Locale locale);

    boolean isEmpty();

    int size();

    String toLanguageTags();
}
