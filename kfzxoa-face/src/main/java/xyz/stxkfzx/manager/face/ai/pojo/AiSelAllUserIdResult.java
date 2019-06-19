package xyz.stxkfzx.manager.face.ai.pojo;

import java.util.ArrayList;
import java.util.List;

public class AiSelAllUserIdResult {
    private List<String> user_id_list;

    public List<Integer> getUser_id_list() {
        List<Integer> list = new ArrayList<>();
        for(String id : user_id_list){
            list.add(Integer.valueOf(id));
        }
        return list;
    }

    public void setUser_id_list(List<String> user_id_list) {
        this.user_id_list = user_id_list;
    }

    @Override
    public String toString() {
        return "AiSelAllUserIdResult{" +
                "user_id_list=" + user_id_list +
                '}';
    }
}
