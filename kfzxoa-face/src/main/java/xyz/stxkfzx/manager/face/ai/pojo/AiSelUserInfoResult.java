package xyz.stxkfzx.manager.face.ai.pojo;

import java.util.List;

public class AiSelUserInfoResult {
    private List<AiFaceUser> user_list;

    @Override
    public String toString() {
        return "AiSelUserInfoResult{" +
                "user_list=" + user_list +
                '}';
    }

    public List<AiFaceUser> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<AiFaceUser> user_list) {
        this.user_list = user_list;
    }
}
