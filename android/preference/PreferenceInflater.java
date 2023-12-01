package android.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceInflater.class */
public class PreferenceInflater extends GenericInflater<Preference, PreferenceGroup> {
    private static final String EXTRA_TAG_NAME = "extra";
    private static final String INTENT_TAG_NAME = "intent";
    private static final String TAG = "PreferenceInflater";
    private PreferenceManager mPreferenceManager;

    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        super(context);
        init(preferenceManager);
    }

    PreferenceInflater(GenericInflater<Preference, PreferenceGroup> genericInflater, PreferenceManager preferenceManager, Context context) {
        super(genericInflater, context);
        init(preferenceManager);
    }

    private void init(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        setDefaultPackage("android.preference.");
    }

    @Override // android.preference.GenericInflater
    public GenericInflater<Preference, PreferenceGroup> cloneInContext(Context context) {
        return new PreferenceInflater(this, this.mPreferenceManager, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.GenericInflater
    public boolean onCreateCustomFromTag(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("intent")) {
            try {
                Intent parseIntent = Intent.parseIntent(getContext().getResources(), xmlPullParser, attributeSet);
                if (parseIntent != null) {
                    preference.setIntent(parseIntent);
                    return true;
                }
                return true;
            } catch (IOException e) {
                XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                xmlPullParserException.initCause(e);
                throw xmlPullParserException;
            }
        } else if (name.equals("extra")) {
            getContext().getResources().parseBundleExtra("extra", attributeSet, preference.getExtras());
            try {
                XmlUtils.skipCurrentTag(xmlPullParser);
                return true;
            } catch (IOException e2) {
                XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                xmlPullParserException2.initCause(e2);
                throw xmlPullParserException2;
            }
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.GenericInflater
    public PreferenceGroup onMergeRoots(PreferenceGroup preferenceGroup, boolean z, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup == null) {
            preferenceGroup2.onAttachedToHierarchy(this.mPreferenceManager);
            return preferenceGroup2;
        }
        return preferenceGroup;
    }
}
