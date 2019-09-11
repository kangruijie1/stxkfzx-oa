package xyz.stxkfzx.manager.face.controller;

import org.springframework.util.CollectionUtils;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.config.DepartmentMapping;
import xyz.stxkfzx.manager.face.pojo.SignItemResult;
import xyz.stxkfzx.manager.face.pojo.SignItemResultVo;
import xyz.stxkfzx.manager.face.service.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.common.utils.GetWeek;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private SelSignService selSignService;
    @Autowired
    DepartmentMapping departmentMapping;

    @GetMapping("/manager/sel/department/week/sign")
    public FaceResult selDepartmentUsers(@RequestParam("week") int week,
                                         @RequestParam("departmentId") String departmentId) {
        if (week == 0) {
            week = GetWeek.getHowWeek();
        }
        String startTime = GetWeek.getWeekStartEndDate(week).get(0);
        String endTime = GetWeek.getWeekStartEndDate(week).get(1);

        List<SignItemResult> signItemResultList = selSignService.selDepartmentSignItem(startTime, endTime, departmentId);

        SignItemResultVo vo = new SignItemResultVo();
        vo.setWeek(week);
        vo.setDepartment(departmentMapping.getMap().get(departmentId));
        vo.setSignItemList(signItemResultList);

        return new FaceResult().ok(vo);
    }

    @GetMapping("manager/export/department/sign")
    public FaceResult exportInfo(String startTime, String endTime, String departmentId) {
        List<SignItemResult> selGroupSignItem = selSignService.selDepartmentSignItem(startTime, endTime, departmentId);
        List<Map<String, Object>> resultList = setTableInfo(startTime, endTime, selGroupSignItem);

        return new FaceResult().ok(resultList);
    }

    public List<Map<String, Object>> setTableInfo(String startTime, String endTime, List<SignItemResult> selGroupSignItem) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        if (!CollectionUtils.isEmpty(selGroupSignItem)) {
            for (SignItemResult signItemResult : selGroupSignItem) {
                String temp = startTime;
                Map<String, Object> item = new LinkedHashMap<String, Object>();

                item.put("姓名", signItemResult.getUsername());
                String value = null;
                String valuePre = "day";
                int valueSu = 1;
                while (!temp.equals(endTime)) {
					/*String key = temp + "\n"
                            + GetWeek.getHowWeek(temp) + "周\n"
                            + "周" + GetWeek.getWeekNumber(temp);*/
                    String key = temp.substring(temp.indexOf("-")+1).replace("-", ".");
                    value = valuePre +String.valueOf(valueSu++);
                    item.put(key, signItemResult.getDayMap().get(value));
                    temp = GetWeek.dateAddDay(temp);
                }
                resultList.add(item);
            }
        }
        return resultList;
    }

    @RequestMapping({"/manager/xiaotiantian/sign"})
    public FaceResult smallSweet(String user_info) {
        return managerService.mustSign(user_info);
    }
}
