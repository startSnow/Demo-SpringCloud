package cn.com.enn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class DemoController {
	@Autowired
	private EurekaClient discoveryClient;
	
	
	@ApiOperation("获取服务信息")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code =500, message = "服务器内部异常"),
            @ApiResponse(code = 401, message = "权限不足") })
   // @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "信息id", required = true) })
    @RequestMapping(method = RequestMethod.GET, value = "/eureka-info")
	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("CLIENT", false);
	    return instance.getHomePageUrl();
	}

	@ApiOperation(value="获取用户列表", notes="")
    @ApiImplicitParam(name = "loginName", value = "登录名", required = true, dataType = "String")
    @RequestMapping(value = "/login/{loginName}", method = { RequestMethod.POST })
	public String login(@PathVariable String loginName) {
	return loginName+"恭喜登录成功";
	}
}
