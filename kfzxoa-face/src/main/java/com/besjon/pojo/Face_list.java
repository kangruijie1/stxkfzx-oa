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
public class Face_list {

	private String face_token;
    private Location location;
    private List<User_list> user_list;
    public void setFace_token(String face_token) {
         this.face_token = face_token;
     }
     public String getFace_token() {
         return face_token;
     }

    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setUser_list(List<User_list> user_list) {
         this.user_list = user_list;
     }
     public List<User_list> getUser_list() {
         return user_list;
     }

     @Override
     public String toString() {
    	 return "Face_list [face_token=" + face_token + ", location=" + location + ", user_list=" + user_list + "]";
     }
}