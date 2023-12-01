package com.blued.android.module.base.game_center;

import android.content.Context;
import android.os.Bundle;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/game_center/GameCenterProxy.class */
public class GameCenterProxy implements IGameCenter {
    private static GameCenterProxy a = new GameCenterProxy();
    private IGameCenter b = null;

    private GameCenterProxy() {
    }

    public static GameCenterProxy a() {
        return a;
    }

    @Override // com.blued.android.module.base.game_center.IGameCenter
    public void a(Context context, Bundle bundle) {
        IGameCenter iGameCenter = this.b;
        if (iGameCenter != null) {
            iGameCenter.a(context, bundle);
        }
    }
}
