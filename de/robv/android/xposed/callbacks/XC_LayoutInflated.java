package de.robv.android.xposed.callbacks;

import android.content.res.XResources;
import android.view.View;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XC_LayoutInflated.class */
public abstract class XC_LayoutInflated extends XCallback {

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XC_LayoutInflated$LayoutInflatedParam.class */
    public static final class LayoutInflatedParam extends XCallback.Param {
        public XResources res;
        public XResources.ResourceNames resNames;
        public String variant;
        public View view;

        public LayoutInflatedParam(XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet) {
            super(copyOnWriteSortedSet);
        }
    }

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XC_LayoutInflated$Unhook.class */
    public class Unhook implements IXUnhook<XC_LayoutInflated> {
        private final int id;
        private final String resDir;

        public Unhook(String str, int i) {
            this.resDir = str;
            this.id = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // de.robv.android.xposed.callbacks.IXUnhook
        public XC_LayoutInflated getCallback() {
            return XC_LayoutInflated.this;
        }

        public int getId() {
            return this.id;
        }

        @Override // de.robv.android.xposed.callbacks.IXUnhook
        public void unhook() {
            XResources.unhookLayout(this.resDir, this.id, XC_LayoutInflated.this);
        }
    }

    public XC_LayoutInflated() {
    }

    public XC_LayoutInflated(int i) {
        super(i);
    }

    @Override // de.robv.android.xposed.callbacks.XCallback
    protected void call(XCallback.Param param) throws Throwable {
        if (param instanceof LayoutInflatedParam) {
            handleLayoutInflated((LayoutInflatedParam) param);
        }
    }

    public abstract void handleLayoutInflated(LayoutInflatedParam layoutInflatedParam) throws Throwable;
}
