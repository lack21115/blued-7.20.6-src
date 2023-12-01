package com.igexin.base.boatman;

import com.igexin.base.api.ShipsManager;
import com.igexin.base.boatman.receive.IBoatResult;
import com.igexin.base.boatman.receive.Site;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/boatman/Boater.class */
public abstract class Boater<Bag, V> {
    public abstract String getTag();

    public void postASync(Bag bag, IBoatResult<V> iBoatResult) {
        ShipsManager.get().getShip().a(this, bag, iBoatResult);
    }

    public void postSticky(Bag bag, IBoatResult<V> iBoatResult) {
        b ship = ShipsManager.get().getShip();
        String tag = getTag();
        ship.f23210a.lock();
        try {
            boolean containsKey = ship.b.containsKey(getTag());
            if (!containsKey) {
                if (ship.f23211c.get(tag) == null) {
                    ship.f23211c.put(tag, new ArrayList());
                }
                ship.f23211c.get(tag).add(new a(bag, iBoatResult));
            }
            if (containsKey) {
                ship.a(this, bag, iBoatResult);
            }
        } finally {
            ship.f23210a.unlock();
        }
    }

    public V postSync(Bag bag) {
        Site site = ShipsManager.get().getShip().b.get(getTag());
        if (site == null) {
            return null;
        }
        return (V) site.onArrived(bag);
    }

    public boolean removeSticky(Bag bag) {
        return ShipsManager.get().getShip().a(this, bag);
    }
}
