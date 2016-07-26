package com.better.rntingrrd.di.component;

import com.better.rntingrrd.di.PerActivity;
import com.better.rntingrrd.di.module.ActivityModule;
import com.better.rntingrrd.ui.activity.Login;

import dagger.Component;

@PerActivity
@Component(dependencies = RntingComponent.class, modules = {ActivityModule.class })
public interface LoginComponent {
  void inject(Login login);
}
