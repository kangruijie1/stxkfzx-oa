package xyz.stxkfzx.manager.face.service;

import java.util.*;

import com.besjon.pojo.AiFaceUser;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.io.*;

public interface FaceService
{
    List<AiFaceUser> searchMulti(final String p0);
    
    FaceResult sign(final List<AiFaceUser> p0, final String p1);
    
    /*SignResult signOut(final List<AiFaceUser> p0, final String p1);*/
    
    List<TUser> batchAddFace(final String p0) throws UnsupportedEncodingException;
}
