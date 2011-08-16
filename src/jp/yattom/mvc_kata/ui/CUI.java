package jp.yattom.mvc_kata.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collection;

import jp.yattom.mvc_kata.Action;
import jp.yattom.mvc_kata.AttackAction;
import jp.yattom.mvc_kata.Creature;
import jp.yattom.mvc_kata.UserInteraction;

public class CUI implements UserInteraction {
    private PrintStream out;
    private BufferedReader in;
    private Collection<Creature> opponents;
    private Creature pc;

    public CUI() {
        out = System.out;
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void notifyEncount(Collection<Creature> opponents) {
        this.opponents = opponents;
        StringBuilder builder = new StringBuilder();
        for (Creature c : opponents) {
            if (builder.toString().length() > 0) {
                builder.append(", ");
            }
            builder.append(c.getName());
        }
        builder.append("が現れた！");
        out.println(builder.toString());
    }

    @Override
    public void notifyAttacking(Creature target, int damage) {
        out.println("あなたの攻撃！" + target.getName() + "に" + damage + "のダメージを与えた");
    }

    @Override
    public void notifyHit(Creature actor, int damage) {
        out.println(actor.getName() + "の攻撃！" + damage + "のダメージを受けた！");
    }

    @Override
    public void notifyKill(Creature target) {
        out.println(target.getName() + "を倒した！");
    }

    @Override
    public void notifyDead() {
        out.println("あなたは死にました");
    }

    @Override
    public Action requestActionInEncounter() {
        while (true) {
            out.println("どうしますか？1:攻撃");
            out.print("> ");
            try {
                String line = in.readLine();
                switch (Integer.parseInt(line)) {
                case 1:
                    return new AttackAction(pc, opponents.iterator().next());
                default:
                    out.println("入力が間違っています");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
