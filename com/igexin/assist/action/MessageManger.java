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
    private static final String f9568a = "Assist_MessageManger";
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.igexin.assist.action.MessageManger$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/action/MessageManger$1.class */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9569a;
        final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f9570c;

        AnonymousClass1(String str, boolean z, Context context) {
            this.f9569a = str;
            this.b = z;
            this.f9570c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (e.m.get()) {
                com.igexin.c.a.c.a.b(MessageManger.f9568a, "delay 1s save token = " + this.f9569a);
                MessageManger.b(this.f9569a, this.b);
                return;
            }
            Context context = this.f9570c;
            if (context == null) {
                com.igexin.c.a.c.a.b(MessageManger.f9568a, " save token in SP ,but context is null " + this.f9569a);
                return;
            }
            d a2 = d.a(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("token", this.f9569a);
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
        MessageBean f9571a;

        a(MessageBean messageBean) {
            this.f9571a = messageBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f9571a != null) {
                    GtcProvider.setContext(this.f9571a.getContext());
                    String messageType = this.f9571a.getMessageType();
                    boolean z = true;
                    int hashCode = messageType.hashCode();
                    if (hashCode != -1161803523) {
                        if (hashCode != -786701938) {
                            if (hashCode == 110541305 && messageType.equals("token")) {
                                z = false;
                            }
                        } else if (messageType.equals(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
                            z = true;
                        }
                    } else if (messageType.equals(AssistPushConsts.MSG_TYPE_ACTIONS)) {
                        z = true;
                    }
                    if (!z) {
                        MessageManger.a(MessageManger.this, this.f9571a.getContext(), this.f9571a.getStringMessage(), this.f9571a.extra.getBoolean("isForce"));
                    } else if (z) {
                        if (TextUtils.isEmpty(this.f9571a.getStringMessage())) {
                            return;
                        }
                        com.igexin.assist.action.a aVar = new com.igexin.assist.action.a();
                        aVar.a(this.f9571a);
                        if (aVar.a(false) && aVar.e.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                            MessageManger.a(MessageManger.this, aVar, this.f9571a.getContext());
                        }
                    } else if (z && !TextUtils.isEmpty(this.f9571a.getStringMessage())) {
                        com.igexin.assist.action.a aVar2 = new com.igexin.assist.action.a();
                        aVar2.a(this.f9571a);
                        if (aVar2.a(true) && aVar2.e.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                            MessageManger.a(this.f9571a.getContext(), aVar2);
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
        private static final MessageManger f9572a = new MessageManger((byte) 0);

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
        pushTaskBean.setMessageId(aVar.f9574c);
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
        if (aVar.f9573a != null) {
            bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, aVar.f9573a);
        }
        obtain.setData(bundle);
        d.a.f9866a.a(obtain);
    }

    private void a(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(f9568a, "other token = ".concat(String.valueOf(str)));
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
        com.igexin.c.a.c.a.e.a(f9568a, "other token = ".concat(String.valueOf(str)));
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
            String str2 = aVar.f9574c;
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, aVar.f9574c + ":" + aVar.b, aVar.f9573a));
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
            String str2 = aVar.f9574c;
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, aVar.f9574c + ":" + aVar.b, aVar.f9573a));
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
        if (aVar.f9573a != null) {
            bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, aVar.f9573a);
        }
        obtain.setData(bundle);
        d.a.f9866a.a(obtain);
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
            com.igexin.c.a.c.a.b(f9568a, "online, send addphoneinfo");
            com.igexin.push.core.a.b.d().i();
        } else if (z) {
            f.a().c("");
        }
    }

    public static MessageManger getInstance() {
        return b.f9572a;
    }

    public void addMessage(MessageBean messageBean) {
        com.igexin.b.a.a().f9586a.execute(new a(messageBean));
    }

    public void feedbackPushMessage(Context context, com.igexin.assist.action.a aVar, String str) {
        try {
            if (e.m.get()) {
                FeedbackImpl feedbackImpl = FeedbackImpl.getInstance();
                long currentTimeMillis = System.currentTimeMillis();
                PushTaskBean pushTaskBean = new PushTaskBean();
                pushTaskBean.setAppid(aVar.d);
                pushTaskBean.setMessageId(aVar.f9574c);
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
            jSONObject.put("messageid", aVar.f9574c);
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
