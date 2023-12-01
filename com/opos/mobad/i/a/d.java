package com.opos.mobad.i.a;

import android.content.Context;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a/d.class */
public final class d {
    public static File a(Context context, com.opos.mobad.i.a aVar) {
        if (context == null || aVar == null) {
            return null;
        }
        int i = aVar.f12520c;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new File(context.getDir(aVar.f, aVar.e), aVar.g);
            }
            return new File(context.getFilesDir(), aVar.g);
        }
        return new File(aVar.d);
    }

    public static File b(Context context, com.opos.mobad.i.a aVar) {
        if (context == null || aVar == null) {
            return null;
        }
        int i = aVar.f12520c;
        if (i == 0) {
            return new File(aVar.d + ".tmp");
        } else if (i == 1) {
            File filesDir = context.getFilesDir();
            return new File(filesDir, aVar.g + ".tmp");
        } else if (i != 2) {
            return null;
        } else {
            File dir = context.getDir(aVar.f, aVar.e);
            return new File(dir, aVar.g + ".tmp");
        }
    }

    public static File c(Context context, com.opos.mobad.i.a aVar) {
        if (context == null || aVar == null) {
            return null;
        }
        int i = aVar.f12520c;
        if (i == 0) {
            return new File(aVar.d + ".pos");
        } else if (i == 1) {
            File filesDir = context.getFilesDir();
            return new File(filesDir, aVar.g + ".pos");
        } else if (i != 2) {
            return null;
        } else {
            File dir = context.getDir(aVar.f, aVar.e);
            return new File(dir, aVar.g + ".pos");
        }
    }
}
