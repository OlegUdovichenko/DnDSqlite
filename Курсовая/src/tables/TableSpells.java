package tables;

public class TableSpells {
    String classCh, spellLevel, name;

    public TableSpells(String classCh, String spellLevel, String name) {
        this.classCh = classCh;
        this.spellLevel = spellLevel;
        this.name = name;
    }

    public String getClassCh() {
        return classCh;
    }

    public void setClassCh(String classCh) {
        this.classCh = classCh;
    }

    public String getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(String spellLevel) {
        this.spellLevel = spellLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
