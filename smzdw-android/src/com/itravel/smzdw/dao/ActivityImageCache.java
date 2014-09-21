package com.itravel.smzdw.dao;

import java.util.concurrent.ExecutionException;

import android.graphics.Bitmap;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public final class ActivityImageCache {

	private final LoadingCache<String, Bitmap> imageCache;
	
	private final ImageDao dao = new ImageDao();

	private ActivityImageCache() {
		imageCache = CacheBuilder.newBuilder().build(
				new CacheLoader<String, Bitmap>() {
					@Override
					public Bitmap load(String arg0) throws Exception {
						Bitmap map = dao.getActivityImage(arg0);
						if(map==null){
							throw new Exception("");
						}
						return map;
					}
				}

		);
	}
	
	private static final class ActivityImageCacheHolder {
		private static final ActivityImageCache cache = new ActivityImageCache();
	}
	
	public static ActivityImageCache getInstance(){
		return ActivityImageCacheHolder.cache;
	}
	
	public Bitmap get(String uri) throws ExecutionException{
		return imageCache.get(uri);
	}
	

}
