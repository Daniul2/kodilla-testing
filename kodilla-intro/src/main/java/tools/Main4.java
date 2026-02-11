package tools;

import java.util.LinkedList;
import java.util.List;

class Cannon {
    private boolean loaded;

    public Cannon(boolean loaded) {
        this.loaded = loaded;
    }

    public void fire() {
        if (!loaded) {
            System.out.println("No cannonball in the cannon. Loading the cannon...");
            this.loaded = true;
        } else {
            System.out.println("The cannon is already loaded. Fire!");
            this.loaded = false;
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        List<Cannon> cannons = new LinkedList<>();

        cannons.add(new Cannon(false));
        cannons.add(new Cannon(false));
        cannons.add(new Cannon(true));
        cannons.add(new Cannon(false));

        System.out.println("Checking cannon battery status:");

        for (Cannon cannon : cannons) {
            cannon.fire();
        }
    }
}
