package com.better.rntingrrd.di.component;

import android.app.Activity;

import com.better.rntingrrd.di.PerActivity;
import com.better.rntingrrd.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = RntingComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  Activity getActivity();
}
