package xyz.stxkfzx.manager.face;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.face.request.ReqSearchFaceDb;
import xyz.stxkfzx.manager.face.utils.Base64Util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReqFaceTest {
    @Autowired
    ReqSearchFaceDb reqSearchFaceDb;

    @Test
    public void test(){
        String imgBase64 = null;
        try {
            imgBase64 = Base64Util.getImgBase64("D:\\myData\\IMG_20161018_165444.jpg");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        reqSearchFaceDb.setImgParm(imgBase64);

        reqSearchFaceDb.req();
    }
}
