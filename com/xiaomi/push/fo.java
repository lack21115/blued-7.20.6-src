package com.xiaomi.push;

import android.app.Instrumentation;
import android.nfc.NfcAdapter;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fo.class */
public class fo {

    /* renamed from: a  reason: collision with root package name */
    private XmlPullParser f41414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f41414a = newPullParser;
            newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl a(byte[] bArr, fu fuVar) {
        this.f41414a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f41414a.next();
        int eventType = this.f41414a.getEventType();
        String name = this.f41414a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gt.a(this.f41414a);
            }
            if (name.equals("iq")) {
                return gt.a(this.f41414a, fuVar);
            }
            if (name.equals(NfcAdapter.EXTRA_READER_PRESENCE_CHECK_DELAY)) {
                return gt.m11829a(this.f41414a);
            }
            if (this.f41414a.getName().equals(Instrumentation.REPORT_KEY_STREAMRESULT)) {
                return null;
            }
            if (this.f41414a.getName().equals("error")) {
                throw new gf(gt.m11830a(this.f41414a));
            }
            if (!this.f41414a.getName().equals("warning")) {
                this.f41414a.getName().equals("bind");
                return null;
            }
            this.f41414a.next();
            this.f41414a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
