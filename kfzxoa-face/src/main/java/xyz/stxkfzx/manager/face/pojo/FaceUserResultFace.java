package xyz.stxkfzx.manager.face.pojo;

import java.util.*;

public class FaceUserResultFace
{
    private String face_token;
    private FaceUserResultFaceLocaltion location;
    private List<FaceUserResultFaceUser> user_list;
    
    public FaceUserResultFace() {
    }
    
    public FaceUserResultFace(final String face_token, final FaceUserResultFaceLocaltion location, final List<FaceUserResultFaceUser> user_list) {
        this.face_token = face_token;
        this.location = location;
        this.user_list = user_list;
    }
    
    public String getFace_token() {
        return this.face_token;
    }
    
    public void setFace_token(final String face_token) {
        this.face_token = face_token;
    }
    
    public FaceUserResultFaceLocaltion getLocation() {
        return this.location;
    }
    
    public void setLocation(final FaceUserResultFaceLocaltion location) {
        this.location = location;
    }
    
    public List<FaceUserResultFaceUser> getUser_list() {
        return this.user_list;
    }
    
    public void setUser_list(final List<FaceUserResultFaceUser> user_list) {
        this.user_list = user_list;
    }
    
    public String toString() {
        return "FaceUserResultFace [face_token=" + this.face_token + ", location=" + this.location + ", user_list=" + this.user_list + "]";
    }
}
