package com.better.rntingrrd.di.component;

import com.better.rntingrrd.MainActivity;
import com.better.rntingrrd.MainReplaceActivity;
import com.better.rntingrrd.di.PerActivity;
import com.better.rntingrrd.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by xiashuai on 15:43 2016/7/19.
 * Connection smay1227@163.com.
 */

@PerActivity
@Component(dependencies = RntingComponent.class, modules = {ActivityModule.class })
public interface MainComponent {
	void inject(MainActivity mainActivity);

	void inject(MainReplaceActivity mainReplaceActivity);

}
