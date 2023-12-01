package com.hihonor.push.sdk;

import android.content.Intent;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.Callable;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/a0.class */
public class a0 implements Callable<HonorPushDataMsg> {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f8671a;

    public a0(Intent intent) {
        this.f8671a = intent;
    }

    @Override // java.util.concurrent.Callable
    public HonorPushDataMsg call() throws Exception {
        byte[] bArr;
        String str;
        Intent intent = this.f8671a;
        HonorPushDataMsg honorPushDataMsg = null;
        if (intent != null) {
            long j = 0;
            try {
                j = intent.getLongExtra("msg_id", 0L);
            } catch (Exception e) {
                b.a("PassByMsgIntentParser", "parserMsgId", e);
            }
            try {
                bArr = this.f8671a.getByteArrayExtra("msg_content");
            } catch (Exception e2) {
                b.a("PassByMsgIntentParser", "parseMsgContent", e2);
                bArr = null;
            }
            Inflater inflater = new Inflater();
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[256];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
            while (!inflater.finished()) {
                try {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                } catch (DataFormatException e3) {
                    inflater.end();
                    str = null;
                } catch (Throwable th) {
                    inflater.end();
                    throw th;
                }
            }
            inflater.end();
            str = byteArrayOutputStream.toString("utf-8");
            honorPushDataMsg = null;
            if (str != null) {
                String optString = new JSONObject(str).optString("data");
                honorPushDataMsg = null;
                if (!TextUtils.isEmpty(optString)) {
                    honorPushDataMsg = new HonorPushDataMsg();
                    honorPushDataMsg.setMsgId(j);
                    honorPushDataMsg.setData(optString);
                }
            }
        }
        return honorPushDataMsg;
    }
}
