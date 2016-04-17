package com.yangjianzhou.controller;

import com.yangjianzhou.bean.ProductDTO;
import com.yangjianzhou.bean.ResultGson;
import com.yangjianzhou.service.AppRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by yangjianzhou on 16-4-17.
 */

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private AppRemoteService appRemoteService;

    @RequestMapping("get-all")
    public String getProducts() throws Exception {
        ResultGson<List<ProductDTO>> resultGson = appRemoteService.getAllProducts();

        return "success";
    }
}
