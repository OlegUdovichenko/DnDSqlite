package tables;

public class TableClass {
    String name, diceHits, professional, saves;

    public TableClass(String name, String diceHits, String professional, String saves) {
        this.name = name;
        this.diceHits = diceHits;
        this.professional = professional;
        this.saves = saves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiceHits() {
        return diceHits;
    }

    public void setDiceHits(String diceHits) {
        this.diceHits = diceHits;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getSaves() {
        return saves;
    }

    public void setSaves(String saves) {
        this.saves = saves;
    }

}
