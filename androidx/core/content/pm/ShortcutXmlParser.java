package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/pm/ShortcutXmlParser.class */
public class ShortcutXmlParser {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ArrayList<String> f2421a;
    private static final Object b = new Object();

    private ShortcutXmlParser() {
    }

    private static XmlResourceParser a(Context context, ActivityInfo activityInfo) {
        XmlResourceParser loadXmlMetaData = activityInfo.loadXmlMetaData(context.getPackageManager(), "android.app.shortcuts");
        if (loadXmlMetaData != null) {
            return loadXmlMetaData;
        }
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + activityInfo.name);
    }

    private static String a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        String str2 = attributeValue;
        if (attributeValue == null) {
            str2 = xmlPullParser.getAttributeValue(null, str);
        }
        return str2;
    }

    private static Set<String> a(Context context) {
        HashSet hashSet = new HashSet();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (queryIntentActivities != null) {
            if (queryIntentActivities.size() == 0) {
                return hashSet;
            }
            try {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    Bundle bundle = activityInfo.metaData;
                    if (bundle != null && bundle.containsKey("android.app.shortcuts")) {
                        XmlResourceParser a2 = a(context, activityInfo);
                        hashSet.addAll(parseShortcutIds(a2));
                        if (a2 != null) {
                            a2.close();
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("ShortcutXmlParser", "Failed to parse the Xml resource: ", e);
            }
        }
        return hashSet;
    }

    public static List<String> getShortcutIds(Context context) {
        if (f2421a == null) {
            synchronized (b) {
                if (f2421a == null) {
                    f2421a = new ArrayList<>();
                    f2421a.addAll(a(context));
                }
            }
        }
        return f2421a;
    }

    public static List<String> parseShortcutIds(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String a2;
        ArrayList arrayList = new ArrayList(1);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= 0)) {
                break;
            }
            int depth = xmlPullParser.getDepth();
            String name = xmlPullParser.getName();
            if (next == 2 && depth == 2 && "shortcut".equals(name) && (a2 = a(xmlPullParser, "shortcutId")) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }
}
