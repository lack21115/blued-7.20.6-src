package android.bluetooth.le;

import android.bluetooth.BluetoothAdapter;
import android.util.SparseArray;
import com.igexin.push.core.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/BluetoothLeUtils.class */
public class BluetoothLeUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkAdapterStateOn(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null || bluetoothAdapter.getState() != 12) {
            throw new IllegalStateException("BT Adapter is not turned ON");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(SparseArray<byte[]> sparseArray, SparseArray<byte[]> sparseArray2) {
        if (sparseArray == sparseArray2) {
            return true;
        }
        if (sparseArray == null || sparseArray2 == null || sparseArray.size() != sparseArray2.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sparseArray.size()) {
                return true;
            }
            if (sparseArray.keyAt(i2) != sparseArray2.keyAt(i2) || !Arrays.equals(sparseArray.valueAt(i2), sparseArray2.valueAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean equals(Map<T, byte[]> map, Map<T, byte[]> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<T> keySet = map.keySet();
        if (keySet.equals(map2.keySet())) {
            for (T t : keySet) {
                if (!Objects.deepEquals(map.get(t), map2.get(t))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return b.l;
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sparseArray.size()) {
                sb.append('}');
                return sb.toString();
            }
            sb.append(sparseArray.keyAt(i2)).append("=").append(Arrays.toString(sparseArray.valueAt(i2)));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> String toString(Map<T, byte[]> map) {
        if (map == null) {
            return b.l;
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            T key = it.next().getKey();
            sb.append(key).append("=").append(Arrays.toString(map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
