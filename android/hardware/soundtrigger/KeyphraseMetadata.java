package android.hardware.soundtrigger;

import android.util.ArraySet;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/KeyphraseMetadata.class */
public class KeyphraseMetadata {
    public final int id;
    public final String keyphrase;
    public final int recognitionModeFlags;
    public final ArraySet<Locale> supportedLocales;

    public KeyphraseMetadata(int i, String str, ArraySet<Locale> arraySet, int i2) {
        this.id = i;
        this.keyphrase = str;
        this.supportedLocales = arraySet;
        this.recognitionModeFlags = i2;
    }

    public boolean supportsLocale(Locale locale) {
        return this.supportedLocales.isEmpty() || this.supportedLocales.contains(locale);
    }

    public boolean supportsPhrase(String str) {
        return this.keyphrase.isEmpty() || this.keyphrase.equalsIgnoreCase(str);
    }

    public String toString() {
        return "id=" + this.id + ", keyphrase=" + this.keyphrase + ", supported-locales=" + this.supportedLocales + ", recognition-modes=" + this.recognitionModeFlags;
    }
}
