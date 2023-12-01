package android.content;

import android.content.pm.RegisteredServicesCache;
import android.content.pm.XmlSerializerAndParser;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/content/SyncAdaptersCache.class */
public class SyncAdaptersCache extends RegisteredServicesCache<SyncAdapterType> {
    private static final String ATTRIBUTES_NAME = "sync-adapter";
    private static final String SERVICE_INTERFACE = "android.content.SyncAdapter";
    private static final String SERVICE_META_DATA = "android.content.SyncAdapter";
    private static final String TAG = "Account";
    private static final MySerializer sSerializer = new MySerializer();

    /* loaded from: source-9557208-dex2jar.jar:android/content/SyncAdaptersCache$MySerializer.class */
    static class MySerializer implements XmlSerializerAndParser<SyncAdapterType> {
        MySerializer() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.content.pm.XmlSerializerAndParser
        public SyncAdapterType createFromXml(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
            return SyncAdapterType.newKey(xmlPullParser.getAttributeValue(null, ContactsContract.Directory.DIRECTORY_AUTHORITY), xmlPullParser.getAttributeValue(null, "accountType"));
        }

        @Override // android.content.pm.XmlSerializerAndParser
        public void writeAsXml(SyncAdapterType syncAdapterType, XmlSerializer xmlSerializer) throws IOException {
            xmlSerializer.attribute(null, ContactsContract.Directory.DIRECTORY_AUTHORITY, syncAdapterType.authority);
            xmlSerializer.attribute(null, "accountType", syncAdapterType.accountType);
        }
    }

    public SyncAdaptersCache(Context context) {
        super(context, "android.content.SyncAdapter", "android.content.SyncAdapter", ATTRIBUTES_NAME, sSerializer);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.content.pm.RegisteredServicesCache
    public SyncAdapterType parseServiceAttributes(Resources resources, String str, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.SyncAdapter);
        try {
            String string = obtainAttributes.getString(2);
            String string2 = obtainAttributes.getString(1);
            if (string == null || string2 == null) {
                obtainAttributes.recycle();
                return null;
            }
            return new SyncAdapterType(string, string2, obtainAttributes.getBoolean(3, true), obtainAttributes.getBoolean(4, true), obtainAttributes.getBoolean(6, false), obtainAttributes.getBoolean(5, false), obtainAttributes.getString(0));
        } finally {
            obtainAttributes.recycle();
        }
    }
}
