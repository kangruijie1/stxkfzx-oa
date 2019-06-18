/**
  * Copyright 2019 bejson.com 
  */
package xyz.stxkfzx.manager.face.ai.pojo;
import java.util.List;

/**
 * Auto-generated: 2019-06-18 20:47:56
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AiFaceUserList {

    private String face_token;
    private AiLocation location;
    private List<AiFaceUser> user_list;
    public void setFace_token(String face_token) {
         this.face_token = face_token;
     }
     public String getFace_token() {
         return face_token;
     }

    public void setLocation(AiLocation location) {
         this.location = location;
     }
     public AiLocation getLocation() {
         return location;
     }

    public void setUser_list(List<AiFaceUser> user_list) {
         this.user_list = user_list;
     }
     public List<AiFaceUser> getUser_list() {
         return user_list;
     }

}