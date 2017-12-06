package com.scy.mall.service;

import com.scy.mall.common.ServerResponse;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/6
 */
public interface ICategoryService {
    ServerResponse addCagegory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
}
