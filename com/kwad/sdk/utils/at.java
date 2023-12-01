package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/at.class */
public final class at {
    private static boolean DT() {
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            return false;
        }
        return false;
    }

    public static boolean DU() {
        KsCustomController ksCustomController;
        if (DT()) {
            return true;
        }
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canReadLocation();
        } catch (Throwable th) {
            return false;
        }
    }

    public static Location DV() {
        KsCustomController ksCustomController;
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean DW() {
        KsCustomController ksCustomController;
        if (DT()) {
            return true;
        }
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUsePhoneState();
        } catch (Throwable th) {
            return false;
        }
    }

    public static String DX() {
        KsCustomController ksCustomController;
        try {
            SdkConfig CB = ServiceProvider.CB();
            return (CB == null || (ksCustomController = CB.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String[] DY() {
        KsCustomController ksCustomController;
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB != null && (ksCustomController = CB.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable th) {
        }
        return new String[]{"", ""};
    }

    public static String DZ() {
        KsCustomController ksCustomController;
        try {
            SdkConfig CB = ServiceProvider.CB();
            return (CB == null || (ksCustomController = CB.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean Ea() {
        KsCustomController ksCustomController;
        if (DT()) {
            return true;
        }
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseMacAddress();
        } catch (Throwable th) {
            return false;
        }
    }

    public static String Eb() {
        KsCustomController ksCustomController;
        try {
            SdkConfig CB = ServiceProvider.CB();
            return (CB == null || (ksCustomController = CB.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean Ec() {
        KsCustomController ksCustomController;
        if (DT()) {
            return true;
        }
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseOaid();
        } catch (Throwable th) {
            return false;
        }
    }

    public static String Ed() {
        KsCustomController ksCustomController;
        try {
            SdkConfig CB = ServiceProvider.CB();
            return (CB == null || (ksCustomController = CB.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean Ee() {
        KsCustomController ksCustomController;
        if (DT()) {
            return true;
        }
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseNetworkState();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean Ef() {
        KsCustomController ksCustomController;
        if (DT()) {
            return true;
        }
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseStoragePermission();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean Eg() {
        KsCustomController ksCustomController;
        if (DT()) {
            return true;
        }
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB == null || (ksCustomController = CB.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canReadInstalledPackages();
        } catch (Throwable th) {
            return false;
        }
    }

    public static List<String> Eh() {
        KsCustomController ksCustomController;
        try {
            SdkConfig CB = ServiceProvider.CB();
            if (CB != null && (ksCustomController = CB.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable th) {
        }
        return new ArrayList();
    }
}
