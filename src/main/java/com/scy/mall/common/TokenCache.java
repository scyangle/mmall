package com.scy.mall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TokenCache {
    private static final Logger logger = LoggerFactory.getLogger(TokenCache.class);
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().expireAfterAccess(12, TimeUnit.HOURS)
            .initialCapacity(1000).maximumSize(10000).build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    public static void setKey(String key, String value) {
        localCache.put(key, value);
    }

    public static String getKey(String key) {
        String result = null;
        try {
            result = localCache.get(key);
            if ("null".equals(result)) {
                return null;
            }
        } catch (ExecutionException e) {
            logger.error("localcache get error",e);
            return null;
        }
        return result;
    }
}
