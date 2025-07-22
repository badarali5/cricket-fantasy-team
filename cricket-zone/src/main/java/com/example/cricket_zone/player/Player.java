package com.example.cricket_zone.player;

import jakarta.persistence.*;

@Entity
@Table(name = "stats")
public class Player {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "matches")
    private Integer matches;

    @Column(name = "inns")
    private Integer inns;

    @Column(name = "no")
    private Integer no;

    @Column(name = "runs")
    private Integer runs;

    @Column(name = "hs")
    private String hs;

    @Column(name = "avg")
    private String avg;

    @Column(name = "bf")
    private Integer bf;

    @Column(name = "sr")
    private Double sr;

    @Column(name = "hundreds")
    private Integer hundreds;

    @Column(name = "fifties")
    private Integer fifties;

    @Column(name = "\"0s\"")
    private Integer zeroes;

    @Column(name = "\"4s\"")
    private Integer fours;

    @Column(name = "\"6s\"")
    private Integer sixes;


    @PostLoad
    public void fixNulls() {
        if (runs == null) runs = 0;
        if (matches == null) matches = 0;
        if (inns == null) inns = 0;
        if (no == null) no = 0;
        if (sr == null) sr = 0.0;

    }
    public Player() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getMatches() { return matches; }
    public void setMatches(Integer matches) { this.matches = matches; }

    public Integer getInns() { return inns; }
    public void setInns(Integer inns) { this.inns = inns; }

    public Integer getNo() { return no; }
    public void setNo(Integer no) { this.no = no; }

    public Integer getRuns() { return runs; }
    public void setRuns(Integer runs) { this.runs = runs; }

    public String getHs() { return hs; }
    public void setHs(String hs) { this.hs = hs; }

    public String getAvg() { return avg; }
    public void setAvg(String avg) { this.avg = avg; }

    public Integer getBf() { return bf; }
    public void setBf(Integer bf) { this.bf = bf; }

    public Double getSr() { return sr; }
    public void setSr(Double sr) { this.sr = sr; }

    public Integer getHundreds() { return hundreds; }
    public void setHundreds(Integer hundreds) { this.hundreds = hundreds; }

    public Integer getFifties() { return fifties; }
    public void setFifties(Integer fifties) { this.fifties = fifties; }

    public Integer getZeroes() { return zeroes; }
    public void setZeroes(Integer zeroes) { this.zeroes = zeroes; }

    public Integer getFours() { return fours; }
    public void setFours(Integer fours) { this.fours = fours; }

    public Integer getSixes() { return sixes; }
    public void setSixes(Integer sixes) { this.sixes = sixes; }
}
