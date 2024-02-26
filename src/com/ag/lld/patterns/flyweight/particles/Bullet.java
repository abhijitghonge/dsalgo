package com.ag.lld.patterns.flyweight.particles;

import com.ag.lld.patterns.flyweight.Particle;
import com.ag.lld.patterns.flyweight.ParticleBase;

public class Bullet implements Particle {
    private final ParticleBase bulletBase;

    public Bullet(ParticleBase bulletBase){
        this.bulletBase = bulletBase;
    }

    public Bullet(Bullet bullet){
        super();
        this.bulletBase = bullet.bulletBase;
    }

    @Override
    public Bullet clone() throws CloneNotSupportedException {
        super.clone();
        return new Bullet(this);
    }


    @Override
    public void move(int x1, int y1, int x2, int y2) {
        System.out.printf("Moving from [%d, %d] to [%d, %d] having color:[%s]%n", x1, y1, x2, y2, bulletBase.toString());
    }
}
