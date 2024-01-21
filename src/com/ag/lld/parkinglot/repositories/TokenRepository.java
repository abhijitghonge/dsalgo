package com.ag.lld.parkinglot.repositories;

import com.ag.lld.parkinglot.model.Gate;
import com.ag.lld.parkinglot.model.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TokenRepository {

    private final Map<String, Token> tokenRepo = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(0L);
    public Optional<Token> findTokenByNumber(String tokenNumber){
        return tokenRepo.containsKey(tokenNumber)? Optional.ofNullable(tokenRepo.get(tokenNumber)):Optional.empty();
    }

    public Token save(Token token){
        long id = counter.incrementAndGet();
        token.setId(id);
        token.setNumber("Token:"+id);
        tokenRepo.put(token.getNumber(), token);
        return token;
    }
}
