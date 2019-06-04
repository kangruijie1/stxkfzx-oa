package xyz.stxkfzx.manager.face.pojo;

import java.util.*;

public class FaceUserResultUserListFinal
{
    private List<FaceUserResultFaceUser> user_list;
    
    public FaceUserResultUserListFinal() {
    }
    
    public FaceUserResultUserListFinal(final List<FaceUserResultFaceUser> user_list) {
        this.user_list = user_list;
    }
    
    public List<FaceUserResultFaceUser> getUser_list() {
        return this.user_list;
    }
    
    public void setUser_list(final List<FaceUserResultFaceUser> user_list) {
        this.user_list = user_list;
    }
    
    public String toString() {
        return "FaceUserResultUserListFinal [user_list=" + this.user_list + "]";
    }
}
