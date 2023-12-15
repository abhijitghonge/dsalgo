package com.ag.lld.patterns.flyweight.particles;

import com.ag.lld.patterns.flyweight.ParticleBase;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaseBullet implements ParticleBase {

    private static BaseBullet INSTANCE;

    private static Lock lock = new ReentrantLock();

    private String color;
    private String image;
    private BaseBullet(String color, String image) {
        this.color = color;
        this.image = image;
    }

    public static BaseBullet getInstance(){
        if(Objects.isNull(INSTANCE)){
            lock.lock();
            if(Objects.isNull(INSTANCE)){
                INSTANCE = new BaseBullet("Grey", "Bullet Image");
            }
            lock.unlock();
        }

        return INSTANCE;
    }


    @Override
    public String toString() {
        return "BaseBullet{" +
                "color='" + color + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
