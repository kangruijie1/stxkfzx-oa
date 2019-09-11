package xyz.stxkfzx.manager.face;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.controller.ManagerController;
import xyz.stxkfzx.manager.face.utils.GsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerControllerTest extends ManagerController {

    @Test
    public void test(){
        System.out.println("=============1");
        FaceResult faceResult = exportInfo("2019-5-1", "2019-06-30", "0601");
        String s = GsonUtils.toJson(faceResult);
        System.out.println(s);
    }
}
