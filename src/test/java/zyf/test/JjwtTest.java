package zyf.test;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import zyf.util.JwtUtil;

/**
* @Author 庄元丰
* @CreateTime 2017年11月23日下午2:14:12
*/
public class JjwtTest {
	
	@Test
	public void testJwtString() {
		Key key = MacProvider.generateKey();
		System.out.println(key.getEncoded());
		String jwtString = Jwts.builder().setSubject("zyf")
				.signWith(SignatureAlgorithm.HS512, key).compact();
		
		System.out.println(jwtString);
		
		String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtString).getBody().getSubject();
		System.out.println(subject);
	}
	
	@Test
	public void testJwtUtil() {
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put("name", "zyf");
		map.put("girlFriend", "zy");
		map.put("nickName", "尖叫的喜鹊");
		
		String token = JwtUtil.getJwtString(map, 100000000L);
		System.out.println(token);
		Map<String, Object> result = JwtUtil.parseToken(token);
		System.out.println(result);
	}
}
