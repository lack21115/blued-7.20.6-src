package android.view.textservice;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.textservice.SpellCheckerSession;
import com.android.internal.textservice.ITextServicesManager;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:android/view/textservice/TextServicesManager.class */
public final class TextServicesManager {
    private static final boolean DBG = false;
    private static final String TAG = TextServicesManager.class.getSimpleName();
    private static TextServicesManager sInstance;
    private static ITextServicesManager sService;

    private TextServicesManager() {
        if (sService == null) {
            sService = ITextServicesManager.Stub.asInterface(ServiceManager.getService(Context.TEXT_SERVICES_MANAGER_SERVICE));
        }
    }

    public static TextServicesManager getInstance() {
        synchronized (TextServicesManager.class) {
            try {
                if (sInstance != null) {
                    return sInstance;
                }
                sInstance = new TextServicesManager();
                return sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String parseLanguageFromLocaleString(String str) {
        int indexOf = str.indexOf(95);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }

    public SpellCheckerInfo getCurrentSpellChecker() {
        try {
            return sService.getCurrentSpellChecker(null);
        } catch (RemoteException e) {
            return null;
        }
    }

    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(boolean z) {
        try {
            if (sService == null) {
                Log.e(TAG, "sService is null.");
                return null;
            }
            return sService.getCurrentSpellCheckerSubtype(null, z);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in getCurrentSpellCheckerSubtype: " + e);
            return null;
        }
    }

    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        try {
            return sService.getEnabledSpellCheckers();
        } catch (RemoteException e) {
            Log.e(TAG, "Error in getEnabledSpellCheckers: " + e);
            return null;
        }
    }

    public boolean isSpellCheckerEnabled() {
        try {
            return sService.isSpellCheckerEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "Error in isSpellCheckerEnabled:" + e);
            return false;
        }
    }

    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale, SpellCheckerSession.SpellCheckerSessionListener spellCheckerSessionListener, boolean z) {
        SpellCheckerSubtype spellCheckerSubtype;
        if (spellCheckerSessionListener == null) {
            throw new NullPointerException();
        }
        if (z || locale != null) {
            if (!z || isSpellCheckerEnabled()) {
                try {
                    SpellCheckerInfo currentSpellChecker = sService.getCurrentSpellChecker(null);
                    if (currentSpellChecker == null) {
                        return null;
                    }
                    SpellCheckerSubtype spellCheckerSubtype2 = null;
                    if (!z) {
                        String locale2 = locale.toString();
                        int i = 0;
                        while (true) {
                            spellCheckerSubtype = spellCheckerSubtype2;
                            if (i >= currentSpellChecker.getSubtypeCount()) {
                                break;
                            }
                            spellCheckerSubtype = currentSpellChecker.getSubtypeAt(i);
                            String locale3 = spellCheckerSubtype.getLocale();
                            String parseLanguageFromLocaleString = parseLanguageFromLocaleString(locale3);
                            if (locale3.equals(locale2)) {
                                break;
                            }
                            SpellCheckerSubtype spellCheckerSubtype3 = spellCheckerSubtype2;
                            if (parseLanguageFromLocaleString.length() >= 2) {
                                spellCheckerSubtype3 = spellCheckerSubtype2;
                                if (locale.getLanguage().equals(parseLanguageFromLocaleString)) {
                                    spellCheckerSubtype3 = spellCheckerSubtype;
                                }
                            }
                            i++;
                            spellCheckerSubtype2 = spellCheckerSubtype3;
                        }
                    } else {
                        SpellCheckerSubtype currentSpellCheckerSubtype = getCurrentSpellCheckerSubtype(true);
                        if (currentSpellCheckerSubtype == null) {
                            return null;
                        }
                        spellCheckerSubtype = currentSpellCheckerSubtype;
                        if (locale != null) {
                            String parseLanguageFromLocaleString2 = parseLanguageFromLocaleString(currentSpellCheckerSubtype.getLocale());
                            if (parseLanguageFromLocaleString2.length() < 2) {
                                return null;
                            }
                            spellCheckerSubtype = currentSpellCheckerSubtype;
                            if (!locale.getLanguage().equals(parseLanguageFromLocaleString2)) {
                                return null;
                            }
                        }
                    }
                    if (spellCheckerSubtype == null) {
                        return null;
                    }
                    SpellCheckerSession spellCheckerSession = new SpellCheckerSession(currentSpellChecker, sService, spellCheckerSessionListener, spellCheckerSubtype);
                    try {
                        sService.getSpellCheckerService(currentSpellChecker.getId(), spellCheckerSubtype.getLocale(), spellCheckerSession.getTextServicesSessionListener(), spellCheckerSession.getSpellCheckerSessionListener(), bundle);
                        return spellCheckerSession;
                    } catch (RemoteException e) {
                        return null;
                    }
                } catch (RemoteException e2) {
                    return null;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Locale should not be null if you don't refer settings.");
    }

    public void setCurrentSpellChecker(SpellCheckerInfo spellCheckerInfo) {
        try {
            if (spellCheckerInfo == null) {
                throw new NullPointerException("SpellCheckerInfo is null.");
            }
            sService.setCurrentSpellChecker(null, spellCheckerInfo.getId());
        } catch (RemoteException e) {
            Log.e(TAG, "Error in setCurrentSpellChecker: " + e);
        }
    }

    public void setSpellCheckerEnabled(boolean z) {
        try {
            sService.setSpellCheckerEnabled(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in setSpellCheckerEnabled:" + e);
        }
    }

    public void setSpellCheckerSubtype(SpellCheckerSubtype spellCheckerSubtype) {
        int hashCode;
        if (spellCheckerSubtype == null) {
            hashCode = 0;
        } else {
            try {
                hashCode = spellCheckerSubtype.hashCode();
            } catch (RemoteException e) {
                Log.e(TAG, "Error in setSpellCheckerSubtype:" + e);
                return;
            }
        }
        sService.setCurrentSpellCheckerSubtype(null, hashCode);
    }
}
