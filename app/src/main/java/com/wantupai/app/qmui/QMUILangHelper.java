package com.wantupai.app.qmui;


import android.support.annotation.Nullable;

import java.io.Closeable;
import java.io.IOException;


public class QMUILangHelper {

    public static boolean isNullOrEmpty(@Nullable CharSequence string) {
        return string == null || string.length() == 0;
    }

    public static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
