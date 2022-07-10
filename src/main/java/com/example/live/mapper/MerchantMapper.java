package com.example.live.mapper;

import com.example.live.entity.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/10 13:29
 */
@Mapper
public interface MerchantMapper {

    /**
     * 查询商户列表，包含手机、店铺名、状态条件筛选
     * @param opeUserId
     * @param mobile
     * @param shop
     * @param shopStatus
     * @return
     */
    @Select({"<script>" +
            " SELECT id,mobile,shop,shop_id,shop_status,ope_user,days,login_count,lt,ct FROM `merchant` "
            + " <where>"
            + " ope_user = #{opeUserId}"
            + " <if test=' mobile != null and mobile != \"\"' > AND mobile = #{mobile}</if>"
            + " <if test=' shop != null and shop != \"\"'> AND shop LIKE CONCAT('%',#{shop},'%')</if>"
            + " <if test=' shopStatus != null and shopStatus != \"\" '> AND shop_status = #{shopStatus}</if>"
            + " </where>"
            + " </script> "})
    List<Merchant> getMerchantListByParams(@Param("opeUserId") Integer opeUserId, @Param("mobile")String mobile, @Param("shop") String shop, @Param("shopStatus") String shopStatus);








}
