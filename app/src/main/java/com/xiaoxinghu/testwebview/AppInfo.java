package com.xiaoxinghu.testwebview;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/**
 * Des:
 * Created by huang on 2019/4/24 0024 17:59
 */
public class AppInfo {
    private String packageName; //包名
    private Drawable ico;       //图标
    private String Name;        //应用标签
    private Intent intent;     //启动应用程序的Intent ，一般是Action为Main和Category为Lancher的Activity

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getIco() {
        return ico;
    }

    public void setIco(Drawable ico) {
        this.ico = ico;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
