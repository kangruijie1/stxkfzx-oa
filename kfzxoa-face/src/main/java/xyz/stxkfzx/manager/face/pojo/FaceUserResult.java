package xyz.stxkfzx.manager.face.pojo;

import java.util.*;

public class FaceUserResult
{
    private List<FaceUserResultFace> face_list;
    private String face_num;
    
    public FaceUserResult() {
    }
    
    public FaceUserResult(final List<FaceUserResultFace> face_list, final String face_num) {
        this.face_list = face_list;
        this.face_num = face_num;
    }
    
    public List<FaceUserResultFace> getFace_list() {
        return this.face_list;
    }
    
    public void setFace_list(final List<FaceUserResultFace> face_list) {
        this.face_list = face_list;
    }
    
    public String getFace_num() {
        return this.face_num;
    }
    
    public void setFace_num(final String face_num) {
        this.face_num = face_num;
    }
    
    public String toString() {
        return "FaceUserResult [face_list=" + this.face_list + ", face_num=" + this.face_num + "]";
    }
}
