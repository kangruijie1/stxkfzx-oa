package xyz.stxkfzx.manager.face.service;

import java.util.*;

import com.besjon.pojo.User_list;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.io.*;

public interface FaceService
{
    List<User_list> searchMulti(final String p0);
    
    FaceResult sign(final List<User_list> p0, final String p1);
    
    /*SignResult signOut(final List<User_list> p0, final String p1);*/
    
    List<TUser> batchAddFace(final String p0) throws UnsupportedEncodingException;
}
