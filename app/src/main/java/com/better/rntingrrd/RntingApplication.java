package com.better.rntingrrd;

import android.app.Application;

import com.better.rntingrrd.di.component.DaggerRntingComponent;
import com.better.rntingrrd.di.component.RntingComponent;
import com.better.rntingrrd.di.module.RntingModule;

/**
 * Created by 夏帅 on 2016/7/17.
 * Connection smay1227@163.com.
 */
public class RntingApplication extends Application{

    private RntingComponent rntingComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    private void initComponent(){
        rntingComponent = DaggerRntingComponent.builder()
                .rntingModule(new RntingModule(this))
                .build();
        rntingComponent.inject(this);
    }

    public RntingComponent getApplicationComponent(){
        return rntingComponent;
    }

}
