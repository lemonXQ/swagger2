package com.tit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tit.entity.Person;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

//http://localhost:9090/swagger-ui.html
@RestController
@RequestMapping("/User")
public class UserController {
	
	
	@ApiOperation(value="创建用户!!!s",notes="根据User对象创建用户")
	@ApiImplicitParam(name="person",value="用户对象person",required=true,dataType="Person")
	@RequestMapping(value="",method=RequestMethod.POST)
	public String postUser(@RequestBody Person person){
		System.out.println(person);
		return "postUser";
	}
	
	
	//paramType="path" 否则默认参数会从body获取
	@ApiOperation(value="删除用户",notes="根据URL中的id删除用户")
	@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Integer",paramType="path")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer id){
		System.out.println(id);
		return "deleteUser";
	}
	
	
	@ApiOperation(value="修改用户详细信息",notes="根据传来的user信息来更新用户详细信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="person",value="用户详细实体person",required=true,dataType="Person")
	})
	@RequestMapping(value="",method=RequestMethod.PUT)
	public String putUser(@RequestBody Person person){
		System.out.println(person);
		return "putUser";
	}
	
	
	//paramType="path" 否则默认参数会从body获取
	@ApiOperation(value="根据id获取用户信息!!",notes="根据URL中的id获取用户信息")
	@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Integer",paramType="path")
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getById(@PathVariable Integer id){
		System.out.println(id);
		return "getById";
	}
	
	
	@ApiOperation(value="获取用户信息列表",notes="")
	@RequestMapping(value="userList",method=RequestMethod.GET)
	public List<Person> userList(){
		List<Person> list = new ArrayList<Person>();
		return list;
	}
}
