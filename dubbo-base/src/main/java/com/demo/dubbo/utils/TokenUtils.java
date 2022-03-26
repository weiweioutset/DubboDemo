package com.demo.dubbo.utils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/25 下午9:18
 * @desc token生成工具
 */
public class TokenUtils {
    private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);
    //设置过期时间
    private static final long EXPIRE_DATE = 2*60*60*1000;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2022BQWE";
    // 加密算法
    private static final Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
    /**
     * 根据账号和设备id生成token
     * @param user
     * @return
     */
    public static String generateToken(UserDto user) {
        if (user == null || StringUtil.isEmpty(user.getAccountId())) {
            throw new IllegalArgumentException("user can not be null");
        }
        String token = "";
        // 设置头部信息
        Map<String,Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256");

        token = JWT.create()
                .withHeader(header)
                .withExpiresAt(DateUtils.getFutureTime(EXPIRE_DATE))
                .withClaim("accountId", user.getAccountId())
                .withClaim("userName", user.getUserName())
                .withClaim("userStatus", user.getStatus())
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token是否有效
     * @param token
     * @return
     */
    public static JSONObject verifyToken(String token) {
        if (StringUtil.isEmpty(token)) {
            throw new CommonException(CommonExceptionEnum.TOKEN_INVALID);
        }
        try {
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT jwt = jwtVerifier.verify(token);

            String accountId = jwt.getClaim("accountId").asString();
            String userName = jwt.getClaim("userName").asString();
            String userStatus = jwt.getClaim("userStatus").asString();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("accountId", accountId);
            jsonObject.put("userName", userName);
            jsonObject.put("userStatus", userStatus);
            return jsonObject;
        } catch (Exception e) {
            logger.error("校验token失败", e);
            throw new CommonException(CommonExceptionEnum.TOKEN_INVALID);
        }
    }

    public static void main(String[] args) {
        UserDto userDto = new UserDto();
        userDto.setPassword("weiwei145905");
        userDto.setAccountId("admin");
//        userDto.setUserName("魏巍");
//        userDto.setRealName("魏巍");
//        userDto.setStatus(1);

        System.out.println("token = " + generateToken(userDto));

        verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50SWQiOiJhZG1pbiIsInVzZXJTdGF0dXMiOjEsImV4cCI6MTY0ODI2MDM5MiwidXNlck5hbWUiOiLprY_lt40ifQ.8geJnDHNELN0EYJAvG_jQcpIUXLNTGpX57mheMvs04Y");
    }
}
