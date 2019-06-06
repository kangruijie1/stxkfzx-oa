/**
 * Copyright 2019 bejson.com
 */
package com.besjon.pojo;

import java.util.List;

/**
 * Auto-generated: 2019-06-02 15:20:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AiFaceUserList {

    private String face_token;
    private AiLocation location;
    private List<AiFaceUser> face_list;

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

    public List<AiFaceUser> getFace_list() {
        return face_list;
    }

    public void setFace_list(List<AiFaceUser> face_list) {
        this.face_list = face_list;
    }

    @Override
    public String toString() {
        return "AiFaceUserList{" +
                "face_token='" + face_token + '\'' +
                ", location=" + location +
                ", face_list=" + face_list +
                '}';
    }
}