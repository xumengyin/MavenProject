package com.xu.mybatis.mappers;

import com.xu.pojo.Player;
import com.xu.pojo.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface VideoMapper {
    List<Video> getVideos();

    @Select("select * from videos")
    List<Video> getVideosbyAni();

    int updateVideo(Map<String,Integer> map);

    int deleteVideo(@Param("id") int id);
    List<Video> getVideosLimit(Map<String,Integer> map);

    Player getPlayer(@Param("id") int id);

    List<Player> getPlayers(Map<String,String> map);


    int insetData(@Param("name")String name,@Param("path") String path);
}
