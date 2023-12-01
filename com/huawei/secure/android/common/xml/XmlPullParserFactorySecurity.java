package com.huawei.secure.android.common.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/xml/XmlPullParserFactorySecurity.class */
public class XmlPullParserFactorySecurity {
    public static XmlPullParserFactory getInstance() throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
        newInstance.setFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES, false);
        newInstance.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, true);
        newInstance.setFeature(XmlPullParser.FEATURE_VALIDATION, false);
        return newInstance;
    }
}
