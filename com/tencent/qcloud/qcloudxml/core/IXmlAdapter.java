package com.tencent.qcloud.qcloudxml.core;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/qcloudxml/core/IXmlAdapter.class */
public interface IXmlAdapter<T> {
    T fromXml(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException;

    void toXml(XmlSerializer xmlSerializer, T t, String str) throws XmlPullParserException, IOException;
}
