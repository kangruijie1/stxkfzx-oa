package xyz.stxkfzx.manager.face.mapper;

import org.apache.ibatis.annotations.*;
import xyz.stxkfzx.manager.user.pojo.TSignItem;

import java.util.*;

public interface SignItemMapper
{
    void insertSignItem(TSignItem p0);
    
    List<TSignItem> selSignItem(@Param("uid") int p0, @Param("startTime") String p1, @Param("endTime") final String p2);
    
    void updateSignItem(@Param("item") TSignItem p0, @Param("todayStart") String p1, @Param("todayEnd") final String p2);
    
    void deleteSignout(final int p0);
}
