package com.android.internal.view;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.DragEvent;
import android.view.IWindow;
import android.view.IWindowSession;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/BaseIWindow.class */
public class BaseIWindow extends IWindow.Stub {
    public int mSeq;
    private IWindowSession mSession;

    @Override // android.view.IWindow
    public void closeSystemDialogs(String str) {
    }

    public void dispatchAppVisibility(boolean z) {
    }

    @Override // android.view.IWindow
    public void dispatchDragEvent(DragEvent dragEvent) {
    }

    public void dispatchGetNewSurface() {
    }

    @Override // android.view.IWindow
    public void dispatchSystemUiVisibilityChanged(int i, int i2, int i3, int i4) {
        this.mSeq = i;
    }

    public void dispatchWallpaperCommand(String str, int i, int i2, int i3, Bundle bundle, boolean z) {
        if (z) {
            try {
                this.mSession.wallpaperCommandComplete(asBinder(), null);
            } catch (RemoteException e) {
            }
        }
    }

    public void dispatchWallpaperOffsets(float f, float f2, float f3, float f4, boolean z) {
        if (z) {
            try {
                this.mSession.wallpaperOffsetsComplete(asBinder());
            } catch (RemoteException e) {
            }
        }
    }

    @Override // android.view.IWindow
    public void dispatchWindowShown() {
    }

    @Override // android.view.IWindow
    public void doneAnimating() {
    }

    public void executeCommand(String str, String str2, ParcelFileDescriptor parcelFileDescriptor) {
    }

    public void moved(int i, int i2) {
    }

    public void resized(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5, boolean z, Configuration configuration) {
        if (z) {
            try {
                this.mSession.finishDrawing(this);
            } catch (RemoteException e) {
            }
        }
    }

    public void setSession(IWindowSession iWindowSession) {
        this.mSession = iWindowSession;
    }

    public void windowFocusChanged(boolean z, boolean z2) {
    }
}
