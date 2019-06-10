package xyz.stxkfzx.manager.face.controller;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.utils.*;
import java.util.*;
import xyz.stxkfzx.manager.face.pojo.*;
import java.text.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class SelController {
	@Autowired
	private SelService selService;

	@RequestMapping({ "/sel/group" })
	public FaceResult selGroupUsers(int week, String group_id) throws ParseException {
		Map<String, Object> resultData = new HashMap<String, Object>();
		if (week == 0) {
			week = GetWeek.getWeekNumber();
		}
		resultData.put("week", week);
		List<SignItemResult> signItemResultList = selService.selDepartmentSignItem(week, group_id);
		resultData.put("signItemList", signItemResultList);
		setDepartment(resultData, group_id);
		FaceResult ok = new FaceResult().ok(resultData);
		
		return ok;
	}

	public void setDepartment(Map<String, Object> map, String group_id) {
		if (group_id.equals("0601")) {
			map.put("department", "\u516d\u671f\u8f6f\u4ef6");
		} else if (group_id.equals("0602")) {
			map.put("department", "\u516d\u671fUI");
		} else if (group_id.equals("0701")) {
			map.put("department", "\u4e03\u671f\u8f6f\u4ef6");
		} else if (group_id.equals("0702")) {
			map.put("department", "\u4e03\u671fUI");
		} else if (group_id.equals("0703")) {
			map.put("department", "\u4e03\u671f\u786c\u4ef6");
		} else if (group_id.equals("0801")) {
			map.put("department", "\u516b\u671f\u8f6f\u4ef6");
		} else if (group_id.equals("0802")) {
			map.put("department", "\u516b\u671fUI");
		} else if (group_id.equals("0803")) {
			map.put("department", "\u516b\u671f\u786c\u4ef6");
		}
	}
}
