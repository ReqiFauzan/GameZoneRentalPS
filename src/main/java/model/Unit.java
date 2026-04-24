package model;

import java.util.Objects;

public class Unit {
    public enum Status { DIPAKAI, TERSEDIA, RUSAK }
    public enum TipeRuang { VIP, REGULAR }

    private String unitId;
    private String tipePS; // e.g. PS4, PS5
    private Status status;
    private TipeRuang tipeRuang;
    private long tarifPerJam; // in Rupiah (whole number)

    public Unit(String unitId, String tipePS, TipeRuang tipeRuang, long tarifPerJam) {
        this.unitId = unitId;
        this.tipePS = tipePS;
        this.tipeRuang = tipeRuang;
        this.tarifPerJam = tarifPerJam;
        this.status = Status.TERSEDIA;
    }

    public String getUnitId() { return unitId; }
    public String getTipePS() { return tipePS; }
    public Status getStatus() { return status; }
    public TipeRuang getTipeRuang() { return tipeRuang; }
    public long getTarifPerJam() { return tarifPerJam; }

    public void setStatus(Status status) { this.status = status; }
    public void setTarifPerJam(long tarifPerJam) { this.tarifPerJam = tarifPerJam; }

    public String getInfo() {
        return String.format("%s | %s | %s | Rp. %s/jam", unitId, tipePS, tipeRuang, tarifPerJam);
    }

    public long hitungTarif(int durasiJam) {
        if (durasiJam <= 0) return 0L;
        return tarifPerJam * durasiJam;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;
        Unit unit = (Unit) o;
        return Objects.equals(unitId, unit.unitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitId);
    }
}