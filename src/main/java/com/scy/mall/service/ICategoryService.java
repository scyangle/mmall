package com.scy.mall.service;

import com.scy.mall.common.ServerResponse;
import com.scy.mall.pojo.Category;

import java.util.List;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/6
 */
public interface ICategoryService {
    ServerResponse addCagegory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

}
