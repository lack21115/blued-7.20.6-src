package com.igexin.assist;

import android.content.Context;
import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/MessageBean.class */
public class MessageBean {

    /* renamed from: a  reason: collision with root package name */
    private String f23174a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Object f23175c;
    private Context d;
    public final Bundle extra = new Bundle();

    public MessageBean(Context context, String str, Object obj) {
        this.b = str;
        this.f23175c = obj;
        this.d = context;
    }

    public Context getContext() {
        return this.d;
    }

    public Object getMessage() {
        return this.f23175c;
    }

    public String getMessageSource() {
        return this.f23174a;
    }

    public String getMessageType() {
        return this.b;
    }

    public Object getObjectMessage() {
        return this.f23175c;
    }

    public String getStringMessage() {
        Object obj = this.f23175c;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void setMessageSource(String str) {
        this.f23174a = str;
    }
}
