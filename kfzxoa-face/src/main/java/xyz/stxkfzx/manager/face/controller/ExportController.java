package xyz.stxkfzx.manager.face.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.stxkfzx.manager.face.pojo.FaceResult;
import xyz.stxkfzx.manager.face.pojo.SignItemResult;
import xyz.stxkfzx.manager.face.service.SelService;
import xyz.stxkfzx.manager.face.utils.GetWeek;

@RestController
public class ExportController {

	@Autowired
	private SelService selService;

	@RequestMapping("/export/info")
	public FaceResult exportInfo(int week, String group_id) throws ParseException {

		if (week == 0) {
			week = GetWeek.getWeekNumber();
		}

		List<SignItemResult> selGroupSignItem = selService.selDepartmentSignItem(week, group_id);
		List<Map<String, Object>> resultList = setTableInfo(selGroupSignItem);
		
		return new FaceResult().ok(resultList);
	}
	public List<Map<String, Object>> setTableInfo(List<SignItemResult> selGroupSignItem) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		if (selGroupSignItem != null && selGroupSignItem.size() > 0) {
			for (SignItemResult signItemResult : selGroupSignItem) {
				Map<String, Object> item = new LinkedHashMap<String, Object>();
				item.put("姓名", signItemResult.getUser_info());
				item.put("周一", signItemResult.getWeekMap().get("week1"));
				item.put("周二", signItemResult.getWeekMap().get("week2"));
				item.put("周三", signItemResult.getWeekMap().get("week3"));
				item.put("周四", signItemResult.getWeekMap().get("week4"));
				item.put("周五", signItemResult.getWeekMap().get("week5"));
				item.put("周六", signItemResult.getWeekMap().get("week6"));
				item.put("周日", signItemResult.getWeekMap().get("week7"));
				resultList.add(item);
			}
		}
		return resultList;
	}
}
