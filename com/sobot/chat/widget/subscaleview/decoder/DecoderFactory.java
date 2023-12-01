package com.sobot.chat.widget.subscaleview.decoder;

import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/subscaleview/decoder/DecoderFactory.class */
public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
