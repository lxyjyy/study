package org.wq.spring.spring_mvc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wq.spring.spring_mvc.domain.DemoObj;

/**
 *0. @Controller声明控制器类
 * - 在声明普通Bean时， @Controller @Service @Compoment @Repository 作用等同，因为都组合了@Controller元注解
 * - 但是在Spring MVC中声明控制器的Bean只能用 @Controller
 * @author wq3426
 */
@Controller //0
@RequestMapping("/anno") //请求映射注解，映射此类的访问路径为 /anno
public class DemoAnnoController {

	/**
	 * 1.@RequestMapping 请求映射注解
	 *   - value属性指定访问路径，作用于方法的@RequestMapping会继承作用于类的该注解的路径
	 *   - produces属性指定返回的response的媒体类型和字符集
	 * 2.@ResponseBody 支持将返回值放在response体内而不是返回一个页面，该注解可直接用在方法定义的返回值之前，也可用在方法之上
	 *                 如果返回的是页面，则不能加该注解
	 * 3.可接受HttpServletRequest 或 HttpServletResponse 作为参数
	 * @param request
	 * @return
	 */
	@RequestMapping(produces="text/plain;charset=UTF-8") //1
	public @ResponseBody String index(HttpServletRequest request){ //2 3
		return "url:" + request.getRequestURL() + " can access";
	}
	
	//4.@PathVariable 此注解放在参数前，用来接收路径参数 方位路径为：/anno/pathvar/xx
	@RequestMapping(value="/pathvar/{str}", produces="text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request){// 4
		return "url:" + request.getRequestURL() + " can access, str: " + str;
	}
	
	//5.Long id 常规的request参数解析（基础类型），请求方式为：/anno/requestParam?id=1
	@RequestMapping(value="/requestParam", produces="text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request){// 5
		return "url:" + request.getRequestURL() + " can access, id: " + id;
	}
	
	//6.DemoObj obj 解析参数到对象（引用类型），请求方式为：/anno/obj?id=1&name=wq
	@RequestMapping(value="/obj", produces="application/json;charset=UTF-8")
	@ResponseBody
	public DemoObj passObj(DemoObj obj, HttpServletRequest request){// 6
		System.out.println("url:" + request.getRequestURL() + " can access, obj id: " 
		                   + obj.getId() + " obj name:" + obj.getName());
		return obj;
	}
	
	@RequestMapping(value="/obj2", produces="application/json;charset=UTF-8",
			consumes="application/x-www-form-urlencoded", method=RequestMethod.POST)
	@ResponseBody
	public DemoObj passObj2(@ModelAttribute("obj") DemoObj obj, HttpServletRequest request){// 6
		System.out.println("content-Typt   "+request.getContentType());
		System.out.println("url:" + request.getRequestURL() + " can access, obj id: " 
		                   + obj.getId() + " obj name:" + obj.getName());
		return obj;
	}
	
	//7.value={"/name1", "/name2"} 映射不同的请求路径到相同的方法，请求方式为：/anno/name1 或 /anno/name2
	@RequestMapping(value={"/name1", "/name2"}, produces="text/plain;charset=UTF-8")// 7
	public @ResponseBody String remove(HttpServletRequest request){
		return "url:" + request.getRequestURL() + " can access";
	}
}
