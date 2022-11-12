package me.saif.personalmines.mine;

import me.saif.personalmines.PersonalMines;
import me.saif.personalmines.geometry.Cuboid;
import me.saif.personalmines.mine.contents.MineContents;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.util.Iterator;

public class Mine {

    private static final int BLOCKS_PER_TICK = 500;

    private MineContents mineContents;
    private Cuboid mineCuboid;

    public Mine(MineContents contents, Cuboid cuboid) {
        this.mineContents = contents;
        this.mineCuboid = cuboid;
    }

    public void setMineContents(MineContents mineContents) {
        this.mineContents = mineContents;
    }

    public void setMineCuboid(Cuboid mineCuboid) {
        this.mineCuboid = mineCuboid;
    }

    private void drawLine(Location l1, Location l2, int subSegments) {
        Vector offset = l1.toVector().subtract(l2.toVector()).multiply(1 / subSegments);
        for (double i = 0; i < subSegments; i++) {
            Location loc = l1.clone().add(offset.clone().multiply(i));
            //dostuffwithloc
        }
    }

    public void reset(PersonalMines plugin) {
        Iterator<Block> iterator = mineCuboid.iterator();

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (int i = 0; i < BLOCKS_PER_TICK; i++) {
                if (!iterator.hasNext())
                    return;
                iterator.next().setType(mineContents.generateRandom());
            }
        }, 0L, 1L);
    }

    public Cuboid getMineCuboid() {
        return mineCuboid.clone();
    }

    public Iterator<Block> getBlockIterator() {
        return mineCuboid.iterator();
    }

}
