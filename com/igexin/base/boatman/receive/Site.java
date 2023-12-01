package com.igexin.base.boatman.receive;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/boatman/receive/Site.class */
public abstract class Site<Bag, V> {
    public abstract String getTag();

    public abstract V onArrived(Bag bag);

    public abstract void onArrived(Bag bag, IBoatResult<V> iBoatResult);
}
