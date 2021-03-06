package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.Picture;
import org.cloud.product.client.service.breaker.PictureServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=PictureServiceBreaker.class)
public interface PictureService {
	
	/**
	 * 根据产品编号获取图片列表
	 * @param proId
	 * @return
	 */
	@RequestMapping(value = "/product/product/picture/list_proid",method=RequestMethod.GET)
	public List<Picture> listByProid(@RequestParam(value="proid",required=true)long proid);
	
	/**
	 * 根据产品编号和类型获取图片列表
	 * @param proid
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/product/product/picture/list_proid_type",method=RequestMethod.GET)
	public List<Picture> listByProidType(@RequestParam(value="proid",required=true)long proid,@RequestParam(value="type",required=true)int type);
	
	/**
	 * 根据编号获取产品图片
	 * @param proid
	 * @return
	 */
	@RequestMapping(value="/product/product/picture/get_picid",method=RequestMethod.GET)
	public Picture getByPicid(@RequestParam(value="picid",required=true)long picid);
	
	/**
	 * 添加产品图片
	 * @param picture
	 */
	@RequestMapping(value="/product/product/picture/add",method=RequestMethod.POST)
	public void add(@RequestBody Picture picture);
	
	/**
	 * 根据产品编号删除图片
	 * @param picid
	 */
	@RequestMapping(value="/product/product/picture/del_picid",method=RequestMethod.DELETE)
	public void delByPicid(@RequestParam(value="picid",required=true)long picid);
	
	/**
	 * 修改产品图片
	 * @param picture
	 */
	@RequestMapping(value="/product/product/picture/upd_picid",method=RequestMethod.PUT)
	public void updByPicid(@RequestBody Picture picture);
}
