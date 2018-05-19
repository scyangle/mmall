package com.scy.mall.service;

import com.scy.mall.common.ServerResponse;
import com.scy.mall.pojo.Product;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2018/5/19
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
}
