package cn.edu.bistu.cs.se.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;





public class BaseController {



	
	
	/**
	 * 获取基于应用程序的url绝对路径
	 * 
	 * @param request
	 * @param url
	 *            以"/"打头的URL地址
	 * @return 基于应用程序的url绝对路径
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}
}