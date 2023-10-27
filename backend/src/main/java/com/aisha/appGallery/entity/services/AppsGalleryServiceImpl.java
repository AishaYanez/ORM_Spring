package com.aisha.appGallery.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aisha.appGallery.entity.dao.IAppsGalleryDao;
import com.aisha.appGallery.entity.models.AppsGalleryKey;
import com.aisha.appGallery.entity.models.App;
import com.aisha.appGallery.entity.models.AppsGallery;
import org.springframework.stereotype.Service;

@Service
public class AppsGalleryServiceImpl implements IAppsGalleryService{
	
	@Autowired
	private IAppsGalleryDao appsGalleryDao;
	
	@Override
	public boolean getStatusApp(AppsGalleryKey id) {
		 AppsGallery appGallery = appsGalleryDao.findById(id).get();
		 return appGallery.getFavorite();
	}

	@Override
	public void putStatusApp(AppsGalleryKey id, boolean favorite) {
		appsGalleryDao.findById(id).ifPresent(x -> {
			x.setFavorite(favorite);
			appsGalleryDao.save(x);
		});
	}
	
	@Override
	public List<App> getAppsByUserId(Long userId) {
        return appsGalleryDao.findAppsByUserId(userId);
    }

	@Override
	public void postNewApp(AppsGallery appGal) {
		appsGalleryDao.save(appGal);		
	}
}
