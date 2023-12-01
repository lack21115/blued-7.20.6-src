package org.msgpack.value;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/MapValue.class */
public interface MapValue extends Value {
    Set<Map.Entry<Value, Value>> entrySet();

    Value[] getKeyValueArray();

    Set<Value> keySet();

    Map<Value, Value> map();

    int size();

    Collection<Value> values();
}
