package com.sobot.network.http.task;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/task/PriorityObject.class */
public class PriorityObject<E> {
    public final E obj;
    public final int priority;

    public PriorityObject(int i, E e) {
        this.priority = i;
        this.obj = e;
    }
}
