package com.tencent.mapsdk.engine.jni;

import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/engine/jni/JNIEvent.class */
public class JNIEvent {
    public byte[] data;
    public Object extra;
    public int id;
    public String name;

    public String toString() {
        return "JNIEvent{id=" + this.id + ", name='" + this.name + "', data=" + Arrays.toString(this.data) + ", extra=" + this.extra + '}';
    }
}
