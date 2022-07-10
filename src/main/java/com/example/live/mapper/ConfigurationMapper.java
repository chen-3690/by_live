package com.example.live.mapper;

import com.example.live.entity.Configuration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/10 9:24
 */
@Mapper
public interface ConfigurationMapper {

    @Select("SELECT `content` FROM configuration WHERE agent_user=#{agentUser} AND type=#{type}")
    String  getConfigStr(@Param("agentUser") Integer agentUser, @Param("type") int type);

}
