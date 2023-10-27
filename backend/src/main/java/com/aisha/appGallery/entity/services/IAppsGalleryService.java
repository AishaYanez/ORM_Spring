package com.aisha.appGallery.entity.services;

import java.util.List;

import com.aisha.appGallery.entity.models.App;
import com.aisha.appGallery.entity.models.AppsGallery;
import com.aisha.appGallery.entity.models.AppsGalleryKey;

public interface IAppsGalleryService {
	public boolean getStatusApp(AppsGalleryKey id);
	public void putStatusApp(AppsGalleryKey id, boolean favorite);
	public List<App> getAppsByUserId(Long userId);
	public void postNewApp(AppsGallery appGal);
}
