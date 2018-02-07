/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unict.ing.pds.light.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.unict.ing.pds.dhtdb.utils.dht.Key;
import org.unict.ing.pds.dhtdb.utils.model.GenericValue;

/**
 *
 * @author aleskandro
 */
public class Bucket extends GenericValue {
    private int recordsCounter;
    private Range range;
    private Label leafLabel;
    
    public Bucket(Key key) {
        super(key);
    }
    
    public Bucket(Key key, Range range, 
            Label leafLabel, 
                    int recordsCounter) {
        super(key);
        this.range = range;
        this.leafLabel = leafLabel;
        this.recordsCounter = recordsCounter;
        
    }



    public Bucket(Range range, Label leafLabel, int recordsCounter) {
        super(leafLabel.toKey());
        this.leafLabel = leafLabel;
        this.recordsCounter = recordsCounter;
        this.range = range;
    }

    public Bucket(Range range, Label leafLabel) {
        super(leafLabel.toKey());
        this.range = range;
        this.recordsCounter = 0;        
    }

    public Bucket() {
        super(new Key(""));
    }
    
    public int getRecordsCounter() {
        return recordsCounter;
    }

    public void setRecordsCounter(int recordsCounter) {
        this.recordsCounter = recordsCounter;
    }

    public void incrementRecordsCounter(int i) {
        this.recordsCounter += i;
    }
    
    public void incrementRecordsCounter() {
        this.recordsCounter++;
    }
    
    @JsonIgnore
    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    @JsonIgnore
    public Label getLeafLabel() {
        return leafLabel;
    }

    public void setLeafLabel(Label leafLabel) {
        this.leafLabel = leafLabel;
    }
    
    // Methods for JSON to Jongo to Mongo
    @JsonCreator 
    public Bucket(@JsonProperty("key")Key key,
            @JsonProperty("lower")long lower, 
            @JsonProperty("upper")long upper, 
            @JsonProperty("label")String label, 
            @JsonProperty("recordsCounter") int recordsCounter) {
        super(key);
        this.range = new Range(lower, true, upper, false);
        this.leafLabel = new Label(label);
        this.recordsCounter = recordsCounter;
    }
    
    @JsonProperty("upper")
    public long getUpper() {
        return this.range.getUpper();
    }
    
    @JsonProperty("lower")
    public long getLower() {
        return this.range.getLower();
    }
    
    @JsonProperty("label")
    public String getLabel() {
        return this.leafLabel.getLabel();
    }
    
}
