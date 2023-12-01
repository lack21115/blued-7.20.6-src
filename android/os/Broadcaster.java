package android.os;

import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/os/Broadcaster.class */
public class Broadcaster {
    private Registration mReg;

    /* loaded from: source-9557208-dex2jar.jar:android/os/Broadcaster$Registration.class */
    private class Registration {
        Registration next;
        Registration prev;
        int senderWhat;
        int[] targetWhats;
        Handler[] targets;

        private Registration() {
        }
    }

    public void broadcast(Message message) {
        synchronized (this) {
            if (this.mReg == null) {
                return;
            }
            int i = message.what;
            Registration registration = this.mReg;
            Registration registration2 = registration;
            while (true) {
                if (registration2.senderWhat < i) {
                    Registration registration3 = registration2.next;
                    registration2 = registration3;
                    if (registration3 == registration) {
                        registration2 = registration3;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (registration2.senderWhat == i) {
                Handler[] handlerArr = registration2.targets;
                int[] iArr = registration2.targetWhats;
                int length = handlerArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    Handler handler = handlerArr[i3];
                    Message obtain = Message.obtain();
                    obtain.copyFrom(message);
                    obtain.what = iArr[i3];
                    handler.sendMessage(obtain);
                    i2 = i3 + 1;
                }
            }
        }
    }

    public void cancelRequest(int i, Handler handler, int i2) {
        synchronized (this) {
            Registration registration = this.mReg;
            Registration registration2 = registration;
            if (registration == null) {
                return;
            }
            while (true) {
                if (registration2.senderWhat < i) {
                    Registration registration3 = registration2.next;
                    registration2 = registration3;
                    if (registration3 == registration) {
                        registration2 = registration3;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (registration2.senderWhat == i) {
                Handler[] handlerArr = registration2.targets;
                int[] iArr = registration2.targetWhats;
                int length = handlerArr.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length) {
                        break;
                    } else if (handlerArr[i4] == handler && iArr[i4] == i2) {
                        registration2.targets = new Handler[length - 1];
                        registration2.targetWhats = new int[length - 1];
                        if (i4 > 0) {
                            System.arraycopy(handlerArr, 0, registration2.targets, 0, i4);
                            System.arraycopy(iArr, 0, registration2.targetWhats, 0, i4);
                        }
                        int i5 = (length - i4) - 1;
                        if (i5 != 0) {
                            System.arraycopy(handlerArr, i4 + 1, registration2.targets, i4, i5);
                            System.arraycopy(iArr, i4 + 1, registration2.targetWhats, i4, i5);
                        }
                    } else {
                        i3 = i4 + 1;
                    }
                }
            }
        }
    }

    public void dumpRegistrations() {
        Registration registration;
        synchronized (this) {
            Registration registration2 = this.mReg;
            System.out.println("Broadcaster " + this + " {");
            if (registration2 != null) {
                Registration registration3 = registration2;
                do {
                    System.out.println("    senderWhat=" + registration3.senderWhat);
                    int length = registration3.targets.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        System.out.println("        [" + registration3.targetWhats[i2] + "] " + registration3.targets[i2]);
                        i = i2 + 1;
                    }
                    registration = registration3.next;
                    registration3 = registration;
                } while (registration != registration2);
                System.out.println(i.d);
            } else {
                System.out.println(i.d);
            }
        }
    }

    public void request(int i, Handler handler, int i2) {
        int i3;
        synchronized (this) {
            try {
                if (this.mReg == null) {
                    Registration registration = new Registration();
                    try {
                        registration.senderWhat = i;
                        registration.targets = new Handler[1];
                        registration.targetWhats = new int[1];
                        registration.targets[0] = handler;
                        registration.targetWhats[0] = i2;
                        this.mReg = registration;
                        registration.next = registration;
                        registration.prev = registration;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } else {
                    Registration registration2 = this.mReg;
                    Registration registration3 = registration2;
                    while (true) {
                        if (registration3.senderWhat < i) {
                            Registration registration4 = registration3.next;
                            registration3 = registration4;
                            if (registration4 == registration2) {
                                registration3 = registration4;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (registration3.senderWhat == i) {
                        int length = registration3.targets.length;
                        Handler[] handlerArr = registration3.targets;
                        int[] iArr = registration3.targetWhats;
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= length) {
                                registration3.targets = new Handler[length + 1];
                                System.arraycopy(handlerArr, 0, registration3.targets, 0, length);
                                registration3.targetWhats = new int[length + 1];
                                System.arraycopy(iArr, 0, registration3.targetWhats, 0, length);
                                i3 = length;
                                break;
                            } else if (handlerArr[i5] == handler && iArr[i5] == i2) {
                                return;
                            } else {
                                i4 = i5 + 1;
                            }
                        }
                    } else {
                        Registration registration5 = new Registration();
                        registration5.senderWhat = i;
                        registration5.targets = new Handler[1];
                        registration5.targetWhats = new int[1];
                        registration5.next = registration3;
                        registration5.prev = registration3.prev;
                        registration3.prev.next = registration5;
                        registration3.prev = registration5;
                        if (registration3 == this.mReg && registration3.senderWhat > registration5.senderWhat) {
                            this.mReg = registration5;
                        }
                        registration3 = registration5;
                        i3 = 0;
                    }
                    registration3.targets[i3] = handler;
                    registration3.targetWhats[i3] = i2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
