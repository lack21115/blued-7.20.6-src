package com.tencent.tinker.loader.hotplug;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Camera;
import android.media.tv.TvContract;
import android.os.Build;
import android.os.Bundle;
import android.security.KeyChain;
import android.text.TextUtils;
import android.util.Xml;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.hms.ads.fw;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.umeng.analytics.pro.d;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/IncrementComponentManager.class */
public final class IncrementComponentManager {
    private static final String TAG = "Tinker.IncrementCompMgr";
    private static final int TAG_ACTIVITY = 0;
    private static final int TAG_PROVIDER = 2;
    private static final int TAG_RECEIVER = 3;
    private static final int TAG_SERVICE = 1;
    private static Context sContext;
    private static volatile boolean sInitialized = false;
    private static String sPackageName;
    private static final Map<String, ActivityInfo> CLASS_NAME_TO_ACTIVITY_INFO_MAP = new HashMap();
    private static final Map<String, IntentFilter> CLASS_NAME_TO_INTENT_FILTER_MAP = new HashMap();
    private static final AttrTranslator<ActivityInfo> ACTIVITY_INFO_ATTR_TRANSLATOR = new AttrTranslator<ActivityInfo>() { // from class: com.tencent.tinker.loader.hotplug.IncrementComponentManager.1
        private int parseLaunchMode(String str) {
            if ("standard".equalsIgnoreCase(str)) {
                return 0;
            }
            if ("singleTop".equalsIgnoreCase(str)) {
                return 1;
            }
            if ("singleTask".equalsIgnoreCase(str)) {
                return 2;
            }
            if ("singleInstance".equalsIgnoreCase(str)) {
                return 3;
            }
            ShareTinkerLog.w(IncrementComponentManager.TAG, "Unknown launchMode: " + str, new Object[0]);
            return 0;
        }

        private int parseScreenOrientation(String str) {
            if ("unspecified".equalsIgnoreCase(str)) {
                return -1;
            }
            if ("behind".equalsIgnoreCase(str)) {
                return 3;
            }
            if (Camera.Parameters.SCENE_MODE_LANDSCAPE.equalsIgnoreCase(str)) {
                return 0;
            }
            if (Camera.Parameters.SCENE_MODE_PORTRAIT.equalsIgnoreCase(str)) {
                return 1;
            }
            if ("reverseLandscape".equalsIgnoreCase(str)) {
                return 8;
            }
            if ("reversePortrait".equalsIgnoreCase(str)) {
                return 9;
            }
            if ("sensorLandscape".equalsIgnoreCase(str)) {
                return 6;
            }
            if ("sensorPortrait".equalsIgnoreCase(str)) {
                return 7;
            }
            if ("sensor".equalsIgnoreCase(str)) {
                return 4;
            }
            if ("fullSensor".equalsIgnoreCase(str)) {
                return 10;
            }
            if ("nosensor".equalsIgnoreCase(str)) {
                return 5;
            }
            if ("user".equalsIgnoreCase(str)) {
                return 2;
            }
            if (Build.VERSION.SDK_INT < 18 || !"fullUser".equalsIgnoreCase(str)) {
                if (Build.VERSION.SDK_INT < 18 || !TvContract.Channels.COLUMN_LOCKED.equalsIgnoreCase(str)) {
                    if (Build.VERSION.SDK_INT < 18 || !"userLandscape".equalsIgnoreCase(str)) {
                        return (Build.VERSION.SDK_INT < 18 || !"userPortrait".equalsIgnoreCase(str)) ? -1 : 12;
                    }
                    return 11;
                }
                return 14;
            }
            return 13;
        }

        @Override // com.tencent.tinker.loader.hotplug.IncrementComponentManager.AttrTranslator
        void onInit(Context context, int i, XmlPullParser xmlPullParser) {
            if (i == 0) {
                try {
                    if (xmlPullParser.getEventType() == 2 && "activity".equals(xmlPullParser.getName())) {
                        return;
                    }
                    throw new IllegalStateException("unexpected xml parser state when parsing incremental component manifest.");
                } catch (XmlPullParserException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.tinker.loader.hotplug.IncrementComponentManager.AttrTranslator
        public void onTranslate(Context context, int i, String str, String str2, ActivityInfo activityInfo) {
            int i2 = 0;
            if ("name".equals(str)) {
                if (str2.charAt(0) != '.') {
                    activityInfo.name = str2;
                    return;
                }
                activityInfo.name = context.getPackageName() + str2;
            } else if ("parentActivityName".equals(str)) {
                if (Build.VERSION.SDK_INT >= 16) {
                    if (str2.charAt(0) != '.') {
                        activityInfo.parentActivityName = str2;
                        return;
                    }
                    activityInfo.parentActivityName = context.getPackageName() + str2;
                }
            } else if ("exported".equals(str)) {
                activityInfo.exported = fw.Code.equalsIgnoreCase(str2);
            } else if ("launchMode".equals(str)) {
                activityInfo.launchMode = parseLaunchMode(str2);
            } else if ("theme".equals(str)) {
                activityInfo.theme = context.getResources().getIdentifier(str2, "style", context.getPackageName());
            } else if ("uiOptions".equals(str)) {
                if (Build.VERSION.SDK_INT >= 14) {
                    activityInfo.uiOptions = Integer.decode(str2).intValue();
                }
            } else if ("permission".equals(str)) {
                activityInfo.permission = str2;
            } else if ("taskAffinity".equals(str)) {
                activityInfo.taskAffinity = str2;
            } else if ("multiprocess".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 1;
                } else {
                    activityInfo.flags &= -2;
                }
            } else if ("finishOnTaskLaunch".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2;
                } else {
                    activityInfo.flags &= -3;
                }
            } else if ("clearTaskOnLaunch".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4;
                } else {
                    activityInfo.flags &= -5;
                }
            } else if ("noHistory".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 128;
                } else {
                    activityInfo.flags &= -129;
                }
            } else if ("alwaysRetainTaskState".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8;
                } else {
                    activityInfo.flags &= -9;
                }
            } else if ("stateNotNeeded".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16;
                } else {
                    activityInfo.flags &= -17;
                }
            } else if ("excludeFromRecents".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 32;
                } else {
                    activityInfo.flags &= -33;
                }
            } else if ("allowTaskReparenting".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 64;
                } else {
                    activityInfo.flags &= -65;
                }
            } else if ("finishOnCloseSystemDialogs".equals(str)) {
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 256;
                } else {
                    activityInfo.flags &= -257;
                }
            } else if ("showOnLockScreen".equals(str) || "showForAllUsers".equals(str)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    int valueOfStaticIntField = ShareReflectUtil.getValueOfStaticIntField(ActivityInfo.class, "FLAG_SHOW_FOR_ALL_USERS", 0);
                    if (fw.Code.equalsIgnoreCase(str2)) {
                        activityInfo.flags = valueOfStaticIntField | activityInfo.flags;
                    } else {
                        activityInfo.flags = valueOfStaticIntField & activityInfo.flags;
                    }
                }
            } else if ("immersive".equals(str)) {
                if (Build.VERSION.SDK_INT >= 18) {
                    if (fw.Code.equalsIgnoreCase(str2)) {
                        activityInfo.flags |= 2048;
                    } else {
                        activityInfo.flags &= -2049;
                    }
                }
            } else if ("hardwareAccelerated".equals(str)) {
                if (Build.VERSION.SDK_INT >= 11) {
                    if (fw.Code.equalsIgnoreCase(str2)) {
                        activityInfo.flags |= 512;
                    } else {
                        activityInfo.flags &= -513;
                    }
                }
            } else if ("documentLaunchMode".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activityInfo.documentLaunchMode = Integer.decode(str2).intValue();
                }
            } else if ("maxRecents".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activityInfo.maxRecents = Integer.decode(str2).intValue();
                }
            } else if ("configChanges".equals(str)) {
                activityInfo.configChanges = Integer.decode(str2).intValue();
            } else if ("windowSoftInputMode".equals(str)) {
                activityInfo.softInputMode = Integer.decode(str2).intValue();
            } else if ("persistableMode".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activityInfo.persistableMode = Integer.decode(str2).intValue();
                }
            } else if ("allowEmbedded".equals(str)) {
                int valueOfStaticIntField2 = ShareReflectUtil.getValueOfStaticIntField(ActivityInfo.class, "FLAG_ALLOW_EMBEDDED", 0);
                if (fw.Code.equalsIgnoreCase(str2)) {
                    activityInfo.flags = valueOfStaticIntField2 | activityInfo.flags;
                } else {
                    activityInfo.flags = valueOfStaticIntField2 & activityInfo.flags;
                }
            } else if ("autoRemoveFromRecents".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (fw.Code.equalsIgnoreCase(str2)) {
                        activityInfo.flags |= 8192;
                    } else {
                        activityInfo.flags &= -8193;
                    }
                }
            } else if ("relinquishTaskIdentity".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (fw.Code.equalsIgnoreCase(str2)) {
                        activityInfo.flags |= 4096;
                    } else {
                        activityInfo.flags &= -4097;
                    }
                }
            } else if ("resumeWhilePausing".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (fw.Code.equalsIgnoreCase(str2)) {
                        activityInfo.flags |= 16384;
                    } else {
                        activityInfo.flags &= -16385;
                    }
                }
            } else if ("screenOrientation".equals(str)) {
                activityInfo.screenOrientation = parseScreenOrientation(str2);
            } else if ("label".equals(str)) {
                try {
                    i2 = context.getResources().getIdentifier(str2, "string", IncrementComponentManager.sPackageName);
                } catch (Throwable th) {
                }
                if (i2 != 0) {
                    activityInfo.labelRes = i2;
                } else {
                    activityInfo.nonLocalizedLabel = str2;
                }
            } else {
                try {
                    if ("icon".equals(str)) {
                        activityInfo.icon = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                    } else if ("banner".equals(str)) {
                        if (Build.VERSION.SDK_INT >= 20) {
                            activityInfo.banner = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                        }
                    } else if (TvContract.Channels.Logo.CONTENT_DIRECTORY.equals(str)) {
                        activityInfo.logo = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                    }
                } catch (Throwable th2) {
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/IncrementComponentManager$AttrTranslator.class */
    public static abstract class AttrTranslator<T_RESULT> {
        private AttrTranslator() {
        }

        void onInit(Context context, int i, XmlPullParser xmlPullParser) {
        }

        abstract void onTranslate(Context context, int i, String str, String str2, T_RESULT t_result);

        final void translate(Context context, int i, XmlPullParser xmlPullParser, T_RESULT t_result) {
            onInit(context, i, xmlPullParser);
            int attributeCount = xmlPullParser.getAttributeCount();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= attributeCount) {
                    return;
                }
                if ("android".equals(xmlPullParser.getAttributePrefix(i3))) {
                    onTranslate(context, i, xmlPullParser.getAttributeName(i3), xmlPullParser.getAttributeValue(i3), t_result);
                }
                i2 = i3 + 1;
            }
        }
    }

    private IncrementComponentManager() {
        throw new UnsupportedOperationException();
    }

    private static void ensureInitialized() {
        synchronized (IncrementComponentManager.class) {
            try {
                if (!sInitialized) {
                    throw new IllegalStateException("Not initialized!!");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [org.xmlpull.v1.XmlPullParser] */
    public static boolean init(Context context, ShareSecurityCheck shareSecurityCheck) throws IOException {
        XmlPullParser newPullParser;
        synchronized (IncrementComponentManager.class) {
            Context context2 = context;
            try {
                if (!shareSecurityCheck.getMetaContentMap().containsKey(EnvConsts.INCCOMPONENT_META_FILE)) {
                    ShareTinkerLog.i(TAG, "package has no incremental component meta, skip init.", new Object[0]);
                    return false;
                }
                while (context2 instanceof ContextWrapper) {
                    context = ((ContextWrapper) context2).getBaseContext();
                    if (context != null) {
                        context2 = context;
                    }
                }
                try {
                    sContext = context2;
                    sPackageName = context2.getPackageName();
                    StringReader stringReader = new StringReader(shareSecurityCheck.getMetaContentMap().get(EnvConsts.INCCOMPONENT_META_FILE));
                    try {
                        newPullParser = Xml.newPullParser();
                    } catch (XmlPullParserException e) {
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                        context = null;
                        if (context != null) {
                            try {
                                context.setInput(null);
                            } catch (Throwable th2) {
                            }
                        }
                        SharePatchFileUtil.closeQuietly(stringReader);
                        throw th;
                    }
                    try {
                        newPullParser.setInput(stringReader);
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            if (eventType == 2) {
                                String name = newPullParser.getName();
                                if ("activity".equalsIgnoreCase(name)) {
                                    ActivityInfo parseActivity = parseActivity(context2, newPullParser);
                                    CLASS_NAME_TO_ACTIVITY_INFO_MAP.put(parseActivity.name, parseActivity);
                                } else if (!"service".equalsIgnoreCase(name) && !SocialConstants.PARAM_RECEIVER.equalsIgnoreCase(name)) {
                                    d.M.equalsIgnoreCase(name);
                                }
                            }
                        }
                        sInitialized = true;
                        if (newPullParser != null) {
                            try {
                                newPullParser.setInput(null);
                            } catch (Throwable th3) {
                            }
                        }
                        SharePatchFileUtil.closeQuietly(stringReader);
                        return true;
                    } catch (XmlPullParserException e2) {
                        e = e2;
                        throw new IOException(e);
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public static boolean isIncrementActivity(String str) {
        ensureInitialized();
        return str != null && CLASS_NAME_TO_ACTIVITY_INFO_MAP.containsKey(str);
    }

    private static ActivityInfo parseActivity(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ActivityInfo activityInfo;
        synchronized (IncrementComponentManager.class) {
            try {
                activityInfo = new ActivityInfo();
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                activityInfo.applicationInfo = applicationInfo;
                activityInfo.packageName = sPackageName;
                activityInfo.processName = applicationInfo.processName;
                activityInfo.launchMode = 0;
                activityInfo.permission = applicationInfo.permission;
                activityInfo.screenOrientation = -1;
                activityInfo.taskAffinity = applicationInfo.taskAffinity;
                if (Build.VERSION.SDK_INT >= 11 && (applicationInfo.flags & 536870912) != 0) {
                    activityInfo.flags |= 512;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    activityInfo.documentLaunchMode = 0;
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    activityInfo.uiOptions = applicationInfo.uiOptions;
                }
                ACTIVITY_INFO_ATTR_TRANSLATOR.translate(context, 0, xmlPullParser, activityInfo);
                int depth = xmlPullParser.getDepth();
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                        break;
                    } else if (next != 3 && next != 4) {
                        String name = xmlPullParser.getName();
                        if ("intent-filter".equalsIgnoreCase(name)) {
                            parseIntentFilter(context, activityInfo.name, xmlPullParser);
                        } else if ("meta-data".equalsIgnoreCase(name)) {
                            parseMetaData(context, activityInfo, xmlPullParser);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityInfo;
    }

    private static void parseIntentFilter(Context context, String str, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        synchronized (IncrementComponentManager.class) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                String attributeValue = xmlPullParser.getAttributeValue(null, "priority");
                if (!TextUtils.isEmpty(attributeValue)) {
                    intentFilter.setPriority(Integer.decode(attributeValue).intValue());
                }
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "autoVerify");
                if (!TextUtils.isEmpty(attributeValue2)) {
                    try {
                        ShareReflectUtil.findMethod((Class<?>) IntentFilter.class, "setAutoVerify", (Class<?>[]) new Class[]{Boolean.TYPE}).invoke(intentFilter, Boolean.valueOf(fw.Code.equalsIgnoreCase(attributeValue2)));
                    } catch (Throwable th) {
                    }
                }
                int depth = xmlPullParser.getDepth();
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                        break;
                    } else if (next != 3 && next != 4) {
                        String name = xmlPullParser.getName();
                        if ("action".equals(name)) {
                            String attributeValue3 = xmlPullParser.getAttributeValue(null, "name");
                            if (attributeValue3 != null) {
                                intentFilter.addAction(attributeValue3);
                            }
                        } else if ("category".equals(name)) {
                            String attributeValue4 = xmlPullParser.getAttributeValue(null, "name");
                            if (attributeValue4 != null) {
                                intentFilter.addCategory(attributeValue4);
                            }
                        } else if ("data".equals(name)) {
                            String attributeValue5 = xmlPullParser.getAttributeValue(null, DBDefinition.MIME_TYPE);
                            if (attributeValue5 != null) {
                                try {
                                    intentFilter.addDataType(attributeValue5);
                                } catch (IntentFilter.MalformedMimeTypeException e) {
                                    throw new XmlPullParserException("bad mimeType", xmlPullParser, e);
                                }
                            }
                            String attributeValue6 = xmlPullParser.getAttributeValue(null, "scheme");
                            if (attributeValue6 != null) {
                                intentFilter.addDataScheme(attributeValue6);
                            }
                            if (Build.VERSION.SDK_INT >= 19) {
                                String attributeValue7 = xmlPullParser.getAttributeValue(null, "ssp");
                                if (attributeValue7 != null) {
                                    intentFilter.addDataSchemeSpecificPart(attributeValue7, 0);
                                }
                                String attributeValue8 = xmlPullParser.getAttributeValue(null, "sspPrefix");
                                if (attributeValue8 != null) {
                                    intentFilter.addDataSchemeSpecificPart(attributeValue8, 1);
                                }
                                String attributeValue9 = xmlPullParser.getAttributeValue(null, "sspPattern");
                                if (attributeValue9 != null) {
                                    intentFilter.addDataSchemeSpecificPart(attributeValue9, 2);
                                }
                            }
                            String attributeValue10 = xmlPullParser.getAttributeValue(null, "host");
                            String attributeValue11 = xmlPullParser.getAttributeValue(null, KeyChain.EXTRA_PORT);
                            if (attributeValue10 != null) {
                                intentFilter.addDataAuthority(attributeValue10, attributeValue11);
                            }
                            String attributeValue12 = xmlPullParser.getAttributeValue(null, OapsWrapper.KEY_PATH);
                            if (attributeValue12 != null) {
                                intentFilter.addDataPath(attributeValue12, 0);
                            }
                            String attributeValue13 = xmlPullParser.getAttributeValue(null, "pathPrefix");
                            if (attributeValue13 != null) {
                                intentFilter.addDataPath(attributeValue13, 1);
                            }
                            String attributeValue14 = xmlPullParser.getAttributeValue(null, "pathPattern");
                            if (attributeValue14 != null) {
                                intentFilter.addDataPath(attributeValue14, 2);
                            }
                        }
                        skipCurrentTag(xmlPullParser);
                    }
                }
                CLASS_NAME_TO_INTENT_FILTER_MAP.put(str, intentFilter);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void parseMetaData(Context context, ActivityInfo activityInfo, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        synchronized (IncrementComponentManager.class) {
            try {
                ClassLoader classLoader = IncrementComponentManager.class.getClassLoader();
                String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
                if (!TextUtils.isEmpty(attributeValue)) {
                    if (activityInfo.metaData == null) {
                        activityInfo.metaData = new Bundle(classLoader);
                    }
                    activityInfo.metaData.putString(attributeValue, attributeValue2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ActivityInfo queryActivityInfo(String str) {
        ensureInitialized();
        if (str != null) {
            return CLASS_NAME_TO_ACTIVITY_INFO_MAP.get(str);
        }
        return null;
    }

    public static ResolveInfo resolveIntent(Intent intent) {
        IntentFilter intentFilter;
        String str;
        ensureInitialized();
        ComponentName component = intent.getComponent();
        int i = -1;
        int i2 = 0;
        if (component != null) {
            str = component.getClassName();
            if (CLASS_NAME_TO_ACTIVITY_INFO_MAP.containsKey(str)) {
                i = 0;
            } else {
                str = null;
            }
            intentFilter = null;
        } else {
            String str2 = null;
            intentFilter = null;
            int i3 = -1;
            int i4 = 0;
            for (Map.Entry<String, IntentFilter> entry : CLASS_NAME_TO_INTENT_FILTER_MAP.entrySet()) {
                String key = entry.getKey();
                IntentFilter value = entry.getValue();
                int match = value.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), TAG);
                boolean z = (match == -3 || match == -4 || match == -2 || match == -1) ? false : true;
                int priority = value.getPriority();
                if (z && priority > i3) {
                    intentFilter = value;
                    str2 = key;
                    i4 = match;
                    i3 = priority;
                }
            }
            str = str2;
            i2 = i4;
            i = i3;
        }
        ResolveInfo resolveInfo = null;
        if (str != null) {
            resolveInfo = new ResolveInfo();
            resolveInfo.activityInfo = CLASS_NAME_TO_ACTIVITY_INFO_MAP.get(str);
            resolveInfo.filter = intentFilter;
            resolveInfo.match = i2;
            resolveInfo.priority = i;
            resolveInfo.resolvePackageName = sPackageName;
            resolveInfo.icon = resolveInfo.activityInfo.icon;
            resolveInfo.labelRes = resolveInfo.activityInfo.labelRes;
        }
        return resolveInfo;
    }

    private static void skipCurrentTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }
}
