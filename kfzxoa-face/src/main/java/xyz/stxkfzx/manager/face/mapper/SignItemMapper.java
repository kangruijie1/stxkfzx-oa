package xyz.stxkfzx.manager.face.mapper;

import org.apache.ibatis.annotations.*;
import xyz.stxkfzx.manager.face.pojo.TSignItem;
import xyz.stxkfzx.manager.face.pojo.TSignItemNew;

import java.util.*;

public interface SignItemMapper
{
    int insertSignItem(TSignItemNew item);
    
    List<TSignItemNew> selSignItemNew(@Param("userId") Integer userId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int updateSignItem(@Param("item") TSignItemNew item, @Param("todayStart") String todayStart, @Param("todayEnd") final String todayEnd);
    
}
