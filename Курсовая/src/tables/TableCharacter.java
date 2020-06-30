package tables;

public class TableCharacter {
    String name, classCh, race, species, level, spellsKnow, cantripsKnow;

    public TableCharacter(String name, String classCh, String race, String species, String level, String spellsKnow, String cantripsKnow) {
        this.name = name;
        this.classCh = classCh;
        this.race = race;
        this.species = species;
        this.level = level;
        this.spellsKnow = spellsKnow;
        this.cantripsKnow = cantripsKnow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassCh() {
        return classCh;
    }

    public void setClassCh(String classCh) {
        this.classCh = classCh;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpellsKnow() {
        return spellsKnow;
    }

    public void setSpellsKnow(String spellsKnow) {
        this.spellsKnow = spellsKnow;
    }

    public String getCantripsKnow() {
        return cantripsKnow;
    }

    public void setCantripsKnow(String cantripsKnow) {
        this.cantripsKnow = cantripsKnow;
    }
}
