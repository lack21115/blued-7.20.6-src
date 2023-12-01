package com.tencent.tencentmap.mapsdk.maps.interfaces;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/interfaces/Collisionable.class */
public interface Collisionable {
    boolean isCollisionBy(Collision collision);

    void setCollisions(Collision... collisionArr);
}
