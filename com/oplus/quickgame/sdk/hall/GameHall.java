package com.oplus.quickgame.sdk.hall;

import com.oplus.quickgame.sdk.hall.feature.GameHallRouter;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/GameHall.class */
public class GameHall {
    private static GameHall b;

    /* renamed from: a  reason: collision with root package name */
    private GameHallRouter f10741a = new GameHallRouter();

    private GameHall() {
    }

    public static GameHall getInstance() {
        GameHall gameHall;
        synchronized (GameHall.class) {
            try {
                if (b == null) {
                    b = new GameHall();
                }
                gameHall = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gameHall;
    }

    public GameHallRouter router() {
        return this.f10741a;
    }
}
