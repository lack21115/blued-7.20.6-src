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
    private XmlPullParser f27723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f27723a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl a(byte[] bArr, fu fuVar) {
        this.f27723a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f27723a.next();
        int eventType = this.f27723a.getEventType();
        String name = this.f27723a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gt.a(this.f27723a);
            }
            if (name.equals("iq")) {
                return gt.a(this.f27723a, fuVar);
            }
            if (name.equals(NfcAdapter.EXTRA_READER_PRESENCE_CHECK_DELAY)) {
                return gt.m8779a(this.f27723a);
            }
            if (this.f27723a.getName().equals(Instrumentation.REPORT_KEY_STREAMRESULT)) {
                return null;
            }
            if (this.f27723a.getName().equals("error")) {
                throw new gf(gt.m8780a(this.f27723a));
            }
            if (!this.f27723a.getName().equals("warning")) {
                this.f27723a.getName().equals("bind");
                return null;
            }
            this.f27723a.next();
            this.f27723a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
