package com.fourteen.Q1797;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/2/9 9:11
 */
public class Solution {
}

class AuthenticationManager {

    private Integer time;

    private Map<String, Integer> token;

    public AuthenticationManager(int timeToLive) {
        this.time = timeToLive;
        this.token = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        this.token.put(tokenId, currentTime + this.time);
    }

    public void renew(String tokenId, int currentTime) {
        if (this.token.containsKey(tokenId)) {
            if (this.token.get(tokenId) > currentTime) {
                this.token.put(tokenId, currentTime + this.time);
            } else {
                this.token.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) this.token.values().stream().filter(integer -> integer > currentTime).count();
    }
}