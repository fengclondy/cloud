package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.AttGroup;
import org.cloud.product.client.model.Property;
import org.cloud.product.client.service.AttGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/category/attribute/attGroup")
public class AttGroupController {
	
	@Autowired
	private AttGroupService attGroupService;
	
	@ApiOperation(value="根据类目编号获取属性组集合")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long")})
	@RequestMapping(value="/list_catid",method=RequestMethod.POST)
	public Result<List<AttGroup>> list_catid(@RequestParam(value="catid",required=true)long catid){
		List<AttGroup> attGroups=attGroupService.listByCatid(catid);
		return new Result<List<AttGroup>>(200,null,attGroups);
	}
	
	@ApiOperation(value="根据类目编号获取属性组及属性组以下的属性列表及属性值列表")
	@ApiImplicitParams({@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long")})
	@RequestMapping(value="/list_attributes_attValues_catid",method=RequestMethod.POST)
	public Result<List> list_attributes_attValues_catid(@RequestParam(value="catid",required=true) long catid){
		List<Map<String,List<Object>>> attGroupsAttibutesAttValues=attGroupService.listAttributesAttValuesByCatid(catid);
		return new Result<List>(200,null,attGroupsAttibutesAttValues);
	}
	
	@ApiOperation(value="根据产品编号获取产品属性组及属性组的产品属性")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long")})
	@RequestMapping(value="/list_propertys_proid",method=RequestMethod.POST)
	public Result<Map> list_propertys_proid(@RequestParam(value="proid",required=true)long proid){
		Map<String,List<Property>> attGroupPropertys=attGroupService.listPropertysByProid(proid);
		return new Result<Map>(200,null,attGroupPropertys);
	}
	
	@ApiOperation(value="添加属性组")
	@ApiImplicitParams({
		@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性组名称",required=true,dataType="String")
	})
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public Result<Object> add(@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="name",required=true)String name){
		AttGroup attGroup=new AttGroup();
		attGroup.setCatid(catid);
		attGroup.setName(name);
		attGroupService.add(attGroup);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据属性组编号修改属性组名称")
	@ApiImplicitParams({@ApiImplicitParam(name="groid",value="属性组编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="属性组名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_groid",method={RequestMethod.POST})
	public Result<Object> upd_groid(@RequestParam(value="groid",required=true)long groid,
			@RequestParam(value="name",required=true)String name){
		AttGroup attGroup=attGroupService.getByGroid(groid);
		if(!ValidUtil.isValid(attGroup)){
			return null;
		}
		attGroup.setName(name);
		attGroupService.updByGroid(attGroup);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="删除属性组，并且级联删除以下所有属性")
	@ApiImplicitParams({@ApiImplicitParam(name="groid",value="属性组编号",required=true,dataType="long")})
	@RequestMapping(value="/del_groid",method={RequestMethod.POST})
	public Result<Object> del_groid(@RequestParam(value="groid")long groid){
		attGroupService.delByGroid(groid);
		return new Result<Object>(200,null,null);
	}
}
