package jp.yattom.mvc_kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlimeTest {

    @Test
    public void フレッシュなスライム() {
        Slime slime = new Slime();
        assertEquals("HP", 3, slime.getHP());
    }

    @Test
    public void スライムは死ぬ() {
        Slime slime = new Slime();
        slime.reduceHP(1);
        assertTrue("まだ生きている", slime.isAlive());
        
        slime.reduceHP(3);
        assertFalse("すでに死んでいる", slime.isAlive());
        assertEquals("HPは0未満にならない", 0, slime.getHP());
    }
}
