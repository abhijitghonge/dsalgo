package com.ag.lld.patterns.flyweight;


import com.ag.lld.patterns.flyweight.particles.BaseBullet;
import com.ag.lld.patterns.flyweight.particles.Bullet;

import static com.ag.lld.patterns.flyweight.ParticleType.*;

public class Main {
    public static void main(String[] args) {
        GameRegistry registry = new GameRegistry();
        registry.addParticle(BULLET, BaseBullet.getInstance());
        Particle bullet = new Bullet(registry.getParticle(BULLET));

        bullet.move(1,1,4,5);

    }
}
