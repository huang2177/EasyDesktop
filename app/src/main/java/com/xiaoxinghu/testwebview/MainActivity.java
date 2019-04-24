package com.xiaoxinghu.testwebview;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView topRecycle;
    private RecyclerView bottomRecycle;

    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTopRecycle();
        initBottomRecycle();
        //setBackground();

//        Desktop desktop=new Desktop(this);
//        desktop.getDefaultHome();
    }

    private void setBackground() {
        root = findViewById(R.id.root);
        WallpaperManager manager = WallpaperManager.getInstance(this);
        Drawable drawable = manager.getDrawable();
        root.setBackground(drawable);
    }

    private void initTopRecycle() {
        topRecycle = findViewById(R.id.top_recycle);

//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        topRecycle.setLayoutManager(manager);
//        LinearSnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.attachToRecyclerView(topRecycle);

        GridLayoutManager manager = new GridLayoutManager(this, 4);
        topRecycle.setLayoutManager(manager);

        List<AppInfo> list = AppInfoUtil.getCateApps(this, 1);
        AppAdapter appAdapter = new AppAdapter();
        appAdapter.notifyDataChange(list);

        topRecycle.setAdapter(appAdapter);
    }

    private void initBottomRecycle() {
        bottomRecycle = findViewById(R.id.bottom_recycle);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        bottomRecycle.setLayoutManager(manager);

        List<AppInfo> list = AppInfoUtil.getCateApps(this, 0);
        AppAdapter appAdapter = new AppAdapter();
        appAdapter.notifyDataChange(list);

        bottomRecycle.setAdapter(appAdapter);
    }
}
