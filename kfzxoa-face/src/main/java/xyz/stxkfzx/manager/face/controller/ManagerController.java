package xyz.stxkfzx.manager.face.controller;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.config.DepartmentMapping;
import xyz.stxkfzx.manager.face.pojo.SignItemResult;
import xyz.stxkfzx.manager.face.pojo.SignItemResultVo;
import xyz.stxkfzx.manager.face.service.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.face.utils.GetWeek;

import java.util.List;

@RestController
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private SelSignService selSignService;
	@Autowired
	DepartmentMapping departmentMapping;

	@GetMapping( "/manager/sel/sign" )
	public FaceResult selDepartmentUsers(@RequestParam("week") int week,
										 @RequestParam("departmentId") String departmentId)  {
		if (week == 0) {
			week = GetWeek.getWeekNumber();
		}
		List<SignItemResult> signItemResultList = selSignService.selDepartmentSignItem(week, departmentId);

		SignItemResultVo vo = new SignItemResultVo();
		vo.setWeek(week);
		vo.setDepartment(departmentMapping.getMap().get(departmentId));
		vo.setSignItemList(signItemResultList);

		return new FaceResult().ok(vo);
	}
	@RequestMapping({ "/manager/xiaotiantian/sign" })
	public FaceResult smallSweet(String user_info) throws InterruptedException {
		return managerService.mustSign(user_info);
	}
}
