package com.example.live.mapper;

import com.example.live.entity.PayConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/9 15:28
 */
@Mapper
public interface UserPayConfigMapper {

    PayConfig getConfig(@Param("userId") int userId);

}
