package com.igexin.assist.action;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.core.d;
import com.igexin.push.core.e;
import com.igexin.push.core.e.d;
import com.igexin.push.core.e.f;
import com.igexin.push.core.l;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import com.igexin.sdk.message.GTTransmitMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/action/MessageManger.class */
public class MessageManger {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23176a = "Assist_MessageManger";
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.igexin.assist.action.MessageManger$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/action/MessageManger$1.class */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23177a;
        final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f23178c;

        AnonymousClass1(String str, boolean z, Context context) {
            this.f23177a = str;
            this.b = z;
            this.f23178c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (e.m.get()) {
                com.igexin.c.a.c.a.b(MessageManger.f23176a, "delay 1s save token = " + this.f23177a);
                MessageManger.b(this.f23177a, this.b);
                return;
            }
            Context context = this.f23178c;
            if (context == null) {
                com.igexin.c.a.c.a.b(MessageManger.f23176a, " save token in SP ,but context is null " + this.f23177a);
                return;
            }
            d a2 = d.a(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("token", this.f23177a);
                jSONObject.put("isForce", this.b);
            } catch (JSONException e) {
                com.igexin.c.a.c.a.a(e);
            }
            a2.a(jSONObject);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/action/MessageManger$a.class */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        MessageBean f23179a;

        a(MessageBean messageBean) {
            this.f23179a = messageBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f23179a != null) {
                    GtcProvider.setContext(this.f23179a.getContext());
                    String messageType = this.f23179a.getMessageType();
                    boolean z = true;
                    int hashCode = messageType.hashCode();
                    if (hashCode != -1161803523) {
                        if (hashCode != -786701938) {
                            if (hashCode == 110541305 && messageType.equals("token")) {
                                z = false;
                            }
                        } else if (messageType.equals("payload")) {
                            z = true;
                        }
                    } else if (messageType.equals(AssistPushConsts.MSG_TYPE_ACTIONS)) {
                        z = true;
                    }
                    if (!z) {
                        MessageManger.a(MessageManger.this, this.f23179a.getContext(), this.f23179a.getStringMessage(), this.f23179a.extra.getBoolean("isForce"));
                    } else if (z) {
                        if (TextUtils.isEmpty(this.f23179a.getStringMessage())) {
                            return;
                        }
                        com.igexin.assist.action.a aVar = new com.igexin.assist.action.a();
                        aVar.a(this.f23179a);
                        if (aVar.a(false) && aVar.e.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                            MessageManger.a(MessageManger.this, aVar, this.f23179a.getContext());
                        }
                    } else if (z && !TextUtils.isEmpty(this.f23179a.getStringMessage())) {
                        com.igexin.assist.action.a aVar2 = new com.igexin.assist.action.a();
                        aVar2.a(this.f23179a);
                        if (aVar2.a(true) && aVar2.e.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                            MessageManger.a(this.f23179a.getContext(), aVar2);
                        }
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/action/MessageManger$b.class */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final MessageManger f23180a = new MessageManger((byte) 0);

        private b() {
        }
    }

    private MessageManger() {
    }

    /* synthetic */ MessageManger(byte b2) {
        this();
    }

    private static PushTaskBean a(com.igexin.assist.action.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(aVar.d);
        pushTaskBean.setMessageId(aVar.f23182c);
        pushTaskBean.setTaskId(aVar.b);
        pushTaskBean.setId(String.valueOf(currentTimeMillis));
        pushTaskBean.setCurrentActionid(1);
        return pushTaskBean;
    }

    static /* synthetic */ void a(Context context, com.igexin.assist.action.a aVar) {
        if (!e.m.get()) {
            AssistUtils.startGetuiService(context);
        }
        Message obtain = Message.obtain();
        obtain.what = com.igexin.push.core.b.Q;
        obtain.obj = aVar.f;
        Bundle bundle = new Bundle();
        bundle.putString("content", aVar.f);
        if (aVar.f23181a != null) {
            bundle.putByteArray("payload", aVar.f23181a);
        }
        obtain.setData(bundle);
        d.a.f23474a.a(obtain);
    }

    private void a(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(f23176a, "other token = ".concat(String.valueOf(str)));
        if (e.m.get()) {
            b(str, z);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(str, z, context), 1000L);
        }
    }

    static /* synthetic */ void a(MessageManger messageManger, Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(f23176a, "other token = ".concat(String.valueOf(str)));
        if (e.m.get()) {
            b(str, z);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(str, z, context), 1000L);
        }
    }

