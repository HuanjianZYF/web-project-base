package zyf.util;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import zyf.helper.Result;
import zyf.helper.ResultCodeEnum;

/**
* @Author 庄元丰
* @CreateTime 2017年12月7日下午3:18:41
*/
public class JwtUtil {
	
	/**
	 * token版本
	 */
	public static final String VERSION = "1.0";
	
	/**
	 * token的发行人
	 */
	public static final String ISSUER = "jwt_zyf";
	
	/**
	 * 签名算法
	 */
	public static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
	
	/**
	 * 私钥
	 */
	public static final String HS_256_KEY = "zyf&love&zy";
	
	/**
	 * 签名key
	 */
	private static final Key SIGN_KEY = new SecretKeySpec(HS_256_KEY.getBytes(), SIGNATURE_ALGORITHM.getJcaName());
	
	/**
	 * 生成token
	 */
	public static String getJwtString(Map<String, Object> claims, Long invalidTime) {
		long now = System.currentTimeMillis(); 
		
		claims.put(Claims.ID, VERSION);
		claims.put(Claims.ISSUER, ISSUER);
		claims.put(Claims.ISSUED_AT, new Date(now));
		if (invalidTime != null) {
			claims.put(Claims.EXPIRATION, new Date(now + invalidTime));
		}
		
		JwtBuilder jwtBuilder = Jwts.builder().setClaims(claims);
		jwtBuilder.signWith(SIGNATURE_ALGORITHM, SIGN_KEY);
		
		return jwtBuilder.compact();
	}
	
	/**
	 * 解析token
	 */
	public static Map<String, Object> parseToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(token).getBody();
		return claims ;
	}
	
	/**
	 * 验证token是否有效
	 */
	public static Result<Void> validateToken(String token) {
		try {
			Claims claims = Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(token).getBody();
			Long expireTime = (Long)claims.get(Claims.EXPIRATION);
			if (expireTime == null || expireTime > System.currentTimeMillis()) {
				return ResultUtil.buildSuccessResult();
			}
			
			return ResultUtil.buildFailResult(ResultCodeEnum.EXPIRE_TOKRN);
		} catch (SignatureException e) {
			return ResultUtil.buildFailResult(ResultCodeEnum.INVALID_TOKRN);
		}
	}
	
}
