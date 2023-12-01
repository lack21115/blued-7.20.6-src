package com.youzan.androidsdkx5;

import com.youzan.androidsdk.event.Event;
import com.youzan.x5web.JsSubscriberCompat;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/EventSubscriber.class */
public class EventSubscriber extends JsSubscriberCompat {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Event f1149;

    public EventSubscriber(Event event) {
        this.f1149 = event;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r0.equals(com.youzan.androidsdk.event.EventAPI.SIGN_NOT_NEED_LOGIN) == false) goto L13;
     */
    @Override // com.youzan.x5web.JsSubscriberCompat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCall(com.tencent.smtt.sdk.WebView r5, com.youzan.jsbridge.method.JsMethodCompat r6, com.youzan.x5web.JsTrigger r7) {
        /*
            r4 = this;
            r0 = r4
            com.youzan.androidsdk.event.Event r0 = r0.f1149
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r6
            java.lang.String r0 = r0.getParams()
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r4
            com.youzan.androidsdk.event.Event r0 = r0.f1149
            boolean r0 = r0 instanceof com.youzan.androidsdk.event.AbsAuthEvent
            if (r0 == 0) goto L3a
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L37
            r0 = r7
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = "{}"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L37
            r0 = r7
            r6 = r0
            r0 = r7
            java.lang.String r1 = "{\"need_login\":false}"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3a
        L37:
            java.lang.String r0 = "{\"need_login\":true}"
            r6 = r0
        L3a:
            r0 = r4
            com.youzan.androidsdk.event.Event r0 = r0.f1149
            r1 = r5
            android.content.Context r1 = r1.getContext()
            r2 = r6
            r0.call(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youzan.androidsdkx5.EventSubscriber.onCall(com.tencent.smtt.sdk.WebView, com.youzan.jsbridge.method.JsMethodCompat, com.youzan.x5web.JsTrigger):void");
    }

    @Override // com.youzan.jsbridge.subscriber.MethodSubscriberCompat, com.youzan.jsbridge.subscriber.Subscriber
    public String subscribe() {
        Event event = this.f1149;
        if (event != null) {
            return event.subscribe();
        }
        return null;
    }
}