    static /* synthetic */ void a(MessageManger messageManger, com.igexin.assist.action.a aVar, Context context) {
        if (context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(context);
            if (a2.a(aVar.b)) {
                messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "1");
                return;
            }
            a2.b(aVar.b);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10001);
            String str = aVar.b;
            String str2 = aVar.f23182c;
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, aVar.f23182c + ":" + aVar.b, aVar.f23181a));
            l.a(context);
            l.a().a(bundle);
            messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "0");
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(com.igexin.assist.action.a aVar, Context context) {
        if (aVar == null || context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(context);
            if (a2.a(aVar.b)) {
                feedbackPushMessage(context, aVar, getBrandCode() + "1");
                return;
            }
            a2.b(aVar.b);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10001);
            String str = aVar.b;
            String str2 = aVar.f23182c;
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, aVar.f23182c + ":" + aVar.b, aVar.f23181a));
            l.a(context);
            l.a().a(bundle);
            feedbackPushMessage(context, aVar, getBrandCode() + "0");
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(String str) {
        try {
            l.a().a(str);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void b(Context context, com.igexin.assist.action.a aVar) {
        if (!e.m.get()) {
            AssistUtils.startGetuiService(context);
        }
        if (aVar == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = com.igexin.push.core.b.Q;
        obtain.obj = aVar.f;
        Bundle bundle = new Bundle();
        bundle.putString("content", aVar.f);
        if (aVar.f23181a != null) {
            bundle.putByteArray("payload", aVar.f23181a);
        }
        obtain.setData(bundle);
        d.a.f23474a.a(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, boolean z) {
        a(str);
        if (!z) {
            try {
                if (str.equals(e.I)) {
                    return;
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return;
            }
        }
        f.a().b(str);
        if (e.u) {
            com.igexin.c.a.c.a.b(f23176a, "online, send addphoneinfo");
            com.igexin.push.core.a.b.d().i();
        } else if (z) {
            f.a().c("");
        }
    }

    public static MessageManger getInstance() {
        return b.f23180a;
    }

    public void addMessage(MessageBean messageBean) {
        com.igexin.b.a.a().f23194a.execute(new a(messageBean));
    }

    public void feedbackPushMessage(Context context, com.igexin.assist.action.a aVar, String str) {
        try {
            if (e.m.get()) {
                FeedbackImpl feedbackImpl = FeedbackImpl.getInstance();
                long currentTimeMillis = System.currentTimeMillis();
                PushTaskBean pushTaskBean = new PushTaskBean();
                pushTaskBean.setAppid(aVar.d);
                pushTaskBean.setMessageId(aVar.f23182c);
                pushTaskBean.setTaskId(aVar.b);
                pushTaskBean.setId(String.valueOf(currentTimeMillis));
                pushTaskBean.setCurrentActionid(1);
                feedbackImpl.feedbackMultiBrandMessageAction(pushTaskBean, str);
                return;
            }
            com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(context);
            long currentTimeMillis2 = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(currentTimeMillis2));
            jSONObject.put("messageid", aVar.f23182c);
            jSONObject.put("taskid", aVar.b);
            jSONObject.put("multaid", str);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
            a2.a(aVar.b, jSONObject);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public String getBrandCode() {
        if (TextUtils.isEmpty(this.b)) {
            com.igexin.assist.sdk.a a2 = com.igexin.assist.sdk.a.a();
            String brandCode = a2.b == null ? "" : a2.b.getBrandCode();
            this.b = brandCode;
            return brandCode;
        }
        return this.b;
    }
}
