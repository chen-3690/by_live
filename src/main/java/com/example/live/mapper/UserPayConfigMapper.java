package com.example.live.mapper;

import com.example.live.entity.UserPayConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/9 15:28
 */
@Mapper
public interface UserPayConfigMapper {

    UserPayConfig getConfig(@Param("userId") int userId);

}
