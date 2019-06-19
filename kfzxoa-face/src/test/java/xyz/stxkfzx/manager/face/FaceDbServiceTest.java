package xyz.stxkfzx.manager.face;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.face.service.FaceDbService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FaceDbServiceTest {
    @Autowired
    FaceDbService faceDbService;

    @Test
    public void test(){
        int groupLastUserId = faceDbService.getGroupLastUserId("0601");
        System.out.println(groupLastUserId);
    }
}
