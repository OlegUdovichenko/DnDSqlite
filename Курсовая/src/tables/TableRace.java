package tables;

public class TableRace {
    String name, stats, lifespan, size, speed, darkvision, language, fits;

    public TableRace(String name, String stats, String lifespan, String size, String speed, String darkvision, String language, String fits)
    {
        this.name = name;
        this.stats = stats;
        this.lifespan = lifespan;
        this.size = size;
        this.speed = speed;
        this.darkvision = darkvision;
        this.language = language;
        this.fits = fits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDarkvision() {
        return darkvision;
    }

    public void setDarkvision(String darkvision) {
        this.darkvision = darkvision;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFits() {
        return fits;
    }

    public void setFits(String fits) {
        this.fits = fits;
    }
}
