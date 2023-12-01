package com.youzan.jsbridge.event;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/event/NativeEvent.class */
public class NativeEvent {
    public Object[] datas;
    public String name;

    public NativeEvent(String str, Object... objArr) {
        this.name = str;
        this.datas = objArr;
    }
}
