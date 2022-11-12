package me.saif.personalmines.mine.ladder;

import me.saif.personalmines.mine.contents.MineContents;
import me.saif.personalmines.mine.holder.MineHolder;

import java.util.HashMap;
import java.util.Map;

public class MineLadderRank {

    private String name;
    private MineContents contents;
    private Map<String, MineHolder> mineHolderMap = new HashMap<>();

    public MineLadderRank(String name, MineContents contents) {
        this.name = name;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public MineContents getContents() {
        return contents;
    }
}
