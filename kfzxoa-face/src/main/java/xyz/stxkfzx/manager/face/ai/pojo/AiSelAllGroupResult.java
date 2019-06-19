/**
 * Copyright 2019 bejson.com
 */
package xyz.stxkfzx.manager.face.ai.pojo;

import java.util.List;

/**
 * Auto-generated: 2019-06-19 17:54:16
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AiSelAllGroupResult {

    private List<String> group_id_list;

    public void setGroup_id_list(List<String> group_id_list) {
        this.group_id_list = group_id_list;
    }

    public List<String> getGroup_id_list() {
        return group_id_list;
    }

    @Override
    public String toString() {
        return "AiSelAllGroupResult{" +
                "group_id_list=" + group_id_list +
                '}';
    }
}