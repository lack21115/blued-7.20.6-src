package com.kuaishou.weapon.p0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bn.class */
public class bn {
    public static int a(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return 0;
            }
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            int i = 0;
            if (sensorManager != null) {
                List<Sensor> sensorList = sensorManager.getSensorList(-1);
                i = 0;
                if (sensorList.size() > 0) {
                    ListIterator<Sensor> listIterator = sensorList.listIterator();
                    do {
                        if (!listIterator.hasNext()) {
                            i = 1;
                        }
                    } while (listIterator.next().getType() != 9);
                    return 0;
                }
            }
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    public static long a() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream;
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                double d = 0.0d;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = a(readLine).split(";");
                        if (split != null && split.length != 0) {
                            d = Double.valueOf(split[0]).doubleValue();
                        }
                    } catch (Throwable th) {
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return -1L;
                            } catch (IOException e2) {
                                return -1L;
                            }
                        }
                        return -1L;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis() - ((long) (d * 1000.0d));
                try {
                    dataInputStream.close();
                } catch (IOException e3) {
                }
                try {
                    bufferedReader.close();
                    return currentTimeMillis;
                } catch (IOException e4) {
                    return currentTimeMillis;
                }
            } catch (Throwable th2) {
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            dataInputStream = null;
        }
    }

    public static String a(String str) {
        try {
            return str.replace("      ", ";").replace("     ", ";").replace("    ", ";").replace("   ", ";").replace("  ", ";").replace(" ", ";");
        } catch (Throwable th) {
            return null;
        }
    }

    public static long b() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream;
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                double d = 0.0d;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = a(readLine).split(";");
                        if (split != null && split.length != 0) {
                            d = Double.valueOf(split[0]).doubleValue();
                        }
                    } catch (Throwable th) {
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return -1L;
                            } catch (IOException e2) {
                                return -1L;
                            }
                        }
                        return -1L;
                    }
                }
                System.currentTimeMillis();
                long j = (long) (d * 1000.0d);
                try {
                    dataInputStream.close();
                } catch (IOException e3) {
                }
                try {
                    bufferedReader.close();
                    return j;
                } catch (IOException e4) {
                    return j;
                }
            } catch (Throwable th2) {
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            dataInputStream = null;
        }
    }
}
