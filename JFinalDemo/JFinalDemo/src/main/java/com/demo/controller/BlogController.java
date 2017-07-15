package com.demo.controller;

import com.demo.interceptor.BlogInterceptor;
import com.demo.service.BlogService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {

	static BlogService service = new BlogService();

	public void index() {
    //以json形式返回数据
		renderJson(service.paginate(getParaToInt(0, 1), 10));
	}

}


