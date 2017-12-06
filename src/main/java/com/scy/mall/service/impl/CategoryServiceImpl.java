package com.scy.mall.service.impl;

import com.scy.mall.common.ServerResponse;
import com.scy.mall.dao.CategoryMapper;
import com.scy.mall.pojo.Category;
import com.scy.mall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/6
 */
@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ServerResponse addCagegory(String categoryName, Integer parentId) {
        if (parentId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("添加品类参数错误");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setId(parentId);
        category.setStatus(true);
        int count = categoryMapper.insert(category);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加品类成功");
        }
        return ServerResponse.createByErrorMessage("添加品类失败");
    }

    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        if (categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("更新品类参数错误");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        int count = categoryMapper.updateByPrimaryKeySelective(category);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新商品名字成功");
        }else{
            return ServerResponse.createByErrorMessage("更新商品名字失败");
        }
    }
}
