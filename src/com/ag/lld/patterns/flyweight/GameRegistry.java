package com.ag.lld.patterns.flyweight;

import com.ag.lld.patterns.flyweight.particles.BaseBullet;

import java.util.EnumMap;

public class GameRegistry {
    private EnumMap<ParticleType, ParticleBase> register ;

    public GameRegistry(){
        register = new EnumMap<>(ParticleType.class);
    }

    public void addParticle(ParticleType bulletType, BaseBullet instance) {
        register.put(bulletType, instance);
    }

    public ParticleBase getParticle(ParticleType bulletType) {
        return register.get(bulletType);
    }
}
