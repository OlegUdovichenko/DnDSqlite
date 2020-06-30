package tables;

public class TableSpecies {
    String name, stats, fits;

    public TableSpecies(String name, String stats, String fits) {
        this.name = name;
        this.stats = stats;
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

    public String getFits() {
        return fits;
    }

    public void setFits(String fits) {
        this.fits = fits;
    }
}
