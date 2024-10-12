package org.example.cyberguardianbackend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.cyberguardianbackend.enums.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtUtil {

    public static final String SECRET = "413F4428472B4B6250655368566D5970337336763979244226452948404D6351";

    public String generateToken(String userName, List<UserRole> roles) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roleStrings = roles.stream().map(Enum::name).toList();
        claims.put("roles", roleStrings);
        return createToken(claims, userName);
    }

    private String createToken (Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration (new Date(System.currentTimeMillis() + 10000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim (token, Claims::getSubject);
    }

    public <T> T extractClaim (String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims (String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws (token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration (token).before(new Date());
    }

    public Date extractExpiration (String token) {
        return extractClaim (token, Claims::getExpiration);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired (token));
    }

    public List<String> extractRoles(String token) {
        Object rolesObj = extractClaim(token, claims -> claims.get("roles")); // Extract roles from claims
        if (rolesObj instanceof List<?>) {
            // Safely cast to List<String>
            List<String> roles = new ArrayList<>();
            for (Object role : (List<?>) rolesObj) {
                if (role instanceof String) {
                    roles.add((String) role);
                }
            }
            return roles;
        }
        return Collections.emptyList(); // Return an empty list if the object is not a List
    }

}
